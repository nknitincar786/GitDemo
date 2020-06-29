package Academy.resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import Academy.pageObjects.LicenscePage;
public class FWUtils implements IAutoConstant
{
	public static void verifyTitle(WebDriver driver,String expected)
	{
		String actual = driver.getTitle();
		Assert.assertEquals(actual,expected);
		Reporter.log("The title is true--->"+actual,true);
	}
	public static void verifyDate(WebDriver driver,String expected)
	{
		LicenscePage lp = new LicenscePage(driver);
		WebElement actualDate = lp.getIssueDate();
		String actual = actualDate.getText();
		Assert.assertEquals(actual,expected);
		Reporter.log("The date is true--->"+actual,true);
	}
	public static void verifyEdition(WebDriver driver,String expected)
	{
		LicenscePage lp = new LicenscePage(driver);
		WebElement actualEdition = lp.getProductEdition();
		String actual = actualEdition.getText();
		Assert.assertEquals(actual,expected);
		Reporter.log("The edition is true--->"+actual,true);
	}
	public static String readXLPages(WebDriver driver,String sheet,int row,int cell)
	{
		String data = "";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(filePath));
			data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public static void writeXLPages(WebDriver driver,String sheet,int row,int cell,int data)
	{
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(resultPath));
			wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
			wb.write(new FileOutputStream(resultPath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static int countXLPagesRows(WebDriver driver,String sheet)
	{
		int data = 0;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(filePath));
			data = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public static String takesScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dst = System.getProperty("user.dir")+"/reports/"+screenShotName+dateName+".png";
		File destination = new File(dst);
		FileUtils.copyFile(src,destination);
		return dst;
	}
}
