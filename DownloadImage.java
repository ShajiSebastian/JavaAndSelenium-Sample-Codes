package SeleniumScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadImage {
 
 WebDriver driver;
 @BeforeTest
 public void setup() throws Exception {
  driver =new FirefoxDriver();     
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
 }
 
 @Test
 public void Save_Image() throws IOException, InterruptedException, AWTException {
  //Locate Image
  WebElement Image =driver.findElement(By.xpath("//img[@border='0']"));
  //Right click on Image using contextClick() method.
  Actions action= new Actions(driver);
  action.contextClick(Image).build().perform();
  Thread.sleep(5000);
  //To perform press Ctrl + v keyboard button action.
  action.sendKeys(Keys.CONTROL, "v").build().perform();

  Thread.sleep(3000);
  Robot robot = new Robot();
  // To press D key.
  System.out.println ("Going to press D key");
  Thread.sleep(2000);
  robot.keyPress(KeyEvent.VK_D);
  // To press : key.
  System.out.println ("Going to press SHIFT key");
  Thread.sleep(2000);
  robot.keyPress(KeyEvent.VK_SHIFT);
  System.out.println ("Going to press ';' key");
  Thread.sleep(2000);
  robot.keyPress(KeyEvent.VK_SEMICOLON);
  System.out.println ("Going to press SHIFT key");
  Thread.sleep(2000);
  robot.keyRelease(KeyEvent.VK_SHIFT);
  // To press \ key.
  System.out.println ("Going to press '\' key");
  Thread.sleep(2000);
  robot.keyPress(KeyEvent.VK_BACK_SLASH);
  // To press "test" key one by one.
  System.out.println ("Going to press T key");
  Thread.sleep(2000);
  robot.keyPress(KeyEvent.VK_T);
  System.out.println ("Going to press E key");
  Thread.sleep(2000);
  robot.keyPress(KeyEvent.VK_E);
  System.out.println ("Going to press S key");
  Thread.sleep(2000);
  robot.keyPress(KeyEvent.VK_S);
  System.out.println ("Going to press T key");
  Thread.sleep(2000);
  robot.keyPress(KeyEvent.VK_T);
  // To press Save button.
  System.out.println ("Going to press Enter key");
  Thread.sleep(2000);
  robot.keyPress(KeyEvent.VK_ENTER);  
 }
}