package SeleniumScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectMultipleItems {
 
 WebDriver driver = null;
 
 @BeforeTest
    public void setup() throws Exception {  
  driver = new FirefoxDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
    } 
 
 @Test
 public void selectItems() throws InterruptedException {  

        //Prepare list of selectable Items
        List<WebElement> selectableItems = driver.findElements(By.xpath("//ol[@id='selectable']/*"));           

        //Build the select Item action.
        Actions toSelect = new Actions(driver);
        toSelect.clickAndHold(selectableItems.get(2)).clickAndHold(selectableItems.get(5)).click();

        //Perform action.
        Action selectItems = toSelect.build();
        selectItems.perform();
 }
}