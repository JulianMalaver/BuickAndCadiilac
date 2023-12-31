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

    // Declares a type string variable, commonly used to collect data during the execution of a program
    static List<String> cellValues = new ArrayList<>();
    static int columnIndex = 1;

    public static void main(String[] args) {
        readExcelFile();
    }
    public static List<String> readExcelFile() {
        try{
            String filepath = "C:\\Projects\\ExcelFiles\\BuickWeeklyHealthLinks.xlsx";
            FileInputStream file = new FileInputStream(new File(filepath));
            Workbook workbook = new XSSFWorkbook(file);
            String sheetName = "Buick Weekly HealthChecks";
            Sheet sheet = workbook.getSheet(sheetName);
            for (Row row : sheet){
                Cell cell = row.getCell(columnIndex);
                if(cell != null){
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
            workbook.close();
            file.close();
            for(String value : cellValues){
                System.out.println(value);
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return cellValues;
    }

}


