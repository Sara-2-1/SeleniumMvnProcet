package tasks3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorOperations {
    //Go to https://testpages.eviltester.com/styled/calculator
    //Type any number in first and second input
    //Click Calculate for each operation
    //Get and verify results for all operations
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
    void calculatorOperationsTest() {
        driver.get("https://testpages.eviltester.com/styled/calculator");

        // Input numbers
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");

        Select operation = new Select(driver.findElement(By.id("function")));
        operation.selectByValue("plus");

        driver.findElement(By.id("calculate")).click();
        String result = driver.findElement(By.id("answer")).getText();
        Assertions.assertEquals("15", result); // 10 + 5 = 15

    }
}
