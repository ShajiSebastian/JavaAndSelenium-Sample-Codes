package SeleniumScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SliderMovementEcommerceSite {
 
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
  //Locate slider pointer.
  WebElement dragElementFrom = driver.findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')]"));  
        
  //To Move jQuery slider by 100 pixel offset using dragAndDropBy method of Actions class.
  new Actions(driver).dragAndDropBy(dragElementFrom, 100, 0).build().perform();
  Thread.sleep(5000);
  
  //After 5 seconds, This will Move jQuery slider by 100 pixel offset using the combination of clickAndHold, moveByOffset and release methods of Actions class.
  new Actions(driver).clickAndHold(dragElementFrom).moveByOffset(100,0).release().perform();
 }
}