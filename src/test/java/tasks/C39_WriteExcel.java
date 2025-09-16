package tasks;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import utilities.ExcelUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C39_WriteExcel {
    /*
Given: Save StudentScores.xlsx file into your project

When: In the grade column, write the letter grades (A, B, C, D, F) based on the score ranges:
A: 90-100
B: 80-89
C: 70-79
D: 60-69
F: below 60

Then: Assert that the grade of "Alice" is "A"
     */

    @Test
    void writeExcelTest() throws IOException {

        Workbook workbook = new ExcelUtils("/Users/sarahali/Downloads/StudentScores.xlsx").getWorkbook();
        Sheet sheet = workbook.getSheet("Sheet1");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            double score = sheet.getRow(i).getCell(1).getNumericCellValue();
            //System.out.println("score = " + score);
            String grade = "";
            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            } else if (score >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            sheet.getRow(i).createCell(2).setCellValue(grade);
        }

        FileOutputStream fo = new FileOutputStream("src/main/resources/StudentScores.xlsx");
        workbook.write(fo);

        //Then: Assert that the grade of "Alice" is "A"
        String aliceGrade = "";
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0).getStringCellValue().equals("Alice")) {
                aliceGrade = sheet.getRow(i).getCell(2).getStringCellValue();
            }
        }

        assertEquals("A", aliceGrade);

        workbook.close();
        fo.close();
    }

}
