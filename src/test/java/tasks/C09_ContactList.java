package tasks;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class C09_ContactList {

    /*
    Task:
    Open the Chrome driver in @BeforeAll method
    Go to https://thinking-tester-contact-list.herokuapp.com/ and maximize window in @BeforeEach method
    Check the title in test01 method
    Check the link in test02 method
    Check the page source in test03 method
    Minimize window in @AfterEach
    Close the browser in @AfterAll method
     */

    static WebDriver driver;

    @BeforeAll
    static void openBrowser() {
        driver = new ChromeDriver();
    }

    @BeforeEach
    void goToLink() throws InterruptedException {
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @Test
    void titleTest() {
        String title = driver.getTitle();
        assertEquals("Contact List App", title, "Title did not match!");
    }

    @Test
    void linkTest() {
        String url = driver.getCurrentUrl();
        assertEquals("https://thinking-tester-contact-list.herokuapp.com/", url, "Url did not match!");
    }

    @Test
    void pageSourceTest(){
        Assertions.assertTrue(driver.getPageSource().contains("Created by Kristin Jackvony, Copyright 2021"),"Page source did not contain the text!");
    }


    @AfterEach
    void minimizeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.manage().window().minimize();
    }

    @AfterAll
    static void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}


