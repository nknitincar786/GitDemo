package Academy.resources;
public interface IAutoConstant
{
	String CHROME_KEY = "webdriver.chrome.driver";
	String CHROME_VALUE = "./driver/chromedriver.exe";
	String GECKO_KEY = "webdriver.gecko.driver";
	String GECKO_VALUE = "./driver/geckodriver.exe";
	
	long ETO = 20;
	long ITO = 20;
	
	String filePath = "./DataInput/dataInput.xlsx";
	String resultPath = "./DataOutput/DataOutput.xlsx";
	String photoPath = "./screenShots/";
	
	String URL = "http://localhost:8080/login.do";
}
