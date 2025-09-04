package tasks;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task01_BrowserHistor {

    // Use @BeforeEach to launch Chrome and maximize.
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    // Test 1:
    //Navigate to https://www.wikipedia.org.
    //Navigate to https://www.google.com.
    @Test
    void navigateBackAndForwardTest() {
        driver.get("https://www.wikipedia.org");
        assertEquals("Wikipedia", driver.getTitle().contains("Wikipedia") ? "Wikipedia" : "", "Title not matching on Wikipedia");

        driver.get("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"), "Title not matching on Google");

        //Navigate back and forward multiple times, asserting the correct title at each step.
        driver.navigate().back();
        assertTrue(driver.getTitle().contains("Wikipedia"), "Back failed");

        driver.navigate().forward();
        assertTrue(driver.getTitle().contains("Google"), "Forward failed");
    }
    // Test 2 :
    //Use driver.navigate().refresh() on Google and assert the title still contains "Google".
    //Teardown:
     //Use @AfterEach to close the browser.
    @Test
    void refreshTest() {
        driver.get("https://www.google.com");
        driver.navigate().refresh();
        assertTrue(driver.getTitle().contains("Google"), "Title not matching after refresh");
    }
    @AfterEach
    void teardown() {
        driver.quit();
}
    }