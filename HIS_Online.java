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
public class HIS_Online 
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
		HIS_Online objReadFile = new HIS_Online();
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
		
			
			driver.findElement(By.xpath(".//*[@id='alternateSfrom']")).clear();
			driver.findElement(By.xpath(".//*[@id='alternateSfrom']")).sendKeys("2015/10/15");
			driver.findElement(By.xpath(".//*[@id='alternateSfrom']")).click();	
			//waittimeShort() ;
			
			if (typeOfSearch.equals("RT"))
			{
				driver.findElement(By.xpath(".//*[@id='alternateSto']")).clear();
				driver.findElement(By.xpath(".//*[@id='alternateSto']")).sendKeys("2015/11/15");
				driver.findElement(By.xpath(".//*[@id='alternateSto']")).click();	
			
			}
			
			
			//Selecting passenger counts (Dropdown list)
			Select adultCount = new Select (driver.findElement(By.name("fareSearchVO.noOfAdults")));
			adultCount.selectByIndex(3);
			//waittimeShort() ;	
			Select childCount = new Select (driver.findElement(By.name("fareSearchVO.noOfChild")));
			childCount.selectByIndex(3);
			//waittimeShort() ;
			Select infantCount = new Select (driver.findElement(By.name("fareSearchVO.noOfInfants")));
			infantCount.selectByIndex(2);
			//waittimeShort() ;
			
			
			//Selecting Cabin Class (Dropdown list)
			Select cabinClass = new Select (driver.findElement(By.name("fareSearchVO.cabinClass")));
			cabinClass.selectByVisibleText("Economy");
			//waittimeShort() ;
			
			
			
			//Selecting Connection types (Radio button)
			//driver.findElement(By.cssSelector("input[value='DO']")).click();
			
			//Un checking Seat availability option (Check option)
			//WebElement seatAvailability =driver.findElement(By.id("seatAvlId"));
			//seatAvailability.click();
			/*
			if(seatAvailability instance of WebElement) {
			System.out.println("Seat availability option visible");
			} else {
			System.out.println("Seat availability option Not visible");
			}
			*/
			
			System.out.println ("Search criteria entered");
			//waittimeMedium();
			
			// Clicking on Search button
			driver.findElement(By.xpath(".//*[@id='shoppingSearchButton']")).click();
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
			 
			// Checking if products are displayed in shopping path
	        
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
			String deptDate = deptDateTime.substring(0, 9);
			
			if (typeOfSearch.equals("RT"))
			{	
				String retDateTime = driver.findElement(By.xpath("((.//*[starts-with(@id,'prdouct_develop_sub')])[1]/.//*[@class='deptSlice'])[2]")).getText();
				String retDate = retDateTime.substring(0, 9);
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


	 			
	 	//Verifying show details of first product
	 			
	 			System.out.println ("\nVerifying Show details page of first product");
	 				System.out.println ("*****************************************\n");
	 			
	 			driver.findElement(By.xpath("(//*[starts-with(@id,'exp_showDetails')])[1]")).click();
	 			waittimeVeryShort();
	 			WebElement airlineDetailPage =  driver.findElement(By.xpath(".//*[@id='detail_row']/table[1]/tbody/tr[1]/td[1]/strong"));
	 			System.out.println ("Airline of first product: "+airlineDetailPage.getText());
	 	
	 			
	 			
	 		// The following code verifying the agent Fee
				 
	 			try
	 			{
	 				System.out.println("\nVerifying the fare breakup sum");	
	 				System.out.println("******************************\n");
	 				//for(int q = 1; q<= totalProductsinFirstPage.size(); ++q) 
	 				//{
	 				//driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+q+"]//*[starts-with(@id,'fare_break')]")).click();
	 				driver.findElement(By.xpath("(//*[starts-with(@id,'fare_break')])[1]")).click();
	 				System.out.println("Clicked on FareBreakup");	
	 				MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[starts-with(@id,'totProdPriceWithAgntFee')]"))); // waiting till username field is shown in page
	 				
	 			// trying to take screen shot of Farebreakup 
		 			try{
		 	            //take screenshot and save it in a file
		 	            File screenshotFarebreakup = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		 	            //copy the file to the required path
		 	            FileUtils.copyFile(screenshotFarebreakup,new File("D:\\Shaji\\Selenium\\ScreenShots\\Farebreakup.jpeg"));

		 	        }
		 			catch(Exception screenShotError)
		 			{
		 	            //if it fails to take screenshot then this block will execute
		 	            System.out.println("Failure to take screenshot "+screenShotError);
		 	        }

	 				
	 				
	 				WebElement otherChargesAdult = driver.findElement(By.xpath("(//*[contains(@id,'OtherCharges_HISADT')])[2]"));
	 				System.out.println("Adult (including all Adults) Other Charges for all  in Farebreakup: "+otherChargesAdult.getText());	
	 				WebElement otherChargesChild = driver.findElement(By.xpath("(//*[contains(@id,'OtherCharges_HISCNN')])[2]"));
	 				System.out.println("Child (including all Childs) Other Charges in Farebreakup: "+otherChargesChild.getText());	
	 				
	 				//for(int chrgeNum = 0; chrgeNum<= variousCharges.size(); ++chrgeNum) 
	 				//{
	 					
	 			}
	 			catch (Exception FareBreakupError)
	 			{
	 				System.out.println("\nSome issues found while trying to verify Farebreakup Sum" +FareBreakupError);	
	 				}
	 				
	 				

	 			
	 			
	 			
	 		
	 			
	 			
	//Verifying print functionality of first product
	 			
	 			System.out.println ("\nVerifying Print Functionality of first product");
	 				System.out.println ("*****************************************\n");
	 				
	 			// Store the current window handle
	 	 			String basicListingpageBeforePrint = driver.getWindowHandle();
	 	 			
	 	 			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[starts-with(@id,'print')])[1]"))); // waiting till Airshopping link is shown in page
	 	 			driver.findElement(By.xpath(".//*[@src='/fb/images/shoppingpages/print_listing.png']")).click();	
	 	 			System.out.println ("\nClicked on Print icon 1");
	 	 			waittimeShort();
	 	 			 	 			
	 	 			// Switch to new window opened
	 	 			for(String winHandle : driver.getWindowHandles())
	 	 			{
	 	 			    driver.switchTo().window(winHandle);
	 	 			}
	 	 			
	 	 		// Store the current window handle
	 				String popupBeforePrint = driver.getWindowHandle();	 				
	 				
	 				driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[1]/span/img")).click();
	 				
	 				String printWindow = driver.getWindowHandle();
	 				
	 				driver.switchTo().window(printWindow).getTitle();
	 				
	 					 				
	 				System.out.println ("\nShowing pirnt page");
	 				waittimeShort();
	 				System.out.println ("\nprint wait time over");
	 				
	 			// Switch to new window opened
	 	 			for(String winHandle : driver.getWindowHandles())
	 	 			{
	 	 			    driver.switchTo().window(winHandle);
	 	 			}
	 	 			
	 				
	 				try 
	 				{
						Robot rb =new Robot();
						rb.keyPress(KeyEvent.VK_TAB);
		 				rb.keyRelease(KeyEvent.VK_TAB);
		 				rb.keyPress(KeyEvent.VK_TAB);
		 				rb.keyRelease(KeyEvent.VK_TAB);
		 				rb.keyPress(KeyEvent.VK_TAB);
		 				rb.keyRelease(KeyEvent.VK_TAB);
		 				rb.keyPress(KeyEvent.VK_TAB);
		 				rb.keyRelease(KeyEvent.VK_TAB);
		 				rb.keyPress(KeyEvent.VK_TAB);
		 				rb.keyRelease(KeyEvent.VK_TAB);
		 				rb.keyPress(KeyEvent.VK_TAB);
		 				rb.keyRelease(KeyEvent.VK_TAB);
					} 
	 				catch (AWTException e) 
	 				{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	 				
	 				 				
	 				
	 				System.out.println ("\nPrint given");
	 				
	 				
	 				
	 				
	 			/*	
	 				
	 			// Switch to new window opened
	 	 			for(String winHandle2 : driver.getWindowHandles())
	 	 			{
	 	 			    driver.switchTo().window(winHandle2);
	 	 			}
	 	 			
	 				
	 				//driver.findElement(By.cssSelector("button:contains('OK')")).click();
	 			*/	
	 				
	 			
		//The following code verifies the bonus benefit of each product
			
	 					System.out.println ("\nVerifying Bonus benefit of each product");
	 	 				System.out.println ("*********************************\n");
	 	 				List<WebElement> allBonusBenefitDisplayed =  driver.findElements(By.xpath("//*[starts-with(@id,'bonus_benefit_tooltip')]"));
	 	 				
	 	 				 System.out.println ("Products with bonus benefits:" + allBonusBenefitDisplayed.size());
	 	 				int bfcounter = 1;
	 	 				for(bfcounter = 0; bfcounter< allBonusBenefitDisplayed.size(); ++bfcounter) 
	 	 				{
	 	 					allBonusBenefitDisplayed =  driver.findElements(By.xpath("//*[starts-with(@id,'bonus_benefit_tooltip')]"));
	 	 					WebElement bonusBenefit = allBonusBenefitDisplayed.get(bfcounter); 
	 	 					int productCouunter= bfcounter +1;
	 	 				   System.out.println ("Bonus benefit of "+ productCouunter + "th product: " + bonusBenefit.getText());
	 	 				}
	 					 //WebElement airline = airlineDisplayed.get(p); 
	 					
		
 		
 		// The following code displays the airline shown in basic listing page
			
			try
			{
 				System.out.println ("\nVerifying Airline of each product");
 				System.out.println ("*********************************\n");
 				List<WebElement> airlineDisplayed =  driver.findElements(By.xpath("//*[starts-with(@id,'infobox_prdt_')]"));
 				int p=0;
 				for(int q = 0; q< airlineDisplayed.size(); ++q) 
 				{
 					airlineDisplayed =  driver.findElements(By.xpath(".//*[@id='checkTable']/tbody/tr[1]/td[4]/div/p")); 
 					 //WebElement airline = airlineDisplayed.get(p); 
 					WebElement airline = airlineDisplayed.get(p); 
 					String AirLine= airline.getText();
 					int r = p+1;
 				    System.out.println ("Airline of "+ r + "th product is " + AirLine);
 				    p=p+1;
 										
 				}
 	 
 				System.out.println ("\nVerified Airline field of each product");
			}
			catch (Exception airlineError)
			{
				System.out.println ("\n Some issues found while trying to identify Airline of products: "+airlineError);
			}
 		
 	// 	the following code lists the flight numbers in each product
 		
			try
			{
 				System.out.println ("\nVerifying Flight numbers of earch product");	
 				System.out.println ("*****************************************\n");
 				for(int q = 1; q<= totalProductsinFirstPage.size(); ++q) 
 			 	{
 			 		//System.out.println("SSS IS: "+singleProduct.getText());			 			
 			 		List<WebElement> flightNumbers = driver.findElements(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+q+"]//*[starts-with(@id,'fltNoBkgClass')]"));
 			 			
 			 		System.out.println("\nflight numbers of "+q+"th products are: ");
 			 		for(WebElement singleNumber : flightNumbers)	
 			 		{
 			 			
 			 			System.out.println(singleNumber.getText());	
 			 		}
 			 	 			 		
 			 	}	 		
 			 	
 				System.out.println ("\nVerified Flight numbers field of each product");
			}
			catch (Exception FlighNumbersError)
			{
				System.out.println ("\nSome issues found while identifying the flight numbers"+FlighNumbersError);
			}
 			 	
 				
 				
