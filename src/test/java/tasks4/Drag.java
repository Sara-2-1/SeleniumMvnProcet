package tasks4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class Drag {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://claruswaysda.github.io/Dropdowns.html");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void dropdownTest() {
//Go to https://claruswaysda.github.io/Dropdowns.html
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Traditional Dropdown
        Select traditionalDropdown = new Select(driver.findElement(By.id("carSelect")));
        traditionalDropdown.selectByVisibleText("Ford");

        // 2. Multi-Select Dropdown
        Select multiSelect = new Select(driver.findElement(By.id("multiCarSelect")));
        multiSelect.selectByVisibleText("Mercedes");

        // 3. Custom Dropdown (Bootstrap-like)
        WebElement customDropdown = driver.findElement(By.id("customDropdown"));
        customDropdown.click();
        WebElement customOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='customList']/div[text()='BMW']"))
        );
        customOption.click();

        // 4. Static Auto-Suggest Dropdown
        WebElement staticInput = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("staticInput"))
        );
        staticInput.sendKeys("Tesla Model 3");
        WebElement staticSuggestion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='staticSuggestions']//div[contains(text(),'Tesla Model 3')]")
                )
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", staticSuggestion);

        // 5. Dynamic Auto-Suggest Dropdown
        WebElement dynamicInput = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("dynamicInput"))
        );
        dynamicInput.sendKeys("Toy");
        WebElement dynamicSuggestion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='dynamicSuggestions']//div[contains(text(),'Toyota')]")
                )
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dynamicSuggestion);
    }
}
