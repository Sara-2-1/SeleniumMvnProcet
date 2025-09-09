package tasks2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.time.Duration;

public class T2_checkBoxInteraction {
    //Go to "https://the-internet.herokuapp.com/checkboxes"
    //Checks the current state of both checkboxes
    //Ensures both checkboxes are selected (click only if not already selected)
    //Verify both checkboxes are checked after the operations
    //Print the status of each checkbox to console

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void checkBoxTest() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement box : checkBoxes) {
            if (!box.isSelected()) {
                box.click();
            }
            Assertions.assertTrue(box.isSelected());
            System.out.println("Checkbox status: " + box.isSelected());
        }
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
