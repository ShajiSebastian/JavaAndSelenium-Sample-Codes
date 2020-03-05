package SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnableDisableTextBox 
{
	 public static void main(String[] args) throws InterruptedException 
	    {
		 
		 FirefoxProfile profile = new FirefoxProfile();
	        profile.setPreference("network.proxy.type", 1);
	        profile.setPreference("network.proxy.http", "webproxy.ibsplc.com");
	        profile.setPreference("network.proxy.http_port", 80);
	        WebDriver driver = new FirefoxDriver(profile);

	        driver.get("http://192.168.158.6:8280/fb/shop/airfaresearch.htm?ehn=TYO&ln=EN");
	        //Locate text string element to read It's font properties.
	        WebElement text = driver.findElement(By.xpath(".//*[@id='destinationSId']"));
	        
	        boolean fbefore = driver.findElement(By.xpath(".//*[@id='destinationSId']")).isEnabled();
	        System.out.print("\nEnable status is : "+fbefore);
	       
	        
	        Thread.sleep(2000);
	        
	        //To disable First Name text box
	        JavascriptExecutor javascript = (JavascriptExecutor) driver;
	        String todisable = "document.getElementsByid('destinationSId')[0].setAttribute('disabled', '');";
	        javascript.executeScript(todisable);
	        Thread.sleep(2000);
	        
	        //To enable Last Name text box
	        String toenable = "document.getElementsByName('lname')[0].removeAttribute('disabled');";
	        javascript.executeScript(toenable);
	        Thread.sleep(3000);
	        
	        
	        boolean fafter = driver.findElement(By.xpath("//input[@name='fname']")).isEnabled();
	        System.out.print("\nAfter changing : "+fafter);
	      
	          
	    }
}
