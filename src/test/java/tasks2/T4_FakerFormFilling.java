package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class T4_FakerFormFilling {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void fakerFormFillTest() {
        driver.get("https://demoqa.com/text-box");
        Faker faker = new Faker();

        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().secondaryAddress();

        System.out.println("Full Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Current Address: " + currentAddress);
        System.out.println("Permanent Address: " + permanentAddress);

        driver.findElement(By.id("userName")).sendKeys(fullName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);

        // استخدام JavaScript للنقر على زر Submit
        WebElement submitBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);

        // تحقق أن البيانات تظهر في الـ output
        String output = driver.findElement(By.id("output")).getText();
        Assertions.assertTrue(output.contains(fullName));
        Assertions.assertTrue(output.contains(email));
        Assertions.assertTrue(output.contains(currentAddress));
        Assertions.assertTrue(output.contains(permanentAddress));

        System.out.println("✅ All Faker data submitted and verified successfully!");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}