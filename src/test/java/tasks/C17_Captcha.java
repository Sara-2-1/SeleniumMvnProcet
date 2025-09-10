package tasks;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C17_Captcha {
    /*
    Go to "https://form.jotform.com/73302671092956" and extend the provided captcha example to handle division operations.
    Modify the code to:
    Handle division (/) operations in addition to +, -, *
    Round division results to the nearest integer
    Add error handling for division by zero
    Log each calculation step to console
     */

    @Test
    void captchaTest() {

        driver.get("https://form.jotform.com/73302671092956");
        driver.findElement(By.id("jfCard-welcome-start")).click();
        driver.findElement(By.id("first_1")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("last_1")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.xpath("//button[@data-testid='nextButton_0']")).click();
        driver.findElement(By.name("q2_email")).sendKeys(Faker.instance().internet().emailAddress());
        driver.findElement(By.xpath("//button[@data-testid='nextButton_1']")).click();
        driver.findElement(By.id("input_3")).sendKeys(Faker.instance().lorem().paragraph(2));
        driver.findElement(By.xpath("//button[@data-testid='nextButton_2']")).click();


        driver.switchTo().frame(0);//Now we are in the other page in the main page!

        int number1 = Integer.parseInt(driver.findElement(By.id("number")).getText());
        int number2 = Integer.parseInt(driver.findElement(By.id("number2")).getText());
        System.out.println("number2 = " + number2);
        System.out.println("number1 = " + number1);
        String function = driver.findElement(By.id("function")).getText();
        System.out.println("function = " + function);

        int result = 0;

        switch (function) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "x":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0) {
                    System.out.println("You can not use 0 as devider!");
                } else {
                    result = number1 / number2;
                }
                break;
        }

        System.out.println("result = " + result);

        driver.findElement(By.id("result")).sendKeys("" + result);

        driver.switchTo().parentFrame();//This will take us to the previous page!

        driver.findElement(By.xpath("(//button[@type='submit'])[last()]")).click();

        String thankYou = driver.findElement(By.tagName("h1")).getText();
        //System.out.println("thankYou = " + thankYou);
        Assertions.assertEquals("Thank You!", thankYou);


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
