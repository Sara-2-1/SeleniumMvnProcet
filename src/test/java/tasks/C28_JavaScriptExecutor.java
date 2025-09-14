package tasks;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JSUtils;
import utilities.TestBase;

public class C28_JavaScriptExecutor extends TestBase {
    /*
        Go to https://claruswaysda.github.io/form.html
        Create a method to flash the elements you are working on and use it.
        Register a user
        Login
        Celebrate the login!
    */

    @Test
    void javaScriptExecutorTest() {

//        Go to https://claruswaysda.github.io/form.html
        driver.get("https://claruswaysda.github.io/form.html");

//        Create a method to flash the elements you are working on and use it.

//        Register a user
        WebElement ssn = driver.findElement(By.id("ssn"));
        JSUtils.flash(ssn,driver,"red");

//        Login

//        Celebrate the login !

    }
}
