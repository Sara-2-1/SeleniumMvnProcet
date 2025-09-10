package tasks3;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
public class GrowingClickable {
//Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
//Click "click me" button
//Verify "Event Triggered" appears

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testGrowingClickableElement() throws InterruptedException {
        WebElement clickMeButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("growbutton"))
        );
        clickMeButton.click();

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("growbuttonstatus"))
        );

        assertTrue(message.getText().contains("Event Triggered"));

        Thread.sleep(3000);
    }

}

