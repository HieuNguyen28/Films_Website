package Utils;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class ExcelUtils {
    public static final String CHROME_DRIVER_PATH = "D:\\Test_Advanced\\chromedriver.exe";
    public static final String DATA_PATH = "D:\\Java4\\PS15722_NguyenChiHieu_ASM\\src\\test\\resources\\data\\";
    public static final String IMAGES_PATH = "D:\\Java4\\PS15722_NguyenChiHieu_ASM\\src\\test\\resources\\images\\";

    public static XSSFWorkbook getWorkbook(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        return new XSSFWorkbook(fileInputStream);
    }

    public static XSSFSheet getSheet(XSSFWorkbook workbook, String sheetName) throws NullPointerException {
        return workbook.getSheet(sheetName);
    }

    public static CellStyle getRowStyle(XSSFWorkbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setWrapText(true);


        return cellStyle;
    }

    public static String getCellValue(XSSFSheet sheet, int row, int column) {
        XSSFCell cell = sheet.getRow(row).getCell(column);
        try {
            if (cell.getCellType() == CellType.NUMERIC) {
                return String.format("%.0f", cell.getNumericCellValue());
            }else if (cell.getCellType() == CellType.BOOLEAN){
                return cell.getBooleanCellValue()+"";
            }else {
                return cell.getStringCellValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void takeScreenshot(WebDriver driver, String outputPath) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(outputPath));
    }

    public static Object[][] readSheetData(XSSFSheet sheet) {
        int rows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows - 1][columns];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i - 1][j] = ExcelUtils.getCellValue(sheet, i, j);
            }
        }

        return data;
    }

    public static void writeImage(String imagePath, Row row, Cell cell, XSSFSheet sheet) throws IOException {
        InputStream inputStream = new FileInputStream(imagePath);
        byte[] images = IOUtils.toByteArray(inputStream);
        int pictureID = sheet.getWorkbook().addPicture(images, XSSFWorkbook.PICTURE_TYPE_PNG);
        inputStream.close();

        XSSFDrawing xssfDrawing = sheet.createDrawingPatriarch();
        ClientAnchor clientAnchor = new XSSFClientAnchor();

        clientAnchor.setCol1(cell.getColumnIndex());
        clientAnchor.setRow1(row.getRowNum());
        clientAnchor.setCol2(cell.getColumnIndex() + 1);
        clientAnchor.setRow2(row.getRowNum() + 1);

        xssfDrawing.createPicture(clientAnchor, pictureID);
    }

    public static void export(String outputPath, XSSFWorkbook workbook) throws IOException {
        FileOutputStream xssfWriter = new FileOutputStream(outputPath);
        workbook.write(xssfWriter);
        xssfWriter.close();
    }
}
