package Academy.resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Base implements IAutoConstant
{
	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static WebDriver driver;
	@BeforeTest
	public static void extentReportsIntialization()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/reporter/index.html",true);
	}
	@BeforeClass
	public static void openBrowser() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Eclipsce Selenium Programs\\E2EProject\\src\\main\\java\\Academy\\resources\\data.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else 
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public static void openApplication()
	{
		driver.get(URL);
	}
	@AfterMethod
	public static void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.log(LogStatus.FAIL,"Test Case Failed Is"+result.getName());
			extentTest.log(LogStatus.FAIL,"Test Case Failed Is"+result.getThrowable());
			String screenShotPath = FWUtils.takesScreenShot(driver,result.getName());
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(screenShotPath));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(LogStatus.SKIP,"Test Case is Skipped"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.log(LogStatus.PASS,"Test Case is Passed"+result.getName());
		}
		extent.endTest(extentTest);
		driver.close();
	}
	@AfterTest
	public static void endReport()
	{
		extent.flush();
		extent.close();
	}
}
