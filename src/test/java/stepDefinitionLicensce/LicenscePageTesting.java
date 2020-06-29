package stepDefinitionLicensce;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import java.util.concurrent.TimeUnit;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Academy.pageObjects.LicenscePage;
import Academy.pageObjects.LoginPage;
import Academy.pageObjects.TimeTrackPage;
import Academy.resources.Base;
@RunWith(Cucumber.class)
public class LicenscePageTesting extends Base
{
	@Given("^Intialize the browser with chrome$")
    public void intialize_the_browser_with_chrome() throws Throwable
	{
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }
	@And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String url) throws Throwable 
    {
		driver.get(url);
    }
    @When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable
    {
    	LoginPage lp = new LoginPage(driver);
    	lp.enterUnTb(username);
    	lp.enterPwTb(password);
    	lp.clickChBx();
    	lp.clickLogin();
    }
    @Then("^verify the user is successfully logged into \"([^\"]*)\"$")
    public void verify_the_user_is_successfully_logged_into_something(String expected) throws Throwable 
    {
    	Thread.sleep(4000);
    	String actual = driver.getTitle();
    	if(expected.equals(actual))
    	{
    		System.out.println("Correct");
    	}
    	else
    	{
    		System.out.println("Wrong");
    	}
    }
    @And("^click on settings$")
    public void click_on_settings() throws Throwable 
    {
    	TimeTrackPage tp = new TimeTrackPage(driver);
		tp.clickSettings();
    }
    @When("^click on licensce$")
    public void click_on_licensce() throws Throwable 
    {
    	TimeTrackPage tp = new TimeTrackPage(driver);
		tp.clickLicensce();
    }
    @And("^verify the user is successfully logged into the title \"([^\"]*)\"$")
    public void verify_the_user_is_successfully_logged_into_the_title_something(String expected) throws Throwable
    {
    	Thread.sleep(4000);
    	String actual = driver.getTitle();
    	if(expected.equals(actual))
    	{
    		System.out.println("Correct");
    	}
    	else
    	{
    		System.out.println("Wrong");
    	}
    }
    @And("^verify the date (.+)$")
    public void verify_the_date(String date) throws Throwable 
    {
    	LicenscePage pl = new LicenscePage(driver);
		WebElement actualIssueDate = pl.getIssueDate();
		String actual = actualIssueDate.getText();
		if(date.equals(actual))
    	{
    		System.out.println("Correct");
    	}
    	else
    	{
    		System.out.println("Wrong");
    	}
    }
    @And("^verify the edition (.+)$")
    public void verify_the_edition(String edition) throws Throwable
    {
    	LicenscePage pl = new LicenscePage(driver);
		WebElement actualIssueEdition = pl.getProductEdition();
		String actual = actualIssueEdition.getText();
		if(edition.equals(actual))
    	{
    		System.out.println("Correct");
    	}
    	else
    	{
    		System.out.println("Wrong");
    	}
		driver.close();
    }
}
