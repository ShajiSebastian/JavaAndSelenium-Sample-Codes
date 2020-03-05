package SeleniumScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserProfile_Custom {
 WebDriver driver;
 
 @BeforeTest
 public void StartBrowser() {
  //Create object of webdriver's inbuilt class ProfilesIni to access Its method getProfile.
  ProfilesIni firProfiles = new ProfilesIni();
  //Get access of newly created profile WebDriver_Profile.
  FirefoxProfile wbdrverprofile = firProfiles.getProfile("Selenium_Profile");
  //Pass wbdrverprofile parameter to FirefoxDriver.
  driver = new FirefoxDriver(wbdrverprofile);  
 }
 
 @Test
 public void OpenURL(){
  driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");  
 }
 
 @AfterTest
 public void CloseBrowser() {
  driver.quit();  
 }
}