package tasks3;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class OldStyleSelectMenu {
//Launch browser
//Open https://demoqa.com/select-menu
//Select Old Style Select Menu using element id
//Print all dropdown options
//Select 'Purple' using index
//Select 'Magenta' using visible text
//Select an option using value
//Close browser
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void oldStyleMenuTest() {
        driver.get("https://demoqa.com/select-menu");

        WebElement dropDown = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropDown);

        List<WebElement> options = select.getOptions();
        options.forEach(o -> System.out.println(o.getText()));

        select.selectByIndex(4); // Purple
        select.selectByVisibleText("Magenta");
        select.selectByValue("7"); // Gray
    }

}
