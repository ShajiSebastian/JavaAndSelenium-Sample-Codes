package SeleniumScripts;

import java.util.List;



import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

 
public class AllLinksInWeb 
{
 
    public static void main(String[] args) 
    {
    	
    	
        String baseUrl = "http://newtours.demoaut.com/";
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try
        {
       JavascriptExecutor javascript = (JavascriptExecutor) driver;
    	javascript.executeScript("alert('Test Case Execution Is started Now..');");
    	Thread.sleep(5000);
    	  driver.switchTo().alert().accept();
        }
        catch(Exception e3)
        {
        	 System.out.println("AAAAAAAAAAA");
        }
    	
        String underConsTitle = "Under Construction: Mercury Tours";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        driver.get(baseUrl);
        System.out.println("identifying the number of links");
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links is: "+ linkElements.size());
        String linkTexts[] = new String[linkElements.size()];
        int i = 0;
        
    
        //extract the link texts of each link element
        for (WebElement e : linkElements) 
        {
        	
            linkTexts[i] = e.getText();
            System.out.println("linkTexts["+i+"]="+linkTexts[i] ) ;
            i++;
        }
 
        //test each link
        for (String t : linkTexts) 
        {
            driver.findElement(By.linkText(t)).click();
            if (driver.getTitle().equals(underConsTitle)) 
            {
                System.out.println("\"" + t + "\"" + " is under construction.");
            } else 
            {
                System.out.println("\"" + t + "\"" + " is working.");
            }
         driver.navigate().back();
         //driver.navigate().forward();
        }
        System.out.println("Finished");
        driver.quit();
    }
}