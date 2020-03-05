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

public class Timeout_ExpectedException {
 
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


@Test(timeout=2000) // this will fail as this fn takes more than 2 seconds
public void test1() throws InterruptedException{  
	System.out.print("\ninside @Test(timeout=2000)");
driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("junittest2 class-test1");
System.out.print("\njunittest2 class-test1 executed before sleep");
Thread.sleep(5000);
System.out.print("\njunittest2 class-test1 executed after sleep");
}

@Test // this will fail as this fn throws exception
public void exceptiontest1() {
	System.out.print("\ninside @Test");
    throw new NullPointerException();
}

@Test(expected = NullPointerException.class) // this will NOT fail as this fn Catches the Exception
public void exceptiontest2() {
	System.out.print("\ninside @Test(expected = NullPointerException.class)");
 throw new NullPointerException();
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

