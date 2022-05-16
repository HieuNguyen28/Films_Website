package Test;

import Model.RegisterData;
import Utils.ExcelUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RegisterTest {
    private WebDriver driver;
    private String SRC= ExcelUtils.DATA_PATH+"REGISTER_TEST.xlsx";
    private Set<RegisterData> logs;
    private RegisterData data;

    private void processRegister(String username, String password, String email, String fullname){
        WebElement labelElement = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/label[2]"));
        labelElement.submit();
        WebElement usernameElement = driver.findElement(By.name("username"));
        usernameElement.sendKeys(username);
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(password);

        WebElement emailElement = driver.findElement(By.name("email"));
        passwordElement.sendKeys(email);

        WebElement fullnameElement = driver.findElement(By.name("fullname"));
        passwordElement.sendKeys(fullname);
        WebElement buttonElement = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/form[2]/div/div[5]/input"));
        buttonElement.submit();
    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",ExcelUtils.CHROME_DRIVER_PATH);
        logs = new LinkedHashSet<>();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/PS15722_NguyenChiHieu_ASM_war_exploded/LoginServlet");
        data = new RegisterData();
    }

    @Test(dataProvider = "RegisterData")
    public void multipleRegisterTest(String username, String password,String email, String fullname, Boolean role, String expected) throws Exception {
        processRegister(username,password,email,fullname);
        String currentURL= driver.getCurrentUrl();
        data.setUsername(username);
        data.setPassword(password);
        data.setEmail(email);
        data.setFullname(fullname);
        data.setRole(role);
        data.setAction("Test Register with multiple parameters");
        data.setExpectedOutput(expected);
        data.setActualOutput(currentURL);

        assertEquals(expected,currentURL);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        data.setTestMethodName(result.getName());

        switch (result.getStatus()){
            case ITestResult.SUCCESS:
                data.setStatus("SUCCESS");
                break;
            case ITestResult.FAILURE:
                data.setStatus("FAILURE");
                data.setException(result.getThrowable().getMessage());

                String path = ExcelUtils.IMAGES_PATH + "failure-" + System.currentTimeMillis() + ".png";

                ExcelUtils.takeScreenshot(driver, path);
                data.setImage(path);
                break;
            case ITestResult.SKIP:
                data.setStatus("SKIP");
                break;
            default:
                break;
        }
        logs.add(data);
        driver.close();

    }

    @AfterClass
    public void afterClass() throws Exception {
        data.writeLog(SRC, "RESULT_TEST", logs);
    }

    @DataProvider(name = "RegisterData")
    public Object[][] data() throws IOException {
        XSSFWorkbook workbook = ExcelUtils.getWorkbook(SRC);
        System.out.println(workbook.getNumberOfSheets());
        XSSFSheet sheet = workbook.getSheet("REGISTER_DATA");
        Object[][] data = ExcelUtils.readSheetData(sheet);
        return data;
    }
}
