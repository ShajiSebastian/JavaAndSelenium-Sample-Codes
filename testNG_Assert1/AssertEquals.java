package testNG_Assert1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//Assert.assertEquals - If expected and actual matches execution of the method will continue. 
//Else, execution of that method will stop and will go to next method

public class AssertEquals extends testNG_Assert1.BaseClassOne{
  
 String Actualtext;
 
 @BeforeClass
 public void load_url()
 {
  driver.navigate().to("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
 } 
 
 //Method Example For Assertion
 @Test
  public void assertion_method_1() 
 {
  Actualtext = driver.findElement(By.xpath("//h2/span")).getText();
  Assert.assertEquals(Actualtext, "Tuesday, 28 January 2014");
  System.out.print("\nassertion_method_1() executed");
 } 
 
 //Method Example For Assertion
 @Test
 public void assertion_method_2() 
 {  
  Assert.assertEquals(Actualtext, "Tuesday, 29 January 2014");
  System.out.print("\nassertion_method_2() executed");
 }
 
 //Method Example For Verification
 @Test
 public void verification_method() {
  
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