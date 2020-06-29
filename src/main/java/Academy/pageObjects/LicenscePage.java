package Academy.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LicenscePage 
{
	@FindBy(xpath="(//nobr[text()='Issue Date:']//ancestor::tr)[5]//descendant::td[contains(text(),'Jul 14, 2017')]")
	private WebElement issueDate;
	@FindBy(xpath="(//nobr[text()='Product Edition:']//ancestor::tr)[5]//descendant::b[text()='actiTIME 2017.4']")
	private WebElement productEdition;
	
	public LicenscePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getIssueDate()
	{
		return issueDate;
	}
	public WebElement getProductEdition()
	{
		return productEdition;
	}
}
