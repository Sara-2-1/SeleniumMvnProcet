package tasks;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C37_ExcelRead extends TestBase {
    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add 10 records to the table by taking data (Name, Age, Country) from Excel.
     */

    @Test
    void excelReadTest() {

//        Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

//        Add 10 records to the table by taking data (Name, Age, Country) from Excel.
        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(new FileInputStream("/Users/sarahali/Downloads/People.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet1 = workbook.getSheet("Sheet1");
//        Row row2 = sheet1.getRow(1);
//        Cell r2c1 = row2.getCell(0);
//        System.out.println("r2c1 = " + r2c1);

        for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
            String name = sheet1.getRow(i).getCell(0).getStringCellValue();
            Double age = sheet1.getRow(i).getCell(1).getNumericCellValue();
            String country = sheet1.getRow(i).getCell(2).getStringCellValue();
            driver.findElement(By.id("nameInput")).sendKeys(name);
            driver.findElement(By.id("ageInput")).sendKeys((age+"").substring(0,2));
            new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
        }
    }
}
