package testsuits;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.BrowserHelper;
import common.ExcelHelper;
import common.TestConfig;
import guipages.mercurypages.MercuryBookFlight;
import guipages.mercurypages.MercuryLoginPage;

public class MercuryTestCases
{
	WebDriver driver = null;
	ExcelHelper objExcel = null;
	
	@Test
	public void TC01_MercuryLoginSuccess() throws InterruptedException
	{
		
		String tcName = "TC01_MercuryLoginSuccess";
		System.out.println(tcName);
		objExcel.SetListData(TestConfig.testDataDir + "TestData_Mercury.xlsx", tcName);
		driver.get((TestConfig.mercuryUrl));
		MercuryLoginPage objMercuryLogin = new MercuryLoginPage(driver);
	    objMercuryLogin.MercuryLogin(objExcel);
		//Assert.assertEquals(objExcel.GetValue(0, "ExpTitle"), mercuryLogo);
		
	}
	@Test
	public void TC02_MercuryLoginFailure()
	{
		
		String tcName = "TC02_MercuryLoginFailure";
		System.out.println(tcName);
		objExcel.SetListData(TestConfig.testDataDir + "TestData_Mercury.xlsx", tcName);
		driver.get((TestConfig.mercuryUrl));
		MercuryLoginPage objMercuryLogin = new MercuryLoginPage(driver);
		objMercuryLogin.MercuryLogin(objExcel);
		
		//Assert.assertEquals(objExcel.GetValue(0, "ExpTitle"), driver.getTitle());
		
	}
	@Test
	public void TC03_MercuryBookFlight()
	{
		try
		{
			String tcName = "TC03_MercuryBookTicket";
			System.out.println(tcName);
			objExcel.SetListData(TestConfig.testDataDir + "TestData_Mercury.xlsx", tcName);
			//driver.get(TestConfig.mercuryUrl);
			MercuryBookFlight objMercuryBookFligt = new MercuryBookFlight(driver);
			objMercuryBookFligt.MercuryFligtBooking(objExcel);
			
			objExcel.SetExcelValue(TestConfig.testDataDir + "TestData_Mercury.xlsx");
			//Assert.assertEquals(objExcel.GetValue(0, "ExpTitle"), driver.getTitle());
		} catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	
	}
	
	
	@BeforeTest
	public void TestSetUp()
	{
		TestConfig.SetCommonEnv();
	}
	
	@BeforeClass
	public void classSetup()
	{
		objExcel = new ExcelHelper();
		objExcel.SetListHeader(TestConfig.testDataDir + "TestData_Mercury.xlsx", 0);
		driver = BrowserHelper.LaunchBrowser(driver);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void MethodCleanUp()
	{
		objExcel.ClearDataList();
		
	}
	@AfterClass
	public void CloseDriver()
	{
		//driver.close();
	}
}
