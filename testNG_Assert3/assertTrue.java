package testNG_Assert3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Assert.assertTrue - If condition returns True the execution of the method will continue. 
//Else, execution of that method will stop and will go to next method

public class assertTrue extends testNG_Assert3.BaseClassOne
{
  
 String Actualtext;
 WebElement chk1, chk2;
 
 @BeforeClass
 public void load_url()
 {
  driver.get("http://only-testing-blog.blogspot.in/2014/02/attributes.html");
  chk1 = driver.findElement(By.xpath("//input[@name='option1']"));
  chk2 = driver.findElement(By.xpath("//input[@name='option2']"));  
 } 
 //Assertion Method - will pass
 @Test
  public void asserttrue1() 
 {  
  System.out.print("\nCheck1 button selection status: "+chk1.isSelected());
  Assert.assertTrue(chk1.isSelected());  
  System.out.print("\n asserttrue1() Executed. It means assertion is pass");
 } 
 //Assertion Method - will fail
 @Test
  public void asserttrue2() 
 {  
  System.out.print("\nChecke button selection status: "+chk2.isSelected());
  Assert.assertTrue(chk2.isSelected());
  System.out.print("\n asserttrue2() Executed. It means assertion is pass");
 }
 
}