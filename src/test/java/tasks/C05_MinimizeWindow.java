package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_MinimizeWindow {
    public static void main(String[] args) throws InterruptedException {

        // Invoke Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open URL: https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");

        // Maximize the window.
        driver.manage().window().maximize();

        // Print the position and size of the page.
        System.out.println("Maximized position: " + driver.manage().window().getPosition());
        System.out.println("Maximized size: " + driver.manage().window().getSize());

        // Minimize the page.
        driver.manage().window().minimize();

        // Wait 7 seconds in the icon state
        Thread.sleep(7000);

        // Maximize the page again.
        driver.manage().window().maximize();

        // Print the position and dimensions of the page in maximized state.
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        // Make the page fullscreen.
        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        // Close the Browser
        Thread.sleep(3000);
        driver.quit();
    }
}
