package ddtPackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UpdatingExistingCellData
{
    public static void main(String[] args) {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DummyWorkBook.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("Books");

            Row row = sheet.getRow(4);

            Cell cell = row.getCell(0);

            cell.setCellValue("Cucumber");


            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataFolder/DummyWorkBook.xlsx");

            workbook.write(fos);

            workbook.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
