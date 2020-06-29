package Academy.tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import Academy.pageObjects.LoginPage;
import Academy.pageObjects.TimeTrackPage;
import Academy.resources.Base;
import Academy.resources.FWUtils;
public class TimeTrackPageTest extends Base
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void timeTrack() throws InterruptedException
	{
		extentTest = extent.startTest("timeTrack");
		Thread.sleep(5000);
		String un = "",pw = "",title1 = "",title2 = "",title3 = "";
		LoginPage lt  = new LoginPage(driver);
		TimeTrackPage tp = new TimeTrackPage(driver);
		Thread.sleep(4000);
		title1 = FWUtils.readXLPages(driver,"input",1,2);
		log.info("retreving the title1 info from excel sheet");
		FWUtils.verifyTitle(driver,title1);
		log.info("verifying the title1 from excel sheet");
		un = FWUtils.readXLPages(driver,"input",1,0);
		log.info("retreiving the username info from excel sheet");
		pw = FWUtils.readXLPages(driver,"input",1,1);
		log.info("retreiving the password info from excel sheet");
		title2 = FWUtils.readXLPages(driver,"input",1,3);
		log.info("retreiving the title2 info from excel sheet");
		lt.login(un,pw);
		log.info("Logging into the site");
		Thread.sleep(3000);
		FWUtils.verifyTitle(driver,title2);
		log.info("verifying the title2 from excel sheet");
		tp.clickSettings();
		tp.clickLicensce();
		title3 = FWUtils.readXLPages(driver,"input",1,4);
		log.info("retreiving the title3 info from excel sheet");
		FWUtils.verifyTitle(driver,title3);
		log.info("verifying the title3 from excel sheet");
	}
}
