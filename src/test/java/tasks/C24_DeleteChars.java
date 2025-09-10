package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C24_DeleteChars extends TestBase {
    /*
        Go to https://claruswaysda.github.io/deleteChars.html
        Enter your full name
        Delete the letters
        Verify the message 'Deleted'
    */

    @Test
    void deleteCharsTest() {
//        Go to https://claruswaysda.github.io/deleteChars.html
        driver.get("https://claruswaysda.github.io/deleteChars.html");

//        Enter your full name
        String fullName = "Mary Star";
        driver.findElement(By.id("inputText")).sendKeys(fullName);
        driver.findElement(By.xpath("//*[.='Enter']")).click();

//        Delete the letters
        WebElement deleteButton = driver.findElement(By.id("deleteButton"));
        for (int i = 0; i < fullName.length(); i++) {
            deleteButton.click();
        }

//        Verify the message 'Deleted'
        assert driver.findElement(By.xpath("//*[.='Deleted']")).isDisplayed();
    }
}
