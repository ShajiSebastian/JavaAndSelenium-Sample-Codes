package SeleniumScripts;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadTextFromWeb {
	public static void main(String args[])
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://192.168.158.6:8280/fb/login/login.htm");
		System.out.println ("Application url invoked");
		
		//Maximizing browser window
		driver.manage().window().maximize() ;
		
		// Entering User id and Password and submitting
		driver.findElement(By.xpath(".//*[@id='j_username']")).sendKeys("00F88");
		driver.findElement(By.xpath(".//*[@id='j_password']")).sendKeys("PASSWORD");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println ("Login credential submitted");
		   
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Clicking Airshopping page link
		try
		{		String ShopPage = driver.findElement(By.xpath(".//*[@id='menu']/ul/li[1]/a")).getText();
				if (ShopPage.equals("Air Shopping"))
					System.out.println ("Logged in Successfuly");
				else
					System.out.println ("Log in Failed");
		}
		
		catch(Exception e)
		{
				
					System.out.println ("Unexpected Exception occured and Log in Failed");
		}
		
		driver.close();
		
		// To close previously opened window
		driver.switchTo().window(winHandleBefore);
	 	driver.close();
	 	System.out.println ("All windows closed sucessfully");
	}
}
