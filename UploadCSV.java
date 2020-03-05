package SeleniumScripts;
 
 
 
 
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
public class UploadCSV {
public static void main(String[] args) {
String baseUrl = "http://192.168.158.11:8280/fb/login/login.htm";
WebDriver driver = new FirefoxDriver();
 
driver.get(baseUrl);

driver.findElement(By.xpath(".//*[@id='j_username']")).sendKeys("00F888");
driver.findElement(By.xpath(".//*[@id='j_password']")).sendKeys("PASSWORD");
driver.findElement(By.xpath("//input[@value='Login']")).click();



//Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Clicking Airshopping page link
		driver.findElement(By.xpath(".//*[@id='menu']/ul/li[5]/a")).click();
		System.out.println ("NFE link clicked");
		
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle);
		}

		driver.findElement(By.xpath(".//*[@id='confGroup']/a")).click();
		driver.findElement(By.xpath(".//*[@id='uploadACSMenuItm']/a")).click();
		
		


WebElement uploadElement = driver.findElement(By.xpath(".//*[@id='csvFile']"));
 
// enter the file path onto the file-selection input field
uploadElement.sendKeys("D:\\Shaji\\Documents\\ACSMCDirect.csv");
 
//click the "UploadFile" button
driver.findElement(By.xpath(".//*[@id='uploadACSData']/div/div/div[2]/input[2]")).click();
 

}
}