package Test;

import Model.LoginData;
import Model.ManagementVideoData;
import Utils.ExcelUtils;
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

public class ManagementVideoTest {
    private WebDriver driver;
    private String SRC= ExcelUtils.DATA_PATH+"ADDVIDEO_TEST.xlsx";
    private Set<ManagementVideoData> logs;
    private ManagementVideoData data;

    private void processAddVideo(String id, String title, String poster, String link, String views, String description, String active){
        WebElement idElement = driver.findElement(By.name("videoId"));
        idElement.sendKeys(id);
        WebElement titleElement = driver.findElement(By.name("title"));
        titleElement.sendKeys(title);
        WebElement posterElement = driver.findElement(By.name("poster"));
        posterElement.sendKeys(poster);
        driver.findElement(By.name("link")).sendKeys(link);
        driver.findElement(By.name("views")).sendKeys(views);

        WebElement descriptionElement = driver.findElement(By.name("description"));
        descriptionElement.sendKeys(description);
        WebElement activeElement = driver.findElement(By.id("customRadioInline2"));
        activeElement.click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div[2]/form/div/div[2]/div[8]/button[1]")).submit();
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

        driver.findElement(By.name("username")).sendKeys("user1");
        driver.findElement(By.name("password")).sendKeys("1234");

        WebElement buttonElement = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/form[1]/div/div[4]/input"));
        buttonElement.submit();

        data = new ManagementVideoData();
    }

    @Test(dataProvider = "managementVideoData")
    public void multipleLoginTest(String id, String title, String poster, String link, String views, String description, String active, String expected) throws Exception {
        processAddVideo(id, title, poster, link, views, description, active);
        String currentURL= driver.getCurrentUrl();
        data.setId(id);
        data.setTitle(title);
        data.setPoster(poster);
        data.setLink(link);
        data.setViews(views);
        data.setDescription(description);
        data.setActive(Boolean.parseBoolean(active));
        data.setAction("Test AddVideo with multiple parameters");
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
        data.writeLog(SRC, "RESULT_ADD_VIDEO", logs);
    }

    @DataProvider(name = "managementVideoData")
    public Object[][] data() throws IOException {
        XSSFWorkbook workbook = ExcelUtils.getWorkbook(SRC);
        XSSFSheet sheet = workbook.getSheet("ADD_VIDEO_DATA");
        Object[][] data = ExcelUtils.readSheetData(sheet);
        return data;
    }
}
