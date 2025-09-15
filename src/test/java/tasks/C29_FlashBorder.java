package tasks;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.JSUtils;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utilities.JSUtils.flash;
import static utilities.JSUtils.flashBorder;

public class C29_FlashBorder extends TestBase {

    /*
        Go to https://claruswaysda.github.io/signIn.html
        enter username 'admin'
        enter password '123'
        Click on Sign In
        Assert the 'Employee Table' is visible
        Create a method to change border color and style of web elements.
        Use the method on each element you interact with.
    */

    @Test
    void flashBorderTest() {

//        Go to https://claruswaysda.github.io/signIn.html
        driver.get("https://claruswaysda.github.io/signIn.html");

//        enter username 'admin'
        WebElement username = driver.findElement(By.id("username"));
        //JSUtils.removeBorder(driver,username);
        flashBorder(driver, username, "2px", "solid", "pink");
        username.sendKeys("admin");

//        enter password '123'
        WebElement password = driver.findElement(By.id("password"));
        flashBorder(driver, password, "3px", "dotted", "brown");
        password.sendKeys("123");

//        Click on Sign In
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        flashBorder(driver, submit, "2px", "solid", "red");
        submit.submit();

//        Assert the 'Employee Table' is visible
        WebElement header = driver.findElement(By.tagName("h1"));
        flash(header, driver, "blue");
        assertEquals("Employee Table", header.getText());
//        Create a method to change border color and style of web elements.
//        Use the method on each element you interact with.

    }


}
