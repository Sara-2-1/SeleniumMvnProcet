package tasks4;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DrawTest {
    //Go to https://claruswaysda.github.io/Draw.html
    // Draw a triangle
    // Reset
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://claruswaysda.github.io/Draw.html");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void drawTriangleAndReset() {
        WebElement canvas = driver.findElement(By.id("myCanvas"));
        Actions actions = new Actions(driver);

        int centerX = canvas.getLocation().getX() + canvas.getSize().getWidth() / 2;
        int centerY = canvas.getLocation().getY() + canvas.getSize().getHeight() / 2;

        // Draw triangle
        actions.moveToElement(canvas, -50, -50)
                .clickAndHold()
                .moveByOffset(100, 0)
                .moveByOffset(-50, 100)
                .moveByOffset(-50, -100)
                .release()
                .perform();

        // Click Reset
        driver.findElement(By.id("resetButton")).click();
    }
}