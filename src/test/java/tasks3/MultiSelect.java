package tasks3;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class MultiSelect {
    //Launch browser
    //Open https://demoqa.com/select-menu
    //Select Standard Multi-Select using element id
    //Verify element is multi-select
    //Select 'Opel' using index, then deselect using index
    //Select 'Saab' using value, then deselect using value
    //Deselect all options
    //Close browser

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void multiSelectTest() {
        driver.get("https://demoqa.com/select-menu");

        WebElement multiSelect = driver.findElement(By.id("cars"));
        Select select = new Select(multiSelect);

        assertTrue(select.isMultiple());

        select.selectByIndex(2); // Opel
        select.deselectByIndex(2);

        select.selectByValue("saab");
        select.deselectByValue("saab");

        select.deselectAll();
    }
}
