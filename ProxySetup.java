package SeleniumScripts;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;// This is used for explicit wait
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 

import java.awt.Dimension;
import java.io.IOException;  
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.firefox.FirefoxProfile;  
import org.testng.annotations.BeforeTest;  
import org.testng.annotations.Test; 
 
public class ProxySetup {
 
    public static void main(String[] args) {
     
        
       // WebDriverWait MyWaitVar = new WebDriverWait(driver,5); //10 indicates the number of seconds to wait
        
      
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "webproxy.ibsplc.com");
        profile.setPreference("network.proxy.http_port", 80);
        WebDriver driver = new FirefoxDriver(profile);
            
             
        driver.get("http://192.168.158.6:8280/fb/shop/airfaresearch.htm?ehn=TYO&ln=EN");
        
      //  driver.manage().window().setSize(new Dimension(200,200));
        
        System.out.println("url invoked ");
  
      		
        WebElement el  =  driver.findElement(By.xpath(".//*[@id='fromCombo']"));
      //get test from element and stored in text variable
      String attributeValue = el. getAttribute("id") ;
      
      System.out.println("attributeValue value is "+attributeValue);

    }
}

       
    
    
	
