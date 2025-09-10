package tasks;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C13_GoogleSearch {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // TODO: Initialize static WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // TODO: Navigate to ToDo List
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    public void searchMovies() {
        String[] todos = {"Green Mile", "Premonition", "The Curious Case of Benjamin Button", "Matrix", "Lord Of The Rings"};
        for (String todo : todos) {
            // TODO: Find add todo box
            WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));

            // TODO: Clear and enter todo
            searchBox.clear();
            searchBox.sendKeys(todo, Keys.ENTER);

            // TODO: Get and print todo
            String lastToDo = driver.findElements(By.tagName("li")).getLast().getText();
            System.out.println("lastToDo = " + lastToDo);
            assertEquals(todo,lastToDo);

        }
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        // TODO: Close driver
        Thread.sleep(3000);
        driver.quit();
    }

}
