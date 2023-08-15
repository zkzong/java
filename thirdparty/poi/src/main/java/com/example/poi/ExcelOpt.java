package com.example.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zong on 2016/10/13.
 */
public class ExcelOpt {

    @Test
    public void readExcel() throws IOException {
        File file = new File("region.xlsx");
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }

            // 读取Sheet中数据
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    // 第一列值
                    XSSFCell districtName = xssfRow.getCell(0);
                    System.out.print(districtName + " : ");
                    // 第二列值
                    XSSFCell cityName = xssfRow.getCell(1);
                    System.out.println(cityName);
                }
            }
        }
    }

    /**
     * 读取数字时自动带.0
     * 解决方法有两种：
     * 1. cell.setCellType(CellType.STRING);
     * 2. DataFormatter dataFormatter = new DataFormatter();
     * String value = dataFormatter.formatCellValue(cell);
     *
     * @throws IOException
     */
    @Test
    public void readNumber() throws IOException {
        File file = new File("number.xlsx");
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        for (Sheet sheet : xssfWorkbook) {
            String sheetName = sheet.getSheetName();
            int lastRowNum = sheet.getLastRowNum();
            System.out.println("SheetName = " + sheetName + "，总共有 " + lastRowNum + " 行");

            for (Row row : sheet) {
                for (Cell cell : row) {
                    // 第1种方式
                    cell.setCellType(CellType.STRING);
                    System.out.println(cell);
                    // 第2种方式
                    DataFormatter dataFormatter = new DataFormatter();
                    String value = dataFormatter.formatCellValue(cell);
                    System.out.println(value);
                }
            }
        }
    }

    @Test
    public void formula() throws IOException {
        File file = new File("formula.xlsx");
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        for (Sheet sheet : xssfWorkbook) {
            String sheetName = sheet.getSheetName();
            int lastRowNum = sheet.getLastRowNum();
            System.out.println("SheetName = " + sheetName + "，总共有 " + (lastRowNum + 1) + " 行");

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print("STRING ");
                            String stringCellValue = cell.getStringCellValue();
                            System.out.println(stringCellValue);
                        case NUMERIC:
                            System.out.print("NUMERIC ");
                            DataFormatter dataFormatter = new DataFormatter();
                            String cellValue = dataFormatter.formatCellValue(cell);
                            // 使用getNumericCellValue方法，3变成3.0
                            //double numericCellValue = cell.getNumericCellValue();
                            System.out.println(cellValue);
                            break;
                        case FORMULA:
                            System.out.print("FORMULA ");
                            // Cell强转为XSSFCell，否则没有getRawValue方法
                            XSSFCell xssfCell = (XSSFCell) cell;
                            String formulaCellValue = xssfCell.getRawValue();
                            //String formulaCellValue = cell.getStringCellValue();
                            System.out.println(formulaCellValue);
                            break;
                        default:
                            System.out.print("default ");
                            String value = cell.getStringCellValue();
                            System.out.println(value);
                            break;
                    }
                }
            }
        }
        xssfWorkbook.close();
    }

    @Test
    public void formula2() throws IOException {
        File file = new File("formula.xlsx");
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        for (int i = 0; i < xssfWorkbook.getNumberOfSheets(); i++) {
            XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
            for (int j = 0; j <= sheet.getLastRowNum(); j++) {
                XSSFRow row = sheet.getRow(j);
                for (int k = 0; k < row.getLastCellNum(); k++) {
                    XSSFCell cell = row.getCell(k);
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print("STRING ");
                            String stringCellValue = cell.getStringCellValue();
                            System.out.println(stringCellValue);
                        case NUMERIC:
                            System.out.print("NUMERIC ");
                            DataFormatter dataFormatter = new DataFormatter();
                            String cellValue = dataFormatter.formatCellValue(cell);
                            // 使用getNumericCellValue方法，3变成3.0
                            //double numericCellValue = cell.getNumericCellValue();
                            System.out.println(cellValue);
                            break;
                        case FORMULA:
                            System.out.print("FORMULA ");
                            String formulaCellValue = cell.getRawValue();
                            System.out.println(formulaCellValue);
                            break;
                        default:
                            System.out.print("default ");
                            String value = cell.getStringCellValue();
                            System.out.println(value);
                            break;
                    }
                }
            }
        }
    }

}
