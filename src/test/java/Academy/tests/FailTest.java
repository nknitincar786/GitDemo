package Academy.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import Academy.resources.Base;
public class FailTest extends Base
{
	@Test
	public void fail()
	{
		extentTest = extent.startTest("fail");
		String s1 = "qsp";
		String s2 = "jsp";
		Assert.assertTrue(s1.equals(s2));
	}
}
