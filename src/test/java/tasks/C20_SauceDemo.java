package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C20_SauceDemo {
    /*
        Given: Go to https://www.saucedemo.com/
        When: Enter username as "standard_user"
        And: Enter password as "secret_sauce"
        And: Click login button
        And: Order products by "Price (low to high)"
        Then: Assert last product costs $49.99, first product costs $7.99 and total cost is $129.94
     */

    @Test
    void sauceDemoTest() throws InterruptedException {

//        Given: Go to https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

//        When: Enter username as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

//        And: Enter password as "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//        And: Click login button
        driver.findElement(By.id("login-button")).click();

//        And: Order products by "Price (low to high)"
        WebElement dropDown = driver.findElement(By.tagName("select"));
        Select select = new Select(dropDown);
        //Thread.sleep(3000);
        select.selectByValue("lohi");

//      Then: Assert last product costs $49.99, first product costs $7.99 and total cost is $129.94
        List<WebElement> costs = driver.findElements(By.className("inventory_item_price"));
        //costs.forEach(cost -> System.out.println(cost.getText()));
        assertEquals("$49.99", costs.getLast().getText());
        assertEquals("$7.99", costs.getFirst().getText());
        double sum = 0;
        for (WebElement cost : costs) {
            sum  += Double.parseDouble(cost.getText().replaceAll("[^0-9.]", ""));
        }

        assertEquals(129.94, sum);

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
        Thread.sleep(6000);
        driver.quit();
    }
}
