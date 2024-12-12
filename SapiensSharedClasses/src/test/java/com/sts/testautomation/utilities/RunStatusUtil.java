package com.sts.testautomation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.sts.testautomation.BaseTest;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class RunStatusUtil extends BaseTest {

    public static FileInputStream fis;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static List<String> testCases = new ArrayList<String>();
    public static List<String> runStatus = new ArrayList<String>();
    //public static HashMap<Integer, String> rowAndTestCaseMap = new HashMap<Integer, String>();


    public static void getRunStatus() throws Exception {
        try {

            fis = new FileInputStream("../src/data/Hollard Nimbis Buildings.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("ControlSheet");

//            for(currentRow = 1; currentRow<=getLastRowNum("Executions"); currentRow++){

//                for (int k = 3; k < getLastColumnNum("Executions", 0); k++) {
//                    int j = 0;
//                    testCases.add(getCellContent("Executions", 0, k));
//                    runStatus.add(getCellContent("Executions", currentRow, k));
//                    j++;
//                }
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*
     * Takes rowname and sheetname as parameter return row number based on rowname
     */
    public static int getRowNumForRowName(String sheetname, String rowName) {
        int rownum = 0;
        sheet = workbook.getSheet(sheetname);
        for (int i = 1; i <= getLastRowNum(sheetname); i++) {
            if (rowName.equalsIgnoreCase(sheet.getRow(i).getCell(0).getStringCellValue())) {
                rownum = i;
                break;
            }
        }

        return rownum;
    }

    /*
     * Takes columnname and sheetname as parameter return column number based on
     * columnheader
     */

    public static int getColumnNumForColumnName(String sheetname, String columnname) {
        int colnum = 0;
        sheet = workbook.getSheet(sheetname);
        for (int i = 0; i < getLastColumnNum(sheetname, 0); i++) {
            if (columnname.equalsIgnoreCase(sheet.getRow(0).getCell(i).getStringCellValue())) {
                colnum = i;
                break;
            }
        }

        return colnum;

    }

    /*
     * Takes sheetname as parameter return last row number of the sheet
     */
    public static int getLastRowNum(String sheetname) {
        return workbook.getSheet(sheetname).getLastRowNum();
    }

    /*
     * Takes sheetname, row number as parameter return last cell number of the row
     */
    public static int getLastColumnNum(String sheetname, int rownum) {
        return workbook.getSheet(sheetname).getRow(rownum).getLastCellNum();
    }

    /*
     * Takes sheetname, row number, column number as parameter return cell value
     */
    public static String getCellContent(String sheetname, int rownum, int colnum) {
        sheet = workbook.getSheet(sheetname);
        return sheet.getRow(rownum).getCell(colnum).getStringCellValue().concat("").toString();

    }

    /*
     * Takes sheetname, row number, column name as parameter return cell value
     */
    public static String getCellContent(String sheetname, int rownum, String columnname) {
        sheet = workbook.getSheet(sheetname);
        return sheet.getRow(rownum).getCell(getColumnNumForColumnName(sheetname, columnname)).getStringCellValue()
                .concat("").toString();

    }
}
