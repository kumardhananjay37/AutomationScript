package BasePage;

import CommonFunctions.CommonMethods;
import Utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class DesktopBase
{
    public static WebDriver driver;
    public static CommonMethods commonMethods;
    public static PropertyUtils propertyUtils;
    @BeforeMethod
    public void openURL()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(propertyUtils.propertyValueOf("url"));
    }
    @BeforeClass
    public void beforeClass()
    {
        System.out.println("********************* @BeforeClass started from here *****************************");
        propertyUtils=new PropertyUtils();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
