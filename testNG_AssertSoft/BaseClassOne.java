package testNG_AssertSoft;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClassOne 
{
    //Declared as public static to use same webdriver instance publicly
   // public static WebDriver driver = new FirefoxDriver();
    
    //Create object of webdriver's inbuilt class ProfilesIni to access Its method getProfile.
    ProfilesIni firProfiles = new ProfilesIni();
    //Get access of newly created profile WebDriver_Profile
    FirefoxProfile wbdrverprofile = firProfiles.getProfile("Selenium_Profile");
    //Pass wbdrverprofile parameter to FirefoxDriver.
    		public  WebDriver driver = new FirefoxDriver(wbdrverprofile);  

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