package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C18_DropDown {

    @Test
    void dropDownTest() throws InterruptedException {

        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        WebElement dd = driver.findElement(By.name("dropdown"));
        Select select = new Select(dd);
        //Thread.sleep(3000);
        select.selectByIndex(4);
        //Thread.sleep(3000);
        select.selectByVisibleText("Drop Down Item 2");
        //Thread.sleep(3000);
        select.selectByValue("dd6");

        List<WebElement> options = select.getOptions();
        options.forEach(element -> System.out.println(element.getText()));

        System.out.println(select.isMultiple());

        Select selectMultiple = new Select(driver.findElement(By.name("multipleselect[]")));
        System.out.println(selectMultiple.isMultiple());
        Thread.sleep(3000);
        selectMultiple.selectByIndex(2);
        Thread.sleep(3000);
        selectMultiple.selectByIndex(3);
        Thread.sleep(1000);
        selectMultiple.selectByIndex(0);
        Thread.sleep(3000);
        selectMultiple.deselectByIndex(3);
        Thread.sleep(3000);
        selectMultiple.deselectAll();

    }


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}
