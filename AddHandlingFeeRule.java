package SeleniumScripts;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AddHandlingFeeRule 
{
	public static void main(String args[])
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://192.168.158.6:8280/fb/login/login.htm");
		System.out.println ("Application url invoked");
		
		//Maximizing browser window
		driver.manage().window().maximize() ;
		
		// Entering User id and Password and submitting
		driver.findElement(By.xpath(".//*[@id='j_username']")).sendKeys("00F888");
		driver.findElement(By.xpath(".//*[@id='j_password']")).sendKeys("PASSWORD");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println ("Login credential submitted");
		   
		// Store the current window handle
		//String winHandleBefore = driver.getWindowHandle();

		// Clicking Manage buisiness rule link
		driver.findElement(By.xpath(".//*[@id='menu']/ul/li[2]/a")).click();
		System.out.println ("Manage buisiness rule link clicked");
		
		//Clicking on Agent Fees link
		driver.findElement(By.xpath(".//*[@id='menu']/ul/li[2]/a")).click();
		System.out.println ("Agent Fees link clicked");
	
		//Selecting Handling Fee Rule (Radio button)
		driver.findElement(By.cssSelector("input[value='H']")).click();
		System.out.println ("Handling Fee Rule selected");
		
		//Clicking on Add button
		driver.findElement(By.xpath(".//*[@id='handlingAddButton']")).click();
		System.out.println ("Add button clicked ");
		
		try
		{
		  Thread.sleep(5*60*10);
		}
		catch(Exception e)
		{
				
		}
		// Entering values in the popup
		driver.findElement(By.xpath(".//*[@id='alternateaddFrom']")).sendKeys("18-06-2019");
		driver.findElement(By.xpath(".//*[@id='originAirportCodesHandlng']")).sendKeys("NRT,HND");
		driver.findElement(By.xpath(".//*[@id='feeAmount']")).sendKeys("500");
		
		//Un checking Seat availability option (Check option)
		WebElement allCitiesEihon =driver.findElement(By.xpath(".//*[@id='isAllCitiesEihon']"));
		allCitiesEihon.click();
		System.out.println ("Rule values entered in popup");		
		
		try
		{
		  Thread.sleep(15*60*10);
		}
		catch(Exception e)
		{
				
		}
		
		// Clicking on Save button
		driver.findElement(By.xpath(".//*[@id='popupSaveButton']")).click();
		System.out.println ("Save button clicked");
		// Clicking on Ok button in the alert message
		driver.switchTo().alert().accept();
		System.out.println ("Rule added successfully");
		
	}
}