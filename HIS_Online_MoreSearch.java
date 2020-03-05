package SeleniumScripts;
//import org.openqa.jetty.html.List;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent ;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;// This is used for explicit wait
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait
import java.util.concurrent.TimeUnit; // this is used for implicit wait
import org.openqa.selenium.support.ui.Select;

import java.awt.Robot;
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
import org.openqa.selenium.Keys;
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
public class HIS_Online_MoreSearch 
{
	static WebDriver driver;
	int productCount = 0;
	int i;
	WebDriverWait MyWaitVar5Sec = new WebDriverWait(driver,5);
	WebDriverWait MyWaitVar10Sec = new WebDriverWait(driver,10);
	WebDriverWait MyWaitVar20Sec = new WebDriverWait(driver,20);
	WebDriverWait MyWaitVar30Sec = new WebDriverWait(driver,30); //10 indicates the number of seconds to wait
	WebDriverWait MyWaitVar60Sec = new WebDriverWait(driver,60);
	String typeOfSearch;
	
	public static void main(String args[]) throws IOException
	{
		System.out.println ("Execution starts...");
				
		driver =  new FirefoxDriver();
		
        //Create a object of Read data from excel
		HIS_Online_MoreSearch objReadFile = new HIS_Online_MoreSearch();
 	    objReadFile.loginApplication(driver); // Calling function to read the data from input data sheet
 	    //exitExecution();
 	    
	}
  
 	   
 	   
