package tasks;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C32_Cookies extends TestBase {

    /*
        Go to https://claruswaysda.github.io/CookiesWait.html
        Accept the alert if it is present
        Print the cookies
        Delete all cookies and assert
    */

    @Test
    void cookiesTest() {

//        Go to https://claruswaysda.github.io/CookiesWait.html
        driver.get("https://claruswaysda.github.io/CookiesWait.html");

//        Accept the alert if it is present
        try {
            driver.switchTo().alert().accept();
            System.out.println("Alert Appeared!");
        } catch (Exception ignored) {
            System.out.println("Alert did not Appear!");
        }

//        Print the cookies
        System.out.println(driver.manage().getCookies());

//        Delete all cookies and assert
        driver.manage().deleteAllCookies();
        System.out.println( driver.manage().getCookies());
        assertEquals(0, driver.manage().getCookies().size());


    }


}
