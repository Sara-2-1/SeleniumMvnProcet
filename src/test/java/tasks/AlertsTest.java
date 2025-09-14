package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void testAlerts() {
        driver.get("http://demo.automationtesting.in/Alerts.html");

        // ========== 1. Alert with OK ==========
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println("Alert with OK Text: " + alert1.getText());
        alert1.accept(); // OK

        // ========== 2. Alert with OK & Cancel ==========
        driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Alert with OK & Cancel Text: " + alert2.getText());
        alert2.dismiss(); // Cancel

        // ========== 3. Alert with Textbox ==========
        driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Bootcamp");
        alert3.accept();

        // التحقق من الرسالة
        WebElement message = driver.findElement(By.id("demo1"));
        String actualMessage = message.getText();
        System.out.println("Prompt Result: " + actualMessage);
        assertEquals("Hello Bootcamp How are you today", actualMessage);
    }
}
