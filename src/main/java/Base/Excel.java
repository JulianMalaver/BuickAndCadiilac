package Base;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {

    public class writeExcel{

        //Creation of workbook object. It represents the Excel file
        public static void main (String[]args) throws IOException {
            String path = "C:\\Projects\\ExcelFiles\\BuickWeeklyReport.xlsx";
            FileInputStream fileStream = new FileInputStream(path);
            Workbook workBook = new XSSFWorkbook(fileStream);

            //Represents a sheet in the Excel file
            Sheet sheetOne = workBook.getSheetAt(0);

            //Row represents a row in the sheet
            Row row =sheetOne.getRow(0);
            //Cell object represents a cell in the row
            Cell cell = row.createCell(2);

            //Write data in to the cell object
            cell.setCellValue("WriteIntoExcel");

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
        }

    }


}
