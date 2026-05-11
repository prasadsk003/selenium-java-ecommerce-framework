package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtility {

    FileInputStream fis;
    FileOutputStream fos;
    Workbook workbook;
    Sheet sheet;
    Row row;
    Cell cell;

    String path;

    // Constructor
    public ExcelUtility(String path) {
        this.path = path;
    }

    // Get Row Count
    public int getRowCount(String sheetName) throws IOException {

        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();

        workbook.close();
        fis.close();

        return rowCount;
    }

    // Get Cell Count
    public int getCellCount(String sheetName, int rowNum) throws IOException {

        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);

        int cellCount = row.getLastCellNum();

        workbook.close();
        fis.close();

        return cellCount;
    }

    // Read Data from Cell
    public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {

        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(cellNum);

        DataFormatter formatter = new DataFormatter();

        String data;

        try {
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }

        workbook.close();
        fis.close();

        return data;
    }

    // Write Data into Cell
    public void setCellData(String sheetName, int rowNum, int cellNum, String value) throws IOException {

        File file = new File(path);

        if (!file.exists()) {
            workbook = new XSSFWorkbook();
            fos = new FileOutputStream(path);
            workbook.write(fos);
        }

        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet(sheetName);

        if (sheet == null)
            sheet = workbook.createSheet(sheetName);

        row = sheet.getRow(rowNum);

        if (row == null)
            row = sheet.createRow(rowNum);

        cell = row.getCell(cellNum);

        if (cell == null)
            cell = row.createCell(cellNum);

        cell.setCellValue(value);

        fos = new FileOutputStream(path);

        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();
    }
}