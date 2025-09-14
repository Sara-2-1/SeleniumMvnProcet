package tasks;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CustomerDeletionWithAlerts {
    /*
Go to URL: http://demo.guru99.com/test/delete
_
Delete customer ID: 123
customer.php
Handle 2 alerts that appear
*/
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    void deleteCustomerTest() {
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        // إدخال ID
        driver.findElement(By.name("cusid")).sendKeys("123");

        // الضغط على زر الحذف
        driver.findElement(By.name("submit")).click();

        // التعامل مع التنبيه الأول (Confirm Delete)
        Alert alert1 = driver.switchTo().alert();
        System.out.println("Alert 1 Text: " + alert1.getText());
        alert1.accept(); // OK

        // التعامل مع التنبيه الثاني (Result message)
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Alert 2 Text: " + alert2.getText());
        alert2.accept(); // OK
    }
}
