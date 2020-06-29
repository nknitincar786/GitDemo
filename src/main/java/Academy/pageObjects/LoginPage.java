package Academy.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
public class LoginPage
{
	@FindBy(id="username")
	private WebElement unTB;
	@FindBy(name="pwd")
	private WebElement pwTB;
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement chBX;
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement login;
	@FindBy(xpath="//span[contains(text(),'invalid']")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterUnTb(String un)
	{
		unTB.sendKeys(un);
	}
	public void enterPwTb(String pw)
	{
		pwTB.sendKeys(pw);
	}
	public void clickChBx()
	{
		chBX.click();
	}
	public void clickLogin()
	{
		login.click();
	}
	public void login()
	{
		unTB.sendKeys("admin");
		pwTB.sendKeys("manager");
		chBX.click();
		login.click();
	}
	public void login(String un,String pw)
	{
		unTB.sendKeys(un);
		pwTB.sendKeys(pw);
		chBX.click();
		login.click();
	}
	public void errMsg()
	{
		Assert.assertTrue(errMsg.isDisplayed());
		Reporter.log("The Error message is Displayed",true);
	}
}
