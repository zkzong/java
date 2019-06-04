package com.zkzong.poi;

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
        File file = new File("T1区域表.xlsx");
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

    @Test
    public void readNumber() throws IOException {
        File file = new File("number.xlsx");
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        for (Sheet sheet : xssfWorkbook) {
            String sheetName = sheet.getSheetName();
            int lastRowNum = sheet.getLastRowNum();
            System.out.println("SheetName = " + sheetName + "，总共有 " + lastRowNum + " 行");

            DataFormatter dataFormatter = new DataFormatter();
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // 第1种方式
                    cell.setCellType(CellType.STRING);
                    // 第2种方式
                    String value = dataFormatter.formatCellValue(cell);
                    System.out.println(value);
                }
            }
        }
    }
}
