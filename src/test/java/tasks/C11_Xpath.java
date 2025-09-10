package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_Xpath {

    @Test
    void xPathTest() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement username = driver.findElement(By.xpath("//input[@name='username'][@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement login = driver.findElement(By.xpath("//button[.=' Login ']"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        login.click();

    }


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
}
