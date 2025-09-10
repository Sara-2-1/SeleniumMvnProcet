package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C14_CheckBox_RadioButton {

    @Test
    void checkBoxTest() {
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkBox : checkBoxList) {
            if (!checkBox.isSelected()) {
                checkBox.click();
            }
            if (!checkBox.isSelected()) {
                Assertions.fail();
            }
        }
        Assertions.assertTrue(true);
    }

    @Test
    void radioButtonTest() throws InterruptedException {

        WebElement rb1 = driver.findElement(By.xpath("//input[@value='rd1']"));
        WebElement rb2 = driver.findElement(By.xpath("//input[@value='rd2']"));
        WebElement rb3 = driver.findElement(By.xpath("//input[@value='rd3']"));

        Thread.sleep(3000);
        rb1.click();
        assert rb1.isSelected();
        Thread.sleep(3000);
        rb2.click();
        assert rb2.isSelected();
        Thread.sleep(3000);
        rb3.click();
        assert rb3.isSelected();
    }


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}