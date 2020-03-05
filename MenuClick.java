package SeleniumScripts;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;// This is used for explicit wait
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class MenuClick {
 
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
 
        //driver.get("http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html");
        driver.get("http://www.manoramaonline.com/fasttrack.html");
        
        
        driver.switchTo().frame("classFrame");
       driver.findElement(By.xpath(".//*[@id='dropdown-7']/div/div[1]/div[3]/h2/a")).click();
    //    driver.quit();
      
     
      System.out.println("Implicit wait started ");
      driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS); // 10 and SECONDS can be changed
      
      System.out.println("Explicit wait to display Menu option ");
      WebDriverWait MyWaitVar = new WebDriverWait(driver,15); //10 indicates the number of seconds to wait
    MyWaitVar.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("classFrame"));
    driver.findElement(By.linkText("Deprecated")).click();
        
    }
}