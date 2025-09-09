package tasks2;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;

public class T3_RadioButtonSelection {
//avigate to "https://demoqa.com/radio-button"
//Attempts to select each radio button (Yes, Impressive, No)
//Prints whether each option is enabled/disabled
//For enabled options, select them and verify selection
//Print confirmation message for each successful selection
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void radioButtonTest() {
        driver.get("https://demoqa.com/radio-button");

        List<WebElement> radioButtons = List.of(
                driver.findElement(By.xpath("//label[@for='yesRadio']")),
                driver.findElement(By.xpath("//label[@for='impressiveRadio']")),
                driver.findElement(By.xpath("//label[@for='noRadio']"))
        );

        for (WebElement rb : radioButtons) {
            WebElement input = driver.findElement(By.id(rb.getAttribute("for")));
            System.out.println("🔘 Option: " + rb.getText() + " | Enabled? " + input.isEnabled());

            if (input.isEnabled()) {
                rb.click();
                Assertions.assertTrue(input.isSelected());
                System.out.println("✅ " + rb.getText() + " selected successfully!");
            }
        }
    }


    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}