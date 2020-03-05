package SeleniumScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.Select;


 
public class MultiSelectDropDown {
 
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
     
 
        driver.get("http://jsbin.com/osebed/2");
        System.out.println("Selecting multiple options");
        Select fruits = new Select(driver.findElement(By.id("fruits")));
        
        if (fruits.isMultiple()) // checking whether dropdown is multiple or not
        {
        fruits.selectByVisibleText("Banana");
        fruits.selectByIndex(3);
        
        WebElement firstOption = fruits.getFirstSelectedOption();
        System.out.println("First selected option:" +firstOption.getText());
        
        System.out.println("Listing all selected items");
        List<WebElement> allSelectedOptions = fruits.getAllSelectedOptions();
        for (WebElement webElement : allSelectedOptions)
        {
        System.out.println( webElement.getText());
        }
        }
        waittimeMedium();
        
        System.out.println("Deselecting selected items");
        fruits.deselectAll();
        //driver.quit();
        
    }
    
    private static void waittimeMedium() 
	{

		try
		{
		  Thread.sleep(10*60*10);
		}
		catch(Exception e)
		{
				
		}
		
	}
	
}