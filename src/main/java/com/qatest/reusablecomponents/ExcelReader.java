package com.qatest.reusablecomponents;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    public static Map<String, String> getTestData(String sheetName,int rowIndex) throws IOException {
        Map<String, String> vehicleData = new HashMap<>();
        Workbook workbook = WorkbookFactory.create(new File(PropertiesLoader.getPropertyByKey("dataSheet")));
        Sheet sheet = workbook.getSheet(sheetName);
        int cellCount = sheet.getRow(0).getLastCellNum();
            for (int j = 0; j < cellCount; j++) {
                System.out.println(sheet.getRow(rowIndex).getCell(j).getStringCellValue());
                vehicleData.put(sheet.getRow(0).getCell(j).getStringCellValue(),
                        sheet.getRow(rowIndex).getCell(j).getStringCellValue());
            }
        return vehicleData;
    }
    public static int getRowCountOfSheet(String sheetName) throws IOException {
        Workbook workbook = WorkbookFactory.create(new File(PropertiesLoader.getPropertyByKey("dataSheet")));
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum();
    }
    public static int getCellCountOfSheet(String sheetName) throws IOException {
        Workbook workbook = WorkbookFactory.create(new File(PropertiesLoader.getPropertyByKey("dataSheet")));
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getRow(0).getLastCellNum();
    }
}
