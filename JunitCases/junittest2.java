package JunitCases;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class junittest2 {
 
 WebDriver driver = new FirefoxDriver();
 
 @BeforeClass
 public static void BeforeClass() {
 	System.out.print("\ninside @BeforeClass");
 
 }
 
@Before
public void setup () {
	System.out.print("\n\ninside @Before. Execution starts of junittest2");
 driver.manage().window().maximize();
 driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
}


@Ignore
 @Test
 public void test1() throws InterruptedException{  
	 System.out.print("\ninside @Test. inside test1() of junittest2");
 driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest2 class-test1");

 Thread.sleep(1000);
 }
 
 @Test
 public void test2() throws InterruptedException {
	 System.out.print("\ninside @Test. inside test2() of junittest2");
 driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest2 class-test2");
 Thread.sleep(1000);
 
 }
 


@After
public void aftertest() {
	System.out.print("\ninside @After.inside aftertest() of junittest2");
 driver.quit(); 
}

 
 @AfterClass
 public static void AfterClass() {
 	System.out.print("\n\ninside @AfterClass");

  
 }
}

