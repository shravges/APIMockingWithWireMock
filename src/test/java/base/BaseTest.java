package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import APIMocking.WiremockSetup;

public class BaseTest {

	@BeforeTest
	public void setup()
	{
		WiremockSetup.startMockServer();
	}
	
	@AfterTest
	public void tearDown()
	{
		WiremockSetup.stopMockServer();
	}
	
	
	
}
