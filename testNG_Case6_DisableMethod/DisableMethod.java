package testNG_Case6_DisableMethod;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DisableMethod 
{
 WebDriver driver;

 @BeforeTest
 public void setup() throws Exception 
 {
  System.out.println("In @BeforeTest Of Test_One.");
 }
 
 @Test(priority=1,enabled = false)
 public void testCaseOne_Test_One() 
 {
  System.out.println("This method is Disabled.Executing testCaseOne_Test_One.");
 }
 
 @Test(priority=2)
 public void testCaseTwo_Test_One() 
 {
  System.out.println("This method is Active.Executing testCaseTwo_Test_One.");	
  
 }
}