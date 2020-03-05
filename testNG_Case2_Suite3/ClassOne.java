package testNG_Case2_Suite3;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ClassOne extends testNG_Case2_Suite1.BaseClassOne{
  
 @Test
  public void testmethodone() {
	 System.out.print("\n\ninside testNG_Case2_Suite3 ClassOne.java testmethodone()");
    String title = driver.getTitle();
    System.out.print("\nCurrent page title is : "+title);
    String Workdir = System.getProperty("user.dir");
    String Classpackname = this.getClass().getName();
    System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodone' has been executed successfully");
  }
 
 @Test
 public void testmethodtwo() {
	 System.out.print("\n\ninside testNG_Case2_Suite3 ClassOne.java testmethodtwo()");
     driver.findElement(By.xpath("//input[@value='female']"));
     String Workdir = System.getProperty("user.dir");
     String Classpackname = this.getClass().getName();
     System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodtwo' has been executed successfully");
  }
}