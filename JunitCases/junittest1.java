package JunitCases;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class junittest1 {
 
 WebDriver driver = new FirefoxDriver();

 @Test
 public void test() throws InterruptedException {
	 System.out.print("\ninside @Test. Execution starts of junittest1");
  driver.manage().window().maximize();
  driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
  driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest1 executed");
  Thread.sleep(2000);
  System.out.print("\njunittest1 class is executed");
  driver.quit();
 }
}