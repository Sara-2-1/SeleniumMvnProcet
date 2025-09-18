package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C41_TableTotalPrice extends TestBase {
    /*
    Go to https://claruswaysda.github.io/webTable.html
    Calculate and assert the total price in Table 2.
    */

    @Test
    void tableTotalPriceTest() {

//        Go to https://claruswaysda.github.io/webTable.html
        driver.get("https://claruswaysda.github.io/webTable.html");

//        Calculate and assert the total price in Table 2.
        WebElement table2 = driver.findElement(By.id("t2"));
        List<WebElement> prices = table2.findElements(By.xpath(".//td[3]"));
        //prices.forEach(t -> System.out.println(t.getText()));
        int totalPrice = 0;
        for (WebElement eachPrice : prices) {
            totalPrice += Integer.parseInt(eachPrice.getText().replaceAll("[^0-9.,]", ""));
        }

        System.out.println("totalPrice = " + totalPrice);
        assertEquals(2275, totalPrice);

    }
}