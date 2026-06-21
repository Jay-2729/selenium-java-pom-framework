//package utils;
//
//public class ExcelUtil {
//    public static Object[][] getData() {
//        return new Object[][]{
//                {"standard_user", "secret_sauce"}
//        };
//    }
//}

package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getTestData(
            String sheetName) {

        try {

            String path =
                    "src/test/resources/testdata/TestData.xlsx";

            FileInputStream file =
                    new FileInputStream(path);

            Workbook workbook =
                    new XSSFWorkbook(file);

            Sheet sheet =
                    workbook.getSheet(sheetName);

            int rows =
                    sheet.getPhysicalNumberOfRows();

            int cols =
                    sheet.getRow(0)
                            .getPhysicalNumberOfCells();

            Object[][] data =
                    new Object[rows - 1][cols];

            for(int i = 1; i < rows; i++) {

                for(int j = 0; j < cols; j++) {

                    data[i - 1][j] =
                            sheet.getRow(i)
                                    .getCell(j)
                                    .toString();
                }
            }

            workbook.close();

            return data;

        } catch(Exception e) {

            throw new RuntimeException(
                    "Unable to read Excel file",
                    e);
        }
    }
}