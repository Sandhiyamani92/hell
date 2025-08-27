package NIMBIS_SharedClasses.utilities;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

    public static List<Map<String, String>> readExcelData(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> dataList = new ArrayList<>();

        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0); // First row contains headers

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            if (currentRow == null) continue;

            Map<String, String> dataMap = new HashMap<>();
            for (int j = 0; j < currentRow.getLastCellNum(); j++) {
                String header = headerRow.getCell(j).getStringCellValue();
                Cell cell = currentRow.getCell(j);

                if (cell != null) {
                    cell.setCellType(CellType.STRING);
                    dataMap.put(header, cell.getStringCellValue());
                } else {
                    dataMap.put(header, "");
                }
            }
            dataList.add(dataMap);
        }

        workbook.close();
        file.close();
        return dataList;
    }
}