 	  public void loginApplication(WebDriver driver) throws IOException
 		// public void loginApplication(String filePath,String fileName,String sheetName) throws IOException
 		   {
 		   		  	 
 		
 		 	System.out.println("Trying to access input test data sheet");   
 			
 			String filePath= "D:\\Shaji\\Selenium\\SeleniumScriptsFiles";
 			String fileName= "HIS_TestData.xlsx";
 			String sheetName= "Login_Online";
 			
 			File file =    new File(filePath+"\\"+fileName);
 			//File file =    new File("D:\\Shaji\\Selenium\\SeleniumScriptsFiles"+"\\"+"VSC_Selenium_TestData.xlsx");	   
 	   
 			//Create an object of FileInputStream class to read excel file

 			FileInputStream inputStream = new FileInputStream(file);

 			Workbook vscWorkbook = null;

 			//Find the file extension by splitting file name in substring and getting only extension name
 	   
 			System.out.println("checking the file type of input file");

 			String fileExtensionName = fileName.substring(fileName.indexOf("."));

 			//Check condition if the file is xlsx file

 				if(fileExtensionName.equals(".xlsx"))
 	   			{
 					//If it is xlsx file then create object of XSSFWorkbook class
 					vscWorkbook = new XSSFWorkbook(inputStream);
 				}

 			//Check condition if the file is xls file

 				else if(fileExtensionName.equals(".xls"))
 	   			{
 					//If it is xls file then create object of XSSFWorkbook class
 					vscWorkbook = new HSSFWorkbook(inputStream);
 				}

 			//Read sheet inside the workbook by its name
 			
 				Sheet vscSheet = vscWorkbook.getSheet(sheetName);

 	 			//Create a loop over all the rows of excel file to read it

 					System.out.println ("Login credentials as per test data sheet");
 	 				Row row0 = vscSheet.getRow(0);
 	 				String applicationURL = row0.getCell(1).getStringCellValue();
 	 				System.out.println ("   Login url: " + applicationURL);
 	 		
 	 				
 	 			 //Invoking application url
 	 	 		  System.out.println ("\nTrying to invoke Login page");
 	 	 		 driver.get(applicationURL);
 	 	 		  
 	 	 	
				
				
 	 	 			   
 	 	 		// MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j_username']"))); // waiting till username field is shown in page
 	 	 		 
 	 	 		// get the page name of the invoked url
 	 	         String actualTitleurl = driver.getTitle(); 
 	 	         
 	 	         
 	 	         String expectedTitleurl = "Farebroker - Login Page";
 	 	         
 	 	         // compare the actual title of the page with the expected one and print the result as "Passed" or "Failed"
 	 	         
 	 	         if (actualTitleurl.contentEquals(expectedTitleurl)){
 	 	             System.out.println("Login page invoked successfully");
 	 	         } else {
 	 	             System.out.println("The page invoked is not as expected");
 	 	         }
 	 	        System.out.println ("Title of launched page is : "+ actualTitleurl);
 	 	      
 	 	          
 	 	           // Getting current url
 	 	         String currentUrl= driver.getCurrentUrl();
 	 	         System.out.println("Current url is: "+ currentUrl);
 	 	     /*
 	 	       WebElement UserID = driver.findElement(By.id(".//*[@id='j_username']"));
 	 	     UserID.clear();
 	 	     UserID.sendKeys("00F888");
 	 	      	 	     */
 	 	  
 			
 		// trying to take screen shot before submitting the Login credentials	
 			try{
 	            //take screenshot and save it in a file
 	            File screenshotLogin = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

 	            //copy the file to the required path
 	            FileUtils.copyFile(screenshotLogin,new File("D:\\Shaji\\Selenium\\ScreenShots\\LoginScreen.jpeg"));

 	        }
 			catch(Exception screenShotError)
 			{
 	            //if it fails to take screenshot then this block will execute
 	            System.out.println("Failure to take screenshot "+screenShotError);
 	        }
 	            
 	
 			
 			      
 	
 	        
 	 	 
 		
 			// Store the current window handle
 			//String winHandleBefore = driver.getWindowHandle();

 			// Clicking Airshopping page link
 			
 		
 			
 			// Switch to new window opened
 			//for(String winHandle : driver.getWindowHandles())
 			//{
 			//    driver.switchTo().window(winHandle);
 			//}
 			
 			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fromCombo']"))); // waiting till Search page is shown in page
 			
 			 				
 			       inputStream.close();	
 			      searchProducts(vscWorkbook); 
 		   }
 	  
 	  
 	 public void searchProducts(Workbook vscWorkbook) throws IOException
 	 {
 		 
 		
		driver.getWindowHandle();
		
	
		String sheetName= "Search_Online";
		
		Sheet vscSheet = vscWorkbook.getSheet(sheetName);

		//Find number of rows in excel file

		int rowCount = vscSheet.getLastRowNum()-vscSheet.getFirstRowNum();

		//Create a loop over all the rows of excel file to read it

	for (int i = 1; i < rowCount+1; i++) 
		{
			productCount = 0;
			System.out.println ("\n\n++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println ("\nTest Data No: " + i + "\n");
			//driver.navigate().refresh(); // Simply refreshes the page
			Row row = vscSheet.getRow(i);

			//Create a loop to print cell values in a row

			System.out.println ("Search criteria as per test data sheet");
			
			Row row1 = vscSheet.getRow(i);
			
			String runStatus = row1.getCell(1).getStringCellValue();
			System.out.println ("   Run Status: " + runStatus);
			
			if (runStatus.equals("Yes") || (runStatus.equals("yes") ) || (runStatus.equals("YES")) )
			{
			
						
			String typeOfSearch = row1.getCell(2).getStringCellValue();
			System.out.println ("   Type of Search: " + typeOfSearch);
			
			String originAirport = row1.getCell(3).getStringCellValue();
			System.out.println ("   Origin Airport: " + originAirport);
			
			String DestinationAirport = row1.getCell(4).getStringCellValue();
			System.out.println ("   Destination Airport: " + DestinationAirport);
			
			System.out.println ("\n Verifying Search Functionality");
			System.out.println (" ********************************\n");
			
						
			if (typeOfSearch.equals("RT"))
			{
				
				MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='searchTypeId']"))); // waiting till Search page is shown in page
				//driver.findElement(By.cssSelector("input[value='RT']")).clear();
				driver.findElement(By.cssSelector("input[value='RT']")).click();
				System.out.println ("RT search option selected");
			}
			else if (typeOfSearch.equals("OW")) 
			{	
				
				MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='search_store_box']/p/label[2]"))); // waiting till Search page is shown in page
				
				//driver.findElement(By.cssSelector("input[value='OW']")).clear();	
				driver.findElement(By.cssSelector("input[value='OW']")).click();
				System.out.println ("OW search option selected");
			}

			
			
			//Selecting Origin Airport (Dropdown list)
			 // declares an array of integers
	        String[] originAirportList;

	        // allocates memory for 10 Strings
	        originAirportList = new String[47];
	           
	        // initialize first element
	        originAirportList[0] = "NRT";
	        
	        for (int originCount =0 ; originCount <=46 ; ++originCount)
	        {
	        Select originAirportDropdown = new Select (driver.findElement(By.xpath(".//*[@id='fromCombo']")));
	        originAirportDropdown.selectByIndex(originCount);
	        WebElement selectedOriginAirport = originAirportDropdown.getFirstSelectedOption();
	        System.out.println("Dropdown Airport "+selectedOriginAirport.getText());
	        System.out.println("Excel Airport "+originAirport);
	        if (selectedOriginAirport.getText().equals(originAirport))
	        {
	        	System.out.println("Selected Origin airport");	
	        	break;
	        }
	        //originAirportList[originCount]=originAirport1.getText();
	        
	       // System.out.println("originAirportList["+originCount+"] :"+originAirportList[originCount]);	        
	        }
	        
	       
			driver.findElement(By.xpath(".//*[@id='destinationSId']")).clear();
			driver.findElement(By.xpath(".//*[@id='destinationSId']")).sendKeys(DestinationAirport);
			waittimeVeryShort() ;
			driver.findElement(By.xpath(".//*[@id='destinationSId']")).click();	
			
			//trying for Multidestination search
			MyWaitVar5Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='RTFrmMreSrchId']")));
			driver.findElement(By.xpath(".//*[@id='RTFrmMreSrchId']")).click();	
			
			MyWaitVar5Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='moreSearchTypeId']")));
			driver.findElement(By.xpath(".//*[@id='moreSearchTypeId']")).click();	
			
			
			
