
package tasks2;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DynamicListTest {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @Test
    void dynamicListManagement() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        Faker faker = new Faker();

        // (1) إضافة 5 مهام باستخدام Faker
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        for (int i = 0; i < 5; i++) {
            String task = faker.book().title();
            input.sendKeys(task + Keys.ENTER);
            System.out.println("➕ Added task: " + task);
        }

        List<WebElement> tasks = driver.findElements(By.cssSelector("ul li"));

        for (int i = 0; i < tasks.size(); i++) {
            if (i % 2 == 0) {
                tasks.get(i).click(); // يعمل strike-through
                System.out.println("✔ Marked completed: " + tasks.get(i).getText());
            }
        }

        while (true) {
            List<WebElement> completed = driver.findElements(By.cssSelector("ul li.completed"));
            if (completed.isEmpty()) break;

            for (WebElement task : completed) {
                try {
                    actions.moveToElement(task).perform(); // hover
                    WebElement deleteBtn = task.findElement(By.cssSelector("span"));
                    wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
                    System.out.println("❌ Deleted completed task: " + task.getText());
                } catch (StaleElementReferenceException ignored) {
                }
            }
        }

        List<WebElement> remaining = driver.findElements(By.cssSelector("ul li"));
        for (WebElement t : remaining) {
            assertFalse(t.getAttribute("class").contains("completed"),
                    "❌ Found a completed task that should be deleted!");
            System.out.println("📌 Remaining task: " + t.getText());
        }

        System.out.println("✅ Test passed: Only incomplete tasks remain!");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

