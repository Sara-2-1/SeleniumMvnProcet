package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task04_MultipleNavigation {
// Launch Chrome and maximize in @BeforeEach.
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
// Test 1:
//Navigate Google → YouTube → LinkedIn.
//Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
    @Test
    void multipleNavigationTest() {
        driver.get("https://www.google.com");
        assertTrue(driver.getTitle().contains("Google"));

        driver.get("https://www.youtube.com");
        assertTrue(driver.getTitle().contains("YouTube"));

        driver.get("https://www.linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));
    }
//Test 2:
//Navigate back twice and assert the URL of Google.
//Navigate forward twice and assert URL of LinkedIn.
    @Test
    void backForwardNavigationTest() {
        driver.get("https://www.google.com");
        driver.get("https://www.youtube.com");
        driver.get("https://www.linkedin.com");

        driver.navigate().back();
        driver.navigate().back();
        assertEquals("https://www.google.com/", driver.getCurrentUrl(), "Back navigation URL mismatch");

        driver.navigate().forward();
        driver.navigate().forward();
        assertEquals("https://www.linkedin.com/", driver.getCurrentUrl(), "Forward navigation URL mismatch");
    }
//Teardown:
//Use @AfterEach to quit the browser.
    @AfterEach
    void teardown() {
        driver.quit();
    }
}

