package Test;

import Model.LoginData;
import Utils.ExcelUtils;
import Utils.RecordUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.common.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;


public class LoginTest {
    private WebDriver driver;
    private String SRC= ExcelUtils.DATA_PATH+"LOGIN_TEST.xlsx";
    private Set<LoginData> logs;
    private LoginData data;

    private void processLogin(String username, String password){
        WebElement usernameElement = driver.findElement(By.name("username"));
        usernameElement.sendKeys(username);
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(password);

        WebElement buttonElement = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/form[1]/div/div[4]/input"));
        buttonElement.submit();
    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",ExcelUtils.CHROME_DRIVER_PATH);
        logs = new LinkedHashSet<>();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        RecordUtils.startRecording("Test-Login-"+ System.currentTimeMillis());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/PS15722_NguyenChiHieu_ASM_war_exploded/LoginServlet");
        data = new LoginData();

    }

    @Test(dataProvider = "loginData")
    public void multipleLoginTest(String username, String password, String expected) throws Exception {
        processLogin(username,password);
        String currentURL= driver.getCurrentUrl();
        data.setUsername(username);
        data.setPassword(password);
        data.setAction("Test Login with multiple parameters");
        data.setExpectedOutput(expected);
        data.setActualOutput(currentURL);

        assertEquals(currentURL,expected);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
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
        RecordUtils.stopRecording();

    }

    @AfterClass
    public void afterClass() throws Exception {
        data.writeLog(SRC, "RESULT_TEST", logs);
    }

    @DataProvider(name = "loginData")
    public Object[][] data() throws IOException {
        XSSFWorkbook workbook = ExcelUtils.getWorkbook(SRC);
        XSSFSheet sheet = workbook.getSheet("LOGIN_DATA");
        Object[][] data = ExcelUtils.readSheetData(sheet);
        return data;
    }
}
