package tasks4;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DragAndDropTest {
     //Go to https://claruswaysda.github.io/dragAndDrop.html
    //Drag the items in their right places
    //Assert the success message and Task
    
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void dragAllPiecesAndCheckMessage() {
        Actions actions = new Actions(driver);

        WebElement piece1 = driver.findElement(By.id("piece1"));
        WebElement piece2 = driver.findElement(By.id("piece2"));
        WebElement piece3 = driver.findElement(By.id("piece3"));

        WebElement slot1 = driver.findElement(By.id("slot1"));
        WebElement slot2 = driver.findElement(By.id("slot2"));
        WebElement slot3 = driver.findElement(By.id("slot3"));

        actions.dragAndDrop(piece1, slot1).perform();
        actions.dragAndDrop(piece2, slot2).perform();
        actions.dragAndDrop(piece3, slot3).perform();

        WebElement congratsMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("celebrate"))
        );

        assertTrue(congratsMsg.getText().contains("Congratulations"),
                "Message should contain 'Congratulations'");
    }
}