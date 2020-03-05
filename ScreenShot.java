package SeleniumScripts;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShot {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.co.in");

        try{
            //Code to capture the screenshot
            File scrFile  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //copy the file to the required path
            FileUtils.copyFile(scrFile ,new File("D:\\Shaji\\Selenium\\ScreenShots\\screenshot.jpeg"));

        }catch(Exception e){
            //if it fails to take screenshot then this block will execute
            System.out.println("Failure to take screenshot "+e);

        }
        finally
        {
            //Whatever happens with the screenshot, driver will quit.
            driver.quit();
        }
    }
}