package tasks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        ;// Invoke Chrome Browser
        WebDriver driver = new ChromeDriver();

// Navigate to URL: https://www.w3schools.com/
        driver.get("https//:www.w3schools.com/");

        // Navigate to URL: https://stackoverflow.com/
        driver.get("https://stackoverflow.com/");

// Come back to the w3schools using the back command.
        Thread.sleep(3000);
        driver.navigate().back();

// Again go back to the stackoverflow website using forward command
        Thread.sleep(3000);
        driver.navigate().forward();

// Refresh the Browser using refresh command.
        Thread.sleep(3000);
        driver.navigate().refresh();

        // Close the Browser
        Thread.sleep(3000);
        driver.close();
    }

    }

