import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import static junit.framework.TestCase.assertTrue;

public class TASK2 {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception
    {
        String exePath = "D:\\DOWLOADS\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logs);
        ChromeOptions opts = new ChromeOptions();
        caps.setCapability(ChromeOptions.CAPABILITY, opts);
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        opts.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(caps);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @Test
    public void Testcase1() throws Exception
    {
        driver.navigate().to("https://www.ibar.az/en/");
        //Home page opened
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/img")).click();
        //corona banner closed
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/footer/div[2]/div/ul[1]/li[1]/a")).click();
        //switching AZ language
        assertTrue(driver.getCurrentUrl().equals("https://www.ibar.az/"));
        //verify page opened in AZ language
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/img")).click();
        //corona banner closed
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/footer/div[2]/div/ul[1]/li[1]/a")).click();
        //switching EN language
        assertTrue(driver.getCurrentUrl().equals("https://www.ibar.az/en/"));
        //verify page opened in EN language
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/img")).click();
        //corona banner closed
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/footer/div[2]/div/ul[1]/li[2]/a")).click();
        //Switching RU language
        assertTrue(driver.getCurrentUrl().equals("https://www.ibar.az/ru/"));
        //verify page opened in Ru language
    }
    @Test
    public void Testcase2() throws Exception
    {
        driver.navigate().to("https://www.ibar.az/en/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/img")).click();
        //corona banner closed
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/div/div[1]/div/input")).sendKeys("American Ekspress");
        Thread.sleep(10000);
        WebElement americanekspres1= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/div/div[3]/div[2]/div/div/div[3]/div/a"));
        Boolean ImagePresent1 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", americanekspres1);
        if (!ImagePresent1){
            System.out.println("american ekspress gold image not displayed.");
            System.out.println("================== BROWSER LOGS =======================");
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
            System.out.println("=======================================================");}
        else {
            System.out.println("american ekspress gold image  displayed.");
        }
        WebElement americanekspres2= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/div/div[3]/div[2]/div/div/div[4]/div/a"));
        Boolean ImagePresent2= (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", americanekspres2);
        if (!ImagePresent2){
            System.out.println("american ekspress green image not displayed.");
            System.out.println("================== BROWSER LOGS =======================");
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
            System.out.println("=======================================================");}
        else {
            System.out.println("american ekspress green image  displayed.");
        }
    }
    @Test
    public void Testcase3() throws Exception
    {
        driver.navigate().to("https://www.ibar.az/en/");
        //Home page opened
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/img")).click();
        //corona banner closed
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/div/div[3]/div[1]/div/div[2]/div/a")).click();
        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().equals("https://www.ibar.az/en/individual/urgent-credit-order/"));
        //verify urgent credit order page
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[3]/div/div/form/section/div[7]/input[2]")).click();
        //click send button
        Thread.sleep(3000);
        WebElement nameerror=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[3]/div/div/form/section/div[1]/div/span"));
        Boolean validate1= (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", nameerror);
        if (!validate1){
            System.out.println("Validation of name field doesn't work");
            System.out.println("================== BROWSER LOGS =======================");
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
            System.out.println("=======================================================");}
        else {
            System.out.println("Validation of name field worked successfully.");
        }
        WebElement errorsurname=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[3]/div/div/form/section/div[2]/div/span"));
        Boolean validate2= (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", errorsurname);
        if (!validate2){
            System.out.println("Validation of surname field doesn't work");
            System.out.println("================== BROWSER LOGS =======================");
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
            System.out.println("=======================================================");}
        else {
            System.out.println("Validation of surname field worked successfully.");
        }
        WebElement phoneerror=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[3]/div/div/form/section/div[3]/div/span"));
        Boolean validate3= (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", phoneerror);
        if (!validate3){
            System.out.println("Validation of phone field doesn't work");
            System.out.println("================== BROWSER LOGS =======================");
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
            System.out.println("=======================================================");}
        else {
            System.out.println("Validation of phone field worked successfully.");
        }
        WebElement salaryerror=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[3]/div/div/form/section/div[4]/div/span"));
        Boolean validate4= (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", salaryerror);
        if (!validate4){
            System.out.println("Validation of phone field worked successfully, field validation is out of scope for this coding challenge");
            System.out.println("================== BROWSER LOGS =======================");
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
            System.out.println("=======================================================");}
        else {
            System.out.println("Validation of phone field doesn't worked successfully.");
        }
    }

    @AfterClass
    public static void tearDown() throws Exception
    {
        System.out.println("================== BROWSER LOGS =======================");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        System.out.println("=======================================================");
        driver.quit();
    }
}