package tasks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C16_ChromeOptions {
    /*
    Maximize window on startup
    Disable extensions
    Run in incognito mode
    Disable infobars
    Navigate to "https://www.example.com" and verify the title contains "Example".
     */

    @Test
    void chromeOptionsTest() {
        //Navigate to "https://www.example.com" and verify the title contains "Example".
        driver.get("https://www.example.com");
        assert driver.getTitle().contains("Example");
    }


    WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
//        Maximize window on startup
        options.addArguments("--start-maximized");
//        Disable extensions
        options.addArguments("--disable-extensions");
//        Run in incognito mode
        options.addArguments("--incognito");
//        Disable infobars
        //options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
