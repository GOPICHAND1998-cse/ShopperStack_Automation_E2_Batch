package ddtPackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class FetchingSingleDataFromExecl
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DummyWorkBook.xlsx") ;

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("Books");

            Row row = sheet.getRow(2);

            Cell cell = row.getCell(0);

            System.out.println(cell.getStringCellValue());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
