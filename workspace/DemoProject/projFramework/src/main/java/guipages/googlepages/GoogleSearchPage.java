package guipages.googlepages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BrowserHelper;
import common.ExcelHelper;

public class GoogleSearchPage
{
	WebDriver driver;
	By byTextSearch = By.name("q");
	
	public GoogleSearchPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void SearchText(ExcelHelper objExcel) throws Exception
	{
		Thread.sleep(10);
		WebElement txtSearch = driver.findElement(byTextSearch);
		//txtSearch.sendKeys("Siba");
		//driver.findElement(By.name("btnK")).click();
		txtSearch.sendKeys(objExcel.GetValue(0, "SearchText") + Keys.ENTER);
		BrowserHelper.SaveScreenshot(objExcel.GetValue(0, "TestCaseName"), driver);
	}
}
