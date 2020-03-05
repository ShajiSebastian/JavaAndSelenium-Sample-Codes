package testNG_Assert4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Assert.assertFalse - If condition returns FALSE the execution of the method will continue. 
//else, execution of that method will stop and will go to next method

public class assertFalse extends testNG_Assert4.BaseClassOne
{
  
 String Actualtext;
 WebElement chk1, chk2;
@BeforeClass
public void load_url(){
 driver.get("http://only-testing-blog.blogspot.in/2014/02/attributes.html");
 chk1 = driver.findElement(By.xpath("//input[@name='option1']"));
 chk2 = driver.findElement(By.xpath("//input[@name='option2']"));  
} 
//Assertion Method - will Fail
@Test
public void assertfalse1() {
 System.out.print("\n"+chk1.isSelected());
 Assert.assertFalse(chk1.isSelected());
}
//Assertion Method - will Pass
@Test
public void assertfalse2() {
 System.out.print("\n"+chk1.isSelected());
 Assert.assertFalse(chk2.isSelected());
}
 
}