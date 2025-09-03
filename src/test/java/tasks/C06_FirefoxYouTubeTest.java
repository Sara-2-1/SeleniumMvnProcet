package tasks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C06_FirefoxYouTubeTest
{
    public static void main(String[] args) throws InterruptedException {

        // 1. Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        // 2. Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // 3. Maximize the window
        driver.manage().window().maximize();

        // 4. Verify the page title contains the word "video"
        String title = driver.getTitle().toLowerCase();
        if (title.contains("video")) {
            System.out.println("✅ Title contains 'video' after maximize: " + title);
        } else {
            System.out.println("❌ Title does not contain 'video': " + title);
        }

        // 5. Minimize the window
        driver.manage().window().minimize();

        // ننتظر شوي عشان يبان التغيير
        Thread.sleep(3000);

        // 6. Verify the page title again
        title = driver.getTitle().toLowerCase();
        if (title.contains("video")) {
            System.out.println("✅ Title still contains 'video' after minimize: " + title);
        } else {
            System.out.println("❌ Title does not contain 'video' after minimize: " + title);
        }

        // 7. Make the page fullscreen
        driver.manage().window().fullscreen();

        Thread.sleep(3000); // ننتظر شوي نشوف الـ fullscreen

        // 8. Close the driver
        driver.quit();
    }
}
