package SeleniumScripts;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 

import java.util.concurrent.TimeUnit; // this is used for implicit wait
 
public class ImplicitWait {
 
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        String alertMessage = "";
 
        driver.get("http://jsbin.com/usidix/1");
        System.out.println("starting implicitwait ");
        
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); // 10 and SECONDS can be changed
        
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
      
        alertMessage = driver.switchTo().alert().getText();
     
        driver.switchTo().alert().accept();
        
        System.out.println(alertMessage);
        //driver.quit();
        
    }
    
    
	
}