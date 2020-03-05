package SeleniumScripts;
//import org.openqa.jetty.html.List;
import org.openqa.selenium.support.ui.ExpectedConditions;// This is used for explicit wait
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait

import java.text.SimpleDateFormat;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

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


		 
		import java.util.Set;
		 
		import java.util.concurrent.TimeUnit;
		 
		import org.openqa.selenium.By;
		 
		import org.openqa.selenium.WebDriver;
		 
import org.openqa.selenium.firefox.FirefoxDriver;
		 
		public class WindowHandles {
		 
		public static WebDriver driver;
		 
		public static void main(String[] args) {
		 
		// Create a new instance of the Firefox driver
		 
		        driver = new FirefoxDriver();
		 
		        // Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
		 
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		        // Launch the URL
		        
		        System.out.println("Execution starts for Window Handles script");
				 
		 
		        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		 
		        // Store and Print the name of the First window on the console
		 
		        
		        String handle= driver.getWindowHandle();
		 
		        System.out.println("First window Handle name: "+handle);
		        
		        String currentURL1 = driver.getCurrentUrl();
		         System.out.println("currentURL 1 name is: "+currentURL1);
		         String title1 = driver.getTitle();
		         System.out.println("Title name is: "+title1);
		 
		        // Click on the Button "New Message Window"
		 
		        driver.findElement(By.xpath(".//*[@id='content']/p[3]/button")).click();
		        					
		        // Store and Print the name of all the windows open     
		        
		        /*
		    	
				 Set <String> handles=driver.getWindowHandles();  
				   Iterator<String> it=handles.iterator();
				   String first=it.next();
				   String second=it.next();
				   System.out.println(first);
				   System.out.println(second);
				   Thread.sleep(5000);
				   driver.switchTo().window(second);
				   
		 */
		        Set handles = driver.getWindowHandles();
		 
		        System.out.println("\nAll window Handle names:\n\n" +handles);
		 
		        // Pass a window handle to the other window
		 
		        for (String handle1 : driver.getWindowHandles()) {
		 
		        
		 
		         driver.switchTo().window(handle1);
		         System.out.println(handle1);		         
		         String currentURL2 = driver.getCurrentUrl();
		         System.out.println("\nCurrentURL name is: "+currentURL2);
		         String title2 = driver.getTitle();
		         System.out.println("Title name is: "+title2);
		 
		         }
		 
		        // Closing Pop Up window
		 
		        driver.close();
		 
		        // Close Original window
		 
		        driver.quit();
		 
		}
		 
		
	
	
}