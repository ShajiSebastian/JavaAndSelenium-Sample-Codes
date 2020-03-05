package testNG_Case3_ParallelTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Two {
 WebDriver driver;
 WebElement dragElementFrom;
 
 @BeforeTest
 public void setup() throws Exception {
  System.out.println("In @BeforeTest Of Test_Two.");
  driver =new FirefoxDriver();     
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");
 }
 
 @Test(priority=1)
 public void testCaseOne_Test_Two() {
  System.out.println("Executing testCase1 of Test_Two");
  driver.findElement(By.xpath("//input[@id='2']")).click();
  driver.findElement(By.xpath("//input[@id='minus']")).click();
  driver.findElement(By.xpath("//input[@id='6']")).click();
  driver.findElement(By.xpath("//input[@id='equals']")).click();
  String Result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
  System.out.println("Result of testCase1 of Test_Two = "+Result);
 }
 
 @Test(priority=2)
 public void testCaseTwo_Test_Two() {
  System.out.println("Executing testCase2 of Test_Two.");
  driver.findElement(By.xpath("//input[@id='Resultbox']")).clear();
  driver.findElement(By.xpath("//input[@id='7']")).click();
  driver.findElement(By.xpath("//input[@id='minus']")).click();
  driver.findElement(By.xpath("//input[@id='3']")).click();
  driver.findElement(By.xpath("//input[@id='equals']")).click();
  String Result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
  System.out.println("Result of testCase2 of Test_Two = "+Result);
 }
}