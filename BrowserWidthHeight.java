package SeleniumScripts;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

 
public class BrowserWidthHeight 
{
 
    public static void main(String[] args) throws IOException 
    {
    	

WebDriver driver = new FirefoxDriver();

Dimension d = new Dimension (500,6000); // width,height
driver.manage().window().setSize(d);
    }
}
    
    