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

public class Datepicker 
{
	static WebDriver driver;
	
	
	public static void main(String args[]) throws IOException
	{
		System.out.println ("Execution starts for Date picker...");
				
		FirefoxDriver driver =  new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.158.11:8280/fb/shop/airfaresearch.htm?ehn=TYO&ln=ja");
		
		// to click on calendar icon
		driver.findElementByXPath(".//*[@id='alternateSfrom']").click();
		System.out.println("Clicked on Calendar");
		WebElement dateWidget = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]"));
		List<WebElement> Listrows = dateWidget.findElements(By.tagName("tr")); 
		//List<WebElement> Listcolumns= Listrows.findElements(By.tagName("td"));
		
		for (WebElement cell: Listrows)
		{
		if (cell.getText().contains("28"))
		    {
				cell.findElement(By.linkText("29")).click();
				break;
	        }
		}
	
	}
}