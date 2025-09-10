package tasks;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;


public class C22_JSAlert extends TestBase {
    /*
        Go to https://claruswaysda.github.io/ActionsForm.html
        Fill the form
        Generate Passcode
        Use passcode to submit form
    */

    @Test
    void jSAlertTest() {

//        Go to https://claruswaysda.github.io/ActionsForm.html
        driver.get("https://claruswaysda.github.io/ActionsForm.html");

//        Fill the form
        driver.findElement(By.id("name")).sendKeys("John");
        driver.findElement(By.id("age")).sendKeys("50");
        new Select(driver.findElement(By.id("options"))).selectByVisibleText("IT Department");
        WebElement coding = driver.findElement(By.xpath("//input[@value='coding']"));
        if (!coding.isSelected()) {
            coding.click();
        }
        driver.findElement(By.xpath("//input[@value='male']")).click();

//        Generate Passcode
//        Use passcode to submit form
        driver.findElement(By.xpath("//button[@onclick='generatePasscode()']")).click();
        String passCode = driver.switchTo().alert().getText().replaceAll("\\D", "");
        driver.switchTo().alert().accept();
        //System.out.println(passCode);
        driver.switchTo().alert().sendKeys(passCode);
        driver.switchTo().alert().accept();

        //driver.switchTo().frame(0);
        //driver.switchTo().frame("iframeSubmit");
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@name='iframeSubmit']"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.id("submitButton")).click();//This element is inside an iframe!

        driver.switchTo().parentFrame();

    }


}

