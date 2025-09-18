package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class AddRecordsWebTable extends TestBase {

/*
Go to https://claruswaysda.github.io/addRecordWebTable.html
Add 10 records using Faker.
Find the name of the youngest record.
*/
    @Test
    void findYoungestRecordTest() {

        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("nameInput")).sendKeys(faker.name().fullName());
            driver.findElement(By.id("ageInput")).sendKeys(faker.number().numberBetween(18, 65) + "");
            new Select(driver.findElement(By.id("countrySelect")))
                    .selectByIndex(faker.number().numberBetween(1, 5));
            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
        }

        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

        String youngestName = "";
        int youngestAge = Integer.MAX_VALUE;

        for (WebElement row : rows) {
            String name = row.findElement(By.xpath(".//td[1]")).getText();
            int age = Integer.parseInt(row.findElement(By.xpath(".//td[2]")).getText());

            if (age < youngestAge) {
                youngestAge = age;
                youngestName = name;
            }
        }

        System.out.println("Youngest person: " + youngestName + " with age " + youngestAge);
    }
}