package tasks;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class WebTableIntegration {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1️⃣ فتح ملف الإكسل
        String excelPath = System.getProperty("user.home") + "/Downloads/Practice_Tasks.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        // 2️⃣ فتح المتصفح
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        // 3️⃣ قراءة الصفوف واحد واحد
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            String name = row.getCell(0).getStringCellValue();

            // حل مشكلة أن الخلية قد تكون نص أو رقم
            Cell ageCell = row.getCell(1);
            int age;
            if (ageCell.getCellType() == CellType.NUMERIC) {
                age = (int) ageCell.getNumericCellValue();
            } else {
                age = Integer.parseInt(ageCell.getStringCellValue());
            }

            String country = row.getCell(2).getStringCellValue();

            // 4️⃣ تعبئة الفورم
            WebElement nameField = driver.findElement(By.id("name"));
            WebElement ageField = driver.findElement(By.id("age"));
            WebElement countryField = driver.findElement(By.id("country"));
            WebElement addButton = driver.findElement(By.id("add"));

            nameField.clear();
            nameField.sendKeys(name);
            ageField.clear();
            ageField.sendKeys(String.valueOf(age));
            countryField.clear();
            countryField.sendKeys(country);
            addButton.click();

            Thread.sleep(300);
        }

        System.out.println("✅ تم إدخال جميع البيانات بنجاح!");

        // إغلاق كل شيء
        workbook.close();
        fis.close();
        driver.quit();
    }
}
