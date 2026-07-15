package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {
    private Workbook workbook;
    private String filePath;

    public ExcelUtils(String filePath) {
        this.filePath = filePath;
        this.workbook = new XSSFWorkbook();
    }

    public void writeTable(String sheetName, Object[][] data) {
        Sheet sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < data.length; i++) {
            Row row = sheet.createRow(i);

            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                Object value = data[i][j];

                if (value instanceof String) cell.setCellValue((String) value);
                else if (value instanceof Integer) cell.setCellValue((Integer) value);
                else if (value instanceof Double) cell.setCellValue((Double) value);
                else if (value instanceof Boolean) cell.setCellValue((Boolean) value);
                else if (value != null) cell.setCellValue(value.toString());
            }
        }

        for (int j = 0; j < data[0].length; j++) {
            sheet.autoSizeColumn(j);
        }
    }

    public void saveFile() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
        workbook.close();
        System.out.println("Written in excel files.");
    }

    public String readCell(Sheet sheet, int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) return null;

        Cell cell = row.getCell(colNum);
        if (cell == null) return null;

        return cell.toString();
    }

}
