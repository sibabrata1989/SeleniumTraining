package guipages.mercurypages;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class IDE_TC
{
	
		  private WebDriver driver;
		  private String baseUrl;
		  private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();

		  @BeforeClass(alwaysRun = true)
		  public void setUp() throws Exception {
		    driver = new FirefoxDriver();
		    baseUrl = "http://newtours.demoaut.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }

		  @Test
		  public void testTC() throws Exception {
		    driver.get(baseUrl + "/");
		   
		    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
		    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Paris");
		    driver.findElement(By.cssSelector("font > font > input[name=\"servClass\"]")).click();
		    driver.findElement(By.name("findFlights")).click();
		  
		    driver.findElement(By.name("reserveFlights")).click();
		    driver.findElement(By.name("passFirst0")).clear();
		    driver.findElement(By.name("passFirst0")).sendKeys("IDE");
		    driver.findElement(By.name("passLast0")).clear();
		    driver.findElement(By.name("passLast0")).sendKeys("Test");
		    driver.findElement(By.name("creditnumber")).clear();
		    driver.findElement(By.name("creditnumber")).sendKeys("1234123412341234");
		    driver.findElement(By.name("buyFlights")).click();
		  }

		  @AfterClass(alwaysRun = true)
		  public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  }

		  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
		}

