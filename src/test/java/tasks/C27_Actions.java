package tasks;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
public class C27_Actions extends TestBase
{
     /*
        Go to https://claruswaysda.github.io/submit-button.html
        Click on submit
        Verify link contains 'actionsClickDrag'
        Drag 'Drag me' to 'Drop here'
        Right-click on 'Right-click' me
        Double-click on 'Double-click me'
        Hover on 'Hover over me'
        Verify all actions' success messages.
    */

    @Test
    void actionsTest() {

//        Go to https://claruswaysda.github.io/submit-button.html
        driver.get("https://claruswaysda.github.io/submit-button.html");

//        Click on submit
        driver.findElement(By.id("submitButton")).click();

//        Verify link contains 'actionsClickDrag'
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));


        WebElement source = driver.findElement(By.id("drag1"));
        WebElement target = driver.findElement(By.id("drop1"));
        WebElement contextClick = driver.findElement(By.id("showSuccessButton"));
        WebElement doubleClick = driver.findElement(By.id("doubleClickButton"));
        WebElement hover = driver.findElement(By.id("hoverButton"));

        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(source, target)//        Drag 'Drag me' to 'Drop here'
                .contextClick(contextClick)//        Right-click on 'Right-click' me
                .doubleClick(doubleClick)//        Double-click on 'Double-click me'
                .moveToElement(hover)//        Hover on 'Hover over me'
                //.build()//This will prepare the actions
                .perform();

//        Verify all actions' success messages.
        assert driver.findElement(By.xpath("//*[.='Item successfully dropped!']")).isDisplayed();
        assert driver.findElement(By.xpath("//*[.='Button right-clicked!']")).isDisplayed();
        assert driver.findElement(By.xpath("//*[.='Button double-clicked!']")).isDisplayed();
        assert driver.findElement(By.xpath("//*[.='Button hovered!']")).isDisplayed();
        assert driver.findElement(By.tagName("h2")).getText().contains("Selenium's Actions Class");

    }

}
