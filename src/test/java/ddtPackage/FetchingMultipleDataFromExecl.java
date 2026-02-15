package ddtPackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class FetchingMultipleDataFromExecl
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DummyWorkBook.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("Books");

            int lastRow = sheet.getLastRowNum();

            int lastCell = sheet.getRow(0).getLastCellNum();

            System.out.println("Row number - "+lastRow);

            System.out.println("Cell number - "+lastCell);

            for(int r=1;r<=lastRow;r++)
            {
                Row newRow = sheet.getRow(r);

                for(int c=0;c<lastCell;c++)
                {
                    System.out.print(newRow.getCell(c).getStringCellValue()+" ");
                }

                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
