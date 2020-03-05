package SeleniumScripts;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JunitSample {
 
 WebDriver driver = new FirefoxDriver();

 @Test
 public void test() {
  driver.manage().window().maximize();
  System.out.print("Window maximised");
  driver.get("http://only-testing-blog.blogspot.in/");
  System.out.println("Site Open");
  driver.quit();
  System.out.println("End of Test");
 }

}