// 			 	the following code lists origin and destination of each product
			
			try
			{
 				System.out.println ("\nVerifying Origin and Destination of each product");	
 				System.out.println ("************************************************\n");
 				
 				for(int q = 1; q<= totalProductsinFirstPage.size(); ++q) 
 			 	{
 			 		//System.out.println("SSS IS: "+singleProduct.getText());	
 			 		
 			 		WebElement OnwardOriginAirport = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+q+"]//*[@id='checkTable']/tbody/tr[1]/td[9]"));
 			 		WebElement OnwardDestinationAirport = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+q+"]//*[@id='checkTable']/tbody/tr[1]/td[10]"));
 			 		WebElement OnwardConnectionAirport = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+q+"]//*[@id='checkTable']/tbody/tr[1]/td[11]"));
 			 		
 			 		System.out.println("\nOrigin and Destination Airports of "+q+"th products are: ");
 			 		
 			 		System.out.println("Onward Origin Airport      : "+OnwardOriginAirport.getText());	
 			 		System.out.println("Onward Destination Airport : "+OnwardDestinationAirport.getText());	
 			 		
 			 		if (OnwardConnectionAirport.getText().equals("--"))
 			 			System.out.println("Onward Connection Airport  : -- (No connection)");	
 			 		else 
 			 		System.out.println("Onward Connection Airport  : "+OnwardConnectionAirport.getText().substring(0,3));
 			 		
 			 		
 			 		if (typeOfSearch.equals("RT"))
 			 		{
 			 		WebElement ReturnOrignAirport = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+q+"]//*[@id='checkTable']/tbody/tr[2]/td[5]"));
 			 		WebElement ReturnDestinationAirport = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+q+"]//*[@id='checkTable']/tbody/tr[2]/td[6]"));
 			 		System.out.println("Return Orign Airport       : "+ ReturnOrignAirport.getText());	
 			 		System.out.println("Return Destination Airport : "+ ReturnDestinationAirport.getText());
 			 		}
 			 			  			 		
 			 	}
 				System.out.println ("\nVerified Origin and Destination field of each product");
 				
			}
			
			catch (Exception OriginDestinationError)
			{
				System.out.println ("\nSome issues found while trying to identify origin and destination of products"+OriginDestinationError);
			}
 							
 				// The following code verifying the fare breakup option
 				 
 			try
 			{
 				System.out.println("\nVerifying the fare breakup sum");	
 				System.out.println("******************************\n");
 				//for(int q = 1; q<= totalProductsinFirstPage.size(); ++q) 
 				//{
 				//driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+q+"]//*[starts-with(@id,'fare_break')]")).click();
 				driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])[1]//*[starts-with(@id,'fare_break')]")).click();
 				System.out.println("Clicked on FareBreakup");	
 				MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@id,'paxTotal')]"))); // waiting till username field is shown in page
 				
 			// trying to take screen shot of Farebreakup 
	 			try{
	 	            //take screenshot and save it in a file
	 	            File screenshotFarebreakup = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	 	            //copy the file to the required path
	 	            FileUtils.copyFile(screenshotFarebreakup,new File("D:\\Shaji\\Selenium\\ScreenShots\\Farebreakup.jpeg"));

	 	        }
	 			catch(Exception screenShotError)
	 			{
	 	            //if it fails to take screenshot then this block will execute
	 	            System.out.println("Failure to take screenshot "+screenShotError);
	 	        }

 				
 				
 				List<WebElement> variousCharges = driver.findElements(By.xpath(".//*[starts-with(@id,'paxTotal')]"));
 								
 				//for(int chrgeNum = 0; chrgeNum<= variousCharges.size(); ++chrgeNum) 
 				//{
 					Integer Sum = 0;
 					System.out.println("The inidividual charges are: ");	
 				for(WebElement singleCharge : variousCharges)	
			 		{
 					String amountRead= singleCharge.getText().replace(",", "");
 					System.out.println(amountRead);	
 					Sum= Sum + Integer.parseInt(amountRead.trim());  
 					}
 				System.out.println("Sum of all individual charges: "+Sum);	
 				
 				WebElement sumshowninShoPage = driver.findElement(By.xpath(".//*[starts-with(@id,'totProdPriceWithAgntFee')]"));
 				String sumshowninShoPageS= sumshowninShoPage.getText().replace(",", "");
 				Integer finalSum = Integer.parseInt(sumshowninShoPageS.trim());
 			
 				System.out.println("Total sum shown in Fare breakup: "+Sum);	
 				if (Sum.equals(finalSum))
 				System.out.println("The Total sum shown in fare breakup page is the sum of all individual charges\n");		
 				else
 				System.out.println("The Total sum is wrong\n");	
 				
 			}
 			catch (Exception FareBreakupError)
 			{
 				System.out.println("\nSome issues found while trying to verify Farebreakup Sum" +FareBreakupError);	
 				}
 				
 				
 				
			
 				// Sorting by price
 			
 			try
 			{
			System.out.println ("\nVerifying the Functionality 'Sort based on Price'");
			System.out.println ("*************************************************\n");
			
			System.out.println("Number of products in first page before Sorting: "+totalProductsinFirstPage.size());	
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='priceLink']/span"))); 
 				driver.findElement(By.xpath(".//*[@id='priceLink']/span")).click();
 				MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sortByPriceMenu']/p[2]/a")));	
 				driver.findElement(By.xpath(".//*[@id='sortByPriceMenu']/p[2]/a")).click();
 				waittimeShort();
 				 List<WebElement> totalProductsinFirstPageafterSortingbyPrice =  driver.findElements(By.xpath(".//*[@id='example']//*[@class='prdouct_develop_grp']"));
 				
 				System.out.println ("Total products in 1st page after Sorting by Price is : "+ totalProductsinFirstPageafterSortingbyPrice.size() );
 				
 				//int prodSize= totalProductsinFirstPage.size();
 					
 				Integer bigPrice=999999999;
 				Integer newPrice=0;
 				int count ;
 				for(count=1; count<= totalProductsinFirstPageafterSortingbyPrice.size(); ++count) 
 			 	{
 			 		//System.out.println("SSS IS: "+singleProduct.getText());			 			
 			 		WebElement priceDisplayed = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+count+"]//*[starts-with(@id,'fmttd_price')]"));
 			 		String priceWithoutComma= priceDisplayed.getText().replace(",", "");
 	 				System.out.println("Price of "+count+"th product is: " +priceWithoutComma);	
 	 				
 	 				newPrice= Integer.parseInt(priceWithoutComma.trim()); 
 	 				
 			 			if (newPrice <=  bigPrice)
 			 			{
 			 				bigPrice =newPrice;
 			 				continue;
 			 			}
 			 			else
 			 			{
 			 				System.out.println("Products are not sorted on Price:Higher to Lower");	
 			 				break;
 			 			}
 			 			
 			 				 		
 			 	}	
 				
 			
 					
		 			if (count > totalProductsinFirstPage.size())
	 				{
	 				System.out.println ("\nThe flights are sorted based on price- Higher to Lower");
	 				}		
	 					
 
 			}
 			catch (Exception SortPriceError)
 			{
 				System.out.println ("\nSome issues found while trying to sort by Price: " +SortPriceError);
 			}
