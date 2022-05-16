package Model;

import Utils.ExcelUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Set;

public class LoginData extends TestData implements Log<LoginData>{

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void writeLog(String src, String sheetName, Set<LoginData> logs) throws Exception {
        XSSFWorkbook workbook = ExcelUtils.getWorkbook(src);
        XSSFSheet sheet = ExcelUtils.getSheet(workbook,sheetName);
        int startRow = 0, lastRow = Math.max(sheet.getPhysicalNumberOfRows(), startRow);

        CellStyle  style = ExcelUtils.getRowStyle(workbook);

        for (LoginData log:
             logs) {
            Row row = sheet.createRow(lastRow);
            row.setHeightInPoints(50);
            row.setRowStyle(style);

            log.writeDataRow(log, row, sheet);
            lastRow++;
        }
        sheet.autoSizeColumn(logs.size());
        ExcelUtils.export(src,workbook);
    }

    @Override
    public void writeDataRow(LoginData log, Row row, XSSFSheet sheet) throws Exception {
        CellStyle  style = row.getRowStyle();
        Cell cell;

        cell= row.createCell(0);
        cell.setCellValue(log.getUsername());
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue(log.getPassword());
        cell.setCellStyle(style);

        writeTestData(2, row, sheet);
    }
}
