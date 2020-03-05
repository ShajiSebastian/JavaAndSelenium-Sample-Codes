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

public class DropDown 
{
	static WebDriver driver;
	
	
	public static void main(String args[]) throws IOException
	{
		System.out.println ("Execution starts for Dropdown...");
				
		FirefoxDriver driver =  new FirefoxDriver();
		driver.get("http://192.168.158.11:8280/fb/shop/airfaresearch.htm?ehn=TYO&ln=en");
		
		String color = driver.findElement(By.xpath(".//*[@id='more']")).getCssValue("color");
		System.out.println ("Color of text: "+color);
		
		
		driver.findElement(By.xpath(".//*[@id='more']")).click();
		
		
		
		WebElement dropdownlist = driver.findElement(By.id("searchOption1"));
		List<WebElement> allDropdowns = dropdownlist.findElements(By.className("form-group"));
		
		//List<WebElement> allDropdowns = dropdownlist.findElements(By.tagName("label"));
		int dropdownCount= allDropdowns.size();
		System.out.println ("Dropdown options count :" +dropdownCount);
		
		for (WebElement dropdownnames : allDropdowns)
		{
			String sValue = dropdownnames.findElement(By.tagName("label")).getText();
			//String sValue = dropdownnames.getText();
			System.out.println("drop down Name: "+ sValue);
			//driver.findElement(By.id("row")).getText();
			//driver.findElement(By.id("row")).getText();
						
		}
		System.out.println ("Going to quit");
		driver.quit();
		 
		
		//Select mydrpdwn = new Select(driver.findElement(By.id("adults")));
		//mydrpdwn.selectByVisibleText("9");

}
}