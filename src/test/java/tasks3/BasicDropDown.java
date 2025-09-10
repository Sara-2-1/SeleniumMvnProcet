package tasks3;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicDropDown {
    //Go to https://the-internet.herokuapp.com/dropdown
    //Create selectByIndexTest method - Select Option 1 using index
    //Create selectByValueTest method - Select Option 2 by value
    //Create selectByVisibleTextTest method - Select Option 1 by visible text
    //Create printAllTest method - Print all dropdown values
    //Verify dropdown has Option 2 text
    //Create printFirstSelectedOptionTest - Print first selected option
    //Verify dropdown size equals 3 elements

    WebDriver driver;
    WebElement dropdown;
    Select select;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdown = driver.findElement(By.id("dropdown"));
        select = new Select(dropdown);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void selectByIndexTest() {
        select.selectByIndex(1);
        assertEquals("Option 1", select.getFirstSelectedOption().getText());
    }

    @Test
    void selectByValueTest() {
        select.selectByValue("2");
        assertEquals("Option 2", select.getFirstSelectedOption().getText());
    }

    @Test
    void selectByVisibleTextTest() {
        select.selectByVisibleText("Option 1");
        assertEquals("Option 1", select.getFirstSelectedOption().getText());
    }

    @Test
    void printAllTest() {
        List<WebElement> options = select.getOptions();
        options.forEach(option -> System.out.println(option.getText()));
        assertTrue(options.stream().anyMatch(o -> o.getText().equals("Option 2")));
    }

    @Test
    void printFirstSelectedOptionTest() {
        select.selectByIndex(1);
        System.out.println("First Selected: " + select.getFirstSelectedOption().getText());
    }

    @Test
    void verifyDropDownSizeTest() {
        assertEquals(3, select.getOptions().size());
    }

}
