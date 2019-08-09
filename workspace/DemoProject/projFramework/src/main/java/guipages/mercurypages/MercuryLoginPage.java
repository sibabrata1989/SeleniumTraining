package guipages.mercurypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BrowserHelper;
import common.ExcelHelper;

public class MercuryLoginPage
{
	WebDriver driver = null;
	String mercuryLogo;
	By byTextUserName = By.name("userName");
	By byTextPassword = By.name("password");
	By byBtnLogin = By.name("login");
	
	public MercuryLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public String MercuryLogin(ExcelHelper objExcel)
	{
		try
		{
		WebElement txtUserName = driver.findElement(byTextUserName);
		WebElement txtPassword = driver.findElement(byTextPassword);
		WebElement btnLogin = driver.findElement(byBtnLogin);
		WebElement logo = driver.findElement(By.xpath("//*[@alt='Mercury Tours']"));
		
		
		txtUserName.sendKeys(objExcel.GetValue(0, "UserName"));
		txtPassword.sendKeys(objExcel.GetValue(0, "Password"));
		btnLogin.click();
		Thread.sleep(5000);
		mercuryLogo = logo.getText();
		}
		catch(Exception e)
		{
			BrowserHelper.SaveScreenshot(objExcel.GetValue(0, "TestCaseName"), driver);
			System.out.println("The Login failed!"+e.getMessage());
			
		}
		
		return mercuryLogo;
		
	}
}
