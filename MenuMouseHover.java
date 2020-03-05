package SeleniumScripts;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

 
public class MenuMouseHover 
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
        
     // Instantiating Action Interface  
        Actions actions = new Actions(driver);
     // howering on the element
        WebElement link_City = driver.findElement(By.xpath(".//*[@id='nav-city']/a"));
        actions.moveToElement(link_City);
        actions.perform();
       
        System.out.println("Mouse pointer over City option");
        System.out.println("Waiting to display the option 'Kochi'");
        MyWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='nav-city']/div/div/div/div[2]/ul/li[9]/a")));
        
        driver.findElement(By.xpath(".//*[@id='nav-city']/div/div/div/div[2]/ul/li[9]/a")).click();
        System.out.println("Clicked on Kochi option");
        
             
       /*
        WebElement doubleClick = driver.findElement(By.xpath(".//*[@id='netspidersosh']/div[1]/div[1]/div/div[6]/div/div"));
        
        action.doubleClick(doubleClick).build().perform();
        System.out.println("Double clicked on Submenu option");
        
        */
    }
}
    
    