package SeleniumScripts;
//import org.openqa.jetty.html.List;
import org.openqa.selenium.support.ui.ExpectedConditions;// This is used for explicit wait
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait
import java.util.concurrent.TimeUnit; // this is used for implicit wait
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//import com.google.common.collect.Table.Cell;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchSuggestionsGoogle 
{
	static WebDriver driver;
	
	
	public static void main(String args[]) throws IOException, InterruptedException 
	{
		System.out.println ("Execution starts for Google...");
				
		FirefoxDriver driver =  new FirefoxDriver();
		driver.get("https://www.google.co.in/?gws_rd=ssl");
		
		 Thread.sleep(6000);
		 
		 WebElement searcharea = driver.findElement(By.xpath(".//*[@id='gs_htif0']"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].disabled = false", searcharea);
		 Thread.sleep(2000);
		// searcharea.sendKeys("Selenium");
		// Thread.sleep(2000);
		// Capture Search Auto Suggestions
		
		 driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("Selenium");
		 Thread.sleep(2000);
		 //driver.findElement(By.name("q")).sendKeys("calculator3");
		 //Thread.sleep(2000);
		
        List<WebElement> listBox = driver.findElements(By.xpath("//div//div//ul[@role='listbox']//li"));
        int listBoxSize = listBox.size();
        System.out.println("The size of the listbox is:"+listBoxSize);
        
        ArrayList<String> listBoxItems = new ArrayList<String>();
        for (WebElement option : listBox)
        {
        	  System.out.println("option:"+option.getText());
              listBoxItems.add(option.getText());
        }
	

                
        // ArrayList to store expected Test data
        ArrayList<String> expectedItems = new ArrayList<String>();
        
        expectedItems.add("selenium ide");
        expectedItems.add("selenium tutorial");
        expectedItems.add("selenium webdriver");
        expectedItems.add("selenium");
     //    Compare the ArrayLists
      //  assertTrue("Verification Failed: The correct options are not being dispalyed.",expectedItems.toString().contentEquals(expectedItems.toString()));
      //   Verify and Click on the Submit Button
    //    WebElement submitButton = driver.findElement(By.name("btnG"));
       // assertTrue("Verification Failed: Submit button is not being displayed.",submitButton.isDisplayed());
     //   submitButton.click();
        // Verify that the first result for Selenium HQ website is shown and Click on it
        WebElement seleniumHQLink = driver.findElement(By.linkText("Selenium - Web Browser Automation"));
       // assertTrue("Verification Failed: Selenium HQ website link is not shown.",seleniumHQLink.isDisplayed());
        seleniumHQLink.click();
        // Verify that the user is redirected to the Selenium's Official Website
        //assertTrue("Verification Failed: User is redirected to a wrong page.",(driver.getCurrentUrl().equals("http://www.seleniumhq.org/"))&&(driver.getTitle().equals("Selenium - Web Browser Automation")));
        // Navigate back to the Google Search Engine Webpage
        driver.navigate().back();
   
	}
}
	

	
