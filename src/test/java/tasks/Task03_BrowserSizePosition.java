package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task03_BrowserSizePosition {
// Open Chrome in @BeforeEach.
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    // Test 1:
    //Navigate to https://www.bbc.com.
    //Set browser size to 800x600 and assert the window size.
    @Test
    void setSizeTest() {
        driver.get("https://www.bbc.com");
        driver.manage().window().setSize(new Dimension(800, 600));
        Dimension size = driver.manage().window().getSize();
        assertEquals(800, size.getWidth(), "Width mismatch");
        assertEquals(600, size.getHeight(), "Height mismatch");
    }

    // Move the window to position (100, 100) and assert its position.
    @Test
    void setPositionTest() {
        driver.get("https://www.bbc.com");
        driver.manage().window().setPosition(new Point(100, 100));
        Point position = driver.manage().window().getPosition();
        assertEquals(100, position.getX(), "X position mismatch");
        assertEquals(100, position.getY(), "Y position mismatch");
    }

    // Teardown:
//Close the browser.
    @AfterEach
    void teardown() {
        driver.quit();
    }
}
