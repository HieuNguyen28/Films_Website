package Model;

import Utils.ExcelUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Set;

public class RegisterData extends TestData implements Log<RegisterData> {
   private String username;
   private String password;
   private String email;
   private String fullname;
   private boolean role;

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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getFullname() {
      return fullname;
   }

   public void setFullname(String fullname) {
      this.fullname = fullname;
   }

   public boolean isRole() {
      return role;
   }

   public void setRole(boolean role) {
      this.role = role;
   }

   @Override
   public void writeLog(String src, String sheetName, Set<RegisterData> logs) throws Exception {
      XSSFWorkbook workbook = ExcelUtils.getWorkbook(src);
      XSSFSheet sheet = ExcelUtils.getSheet(workbook,sheetName);
      int startRow = 0, lastRow = Math.max(sheet.getPhysicalNumberOfRows(), startRow);

      CellStyle  style = ExcelUtils.getRowStyle(workbook);

      for (RegisterData log:
              logs) {
         Row row = sheet.createRow(lastRow);
         row.setHeightInPoints(50);
         row.setRowStyle(style);

         log.writeDataRow(log, row, sheet);
         lastRow++;
      }
      ExcelUtils.export(src,workbook);
   }

   @Override
   public void writeDataRow(RegisterData logs, Row row, XSSFSheet sheet) throws Exception {
      CellStyle  style = row.getRowStyle();
      Cell cell;

      cell= row.createCell(0);
      cell.setCellValue(logs.getUsername());
      cell.setCellStyle(style);

      cell = row.createCell(1);
      cell.setCellValue(logs.getPassword());
      cell.setCellStyle(style);

      cell = row.createCell(2);
      cell.setCellValue(logs.getEmail());
      cell.setCellStyle(style);

      cell = row.createCell(3);
      cell.setCellValue(logs.getFullname());
      cell.setCellStyle(style);

      cell = row.createCell(4);
      cell.setCellValue(logs.isRole());
      cell.setCellStyle(style);
      writeTestData(5, row, sheet);
   }
}
