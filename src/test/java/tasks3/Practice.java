package tasks3;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class Practice {
    //Practice on https://demo.guru99.com/test/newtours/register.php
    //Apply dropdown and form handling techniques
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void registerFormTest() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        driver.findElement(By.name("firstName")).sendKeys("Sarah");
        driver.findElement(By.name("lastName")).sendKeys("Ali");
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.name("userName")).sendKeys("sarahali@test.com");

        driver.findElement(By.name("address1")).sendKeys("123 Main Street");
        driver.findElement(By.name("city")).sendKeys("Riyadh");
        driver.findElement(By.name("state")).sendKeys("KSA");
        driver.findElement(By.name("postalCode")).sendKeys("00000");

        Select country = new Select(driver.findElement(By.name("country")));
        country.selectByVisibleText("SAUDI ARABIA");

        driver.findElement(By.name("email")).sendKeys("SarahAli");
        driver.findElement(By.name("password")).sendKeys("pass123");
        driver.findElement(By.name("confirmPassword")).sendKeys("pass123");

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
        submitBtn.click();

        Assertions.assertTrue(
                driver.getPageSource().contains("Thank you for registering")
        );
    }
}

