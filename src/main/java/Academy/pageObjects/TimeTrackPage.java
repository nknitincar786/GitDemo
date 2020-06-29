package Academy.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class TimeTrackPage 
{
	@FindBy(xpath="(//div[contains(text(),'Settings')])[1]")
	private WebElement settings;
	@FindBy(xpath="//a[text()='Licenses']")
	private WebElement licsence;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	public TimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void clickSettings()
	{
		settings.click();
	}
	public void clickLicensce()
	{
		licsence.click();
	}
	public void clickLogout()
	{
		logout.click();
	}
}
