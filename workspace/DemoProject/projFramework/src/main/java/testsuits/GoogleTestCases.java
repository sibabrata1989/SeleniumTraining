package testsuits;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.BrowserHelper;
import common.ExcelHelper;
import common.TestConfig;
import guipages.googlepages.GoogleSearchPage;

public class GoogleTestCases
{
	WebDriver driver = null;
	ExcelHelper objExcel = null;
	
	@Test
	public void TC01_SearchSelenium() throws Exception
	{
		
		String tcName = "TC01_SearchSelenium";
		System.out.println(tcName);
		objExcel.SetListData(TestConfig.testDataDir + "TestData_Google.xlsx", tcName);
		driver.get((TestConfig.googleUrl));
		GoogleSearchPage objGoogleSearchPage = new GoogleSearchPage(driver);
		objGoogleSearchPage.SearchText(objExcel);
		
	}
	@Test
	public void TC02_SearchJava() throws Exception
	{
		
		String tcName = "TC02_SearchJava";
		System.out.println(tcName);
		objExcel.SetListData(TestConfig.testDataDir + "TestData_Google.xlsx", tcName);
		driver.get((TestConfig.googleUrl));
		GoogleSearchPage objGoogleSearchPage = new GoogleSearchPage(driver);
		objGoogleSearchPage.SearchText(objExcel);
		
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
		objExcel.SetListHeader(TestConfig.testDataDir + "TestData_Google.xlsx", 0);
		driver = BrowserHelper.LaunchBrowser(driver);
	}
	
	@AfterMethod
	public void MethodCleanUp()
	{
		objExcel.ClearDataList();
		
	}
	@AfterClass
	public void CloseDriver()
	{
		driver.close();
	}
	
}
