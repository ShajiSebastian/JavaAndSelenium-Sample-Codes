package SeleniumScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
 
 WebDriver driver = null;
 
 @BeforeTest
    public void setup() throws Exception {  
  driver = new FirefoxDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.get("http://only-testing-blog.blogspot.in/2014/09/drag-and-drop.html");
    } 
 
 @Test
 public void dragAndDrop() {
  //Locate element which you wants to drag.
  WebElement dragElementFrom = driver.findElement(By.xpath("//div[@id='dragdiv']"));
  //Locate element where you wants to drop.
  WebElement dropElementTo = driver.findElement(By.xpath("//div[@id='dropdiv']"));
  
  //Use Actions class and Its members of WebDriver API to perform drag and drop operation.
  Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(dragElementFrom)
            .moveToElement(dropElementTo)
            .release(dropElementTo)
            .build();
        dragAndDrop.perform();   
        System.out.println ("Drag and drop done successfully");
 }
}