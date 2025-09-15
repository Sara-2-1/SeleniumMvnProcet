package tasks;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C36_AddDeleteTable extends TestBase {

    @Test
    void addDeleteTableTest() throws InterruptedException {

//        Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

//        Add 3 records
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("nameInput")).sendKeys(Faker.instance().name().fullName());
            driver.findElement(By.id("ageInput")).sendKeys(Faker.instance().number().numberBetween(18, 65) + "");
            new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(Faker.instance().number().numberBetween(1, 5));
            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
        }


//        Edit the 5th record
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[.='Edit'])[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nameInput")).clear();
        driver.findElement(By.id("nameInput")).sendKeys(Faker.instance().name().fullName());
        Thread.sleep(1000);
        driver.findElement(By.id("ageInput")).clear();
        driver.findElement(By.id("ageInput")).sendKeys(Faker.instance().number().numberBetween(18, 65) + "");
        Thread.sleep(1000);
        new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(Faker.instance().number().numberBetween(1, 5));
        driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();

//        Delete the 1st record
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[.='Delete'])[1]")).click();

    }


}
