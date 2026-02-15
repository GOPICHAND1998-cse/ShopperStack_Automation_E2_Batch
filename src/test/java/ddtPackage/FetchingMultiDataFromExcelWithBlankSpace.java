package ddtPackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class FetchingMultiDataFromExcelWithBlankSpace
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DummyWorkBook.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("NewBooks");

            int firstRownum = sheet.getFirstRowNum();
            int lastRownum = sheet.getLastRowNum();

            int firstCellNum = sheet.getRow(firstRownum).getFirstCellNum();
            int lastCellNum = sheet.getRow(firstRownum).getLastCellNum();

            for(int r=firstRownum;r<=lastRownum;r++)
            {
                Row newRow = sheet.getRow(r);

                if (newRow==null) continue;

                for(int c=firstCellNum;c<lastCellNum;c++)
                {
                    Cell dataCell = newRow.getCell(c);

                    if (dataCell==null)
                    {
                        continue;
                    }

                    System.out.print(dataCell.getStringCellValue()+"     ");
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
