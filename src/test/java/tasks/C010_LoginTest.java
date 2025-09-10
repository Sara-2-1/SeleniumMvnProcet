package tasks;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium. WebElement;
import org.openqa.selenium. By;
import org.openqa.selenium. Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class C010_LoginTest {

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    void positiveLoginTest() {

        driver.get("https://www.saucedemo.com/v1");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce", Keys.ENTER);

        // بديل ممكن: driver.findElement(By.id("login-button")).click();

        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
    @AfterAll
    static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}