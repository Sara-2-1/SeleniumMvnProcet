package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task02_PageSource {

    //Use @BeforeEach to open Chrome and maximize.
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //Test 1:
    //Navigate to https://www.selenium.dev.
    //Verify that the page source contains the word "WebDriver".
    @Test
    void seleniumPageSourceTest() {
        driver.get("https://www.selenium.dev");
        assertTrue(driver.getPageSource().contains("WebDriver"), "Page source does not contain 'WebDriver'");
    }
    //Test 2:
    //Navigate to https://www.python.org.
    //Assert the page source contains "Python".
    @Test
    void pythonPageSourceTest() {
        driver.get("https://www.python.org");
        assertTrue(driver.getPageSource().contains("Python"), "Page source does not contain 'Python'");
    }
    //Teardown:
    //Close the browser with @AfterEach.
    @AfterEach
    void teardown() {
        driver.quit();
    }
}

