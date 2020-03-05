package testNG_Assert1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClassOne 
{
    //Declared as public static to use same webdriver instance publicly
    public static WebDriver driver = new FirefoxDriver();

    //@BeforeSuite annotation describes this method has to run before all suites
    @BeforeSuite 
    public void setup() throws Exception 
    { 
    	System.out.print("\ninside testNG_Assert BaseClassOne.java");
    	System.out.print("\nbrowser inovked and accessing url");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html"); 
    } 
    
    //@AfterSuite annotation describes this method has to run after execution of all suites
    @AfterSuite
    public void tearDown() throws Exception 
    { 
    	System.out.print("\n\ninside testNG_Assert BaseClassOne.java");
    	System.out.print("\nquitting browser");
        driver.quit(); 
    } 
}