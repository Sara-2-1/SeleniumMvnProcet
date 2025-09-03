import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Teat01 {
    public static void main(String[] args)  {

        // استخدام الـ Polymorphism: تعريف WebDriver عام وربطه مع ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.close();
    }
}
