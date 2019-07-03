import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.Console;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import static junit.framework.TestCase.assertTrue;

public class TRENDYOL {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        String exePath = "D:\\DOWNLOAD\\FOLDERS\\Selenium_drivers\\chromedriver_win32\\chromedriver.exe";
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
        driver.manage().deleteAllCookies();
    }
    @Test
    public void Testcase1()throws Exception{
        driver.navigate().to("https://www.trendyol.com/");
        //Thread.sleep(2000);
        //    ((JavascriptExecutor) driver).executeScript(
        //            "body > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a");
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"accountNavigationRoot\"]/div/ul/li[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("turkcellbip@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Bip2014bip2");
        driver.findElement(By.xpath("//*[@id=\"loginSubmit\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[1]/a")).click();
        //KADIN butiq opens
        assertTrue(driver.getCurrentUrl().contains("kadin"));
        //verify KADIN butiq opens
        WebElement kadin_butiq_image = driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[1]/a/span/img"));
        Boolean ImagePresent1 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", kadin_butiq_image);
        if (!ImagePresent1){
            System.out.println("kadin butiq image not displayed.");
            System.out.println("================== BROWSER LOGS =======================");
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
            System.out.println("=======================================================");}
         else {
            System.out.println("kadin butiq image displayed.");
        }
            driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[2]/a")).click();
        //ERKEK buiq opens
        assertTrue(driver.getCurrentUrl().contains("erkek"));
        //verify ERKEK butiq opens
        WebElement erkek_butiq_image = driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[2]/a/span/img"));
        Boolean ImagePresent2 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", erkek_butiq_image);
        if (!ImagePresent2) {
        System.out.println("erkek butiq image not displayed.");
        driver.manage().logs();}
        else {
        System.out.println("erkek butiq image displayed.");
        //test amaçlı success logu da yazdırılmıştır.
            System.out.println("================== BROWSER LOGS =======================");
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            }
            System.out.println("=======================================================");
        }
        driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[3]/a")).click();
        //ÇOCUK butiq opens
        assertTrue(driver.getCurrentUrl().contains("cocuk"));
        WebElement cocuk_butiq_image = driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[3]/a/span/img"));
        Boolean ImagePresent3 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", cocuk_butiq_image);
        if (!ImagePresent3) {
        System.out.println("cocuk butiq image not displayed.");
        } else {
        System.out.println("cocuk butiq image displayed.");
        }
        driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[4]/a")).click();
        //AYAKKABI&ÇANTA butiq opens
        assertTrue(driver.getCurrentUrl().contains("ayakkabi--canta"));
        WebElement ayakkabi_canta__butiq_image = driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[4]/a/span/img"));
        Boolean ImagePresent4 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ayakkabi_canta__butiq_image);
        if (!ImagePresent4) {
        System.out.println("ayakkabi_canta butiq image not displayed.");
        } else {
        System.out.println("ayakkabi_canta butiq image displayed.");
        }
        driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[5]/a")).click();
        //SAAT&AKSESUAR butiq opens
        assertTrue(driver.getCurrentUrl().contains("saat--aksesuar"));
        WebElement saat_aksesuar_butiq_image = driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[5]/a/span/img"));
        Boolean ImagePresent5 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", saat_aksesuar_butiq_image);
        if (!ImagePresent5) {
        System.out.println("saat_aksesuar butiq image not displayed.");
        } else {
        System.out.println("saat_aksesuar butiq image displayed.");
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[1]/a/span/img")).click();
        //if xpath fails product url:"https://www.trendyol.com/saat--saat/butikdetay/317429/saat--aksesuar"
        //driver.navigate().to("https://www.trendyol.com/saat--saat/butikdetay/317429/saat--aksesuar");
        //saat--saat/butikdetay/317429 product detailpage opens
        driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[6]/a")).click();
        //KOZMETIK butiq opens
        assertTrue(driver.getCurrentUrl().contains("kozmetik"));
        //verify Kozmetik butiq opens
        WebElement kozmetik_butiq_image = driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[6]/a/span/img"));
        Boolean ImagePresent6 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", kozmetik_butiq_image);
        if (!ImagePresent6) {
        System.out.println("kozmetik butiq image not displayed.");
        } else {
        System.out.println("kozmetik butiq image displayed.");
        }
        driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[7]/a")).click();
        //EV&YAŞAM butiq opens
        assertTrue(driver.getCurrentUrl().contains("ev--yasam"));
        //verify Ev&Yaşam butiq opens
        WebElement ev_yasam_butiq_image = driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[7]/a/span/img"));
        Boolean ImagePresent7 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ev_yasam_butiq_image);
        if (!ImagePresent7) {
        System.out.println("ev_yasam_butiq_image not displayed.");
        } else {
        System.out.println("ev_yasam_butiq_image displayed.");
        }
        driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[8]/a")).click();
        //ELEKTRONİK butiq opens
        assertTrue(driver.getCurrentUrl().contains("elektronik"));
        //verify ELEKTRONIK butiq opens
        WebElement elektroink_butiq_image = driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[8]/a/span/img"));
        Boolean ImagePresent8 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", elektroink_butiq_image);
        if (!ImagePresent8) {
        System.out.println("elektronik butiq image not displayed.");
        } else {
        System.out.println("elektronik butiq image displayed.");
        }
        driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[9]/a")).click();
        //SUPERMARKET butiq opens
        assertTrue(driver.getCurrentUrl().contains("supermarket"));
        //verify SUPERMARKET butiq opens
        WebElement supermarket_butiq_image = driver.findElement(By.xpath("//*[@id=\"browsing-gw-homepage\"]/div/div/div[1]/div[1]/article[9]/a/span/img"));
        Boolean ImagePresent9 = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", supermarket_butiq_image);
        if (!ImagePresent9) {
        System.out.println("supermarket butiq image not displayed.");
        } else {
        System.out.println("supermarket butiq image displayed.");
        }
        driver.navigate().to("https://www.trendyol.com/saat--saat/butikdetay/317429/saat--aksesuar");
        driver.navigate().to("https://www.trendyol.com/wesse/wwl107201-bayan-kol-saati-p-6253265?boutiqueId=317429&merchantId=105249");
        //product detail page merchanetID105249 opens
        driver.findElement(By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[2]/div[2]/button[1]/div[1]")).click();
        //add to basket product
        driver.navigate().to("https://www.trendyol.com/sepetim#/basket");
        Thread.sleep(2000);
        Boolean basketitemcount = driver.findElements(By.xpath("//*[@id=\"basketItemCount\"]")).size() != 0;
        //verify product added to basket
        if (basketitemcount) {
        System.out.println("Product added to basket");
        } else {
        System.out.println("An error has occurred, please try again later.");
        }
        driver.findElement(By.xpath("//*[@id=\"basketContent\"]/div[2]/div/ul/li/div[2]/div[5]/a")).click();
        //after test clean basket
        driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div[11]/div[1]/div/div[3]/a[1]")).click();
        //confirm delete basket
        Thread.sleep(1000);
        Boolean basketitemcount2 = driver.findElements(By.xpath("//*[@id=\"basketNoProductPage\"]/div[1]/div/i")).size() != 0;
        if (basketitemcount2) {
            System.out.println("Basket cleaned");
        } else {
            System.out.println("An error has occurred, please try again later.");
        }
}
    @AfterClass
    public static void tearDown () throws Exception {
        System.out.println("================== BROWSER LOGS =======================");
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        System.out.println("=======================================================");
        driver.quit();
    }
}