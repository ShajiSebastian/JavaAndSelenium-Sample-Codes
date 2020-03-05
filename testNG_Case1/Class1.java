package testNG_Case1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class1 {
 
 WebDriver driver = new FirefoxDriver();
  
 //@BeforeMethod defines this method has to run before every @Test methods
 @BeforeMethod
 public void openbrowser() { 
 System.out.print("\ninside Class1.java");
 System.out.print("\n\ninisde @BeforeMethod ");
  driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
 }

 //@AfterMethod defines this method has to run after every @Test methods
 @AfterMethod
 public void closebrowser() {
 System.out.print("\n\ninisde @AfterMethod ");
  System.out.print("\nBrowser close");
  driver.quit();
 }
 
 @Test
 public void testmethodone() {
   System.out.print("\n\ninisde @Test ");
   String title = driver.getTitle();
   System.out.print("Current page title is : "+title);
   System.out.print("\n'testmethodone' has been executed successfully");
 }
}