package guipages.mercurypages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import common.BrowserHelper;
import common.ExcelHelper;

public class MercuryBookFlight
{
	WebDriver driver = null;
	//By byTripType = By.xpath("//input[starts-with(@name,'tripType')]");
	By byTripType = By.name("tripType");
	By byPassenger = By.name("passCount");
	By byDepartFrom = By.name("fromPort");
	By byArrivingIn = By.name("toPort");
	By byServiceClass = By.name("servClass");
	//By byServiceClass = By.xpath("//input[starts-with(@value,'Business')]");
	By btnContinue = By.name("findFlights");
	By deptFlight = By.name("outFlight");
	By inFlight = By.name("inFlight");
	By reservFlight = By.name("reserveFlights");
	By firstName = By.name("passFirst0");
	By lastName = By.name("passLast0");
	By cardNum = By.name("creditnumber");
	By buytckt = By.name("buyFlights");
	By ticketConfrmtn = By.xpath("//table/tbody/tr/td[1]/b/font/font/b/font[1]");

	public MercuryBookFlight(WebDriver driver)
	{

		this.driver = driver;
	}

	
	public void MercuryFligtBooking(ExcelHelper objExcel)
	{

		List<WebElement> listTriptyp = driver.findElements(byTripType);

		System.out.println(listTriptyp.size());

		for (int i = 0; i < listTriptyp.size(); i++)
		{

			String value1 = listTriptyp.get(i).getAttribute("value");

			if (value1.equalsIgnoreCase(objExcel.GetValue(0, "Triptype")))
			{
				System.out.println(value1);
				listTriptyp.get(i).click();
				listTriptyp.clear();
				value1 = null;
				break;

			}
		}
		

		Select passngr = new Select(driver.findElement(byPassenger));
		Select deptFrom = new Select(driver.findElement(byDepartFrom));
		Select arrivIn = new Select(driver.findElement(byArrivingIn));

		List<WebElement> listSrvClass = driver.findElements(byServiceClass);
		System.out.println(listSrvClass.size());

		
		WebElement continueBtn = driver.findElement(btnContinue);

		
		passngr.selectByValue(objExcel.GetValue(0, "Passengers"));
		deptFrom.selectByValue(objExcel.GetValue(0, "FromLocation"));
		arrivIn.selectByValue(objExcel.GetValue(0, "ToLoation"));

		for (int j = 0; j < listSrvClass.size(); j++)
		{
			String value2 = listSrvClass.get(j).getAttribute("value");

			if (value2.equalsIgnoreCase(objExcel.GetValue(0, "ServiceClass")))

			{
				System.out.println(value2);
				listSrvClass.get(j).click();
				listSrvClass.clear();
				value2 = null;
				break;
			}
		}

		BrowserHelper.SaveScreenshot(objExcel.GetValue(0, "TestCaseName"), driver);
		continueBtn.click();

		// Page 2

		List<WebElement> listOutFlight = driver.findElements(deptFlight);
		System.out.println("Dept Flight Size is:" + listOutFlight.size());

		for (int k = 0; k < listOutFlight.size(); k++)
		{
			String value3 = listOutFlight.get(k).getAttribute("value");

			if (value3.equalsIgnoreCase(objExcel.GetValue(0, "DepartFlight")))
			{
				System.out.println(value3);
				listOutFlight.get(k).click();
				value3 = null;
				break;
			}
		}

		List<WebElement> listInFlight = driver.findElements(inFlight);
		System.out.println("InFlight Size:" + listInFlight.size());

		for (int l = 0; l < listInFlight.size(); l++)
		{
			String value4 = listInFlight.get(l).getAttribute("value");

			if (value4.equalsIgnoreCase(objExcel.GetValue(0, "ReturnFlight")))
			{
				System.out.println(value4);
				listInFlight.get(l).click();
				value4 = null;
				break;
			}
		}
		BrowserHelper.SaveScreenshot(objExcel.GetValue(0, "TestCaseName"), driver);

		WebElement reserveButton = driver.findElement(reservFlight);
		reserveButton.click();

		WebElement firstname = driver.findElement(firstName);
		firstname.sendKeys(objExcel.GetValue(0, "FirstName"));

		WebElement lastname = driver.findElement(lastName);
		lastname.sendKeys(objExcel.GetValue(0, "LastName"));

		WebElement cardNumber = driver.findElement(cardNum);
		cardNumber.sendKeys(objExcel.GetValue(0, "CardNumber"));

		BrowserHelper.SaveScreenshot(objExcel.GetValue(0, "TestCaseName"), driver);

		WebElement buyTicket = driver.findElement(buytckt);
		buyTicket.click();
		
		//Print ticket number
		WebElement ticket =  driver.findElement(ticketConfrmtn);
		System.out.println(ticket.getText());
		String ticketnum = ticket.getText();
		objExcel.SetValue(0, "TicketNumber", ticketnum);
		
		
		

	}

}
