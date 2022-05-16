package Model;

import Utils.ExcelUtils;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;
import java.util.Date;

public class TestData {
    private String action;
    private Date logTime;
    private String testMethodName;
    private String expectedOutput;
    private String actualOutput;
    private String status;
    private String exception = null;
    private String image = null;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getTestMethodName() {
        return testMethodName;
    }

    public void setTestMethodName(String testMethodName) {
        this.testMethodName = testMethodName;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public String getActualOutput() {
        return actualOutput;
    }

    public void setActualOutput(String actualOutput) {
        this.actualOutput = actualOutput;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void writeTestData(int startIndex, Row row, XSSFSheet sheet) throws IOException {
        CreationHelper helper = sheet.getWorkbook().getCreationHelper();
        CellStyle cellStyle = row.getRowStyle();

        Cell cell;

        cell = row.createCell(startIndex);
        cell.setCellValue(getAction());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(startIndex + 1);
        System.out.println(new Date());
        cell.setCellValue(new Date());
        CellStyle dateStyle = cellStyle;
        dateStyle.setDataFormat(helper.createDataFormat().getFormat("hh:mm:ss dd-mm-yyyy"));
        cell.setCellStyle(dateStyle);

        cell = row.createCell(startIndex + 2);
        cell.setCellValue(getTestMethodName());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(startIndex + 3);
        cell.setCellValue(getExpectedOutput());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(startIndex + 4);
        cell.setCellValue(getActualOutput());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(startIndex + 5);
        cell.setCellValue(getStatus());
        cell.setCellStyle(cellStyle);

        if (getException() != null) {
            cell = row.createCell(startIndex + 6);
            cell.setCellValue(getException());
        }

        if (getImage() != null) {
            cell = row.createCell(startIndex + 7);
            cell.setCellStyle(cellStyle);
            ExcelUtils.writeImage(getImage(), row, cell, sheet);

            cell = row.createCell(startIndex + 8);
            cell.setCellStyle(cellStyle);
            cell.setCellValue("Click to view picture");
            XSSFHyperlink hyperlink = (XSSFHyperlink) helper.createHyperlink(HyperlinkType.URL);
            hyperlink.setAddress(getImage().replace("\\", "/"));
            cell.setHyperlink(hyperlink);
        }

    }
}
