package utility;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() throws IOException {
        FileInputStream file = new FileInputStream("src\\test\\java\\testData\\Login Details.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("Userlist");

        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][2];

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            Cell usernameCell = row.getCell(0);
            Cell passwordCell = row.getCell(1);

            data[i - 1][0] = usernameCell.getStringCellValue();
            data[i - 1][1] = passwordCell.getStringCellValue();
        }

        workbook.close();
        return data;
    }
}
