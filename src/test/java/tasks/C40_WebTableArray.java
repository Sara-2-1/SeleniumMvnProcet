package tasks;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class C40_WebTableArray extends TestBase {

/*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add 10 records.
    Store the name, age, and country columns in separate arrays (not ArrayList).
*/

    @Test
    void webTableArrayTest() {

//        Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

//        Add 10 records.
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("nameInput")).sendKeys(Faker.instance().name().fullName());
            driver.findElement(By.id("ageInput")).sendKeys(Faker.instance().number().numberBetween(18, 65) + "");
            new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(Faker.instance().number().numberBetween(1, 5));
            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();

        }

//        Store the name, age, and country columns in separate arrays (not ArrayList).
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        String[] names = new String[rows.size()];
        String[] ages = new String[rows.size()];
        String[] countries = new String[rows.size()];

        for (int i = 0; i < rows.size(); i++) {
            names[i] = rows.get(i).findElement(By.xpath(".//td[1]")).getText();
            ages[i] = rows.get(i).findElement(By.xpath(".//td[2]")).getText();
            countries[i] = rows.get(i).findElement(By.xpath(".//td[3]")).getText();
        }

        System.out.println("names = " + Arrays.toString(names));
        System.out.println("ages = " + Arrays.toString(ages));
        System.out.println("countries = " + Arrays.toString(countries));

    }


}
