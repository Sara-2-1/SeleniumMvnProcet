package tasks;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C12_LinkedInTest {

    @Test
    void linkedInTest() {

        // TODO: Locate email field using By.id
        WebElement username = driver.findElement(By.id("username"));

        // TODO: Locate password field using By.name
        WebElement password = driver.findElement(By.name("session_password"));

        // TODO: Locate sign-in button using By.xpath
        WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));

        // TODO: Enter test credentials
        username.sendKeys("xyz");
        password.sendKeys("xyz");
        signIn.click();

        // TODO: Verify elements are displayed
        String message = driver.findElement(By.id("error-for-username")).getText();
        Assertions.assertEquals("Please enter a valid username.", message);

    }


    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        // TODO: Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // TODO: Navigate to LinkedIn
        driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
    }

    @AfterAll
    static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
