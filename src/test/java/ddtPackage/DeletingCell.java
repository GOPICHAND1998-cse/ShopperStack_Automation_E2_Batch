package ddtPackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DeletingCell
{

    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DummyWorkBook.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("UpdatedBookName");

            Row row = sheet.getRow(sheet.getLastRowNum());

            Cell desiredCell = row.getCell(row.getFirstCellNum());

            row.removeCell(desiredCell);

            FileOutputStream fos  = new FileOutputStream("./src/test/resources/TestDataFolder/DummyWorkBook.xlsx");

            workbook.write(fos);

            workbook.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
