package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class C04_LoginTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testInvalidLogin() {

        // ✅ Navigate to Heroku login
        driver.get("https://id.heroku.com/login");

        // ✅ Enter test email
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("test@example.com");

        // ✅ Enter test password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("wrongpassword");

        // ✅ Click login button
        driver.findElement(By.name("commit")).click();

        // ✅ Check for error message
        WebElement errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger"));
        String actualText = errorMessage.getText();
        System.out.println("Error message: " + actualText);

        // ✅ Verify that error message is displayed
        assertTrue(actualText.contains("There was a problem with your login."),
                "Error message not displayed!");

        // ✅ Print result
        System.out.println("Test Passed: Invalid login shows error message ✅");
    }

}
