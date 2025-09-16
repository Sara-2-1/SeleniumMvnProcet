package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class UserRegistrationANDScreenshot extends utilities.TestBase {
//    Go to https://claruswaysda.github.io/homepage.html
//    Register a user
//    Sign in with the registered user
//    Take all pages' screenshots
//    Take 'Celebrate Login' button's screenshot.
//    Capture a screenshot of the page with confetti.

    @Test
    public void userRegistrationAndScreenshot() throws InterruptedException {
        driver . get("https://claruswaysda.github.io/homepage.html");

        // Register a user
        driver.findElement(By.xpath("//*[@class='fa-regular fa-user']")).click();
        driver.findElement(By.xpath("//*[.='Register']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='ssn']")).sendKeys("123");
        driver.findElement(By.id("first-name")).sendKeys("sarah");
        driver.findElement(By.id("last-name")).sendKeys("ali");
        driver.findElement(By.id("address")).sendKeys("123 Street");
        driver.findElement(By.id("phone")).sendKeys("1234567890");
        driver.findElement(By.id("username")).sendKeys("sarah2025");
        driver.findElement(By.id("email")).sendKeys("sarah@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("confirm-password")).sendKeys("Test@1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='button']")).click();
        Thread.sleep(2000);

        // Sign in with the registered user
        driver.findElement(By.xpath("//*[@class='login-button']")).click();
        driver.findElement(By.id("username")).sendKeys("sarah2025");
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        // Take all pages' screenshots
        takeFullPageScreenshot();
        Thread.sleep(2000);

        // Take 'Celebrate Login' button's screenshot.
        WebElement CelebrateLogin = driver.findElement(By.id("clickMeButton"));
        takeElementsScreenshot(CelebrateLogin);
        CelebrateLogin.click();
        Thread.sleep(2000);


        // Capture a screenshot of the page with confetti.
        takeFullPageScreenshot();
        Thread.sleep(2000);


    }

}


