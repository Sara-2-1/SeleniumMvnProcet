package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C15_JavaFaker {

    @Test
    void javaFakerTest() {

        Faker faker = new Faker();
        System.out.println("faker.name() = " + faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());
        System.out.println(faker.address().cityName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.app().name());
        System.out.println(faker.lorem().paragraph(50));
        System.out.println(faker.lordOfTheRings().character());
        System.out.println(faker.internet().password(12, 13, true, true));
        System.out.println(faker.slackEmoji().emoji());

        driver.findElement(By.name("username")).sendKeys(faker.name().username());
        driver.findElement(By.name("password")).sendKeys(faker.internet().password());
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys(Faker.instance().lorem().paragraph(50), Keys.ENTER);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

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
        Thread.sleep(6000);
        driver.quit();
    }


}
