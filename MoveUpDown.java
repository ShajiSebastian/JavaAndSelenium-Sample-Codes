package SeleniumScripts;



import java.io.File;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

 
public class MoveUpDown 
{
 
    public static void main(String[] args) 
    {
    	 WebDriver driver = new FirefoxDriver();     
        driver.get("http://timesofindia.indiatimes.com/");
        System.out.println("Invoked url ");
        WebDriverWait MyWaitVar = new WebDriverWait(driver,25); //10 indicates the number of seconds to wait
        System.out.println("Set explicit wait of 25 seconds");
        System.out.println("Waiting to display the option 'City'");
        MyWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='nav-city']/a"))); // waiting till username field is shown in page
        												
        System.out.println("Identifying the Menu option 'City' and mouse points to it");
      
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        System.out.println("Vertical scroll - down by 500 pixels");
        jsx.executeScript("window.scrollBy(0,500)", "");
      
        System.out.println("Vertical scroll - up by 550 pixels (note the number is minus 55)");
        jsx.executeScript("window.scrollBy(0,-550)", "");
       
     
       jsx.executeScript("window.scrollBy(200,0)", "");
       
       System.out.println("Horizontal scroll - left by 395 pixels (note the number is minus 95)");
       jsx.executeScript("window.scrollBy(-395,0)", "");
    }
}