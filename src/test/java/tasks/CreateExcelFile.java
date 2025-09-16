package tasks;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class CreateExcelFile {


    public static void main(String[] args) throws IOException {
        Path RESOURCES = Path.of(System.getProperty("user.dir"), "src/main/resources");
        String filePath = RESOURCES.resolve("Countries.xlsx").toString();

        // 1️⃣ إنشاء الملف XLSX جديد بالكامل
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Country");
        headerRow.createCell(1).setCellValue("Capital");
        headerRow.createCell(2).setCellValue("POPULATION");

        // إضافة البيانات
        Object[][] data = {
                {"Saudi Arabia", "Riyadh", 36000000},
                {"USA", "Washington", 331000000},
                {"Japan", "Tokyo", 125000000}
        };

        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue((String) data[i][0]);
            row.createCell(1).setCellValue((String) data[i][1]);
            row.createCell(2).setCellValue((Integer) data[i][2]);
        }

        // حفظ الملف
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
        workbook.close();
        System.out.println("✅ ملف XLSX جاهز ومطابق لـ Apache POI");

        // 2️⃣ قراءة الملف للتأكد أنه يعمل
        Workbook readWorkbook;
        try (FileInputStream fis = new FileInputStream(filePath)) {
            readWorkbook = WorkbookFactory.create(fis);
            Sheet readSheet = readWorkbook.getSheetAt(0);
            for (Row r : readSheet) {
                for (Cell c : r) {
                    System.out.print(c + " | ");
                }
                System.out.println();
            }
            readWorkbook.close();
        }
    }
}