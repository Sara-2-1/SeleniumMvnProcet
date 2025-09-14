package tasks;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class C26_WindowHandle extends TestBase {
/*
    Go to https://claruswaysda.github.io/
    Click on Window Handle
    Click on 'Open Index Page'
    Verify the link 'https://claruswaysda.github.io/index.html'
*/

    @Test
    void windowHandleTest() throws InterruptedException {

//        Go to https://claruswaysda.github.io/
        driver.get("https://claruswaysda.github.io/");

//        Click on Window Handle
        //Thread.sleep(3000);
        driver.findElement(By.linkText("Window Handle")).click();

//        Click on 'Open Index Page'
        Set<String> wHandles = driver.getWindowHandles();
        List<String> windowHandles = new ArrayList<>(wHandles);
        driver.switchTo().window(windowHandles.get(1));//This will switch to second opened tab/window
        //Thread.sleep(3000);
        driver.findElement(By.id("openIndex")).click();//NoSuchElementException -> Because driver remained in the previous page.
        windowHandles = new ArrayList<>(driver.getWindowHandles());

//        Verify the link 'https://claruswaysda.github.io/index.html'
        driver.switchTo().window(windowHandles.get(2));//Switch to 3rd tab/window
        assertEquals("https://claruswaysda.github.io/index.html", driver.getCurrentUrl());

    }


}
