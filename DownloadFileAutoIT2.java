package SeleniumScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFileAutoIT2  {
 WebDriver driver;
 
 @BeforeTest
 public void setup() throws Exception {
  driver =new FirefoxDriver();     
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
 }
 
 @Test
 public void testCaseOne_Test_One() throws IOException, InterruptedException {
  //Click on Download Text File link to download file.
  driver.findElement(By.xpath("//a[contains(.,'Download Text File')]")).click();
  Thread.sleep(5000);
  //Execute Script To Download File.exe file to run AutoIt script. File location = E:\\AutoIT\\
  Runtime.getRuntime().exec("D:\\Shaji\\AutoITScripts\\DownloadFromBlog.exe");
 }
}