			MyWaitVar5Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='multidestinationSId']")));
			driver.findElement(By.xpath(".//*[@id='multidestinationSId']")).clear();
			driver.findElement(By.xpath(".//*[@id='multidestinationSId']")).sendKeys("LAX");
				
			System.out.println("LAX Typed");	
			waittimeVeryShort() ;
			driver.findElement(By.xpath(".//*[@id='multidestinationSId']")).click();
			
			MyWaitVar5Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='multidestinationSId']")));
			
			driver.findElement(By.xpath(".//*[@id='multidestinationSId']")).sendKeys(Keys.TAB);
			
			waittimeVeryShort() ;
		
			
			MyWaitVar5Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='multidestinationSId']")));
			driver.findElement(By.xpath(".//*[@id='multidestinationSId']")).clear();
			driver.findElement(By.xpath(".//*[@id='multidestinationSId']")).sendKeys("SEL");
			
			System.out.println("SEL Typed");	
			waittimeVeryShort() ;
			driver.findElement(By.xpath(".//*[@id='multidestinationSId']")).click();		
			
			driver.findElement(By.xpath(".//*[@id='alternateMSfrom']")).clear();
			driver.findElement(By.xpath(".//*[@id='alternateMSfrom']")).sendKeys("2015/10/15");
			driver.findElement(By.xpath(".//*[@id='alternateMSfrom']")).click();	
			//waittimeShort() ;
			
			if (typeOfSearch.equals("RT"))
			{
				driver.findElement(By.xpath(".//*[@id='alternateMSto']")).clear();
				driver.findElement(By.xpath(".//*[@id='alternateMSto']")).sendKeys("2015/11/15");
				driver.findElement(By.xpath(".//*[@id='alternateMSto']")).click();	
			
			}
			
		
			
			System.out.println ("Search criteria entered");
			//waittimeMedium();
			
			// Clicking on Search button
			driver.findElement(By.xpath(".//*[@id='moreSearchButton']")).click();
			System.out.println ("Search button clicked");
			
				
				try
				{
				MyWaitVar5Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fareProductSearchForm.errors']")));
				String errorMessage = driver.findElement(By.xpath(".//*[@id='fareProductSearchForm.errors']")).getText();
	 			System.out.println ("Error Message: "+errorMessage);	
	 			continue;
				}
				catch(Exception e01)
				{
					try
					{
					//MyWaitVar5Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/center/h1/span[2]")));
					String errorMessage2 = driver.findElement(By.xpath("html/body/center/h1/span[2]")).getText();
					System.out.println ("Error Message: "+errorMessage2);	
					//exitExecution();
					}
					catch(Exception e02)
					{
						System.out.println ("Search completed");	
					}
				}
			
			
			String actualTitlebasiclistingpage = driver.getTitle(); 
	        System.out.println ("Webpage Title of newly lanched page is : "+ actualTitlebasiclistingpage);
			 
			
	        
	        verifyResults(typeOfSearch,originAirport,DestinationAirport);
	        
	     // Checking whether products are showing for each Destination
	        
	        System.out.println ("\nGoing to click on Singapore City");
	        driver.findElement(By.xpath(".//*[@id='SIN']/span[1]")).click();
	        waittimeVeryShort();
	        
	        String firstCitylowestPriceSIN = driver.findElement(By.xpath("//*[starts-with(@id,'destCityNoLinkDisp')]//*[@id='SIN']/span[2]")).getText();
	        System.out.println ("Lowest Price given in TAB for SIN          : "+ firstCitylowestPriceSIN);
	        
	        String firstCitylowestPriceInShoppingPageSIN = driver.findElement(By.xpath("(//*[starts-with(@id,'prdouct_develop')]//*[@class='label_red_price label_big_20px righttext label_size_normal'])[1]")).getText();
	        System.out.println ("Lowest Price given in Shoping page for SIN : "+ firstCitylowestPriceInShoppingPageSIN);
	        
	        verifyResults(typeOfSearch,originAirport,DestinationAirport);
	        waittimeShort();
	        waittimeShort();
	        
	        System.out.println ("\nGoing to click on LAX City");
	        driver.findElement(By.xpath(".//*[@id='LAX']/span[1]")).click();
	        waittimeVeryShort();
	        
	        String firstCitylowestPriceLAX = driver.findElement(By.xpath("//*[starts-with(@id,'destCityNoLinkDisp')]//*[@id='LAX']/span[2]")).getText();
	        System.out.println ("Lowest Price given in TAB for LAX          : "+ firstCitylowestPriceLAX);
	        
	        String firstCitylowestPriceInShoppingPage = driver.findElement(By.xpath("(//*[starts-with(@id,'prdouct_develop')]//*[@class='label_red_price label_big_20px righttext label_size_normal'])[1]")).getText();
	        System.out.println ("Lowest Price given in Shoping page for LAX : "+ firstCitylowestPriceInShoppingPage);
	        
	        verifyResults(typeOfSearch,originAirport,DestinationAirport);    
	        waittimeShort();
	        waittimeShort();
	        
	        System.out.println ("\nGoing to click on Seoul City");
	        driver.findElement(By.xpath(".//*[@id='SEL']/span[1]")).click();
	        waittimeVeryShort();
	        
	        String firstCitylowestPriceInSEL = driver.findElement(By.xpath("//*[starts-with(@id,'destCityNoLinkDisp')]//*[@id='SEL']/span[2]")).getText();
	        System.out.println ("Lowest Price given in TAB for SEL          : "+ firstCitylowestPriceInSEL);
	        
	        String firstCitylowestPriceInShoppingPageSEL = driver.findElement(By.xpath("(//*[starts-with(@id,'prdouct_develop')]//*[@class='label_red_price label_big_20px righttext label_size_normal'])[1]")).getText();
	        System.out.println ("Lowest Price given in Shoping page for SEL : "+ firstCitylowestPriceInShoppingPageSEL);
	        
	        verifyResults(typeOfSearch,originAirport,DestinationAirport);
	        
	        
			}
			
					
			else
			{
				System.out.println ("Test data is not taken for execution");
			}
			
			writeExcel(i,productCount);
		
		}
 	 }
	
 	 public void verifyResults(String typeOfSearch, String originAirport, String DestinationAirport) throws IOException
 	 {
 		System.out.println ("\nBasic Listing page shown");
 		// code to check number of products returned
 		if(driver.findElements(By.xpath(".//*[@id='example']/span")).isEmpty())
		{ 
 			System.out.println ("No products returned");
 			return;
 		 }
						 
 		else 
		{
 			productCount = Integer.parseInt(driver.findElement(By.xpath(".//*[@id='productSpanId']")).getText());
 			System.out.println ("Total Number of Products returned in shopping page: "+productCount);	
		}
 		
 		 List<WebElement> totalProductsinFirstPage =  driver.findElements(By.xpath(".//*[@id='example']//*[@class='prdouct_develop_grp']"));
			
			System.out.println ("Total products in 1st page is : "+ totalProductsinFirstPage.size() );	
			
			String deptDateTime = driver.findElement(By.xpath("((.//*[starts-with(@id,'prdouct_develop_sub')])[1]/.//*[@class='deptSlice'])[1]")).getText();
			String deptDate = deptDateTime.substring(0, 10);
			
			if (typeOfSearch.equals("RT"))
			{	
				String retDateTime = driver.findElement(By.xpath("((.//*[starts-with(@id,'prdouct_develop_sub')])[1]/.//*[@class='deptSlice'])[2]")).getText();
				String retDate = retDateTime.substring(0, 10);
				System.out.println ("Products returned of the date "+ deptDate+" , "+retDate + "\n");
			}
			
			else if (typeOfSearch.equals("OW"))
			{
				
				System.out.println ("Products returned of the date "+ deptDate);
			}
		
			System.out.println ("\nVerified that User is able to do a search successfully");
			
			
			// trying to take screen shot of basic listing page
	 			try{
	 	            //take screenshot and save it in a file
	 	            File screenshotBasicListingPage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	 	            //copy the file to the required path
	 	            FileUtils.copyFile(screenshotBasicListingPage,new File("D:\\Shaji\\Selenium\\ScreenShots\\BasicListingPage.jpeg"));

	 	        }
	 			catch(Exception screenShotError)
	 			{
	 	            //if it fails to take screenshot then this block will execute
	 	            System.out.println("Failure to take screenshot "+screenShotError); 
	 	        }

 	
	 	 		
 	 }
 	 
 	 
 	 

		public void writeExcel(int i, int productCount) throws IOException
		//public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException{
			{
		   System.out.println("Starts to write the results into an excel");  
	        //Create a object of File class to open xlsx file
			String filePath= "D:\\Shaji\\Selenium\\SeleniumScriptsFiles";
 			String fileName= "HIS_TestData.xlsx";
		   String sheetName ="Search";
		   
	       //File file =    new File("D:\\Shaji\\Selenium\\SeleniumScriptsFiles"+"\\"+"VSC_Selenium_Output.xlsx");
		   File file =    new File(filePath+"\\"+fileName);
	       
		   //Create an object of FileInputStream class to read excel file
	       FileInputStream inputStream = new FileInputStream(file);
	       Workbook vscWorkbookwrite = null;
	 
	       //Find the file extension by splitting file name in substring and getting only extension name
	      
	       String fileExtensionName = fileName.substring(fileName.indexOf("."));
	 
	        //Check condition if the file is xlsx file
	 
	        if(fileExtensionName.equals(".xlsx"))
	        {
	 
	        //If it is xlsx file then create object of XSSFWorkbook class
	        	vscWorkbookwrite = new XSSFWorkbook(inputStream);
	 
	        }
	 
	        //Check condition if the file is xls file
	 
	        else if(fileExtensionName.equals(".xls"))
	        {
	 
	            //If it is xls file then create object of XSSFWorkbook class
	        	vscWorkbookwrite = new HSSFWorkbook(inputStream);
	 
	        }
	 
	        inputStream.close();
	      //Read sheet inside the workbook by its name
 			
		//		Sheet vscSheet = vscWorkbook.getSheet(sheetName);
	 
	    Sheet sheet = vscWorkbookwrite.getSheet(sheetName);
	 
	   
	     
	    //writing value in the excel sheet
	
	     Row row = sheet.getRow(i);
	     Cell prodCount =  row.createCell(5); 
	     prodCount.setCellValue(productCount);

	    //trying to print execution time in excel sheet
	     Date date = new Date();
	     Cell time =  row.createCell(6);
	     time.setCellValue(date.toString());
	    
	     /*
	     HSSFCellStyle style = wb.createCellStyle();
	     style.setFillForegroundColor(HSSFColor.LIME.index);
	     style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

	     HSSFFont font = wb.createFont();
	     font.setColor(HSSFColor.RED.index);
	     style.setFont(font);

	     cell.setCellStyle(style);
	     
	     */
	     
	     
	     
	     Cell status =  row.createCell(7);
	     if (productCount > 10)
	     {	    	 
	    	 //Giving background color
	    	 
	    	 CellStyle style = vscWorkbookwrite.createCellStyle();
		     style.setFillBackgroundColor(HSSFColor.GREEN.index );
		     //Giving font color
		     Font font = vscWorkbookwrite.createFont();
		     font.setColor(HSSFColor.GREEN.index);
		     status.setCellValue("PASS");
		     status.setCellStyle(style);
		   	 style.setFont(font);
		     
		     
		     	     		       
	     }
	     else if (productCount > 0)
	     {
	    	 CellStyle style = vscWorkbookwrite.createCellStyle();
		     style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		     status.setCellValue("FAILed");
		     status.setCellStyle(style);
	     }
	     
	     else
	     {
	    	 status.setCellValue("No Run");
	     }
	     
	     System.out.println("Result written in excel sheet");
	    //Close input stream
	 
	    
	 
	    //Create an object of FileOutputStream class to create write data in excel file
	 
	    FileOutputStream outputStream = new FileOutputStream(file);
	 
	    //write data in the excel file
	 
	    vscWorkbookwrite.write(outputStream);
	 
	    //close output stream
	 
	    outputStream.close();
	 
	     }
	 
	  
		

		public static void exitExecution() throws IOException
		
		
		{
		
		try
		{
		driver.findElement(By.xpath(".//*[@id='logout_btn']/span")).click();
		}
		
		catch (Exception LogoutError)
		{
			System.out.println ("Some issues found in log out action :" +LogoutError);	
		}
		System.out.println ("\nLogged out");
		//driver.close(); //It closes only the browser window that WebDriver is currently controlling.
		driver.quit(); // It closes all windows that WebDriver has opened.
 	 	
		// To close previously opened window
		//driver.switchTo().window(winHandleBefore);
	 	//driver.quit();
	 	System.out.println ("All windows closed sucessfully");
	 	System.out.println ("All Test cases Executed Successfully. Well Done!!!");
		}
		
		
		
		private static void waittimeVeryShort() 
		{
			try
			{
			  Thread.sleep(15*60*2);
			}
			catch(Exception e)
			{
				System.out.println ("Some issues found in wait period :" +e);	
			}
		}
		
	
	private static void waittimeShort() 
	{
		try
		{
		  Thread.sleep(15*60*10);
		}
		catch(Exception e)
		{
			System.out.println ("Some issues found in wait period :" +e);	
		}
	}
	
}


