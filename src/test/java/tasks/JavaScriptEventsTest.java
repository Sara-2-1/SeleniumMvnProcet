package tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavaScriptEventsTest {
 //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(WebElement button : buttons){
            js.executeScript("arguments[0].click();", button);
            System.out.println(button.getText() + " clicked via JS!");
            Thread.sleep(200); // لتجنب الضغط السريع جدًا
        }

        List<WebElement> clickedButtons = driver.findElements(By.cssSelector(".clicked"));
        System.out.println("Total clicked buttons: " + clickedButtons.size());

        driver.quit();
    }
}
