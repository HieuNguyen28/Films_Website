package Model;

import Model.TestData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.Set;

public interface Log<T extends TestData> {
    public void writeLog(String src, String sheetName, Set<T> logs) throws Exception;
    public void writeDataRow(T logs, Row row, XSSFSheet sheet) throws Exception;
}
