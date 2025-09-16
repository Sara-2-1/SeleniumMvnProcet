package tasks;

import org.apache.poi.ss.usermodel.Cell;
import utilities.ExcelUtils;

public class C38_ExcelUtil {

    public static void main(String[] args) {

        ExcelUtils excelUtils = new ExcelUtils("/Users/sarahali/Downloads/People.xlsx");
        Cell r3c5 = excelUtils.getCell("Sheet3", 2, 4);
        System.out.println("r3c5 = " + r3c5.getStringCellValue());

        ExcelUtils excelUtils2 = new ExcelUtils("/Users/sarahali/Downloads/People.xlsx");
        Cell r4c6 = excelUtils2.getCell("Sheet1", 3, 5);
        System.out.println("r4c6 = " + r4c6);

    }

}
