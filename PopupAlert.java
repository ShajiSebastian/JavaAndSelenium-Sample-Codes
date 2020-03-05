package SeleniumScripts;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 

import java.util.concurrent.TimeUnit;
 
public class PopupAlert {
 
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        String alertMessage = "";
 
        driver.get("http://jsbin.com/usidix/1");
        System.out.println("starting implicitwait ");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        waittimeShort() ;
        alertMessage = driver.switchTo().alert().getText();
        waittimeShort() ;
        driver.switchTo().alert().accept();
        
        System.out.println(alertMessage);
        //driver.quit();
        
    }
    
    private static void waittimeShort() 
	{
		try
		{
		  Thread.sleep(5*60*10);
		}
		catch(Exception e)
		{
		}
	}
	
}