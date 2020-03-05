package SeleniumScripts;



import java.io.File;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

 
public class GetColorOfText 
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
        
        String bgcolor = driver.findElement(By.xpath(".//*[@id='nav-city']/a")).getCssValue("background-color");
        System.out.println("Back ground color is :" +bgcolor);
        String textColor = driver.findElement(By.xpath(".//*[@id='nav-city']/a")).getCssValue("color");
        System.out.println("text color is :" +textColor);
        
        //taking a screen shot of webpage
        File snapshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }
}