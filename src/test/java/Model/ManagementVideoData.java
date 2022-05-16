package Model;

import Utils.ExcelUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Set;

public class ManagementVideoData extends TestData implements Log<ManagementVideoData>{
    private String id;
    private String title;
    private String poster;
    private String link;
    private String views;
    private String description;
    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void writeLog(String src, String sheetName, Set<ManagementVideoData> logs) throws Exception {
        XSSFWorkbook workbook = ExcelUtils.getWorkbook(src);
        XSSFSheet sheet = ExcelUtils.getSheet(workbook,sheetName);
        int startRow = 0, lastRow = Math.max(sheet.getPhysicalNumberOfRows(), startRow);

        CellStyle  style = ExcelUtils.getRowStyle(workbook);

        for (ManagementVideoData log: logs) {
            Row row = sheet.createRow(lastRow);
            row.setHeightInPoints(50);
            row.setRowStyle(style);

            log.writeDataRow(log, row, sheet);
            lastRow++;
        }
        ExcelUtils.export(src,workbook);
    }

    @Override
    public void writeDataRow(ManagementVideoData log, Row row, XSSFSheet sheet) throws Exception {
        CellStyle  style = row.getRowStyle();
        Cell cell;

        cell= row.createCell(0);
        cell.setCellValue(log.getId());
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue(log.getTitle());
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue(log.getPoster());
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue(log.getLink());
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue(log.getViews());
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue(log.getDescription());
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue(log.isActive());
        cell.setCellStyle(style);

        writeTestData(7, row, sheet);
    }
}
