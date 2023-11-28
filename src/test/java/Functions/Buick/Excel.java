package Functions.Buick;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    static List<String> cellValues = new ArrayList<>();
    static int columnIndex = 1;

    public static void main(String[] args) {
        readExceldoc();
    }

    public static List<String> readExceldoc() {
        try {
            String filePath = "C:\\CHEVY\\NewChevySiteMap.xlsx";
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(file);
            String sheetName = "Weekly Check"; // Replace with your desired sheet name
            // Access the first sheet in the workbook
            Sheet sheet = workbook.getSheet(sheetName);
            // ArrayList to store the cell values
            // Iterate over each row in the sheet
            for (Row row : sheet) {
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    // Access the cell value based on the cell type
                    CellType cellType = cell.getCellType();
                    if (cellType == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        cellValues.add(cellValue);
                    } else if (cellType == CellType.NUMERIC) {
                        String cellValue = String.valueOf(cell.getNumericCellValue());
                        cellValues.add(cellValue);
                    } else if (cellType == CellType.BOOLEAN) {
                        String cellValue = String.valueOf(cell.getBooleanCellValue());
                        cellValues.add(cellValue);
                    }
                }
            }
            // Close the workbook and file input stream
            workbook.close();
            file.close();
            for (String value : cellValues) {
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellValues;
    }



}
