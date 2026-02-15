package ddtPackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreatingNewCell
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DummyWorkBook.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("UpdatedBookName");

            Row row = sheet.getRow(0);

            row.createCell(2).setCellValue("Edition");

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
