package SeleniumScripts;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ResizeItems {
 
WebDriver driver = null;
 
 @BeforeTest
    public void setup() throws Exception {  
  driver = new FirefoxDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.get("http://only-testing-blog.blogspot.in/2014/09/drag-and-drop.html");
    } 
 
 @Test
 public void selectItems() throws InterruptedException {  
  //Locate resizable element's bottom-right corner.
  WebElement resizeElement = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));  
        
  //To resize jQuery resizable element by 250 pixel X,Y offset using dragAndDropBy method of Actions class.
  new Actions(driver).dragAndDropBy(resizeElement, 250, 250).build().perform();
  Thread.sleep(6000);
  
  //After 5 seconds, This will resize jQuery resizable element by -100 pixel X,Y offset using the combination of clickAndHold, moveByOffset and release methods of Actions class.
  new Actions(driver).clickAndHold(resizeElement).moveByOffset(-100,-100).release().perform();
 }

}