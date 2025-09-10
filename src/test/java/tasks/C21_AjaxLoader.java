package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C21_AjaxLoader {
    /*
        Given: Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        When: Click on Ajax Loader
        And: Click "Click Me!" button
        Then: Assert button is clicked
     */

    @Test
    void ajaxLoaderTest() {

//        Given: Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

//        When: Click on Ajax Loader
        driver.findElement(By.xpath("//a[@href='../Ajax-Loader/index.html']")).click();

//        And: Click "Click Me!" button
        WebElement clickMe = driver.findElement(By.xpath("//p[.='CLICK ME!']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickableButton = wait.until(ExpectedConditions.elementToBeClickable(clickMe));
        clickableButton.click();

//        Then: Assert button is clicked
        WebElement success = driver.findElement(By.tagName("h4"));
        WebElement visibleSuccess = wait.until(ExpectedConditions.visibilityOf(success));

        assertEquals("Well Done For Waiting....!!!", visibleSuccess.getText());
    }


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
