package testNG_Assert2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Assert.assertNotEquals - If expected and actual DOES NOT match execution of the method will continue. 
//Else, execution of that method will stop and will go to next method

public class assertNotEquals extends testNG_Assert1.BaseClassOne{
  
 String Actualtext;
 
 @BeforeClass
 public void load_url()
 {
  driver.navigate().to("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
 } 
 
         //Assertion Method
 @Test
 public void assertion_method_1() 
 {
 Actualtext = driver.findElement(By.xpath("//h2/span")).getText();
 Assert.assertNotEquals(Actualtext, "Tuesday, 28 January 2014", "Expected and actual matches in assertion_method_1");
 System.out.print("\n assertion_method_1()  executed");
}

//Assertion Method
@Test
public void assertion_method_2() 
{  
 Assert.assertNotEquals(Actualtext, "Tuesday, 29 January 2014", "Expected and actual does not match in assertion_method_2");
 System.out.print("\n assertion_method_2() executed");
    }
 
 //Method Example For Verification
 @Test
 public void verification_method() 
 {
  String time = driver.findElement(By.xpath("//div[@id='timeLeft']")).getText();
  
  if (time == "Tuesday, 28 January 2014")
  {
	  System.out.print("\nValue in time is "+ time);
	  System.out.print("\nThe value in time should be compared with 'Tuesday, 28 January 2014' ");
   System.out.print("\nText Match");
  }
  else
  {
   System.out.print("\nValue in time is "+ time);
   System.out.print("\nThe value in time should be compared with 'Tuesday, 28 January 2014' ");
   System.out.print("\nText does not Match\n\n");
  }
 }
}