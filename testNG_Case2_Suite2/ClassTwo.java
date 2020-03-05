package testNG_Case2_Suite2;


import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class ClassTwo extends testNG_Case2_Suite1.BaseClassOne{
  
 @Test
  public void testmethodone() {
	 System.out.print("\n\ninside testNG_Case2_Suite2 classTwo.java testmethodone()");
  driver.navigate().to("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
  String title = driver.getTitle();
  System.out.print("\nCurrent page title is : "+title);
  String Workdir = System.getProperty("user.dir");
  String Classpackname = this.getClass().getName();
  System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodone' has been executed successfully");
  }
 
 @Test
 public void testmethodtwo() {
	 System.out.print("\n\ninside testNG_Case2_Suite2 classTwo.java testmethodtwo()");
     driver.findElement(By.xpath("//input[@value='female']"));
     String Workdir = System.getProperty("user.dir");
     String Classpackname = this.getClass().getName();
     System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodtwo' has been executed successfully");
  }
}