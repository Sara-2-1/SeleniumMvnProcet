package tasks;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EarningsRankingTest {
 //Given: Save EarningList.xlsx file into your project
 //When: In the row column, write the row numbers according to the earnings amount (Natural Order -
 //lowest to highest).
 //Then: Assert that row number of Wednesday is 1

    @Test
    void testEarningsRanking() throws Exception {
        Path RESOURCES = Path.of(System.getProperty("user.dir"), "src/main/resources", "EarningList.xlsx");

        FileInputStream fis = new FileInputStream(RESOURCES.toFile());
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        List<Map.Entry<String, Integer>> earningsList = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // ابدأ من الصف 1 (تجاهل العناوين)
            Row row = sheet.getRow(i);
            String day = row.getCell(0).getStringCellValue();
            int earning = (int) row.getCell(1).getNumericCellValue();
            earningsList.add(new AbstractMap.SimpleEntry<>(day, earning));
        }

        earningsList.sort(Map.Entry.comparingByValue());

        int rank = 1;
        for (Map.Entry<String, Integer> entry : earningsList) {
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String day = row.getCell(0).getStringCellValue();
                if (day.equals(entry.getKey())) {
                    row.createCell(2, CellType.NUMERIC).setCellValue(rank);
                }
            }
            rank++;
        }

        fis.close();
        try (FileOutputStream fos = new FileOutputStream(RESOURCES.toFile())) {
            workbook.write(fos);
        }
        workbook.close();

        int wednesdayRank = -1;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String day = row.getCell(0).getStringCellValue();
            if (day.equals("Wednesday")) {
                wednesdayRank = (int) row.getCell(2).getNumericCellValue();
                break;
            }
        }

        assertEquals(1, wednesdayRank, "❌ Wednesday should be rank 1!");
        System.out.println("✅ Test Passed: Wednesday = 1");
    }
}