/* 	 
 	 
 	 
 	// Sorting by Airline
		
		 			System.out.println ("\nVerifying the Functionality 'Sort by Airline'");
		 			System.out.println ("*********************************************\n");
		 			System.out.println("Number of products in first page before Sorting by Airline: "+totalProductsinFirstPage.size());
 				driver.findElement(By.xpath(".//*[@id='airlineLink']/span")).click();
 				
 				WebElement airlineSort =driver.findElement(By.xpath("(.//*[@id='sortByAirlineMenu']//*[@class='airlineClass'][1])[1]"));
 				airlineSort.click();
 				
 				waittimeShort() ;
 				
 				List<WebElement> sortedAirlineDisplayed =  driver.findElements(By.xpath("//*[starts-with(@id,'infobox_prdt_')]"));
 				 System.out.println ("Number of products after sorting by Airline: " +sortedAirlineDisplayed.size());
 				int pp=0;
 				int aircounter ;
 				String DefaultAirLine = "";
 				for(aircounter = 0; aircounter< sortedAirlineDisplayed.size(); ++aircounter) 
 				{
 					sortedAirlineDisplayed =  driver.findElements(By.xpath(".//*[@id='checkTable']/tbody/tr[1]/td[4]/div/p")); 
 					 //WebElement airline = airlineDisplayed.get(p); 
 					WebElement airline = sortedAirlineDisplayed.get(pp);
 					
 					String CurrentAirLine= airline.getText();
 					
 					int r = pp+1;
 				    System.out.println ("Airline of "+ r + "th product is " + airline.getText());
 				    pp=pp+1;
 				    
 					if (CurrentAirLine.equals(DefaultAirLine) || DefaultAirLine.equals(""))
 					{
 					DefaultAirLine =airline.getText();
 					continue;
 					}
 					
 					else
 					{
 						System.out.println ("Airline NOT sorted based on TG airline");
 						break;
 					}
 					
 									 	
 				}			
 							
 				 				
 				//products are sorted back to initial stage
 				driver.findElement(By.xpath(".//*[@id='airlineLink']/span")).click();
 				WebElement airlineDeSort =driver.findElement(By.xpath("(.//*[@id='sortByAirlineMenu']//*[@class='airlineClass'][1])[1]"));
 				airlineDeSort.click();
 				try
 				{
 				driver.findElement(By.xpath(".//*[@class='checkallAllnceClass']")).click();
 				driver.findElement(By.xpath(".//*[@class='checkallAllnceClass']")).click();
 				}
 				
 				catch(Exception e5)
 				{
 					System.out.println ("\nAlliance not found error message"+e5);	
 					
 				}
 				System.out.println ("The flights sorted back to initial stage");
 				System.out.println ("waiting starts");
 				waittimeShort();
 				System.out.println ("waiting over");
 				List<WebElement> totalProductsinFirstPageafterSortingbyAirline =  driver.findElements(By.xpath("(.//*[@id='example']//*[starts-with(@id,'prdouct_develop_sub')])/table/tbody/tr/td[1]"));
 				System.out.println ("List command over");
  				System.out.println ("Total products in 1st page after restoring back to initial stage : "+ totalProductsinFirstPageafterSortingbyAirline.size() );
 				
			
  				if (aircounter == sortedAirlineDisplayed.size() && totalProductsinFirstPageafterSortingbyAirline.size() == totalProductsinFirstPage.size() )
 				{
 					System.out.println ("\nAirline sorted based on"+ DefaultAirLine+"airline");	
 				}
  				
  				else
  				{
  					System.out.println ("\nSome issue found. Either Airline not sorted or not restored correctly after re-sorting");	
  				}
*/
		 			
			// Sorting by Departure
 			
 			try
 			{
 				System.out.println ("\nVerifying the Functionality 'Sort by Departure'");
 				System.out.println ("***********************************************\n");
			
 				System.out.println("Number of products in first page before Sorting by Airline: "+totalProductsinFirstPage.size());
 				
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='deptTimeLnk']/span")));
			
			driver.findElement(By.xpath(".//*[@id='deptTimeLnk']/span")).click();
					
			
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sortByDepMenu']/p[1]/a")));
			
			driver.findElement(By.xpath(".//*[@id='sortByDepMenu']/p[1]/a")).click();
			System.out.println("Clicked on 'Outbound, earlier to later' option");	
			waittimeShort();
			int depSortCount;
			int newDepTime;
			int bigTime = 0;
			for(depSortCount=1; depSortCount<= totalProductsinFirstPage.size(); ++depSortCount) 
			 	{
			 		//System.out.println("SSS IS: "+singleProduct.getText());			 			
			 		WebElement departureTime = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+depSortCount+"]//.//*[@id='checkTable']/tbody/tr[1]/td[6]/p/span"));
			 		System.out.println("Departure time of "+depSortCount+"th product is: " + departureTime.getText());	
			 		String timeWithoutFullColumn= departureTime.getText().replace(":", "");
	 				
	 				
	 				newDepTime= Integer.parseInt(timeWithoutFullColumn.trim()); 
	 				
			 			if (newDepTime >=  bigTime)
			 			{
			 				bigTime =newDepTime;
			 				continue;
			 			}
			 			else
			 			{
			 				System.out.println("Products are not sorted on Outbound, earlier to later");	
			 				break;
			 			}
			 			
			 				 		
			 	}	
				
		
			 List<WebElement> totalProductsinFirstPageafterSortingbyDeparture =  driver.findElements(By.xpath("(.//*[@id='example']//*[starts-with(@id,'prdouct_develop_sub')])/table/tbody/tr/td[1]"));
				
				System.out.println ("\nTotal products in 1st page after restoring back to initial stage : "+ totalProductsinFirstPageafterSortingbyDeparture.size() );
					
					
	 			if (depSortCount > totalProductsinFirstPage.size() && totalProductsinFirstPageafterSortingbyDeparture.size() == totalProductsinFirstPage.size())
 				{
 				System.out.println ("\nThe flights sorted based on Outbound, earlier to later");
 				}	
	 			
	 			else
	 			{
	 				System.out.println ("\nIssues found. Either it is not sorted or some products disappeared");
	 			}
 				
 				
 			}
 			
 			catch(Exception SortDepartureError)
 			{
 				System.out.println ("\nSome issues found while trying to sort by Departure: " +SortDepartureError);
 			}
		
			
			// Sorting by Arrival
 			
 			try
 			{
	 			System.out.println ("\nVerifying the Functionality 'Sort by Arrival'");
	 			System.out.println ("*********************************************\n");
					
						MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='arrTimeLnk']/span")));
						
						driver.findElement(By.xpath(".//*[@id='arrTimeLnk']/span")).click();
								
						
						MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sortByArrMenu']/p[1]/a")));
						
						driver.findElement(By.xpath(".//*[@id='sortByArrMenu']/p[1]/a")).click();
						System.out.println("Clicked on 'Outbound, earlier to later' option");	
						
						int arivalSortCount;
						int newDepTime1;
						int bigTime1 = 0;
						for(arivalSortCount=1; arivalSortCount<= totalProductsinFirstPage.size(); ++arivalSortCount) 
						 	{
						 		//System.out.println("SSS IS: "+singleProduct.getText());			 			
						 		WebElement ArrivalTime = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+arivalSortCount+"]//.//*[@id='checkTable']/tbody/tr[1]/td[7]/p/span[1]"));
						 		System.out.println("Arrival time of "+arivalSortCount+"th product is: " + ArrivalTime.getText());	
						 		String timeWithoutFullColumn= ArrivalTime.getText().replace(":", "");
				 				
				 				newDepTime1= Integer.parseInt(timeWithoutFullColumn.trim()); 
				 				
						 			if (newDepTime1 >=  bigTime1)
						 			{
						 				bigTime1 =newDepTime1;
						 				continue;
						 			}
						 			else
						 			{
						 				System.out.println("Products are not sorted on Outbound, earlier to later");	
						 				break;
						 			}
						 			
						 				 		
						 	}	
							
							
				 			if (arivalSortCount > totalProductsinFirstPage.size())
			 				{
			 				System.out.println ("\nThe flights sorted based on Outbound, earlier to later");
			 				}
				 			
 			}
 			
 			catch (Exception sortArrivalError)
 			{
 				System.out.println ("\nSome issues found while trying to sort by Arrival: " +sortArrivalError);
 			}
 			
				 				
				 			

							
							// sorting by Duration
 			
 			try
 			{
				 			System.out.println ("\nVerifying the Functionality 'Sort by Duration'");
				 			System.out.println ("**********************************************\n");
				 					
							driver.findElement(By.xpath(".//*[@id='durLnk']/span")).click();
							MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sortByDurMenu']/p[1]/a")));
							driver.findElement(By.xpath(".//*[@id='sortByDurMenu']/p[1]/a")).click();
							System.out.println ("The flights sorted based on Duration - Outbound shorter to longer");
							waittimeShort();
							// sorting by From
							System.out.println ("\nVerifying the Functionality 'Sort by From'");
							System.out.println ("****************************************'\n");
							driver.findElement(By.xpath(".//*[@id='fromLink']/span")).click();
							
							MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[@id='custByFromMenu']//*[@class='frmArptOutbClass'][1])[1]")));
							WebElement airlineSort =driver.findElement(By.xpath("(.//*[@id='custByFromMenu']//*[@class='frmArptOutbClass'][1])[1]"));
			 				airlineSort.click();
														
							System.out.println ("The flights sorted based on From field");
							waittimeShort();
						
							// Flights are sorted back to initial stage
							driver.findElement(By.xpath(".//*[@id='fromLink']/span")).click();
							MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[@id='custByFromMenu']//*[@class='frmArptOutbClass'][1])[1]")));
							WebElement airlineDeSort =driver.findElement(By.xpath("(.//*[@id='custByFromMenu']//*[@class='frmArptOutbClass'][1])[1]"));
							airlineDeSort.click();
							System.out.println ("The Flights are sorted back to initial stage");
							waittimeShort();
 			}
 			catch (Exception sortDurationError)
 			{
 				System.out.println ("\nSome issues found while trying to sort by Duration: " +sortDurationError);
 			}
	
						/*			
							// sorting by To
							System.out.println ("\nVerifying the Functionality 'Sort by To'");	
							System.out.println ("****************************************\n");	
							
							String winHandleSortByTo = driver.getWindowHandle(); // storing current window
							
							driver.findElement(By.xpath(".//*[@id='toLink']/span")).click();
							System.out.println ("\nclicked on menu option");
							
			
				 			
				 			// Switch to new popup window
				 			for(String winHandle : driver.getWindowHandles())
				 			{
				 			    driver.switchTo().window(winHandle);
				 			}
							
				 			
							MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='"+ DestinationAirport +"']")));
							System.out.println ("\nwaiting over");
							driver.findElement(By.xpath(".//*[@id='"+ DestinationAirport +"']")).click();
							System.out.println ("The flights sorted based on To field");
							waittimeShort();
							// flights are sorted back to initial stage
							driver.findElement(By.xpath(".//*[@id='toLink']/span")).click();
							driver.findElement(By.xpath(".//*[@id='"+ DestinationAirport +"']")).click();
							System.out.println ("flights are sorted back to initial stage");
							waittimeShort();				
						
						*/
							
	
			
							// sorting by Connection
 			
 			try
 			{
							System.out.println ("\nVerifying the Functionality 'Sort by Connection'");
							System.out.println ("************************************************\n");
							driver.findElement(By.xpath(".//*[@id='stopsLink']/span")).click();
							driver.findElement(By.xpath(".//*[@id='custByStopsMenu']/p[1]/input")).click();
							System.out.println ("The flights sorted based on Connection field");
							waittimeShort();
					
 			}
 			catch (Exception sortConnectionError)
 			{
 				System.out.println ("\nSome issues found while trying to sort by Connection: " +sortConnectionError);
 			}
							// Clicking Detail view/Normal view
				try
				{
							System.out.println ("\nVerifying the Functionality Detail view and Normal view");
							System.out.println ("**********************************************************");
							try
							{
							driver.findElement(By.xpath(".//*[@id='head_table']/tbody/tr/td[14]/button[2]")).click();
							MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='head_table']/tbody/tr/td[2]")));
							MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='head_table']/tbody/tr/td[3]")));
							
							System.out.println ("Selected Detail view. \nGross Fare and Net Fare are present in this view");
									
							driver.findElement(By.xpath(".//*[@id='head_table']/tbody/tr/td[14]/button[1]")).click();
							
							MyWaitVar30Sec.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='head_table']/tbody/tr/td[2]")));
							MyWaitVar30Sec.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='head_table']/tbody/tr/td[3]")));
							System.out.println ("Back to Normal view");
							}
							catch(Exception DeatailViewError)
							{
								System.out.println ("Some issues found in clicking Detail view");
							}
 			
				}
				catch (Exception detailViewError)
				{
					System.out.println ("\nSome issues found while trying to click on Detailview: " +detailViewError);
				}
 			
			
			
			// Clicking Group by Airline and price
				
				try
				{
							System.out.println ("\nVerifying the Functionality 'Group by Airine'");
							System.out.println ("*********************************************\n");
						MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='groupairlineandpriceRadioDiv']")));
						driver.findElement(By.xpath(".//*[@id='groupairlineandpriceRadioDiv']")).click();
						MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[@id='example']//*[starts-with(@id,'exp_grp_showDetails')])")));
						List<WebElement> groupedProducts =  driver.findElements(By.xpath("(.//*[@id='example']//*[starts-with(@id,'exp_grp_showDetails')])"));
						System.out.println (groupedProducts.size() +" Groups found in first page after grouping by Airline and price");
						
						int AB= 0;
		 				for(int groupedProductCounter = 1; groupedProductCounter<= groupedProducts.size(); ++groupedProductCounter) 
		 				{
		 					WebElement groupedProduct =  driver.findElement(By.xpath("(.//*[@id='example']//*[starts-with(@id,'exp_grp_showDetails')])["+groupedProductCounter+"]")); 
		 					groupedProduct.click();
		 					System.out.println ("\n"+ groupedProductCounter + "th group expanded");
		 					
		 					AB = groupedProductCounter +1;
		 					MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((.//*[@id='example'])["+AB+"]//*[starts-with(@id,'prdouct_develop_group')])")));
		 					List<WebElement> productsInaGroup =  driver.findElements(By.xpath("((.//*[@id='example'])["+AB+"]//*[starts-with(@id,'prdouct_develop_group')])"));
		 					System.out.println ("Number of products in this group is "+productsInaGroup.size());
		 					waittimeShort() ;	 						 															
		 				}
		 				
						System.out.println ("\nExpanded all Grouped products");
						
						for(int groupedProductCounter = 1; groupedProductCounter<= groupedProducts.size(); ++groupedProductCounter) 
		 				{
							MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[@id='example']//*[starts-with(@id,'exp_grp_closeDetails')])["+groupedProductCounter+"]")));
							WebElement ungroupedProduct =  driver.findElement(By.xpath("(.//*[@id='example']//*[starts-with(@id,'exp_grp_closeDetails')])["+groupedProductCounter+"]")); 
		 					ungroupedProduct.click();
		 					System.out.println ("\n"+ groupedProductCounter + "th item Re-Grouped");
		 					waittimeShort();	 															
		 				}
						
						System.out.println ("\nRe-Grouped all expanded items");
						
						System.out.println ("\nGrouped by Airline and price Functionality working fine");
				
				}
				catch(Exception grpAirlineError)
				{
					System.out.println ("\nSome issues found while trying to click on Detailview: " +grpAirlineError);
				}
					
						// Clicking Promotional
				
				try
				{
						System.out.println ("\nVerifying Promotional rule");
						System.out.println ("**************************");
						driver.findElement(By.xpath(".//*[@id='basicListingForm']/table/tbody/tr/td/a[2]")).click();
						System.out.println ("Sorted by Promotional rule");
						
				}
				catch (Exception promotionViewError)
				{
					System.out.println ("\nSome issues found while trying to click on Promotion : " +promotionViewError);
				}
			
	// Fare Matrix action
				
		try
		{
			System.out.println ("\nVerifying Fare Matrix Functionality");
			System.out.println ("*************************************");
			
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='0_NA']")));
		
			driver.findElement(By.xpath(".//*[@id='0_NA']")).click();
			System.out.println ("\nSelected direct product(Non Stop) option");
			waittimeShort() ;
			int fareMatrixProductCount=0;
			if(driver.findElements(By.xpath(".//*[@id='basicListingForm']/table/tbody/tr/td/span")).isEmpty())
			{ 
	 			System.out.println ("No products returned");
			}
							 
	 		else 
			{
	 			fareMatrixProductCount = Integer.parseInt(driver.findElement(By.xpath(".//*[@id='productSpanId']")).getText());
	 			System.out.println (fareMatrixProductCount + " Products are returned in shopping page");	
			}
			
			if (fareMatrixProductCount > 0 )
			
			{
				int counter;
				List<WebElement> fareMatrixProductsInaPage =  driver.findElements(By.xpath(".//*[@id='example']//*[@class='prdouct_develop_grp']"));
				
				System.out.println ("Total products in 1st page after Fare Matrix action : "+ fareMatrixProductsInaPage.size() );
				
				for(counter = 1; counter<= fareMatrixProductsInaPage.size(); ++counter) 
 			 	{
 			 		//System.out.println("SSS IS: "+singleProduct.getText());	
 			 					 		
 			 		WebElement OnwardConnectionAirport = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+counter+"]//*[@id='checkTable']/tbody/tr[1]/td[11]/span"));
 			 		
 			 		if (OnwardConnectionAirport.getText().equals("--"))
 			 			continue;
 			 				
 			 		else 
 			 		{
 			 			System.out.println("Mis match found in Onward slice. Fare Matrix not working correctly");
 			 			break;
 			 		}
 			 			  			 		
 			 	}
				
				if (counter >=fareMatrixProductsInaPage.size())
				{
		 			System.out.println("Onward slice of all prodocts are direct");
				}
				
			 		if (typeOfSearch.equals("RT") && counter >=fareMatrixProductsInaPage.size() )
			 		{
			 			
			 			for(counter = 1; counter<= fareMatrixProductsInaPage.size(); ++counter) 
		 			 	{
		 			 		//System.out.println("SSS IS: "+singleProduct.getText());	
		 			 		
			 				WebElement returnConnectionAirport = driver.findElement(By.xpath("(.//*[@id='example']//*[@class='prdouct_develop_grp'])["+counter+"]//*[@id='checkTable']/tbody/tr[2]/td[7]/span"));
		 			 		
		 			 		if (returnConnectionAirport.getText().equals("--"))
		 			 			continue;
		 			 				
		 			 		else 
		 			 		{
		 			 			System.out.println("Mis match found in Return slice. Fare Matrix not working correctly");
		 			 			break;
		 			 		}
		 			 			  			 		
		 			 	}
			 			
			 			if (counter >=fareMatrixProductsInaPage.size())
						{
				 			System.out.println("Return slice of all prodicts are direct");
						}
			 			
			 			
			 		}
			 		if (counter >=fareMatrixProductsInaPage.size())
					{
			 			System.out.println("Fare Mattrix action working fine");
					}
			 		
			 		else
					{
			 			System.out.println("Fare Mattrix action NOT working");
					}
			}
			
			
			driver.findElement(By.xpath(".//*[@id='0_NA']")).click();
			System.out.println ("Back to initial stage");
			
		
			
			
			// Clicking Next in Fare Matrix
			
			try
			{
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rightArrow']")));
			driver.findElement(By.xpath(".//*[@id='rightArrow']")).click();
			System.out.println ("Next option in FareMatrix working fine");
			}
			catch(Exception NextInFareMatrix)
			{
				System.out.println ("Next option not found in Fare Matrix");
				System.out.println ("Error/Warning message when trying to click on Next option in FareMatrix: "+NextInFareMatrix);
			}
			
		}
		catch (Exception farematrixError)
		{
			System.out.println ("\nSome issues found while trying to click on fare Matrix: " +farematrixError);
		}
			// Clicking page2 in pagination bar
		
		try
		{
			
			System.out.println ("\nVerifying Pagination functionality");
			System.out.println ("**********************************");
			
			
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='paging']/a[4]")));
			driver.findElement(By.xpath(".//*[@id='paging']/a[4]")).click();
			System.out.println ("\nclicked on page2 link");
			waittimeShort() ;
			 List<WebElement> totalProductsinFirstPageInPage2 =  driver.findElements(By.xpath(".//*[@id='example']//*[@class='prdouct_develop_grp']"));
				
			System.out.println ("Total products in 2nd page is : "+ totalProductsinFirstPageInPage2.size() );	
			
			System.out.println ("Pagination Functionality working fine");
			
		}
		catch (Exception pagenationbarError)
		{
			System.out.println ("\nSome issues found while trying to click on pagenation: " +pagenationbarError);
		}
			// Clicking on Flexible search
		
		try
		{
			System.out.println ("\nVerifying Flexible search functionality");
			System.out.println ("****************************************");
			
			
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='flexibleDateSearch']")));
			driver.findElement(By.xpath(".//*[@id='flexibleDateSearch']")).click();
			System.out.println ("Clicked on flexible search option");
			String FlexiSuccess="";
			try
			{
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fdsearch']/tbody/tr[2]/td[1]")));
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fdsearch']/tbody/tr[2]/td[7]")));
			FlexiSuccess="Yes";
			}
			
			catch(Exception Flexible)
			{
				System.out.println ("No results / Issues found in Flexible search");
			}
			
			if (FlexiSuccess.equals("Yes"))
			{
				
			
			if (typeOfSearch.equals("RT"))
			{
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fdsearch']/tbody/tr[5]/td[4]")));
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fdsearch']/tbody/tr[8]/td[7]")));
			}
			System.out.println ("Flexible search matrix shown");
			
			int clickStatus=0;
			
			if (typeOfSearch.equals("RT"))
			{
			
			for ( int row= 2; row <=8; row++)
			{
				for ( int column= 1 ; column <=7; column++)
				{
					String cellText = driver.findElement(By.xpath(".//*[@id='fdsearch']/tbody/tr["+row+"]/td["+column+"]")).getText();	
					
					if (cellText.isEmpty())
												
				{
						
						System.out.println ("There is no value in " + row + "th row and " +column +"th Column");
						continue;
					
				}
				else
				{
					System.out.println ("Lowest price of the product is: "+cellText);
					driver.findElement(By.xpath(".//*[@id='fdsearch']/tbody/tr["+row+"]/td["+column+"]/a")).click();
					System.out.println ("clicked on " + row + "th row and " +column +"th Column");
					clickStatus = 1;
					waittimeShort() ;
					
					break;
				}
				}
				if (clickStatus == 1)
					break;
			}
			
			}
			
			
				
			if (typeOfSearch.equals("OW"))
			{
				for ( int column= 1 ; column <=7; column++)
				{
					String cellText = driver.findElement(By.xpath(".//*[@id='fdsearch']/tbody/tr[2]/td["+column+"]")).getText();	
					
					if (cellText.isEmpty())
												
				{
						
						System.out.println ("There is no value in" +column +"th cell");
						continue;
					
				}
				else
				{
					System.out.println ("Lowest price of the product given in "+column+"th cell is: "+cellText);
					driver.findElement(By.xpath(".//*[@id='fdsearch']/tbody/tr[2]/td["+column+"]/a")).click();
					System.out.println ("clicked on " +column +"th cell");
					clickStatus = 1;
					waittimeShort() ;
					waittimeShort() ;
					waittimeShort() ;
					
					break;
				}
				
			
			}
			}
			
			if (clickStatus == 1)
			{
			productCount = Integer.parseInt(driver.findElement(By.xpath(".//*[@id='productSpanId']")).getText());
			
			if (productCount > 0)
			{
 			System.out.println (productCount + " Products are returned in Flexible search");	
 			System.out.println ("Flexible search is working fine");	
			}
			else
			{
				System.out.println ("Flexible search NOT working. ie No products are returned in Flexible search");
			}
			}
			
			else
			{
				System.out.println ("No price link found in any of the cell");	
			
			}
			
			}
			
		}
		catch (Exception FlexiblesearchError)
		{
			System.out.println ("\nSome issues found while trying to click on Flexible Search: " +FlexiblesearchError);
		}
			
		
			// Clicking on Calendar search
		
		try
		{
			System.out.println ("\nVerifying Calendar search functionality");
			System.out.println ("****************************************");
			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='cal_searchLink']")));
			driver.findElement(By.xpath(".//*[@id='cal_searchLink']")).click();
			System.out.println ("Clicked on Calendar search option");
			waittimeShort();
			waittimeShort();
			try
			{
			MyWaitVar60Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@id,'c2d')]")));
			List<WebElement> totalCalendarCells =  driver.findElements(By.xpath(".//*[starts-with(@id,'c2d')]"));
						
			int calendarCellStatus = 0;
			
			int clickStatus1 = 0;
			String modifedCellText="";
			if (totalCalendarCells.size() == 70)
			{
				System.out.println ("Calendar Matrix shown");
				calendarCellStatus = 1;
			}
			else
				System.out.println ("Calendar Matrix NOT shown");
			if (calendarCellStatus == 1)
			{
				for ( int month= 1; month <=2; month++)
				{
					for ( int calendarCellno= 1 ; calendarCellno <=35; calendarCellno++)
					{
						String cellText = driver.findElement(By.xpath(".//*[@class='jCalMo']["+month+"]//*[starts-with(@id,'c2d')]["+calendarCellno+"]")).getText();	
							if (cellText.length() > 2)
							{
								 modifedCellText = cellText.substring(3);
							}
							else if (cellText.length() == 2)
							{
								 modifedCellText = cellText.substring(2);
							}
							
							else if (cellText.length() < 2)
							{
								 modifedCellText = cellText.substring(1);
							}
							
							
					if (modifedCellText.isEmpty())
													
					{
							
							System.out.println ("There is no price in " + month + "th month and " +calendarCellno +"th cell");
							continue;
						
					}
					else
					{
						System.out.println ("\nPrice present in " + month + "th month and " +calendarCellno +"th cell");
						System.out.println ("Lowest price of the product is: "+modifedCellText);
						driver.findElement(By.xpath(".//*[@class='jCalMo']["+month+"]//*[starts-with(@id,'c2d')]["+calendarCellno+"]/a")).click();
						System.out.println ("clicked on the cell");
						clickStatus1 = 1;
						waittimeShort() ;
						
						break;
					}
					}
					if (clickStatus1 == 1)
						break;
				}
			
		
		
		
		
		if (clickStatus1 == 1)
		{
		MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='productSpanId']")));
		productCount = Integer.parseInt(driver.findElement(By.xpath(".//*[@id='productSpanId']")).getText());
		
		if (productCount > 0)
		{
			System.out.println (productCount + " Products are returned in Calendar search");	
			System.out.println ("Calendar search is working fine");	
		}
		else
		{
			System.out.println ("Calendar search NOT working. ie No products are returned in Calendar search");
		}
		}
		
		else
		{
			System.out.println ("No price link found in any of the cell");	
		
		}
		
			}
			}
			catch(Exception CalError)
			{
				System.out.println ("Some issues found after clicking in Calendar search");	
			}
		
		}
		catch (Exception CalSearchError)
		{
			System.out.println ("\nSome issues found while trying to click on Calendar Search: " +CalSearchError);
		}
			
	
			
			// Selecting Fare view tab
		
		try
		{
		
		System.out.println ("\nVerifying Fare View functionality");
		System.out.println ("***********************************");
			
			driver.findElement(By.xpath(".//*[@id='tabsNfeCompListingLi']/a")).click();
			System.out.println ("clicked on Fare View tab");
			
			waittimeShort();
			
			if(driver.findElements(By.xpath(".//*[@id='nfeComplementTab']/div[2]")).isEmpty())
			{ 
	 			System.out.println ("No products returned");
	 			
			}
			
			else
			
			{
						
			WebElement fareViewProduct = driver.findElement(By.xpath(".//*[@id='productSpanIdNfeComp']"));
			String fareViewProductCount = fareViewProduct.getText();
			System.out.println ("Total number of Fare view products returned: " +fareViewProductCount);
			
			
			// List<WebElement> totalProductsinFirstPage =  driver.findElements(By.xpath(".//*[@id='example']//*[@class='prdouct_develop_grp']"));
				
			//	System.out.println ("Total products in 1st page is : "+ totalProductsinFirstPage.size() );	
			//
		
			List<WebElement> totalFareViewProducts =  driver.findElements(By.xpath(".//*[@id='product_content_sect_store']//*[starts-with (@id,'checkTableNfeComp')]"));
			System.out.println (totalFareViewProducts.size()+" products returned in 1st page of Fare View result");
			
			
			
			//List<WebElement> fareViewDetailsLinks =  driver.findElements(By.xpath("//*[starts-with(@id,'exp_showDetails_nfe_Comp')]/img"));
			WebElement fareViewDetailsLinkClick =  driver.findElement(By.xpath("(//*[starts-with(@id,'exp_showDetails_nfe_Comp')]/img)[1]")); 
			fareViewDetailsLinkClick.click();
			System.out.println ("Clicked on Fare view details link of 1st product");
			
			// Switch to new window opened
			
			String winHandleBeforeFareview = driver.getWindowHandle();
			
 			for(String winHandleFareview : driver.getWindowHandles())
 			{
 			    driver.switchTo().window(winHandleFareview);
 			}
 			
 			MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ruleSummary']/table[1]/tbody/tr[1]/td[1]"))); // waiting till productID Shows in newly opened page
 			
 			// Checking whether Fare view details page displayed correctly or not
 			
 					String fareViewDetailsPage = driver.getTitle(); 
 			        System.out.println ("Title of newly launched page is : "+ fareViewDetailsPage);
 			        
 			        String expectedTitleFareView = "Fare Rule Summary";
 			        
 			        // compare the actual title of the page with the expected one and print the result as "Passed" or "Failed"
 			        
 			        if (fareViewDetailsPage.contentEquals(expectedTitleFareView))
 			        {
 			            System.out.println("Fare View details page launched successfully");
 			        } 
 			        else 
 			        {
 			            System.out.println("Fare View details page failed to launch");
 			        }
			
 			     driver.switchTo().window(winHandleBeforeFareview);
 			     
 	 }
 			        
 			    // Back Schedule view tab
 	 				driver.findElement(By.xpath(".//*[@id='tabsBasicListingLi']/a")).click();
 	 				System.out.println ("Back to Schedule view tab");	
 	 				System.out.println ("Fare View Functionality working fine");	
				
		}
		catch (Exception FareviewError)
		{
			System.out.println ("\nSome issues found while trying to click on Fare View: " +FareviewError);
		}
	 	
 	 	
 	// Time bar view
		
		try
		{
 	 				System.out.println ("\nVerifying Time bar View functionality");
 	 				System.out.println ("***************************************");
			
 				driver.findElement(By.xpath(".//*[@id='timeBarViewLink']/a")).click();
 				System.out.println ("Time bar view clicked");
 				waittimeShort();
 				
 			// trying to take screen shot of Timebar view 
	 			try{
	 	            //take screenshot and save it in a file
	 	            File screenshotTimebarView = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	 	            //copy the file to the required path
	 	            FileUtils.copyFile(screenshotTimebarView,new File("D:\\Shaji\\Selenium\\ScreenShots\\TimebarView.jpeg"));

	 	        }
	 			catch(Exception screenShotError)
	 			{
	 	            //if it fails to take screenshot then this block will execute
	 	            System.out.println("Failure to take screenshot "+screenShotError);
	 	        }

	 			
 				WebElement timeBarViewProducts = driver.findElement(By.xpath(".//*[@id='productSpanId']"));
 				String timeBarViewProductCount = timeBarViewProducts.getText();
 				System.out.println ("Total number of products returned as Time bar Graph: " +timeBarViewProductCount);
			
 				driver.findElement(By.xpath("(.//*[@id='row_1']/div[1]/p)[1]")).click();
 										
 				System.out.println ("Selected first proudct");
 				waittimeShort();
 				waittimeShort();
 				
 				System.out.println ("two wait time over");
 				if (typeOfSearch.equals("RT"))

 				{
 					MyWaitVar60Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[@id='row_1']/div[1]/p)[1]"))); // waiting till Return slice displays
 					driver.findElement(By.xpath("(.//*[@id='row_1']/div[1]/p)[1]")).click();
 					System.out.println ("Selected first Return slice of this product");
 				}
 				
 				waittimeShort();
 				waittimeShort();
 			
 				MyWaitVar60Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='product_detail']/h3[1]")));// waiting till page3 displays
 			
 	 			
 	 			// Checking whether Fare view details page displayed correctly or not
 	 			
 	 					String timebarviewPage3 = driver.getTitle(); 
 	 			        
 	 			        
 	 			        String expectedTitleFareView1 = "H.I.S. Flight Details";
 	 			        
 	 			        // compare the actual title of the page with the expected one and print the result as "Passed" or "Failed"
 	 			    
 	 			        
 	 			        if (timebarviewPage3.substring(0, 21).contentEquals(expectedTitleFareView1))
 	 			        {
 	 			            System.out.println("Page3 launched");
 	 			        } 
 	 			        else 
 	 			        {
 	 			            System.out.println("Page3 failed to launch");
 	 			        }
 					
 	 					
 	 			
 					
 					
 				     
 				     try
 				     {
 				    MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='product_detail']/div[11]/div[1]/button"))); // waiting till Search page3 is shown in page
 				   System.out.println ("\nReached page3 successfully");
 				   driver.findElement(By.xpath(".//*[@id='product_detail']/div[11]/div[1]/button")).click();
 				     }
 				    catch(Exception e10)
 				     {
 				    	
 				    	try
 				    	{
 				    	String warningMessage = driver.findElement(By.xpath(".//*[@id='fareRuleErrMsg']")).getText();
 				    	System.out.println ("Warning Message found in Page3: "+warningMessage);	
 			 			driver.findElement(By.xpath(".//*[@id='product_detail']/div[12]/div[1]/button")).click();
 			 			
 				    	}
 				    	catch(Exception e20)
 				    	{
 				    		try
 				    		{
 				    		String changeInPrice = driver.findElement(By.xpath(".//*[@id='priceChangeId']")).getText();
 				    		System.out.println ("Warning Message found in Page3: "+changeInPrice);	
 	 			 			driver.findElement(By.xpath(".//*[@id='product_detail']/div[12]/div[1]/button")).click();
 	 			 			
 				    		}
 				    		catch(Exception e3)
 				    		{
 				    			System.out.println ("\nSome issues/Warning message found after reaching page3"); 
 				    		}
 				    		
 				    	}
 			 		    	
 				    
 				   			
 				}
 	 			 	 		
 				
 				
 				System.out.println ("Back in time bar view");
 				
 				
 				driver.findElement(By.xpath(".//*[@id='productListViewLink']/a")).click();
 				
 				if (typeOfSearch.equals("RT"))

 				{
 					MyWaitVar30Sec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='prdouct_selected']/div[2]/table/tbody/tr/td[10]/a"))); 
 					driver.findElement(By.xpath(".//*[@id='prdouct_selected']/div[2]/table/tbody/tr/td[10]/a")).click();
 					
 				}
 				
 			 				 				
 				System.out.println ("We are back in page2- Product list View");
				}
 	 
 	 
 	 catch (Exception timebarviewError)
 	 {
 	 
 		System.out.println ("\nSome issues found while trying to click on Time bar view: " +timebarviewError);
 	 
			
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


