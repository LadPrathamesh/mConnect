package testCases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.testng.annotations.Test;
import testBase.TestBase;

public class ExcelWrite extends TestBase {

    private static final String FILE_PATH = "src\\test\\java\\testData\\Results.xlsx";
    private static final String SHEET_NAME = "Userlist";

    @Test(dataProvider = "loginData")
    public void writeDataToExcel(String usernameWrite, String value) throws IOException {
        try {
            FileInputStream file = new FileInputStream(FILE_PATH);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(SHEET_NAME);

            int count = sheet.getLastRowNum();
            int rowIndex = count+1; // Replace with the desired row index

            // Uncomment these lines to create a new row if it doesn't exist
            if (rowIndex < 0) {
                rowIndex = 0;
            }
            Row row = sheet.createRow(rowIndex);

            // Column indices where you want to write the data
            int usernameColumnIndex = 0; 
            int valueColumnIndex = 1; 

            Cell newUsernameCell = row.createCell(usernameColumnIndex);
            Cell newValueCell = row.createCell(valueColumnIndex);

            newUsernameCell.setCellValue(usernameWrite);
            newValueCell.setCellValue(value);

            file.close();

            FileOutputStream outputStream = new FileOutputStream(FILE_PATH);
            workbook.write(outputStream);
            outputStream.close();

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
