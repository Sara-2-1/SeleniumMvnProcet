package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {

    public static void flash(WebElement element, WebDriver driver, String color) {
        String originalColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 20; i++) {
            changeBGColor(driver, element, color);
            changeBGColor(driver, element, originalColor);
        }
    }

    public static void changeBGColor(WebDriver driver, WebElement element, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor ='" + color + "'", element);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeBorderStyleColor(WebDriver driver, WebElement element, String px, String style, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='" + px + " " + style + " " + color + "'", element);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeBorder(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='none'", element);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void flashBorder(WebDriver driver, WebElement element, String px, String style, String color) {
        for (int i = 0; i < 20; i++) {
            removeBorder(driver, element);
            changeBorderStyleColor(driver, element, px, style, color);
        }
    }

    public static void scrollDownByPx(WebDriver driver, int px) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + px + ");");
    }


}