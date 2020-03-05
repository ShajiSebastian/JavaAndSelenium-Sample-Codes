package SeleniumScripts;
 
import java.awt.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

//import org.openqa.selenium.Alert;
public class VSCTestPageCreation {
	public static void main(String args[])
	{
		WebDriver driver = new FirefoxDriver();
		//D:\Shaji\Selenium\iTestFW SVN\Selenium libs
		//System.setProperty("webdriver.chrome.driver", "D:\\Shaji\\Selenium\\iTestFW SVN\\Selenium libs\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//DesiredCapabilities capabilities=null;
		//capabilities = DesiredCapabilities.internetExplorer();  
       /* String s2 = System.getProperty("user.dir"); 
        String path = s2 + "\\lib\\IEDriverServer.exe (file://lib//IEDriverServer.exe)"; 
        System.out.println("@getCapabilities() - ie driver path :" + path); 
        System.setProperty("webdriver.ie.driver", path); */
		//System.setProperty("webdriver.ie.driver","D:\\Shaji\\Selenium\\iTestFW SVN\\Selenium libs\\IE1\\IEDriverServer.exe");
        //capabilities.setBrowserName("iexplore"); 
        //capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS); 
        //WebDriver driver = new InternetExplorerDriver(capabilities);

		//WebDriver driver = new InternetExplorerDriver();	
		//Invoking application url
		
		driver.get("http://login.myvacationstorebuilder.vsbtest.com");
		System.out.println ("VSC Test page invoked");
		waittimeShort();
		//Maximizing browser window
		//driver.manage().window().maximize() ;
		
		// Entering User id and Password and submitting
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[1]/td[2]/input")).sendKeys("ssebastian");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[2]/td[2]/input")).sendKeys("vsc123");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[4]/td/input[1]")).click();
		System.out.println ("Login credentials entered and clicked on submit button");
		
		waittimeLong(); 
		
			

		// Checking whether Login is success or not
		try
		{		
			 
			String Logininfo = driver.findElement(By.xpath(".//*[@id='login_menu']/span")).getText();
			
			if (Logininfo.equals("Logged in as: ssebastian"))
				{
				System.out.println ("Logged in Successfuly");
				}
			else
				{
				System.out.println ("Log in Failed");
				driver.quit();				
				System.out.println ("Browser windows closed");
				System.exit(1);
				}
		}
		
		catch(Exception e)
		{
			System.out.println ("Unexpected Exception occured and Log in Failed");
			System.out.println("Exception Message is: " +e.getMessage());
			driver.quit();				
			System.out.println ("browser windows closed");
			System.exit(1);
		}
		
		
		
		// Store the current window handle
		String winHandle1 = driver.getWindowHandle();
		
		driver.findElement(By.xpath(".//*[@id='siteCreateNew']")).click();
		System.out.println ("Clicked on create new page link");
		waittimeLong();
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles())
			{
			    driver.switchTo().window(winHandle);
			}
		
		/*
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath(".//*[@id='yui-gen39']/a"));
		//actions.moveToElement(mainMenu);
		//actions.click().build().perform();
		actions.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath(".//*[@id='yui-gen44']/a"))).click().build().perform();
		// Extract text from main menu
		String menuName=mainMenu.getText();
		System.out.println("Main Menu name is "+menuName);
		*/
		
/*
		WebElement subMenu = driver.findElement(By.xpath(".//*[@id='yui-gen44']/a"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		
		
		// Extract text from Submenu
		String SubMenuName=subMenu.getText();
		System.out.println("Tooltip message is "+SubMenuName);
		
		*/
		
		/*
		
		// Create action class object
		 Actions builder=new Actions(driver);
		 
		// find the tooltip xpath
		WebElement account_tooltip=driver.findElement(By.xpath(".//*[@id='yui-gen39']/a"));
		//WebElement recache = driver.findElement(By.xpath(".//*[@id='yui-gen45']/a"));
		// Mouse hover to that text message
		builder.moveToElement(account_tooltip).click().perform();
		//builder.keyDown(recache, Keys.ENTER);
 
		// Extract text from tooltip
		String tooltip_msg=account_tooltip.getText();
		 
		// Print the tooltip message just for our refrences
		System.out.println("Tooltip message is "+tooltip_msg);
		
		WebElement hoverElement;
		builder.moveToElement(hoverElement).perform();
		By locator = By.id("yui-gen44");
		((Actions) driver).click();
		
		WebElement termsConditions =driver.findElement(By.name("agree"));
		termsConditions.click();
	
		
		driver.findElement(By.xpath(".//*[@id='yui-gen39']/a")).click();
		System.out.println ("Account button clicked first time");
		waittimeShort();
		driver.findElement(By.xpath(".//*[@id='yui-gen39']/a")).click();
		System.out.println ("Account button clicked second time");
		waittimeShort();
		//Selecting 'create New Site' option (Dropdown list)
		Select newSite = new Select (driver.findElement(By.xpath(".//*[@id='yui-gen44']/a")));
		newSite.selectByIndex(0);
		
		*/
	
		System.out.println ("Filling details in 1st page");
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[1]/td[2]/input")).sendKeys("FirstName");
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[2]/td[2]/input")).sendKeys("LastName");
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[3]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[3]/td[2]/input")).sendKeys("Mr");	
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[4]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[4]/td[2]/input")).sendKeys("1234567890");
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[5]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[5]/td[2]/input")).sendKeys("abc@gmail.com");
		
		
		
		//Selecting 'Desired Micro-Site Type' (Dropdown list)
		Select siteType = new Select (driver.findElement(By.name("sitetype")));
		siteType.selectByIndex(4);
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[12]/td/table/tbody/tr[2]/td[1]/input")).sendKeys("Bittu");
		
		//Selecting 'property Type' (Dropdown list)
		Select propertyType = new Select (driver.findElement(By.name("propertytype")));
		propertyType.selectByIndex(4);
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[12]/td/table/tbody/tr[4]/td[1]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[12]/td/table/tbody/tr[4]/td[1]/input")).sendKeys("CompanyName");
		
		//Selecting 'company Type' (Dropdown list)
		Select companyType = new Select (driver.findElement(By.name("companytype")));
		companyType.selectByIndex(4);
		
		//checking 'Terms n Conditions' option (Check option)
		WebElement termsConditions =driver.findElement(By.name("agree"));
		termsConditions.click();
		
		System.out.println ("All details entered");
		waittimeLong() ;
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[14]/td/input[1]")).click();
		System.out.println ("Contiue button clicked");
		
			
		
		String Secondpage = driver.findElement(By.xpath(".//*[@id='Screen']/div/div[2]/div/h2")).getText();
		
		if (Secondpage.equals("2. Please enter property information"))
			{
			System.out.println ("We are in page2");
			}
		
		System.out.println ("Filling details in 2nd page");
		
		//Selecting 'Primary Exchange Company' (Dropdown list)		
		Select PrimaryExchangeCompany = new Select (driver.findElement(By.name("exchangeresorttype")));
		PrimaryExchangeCompany.selectByIndex(1);
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[2]/td[2]/input")).sendKeys("Bittu");
		
		//Selecting 'Property Type' (Dropdown list)		
		Select PropertyType = new Select (driver.findElement(By.name("propertytype")));
		PropertyType.selectByIndex(1);
		
		//Selecting 'Property Country' (Dropdown list)		
		Select PropertyCountry= new Select (driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[4]/td[2]/select")));
		PropertyCountry.selectByIndex(1);
		
		//Entering property address
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[5]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[5]/td[2]/input")).sendKeys("IBS India");
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[6]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[6]/td[2]/input")).sendKeys("Kerala");
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[7]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[7]/td[2]/input")).sendKeys("Infopark");
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[8]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[8]/td[2]/input")).sendKeys("Kochi");
		
		//Selecting 'State or Province (intl)' (Dropdown list)		
		Select StateProvince= new Select (driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[9]/td[2]/select")));
		StateProvince.selectByIndex(15);
		
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[10]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[10]/td[2]/input")).sendKeys("12345");
		
		//Selecting 'Destination' (Dropdown list)		
		Select Destination= new Select (driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[11]/td[2]/select")));
		Destination.selectByIndex(1);
		
		//Selecting 'Nearest airport' (Dropdown list)		
		Select Nearestairport= new Select (driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[12]/td[2]/select")));
		Nearestairport.selectByIndex(1);
		
		// This microsite will be used for...
		driver.findElement(By.xpath(".//*[@id='regForm']/div[2]/input[2]")).click();
		
		
		//Language(s) to support: First unchecking English and selecting French
		WebElement LangaugeEng =driver.findElement(By.id("languageEn"));
		LangaugeEng.click();
		WebElement LangaugeFrench =driver.findElement(By.id("languageFr"));
		LangaugeFrench.click();
		
		driver.findElement(By.xpath(".//*[@id='regForm']/div[4]/table[2]/tbody/tr/td[2]/textarea")).clear();
		driver.findElement(By.xpath(".//*[@id='regForm']/div[4]/table[2]/tbody/tr/td[2]/textarea")).sendKeys("This is a test page");
		
		System.out.println ("All details entered");
		waittimeLong() ;
		
		driver.findElement(By.xpath(".//*[@id='regForm']/div[6]/input[1]")).click();
		System.out.println ("Contiue button clicked");
		waittimeMedium() ;
			
		
		String Thirdpage = driver.findElement(By.xpath(".//*[@id='regForm']/div/div/div[2]/div/h2")).getText();
		
		if (Thirdpage.equals("3. Select a Site Design"))
			{
			System.out.println ("We are in page3");
			}
		
		driver.findElement(By.xpath(".//*[@id='regForm']/div/div/div[2]/div/center[2]/input[1]")).click();
		
		System.out.println ("Contiue button clicked");
		waittimeMedium() ;
		
		String Fourthpage = driver.findElement(By.xpath(".//*[@id='regForm']/div/div[1]/div[2]/div/h2")).getText();
		
		if (Fourthpage.equals("4. Create Unit Types"))
			{
			System.out.println ("We are in page4");
			}
		
		
		// adding Unit types
		
		// Store the current window handle
		String winHandle2 = driver.getWindowHandle();
		
		driver.findElement(By.xpath(".//*[@id='regForm']/div/div[1]/div[2]/div/table/tbody/tr[2]/td/input")).click();
		
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle);
					}
		
		//Select UnitType= new Select (driver.findElement(By.xpath(".//*[@id='regForm']/table/tbody/tr[12]/td[2]/select")));
		//UnitType.selectByIndex(1);
		
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[2]/td[2]/input")).sendKeys("For Automation");
		
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[4]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[4]/td[2]/input")).sendKeys("1");
		
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[4]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[4]/td[2]/input")).sendKeys("2");
		
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[5]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[5]/td[2]/input")).sendKeys("3");
		
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[6]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[6]/td[2]/input")).sendKeys("4");
		
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[7]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[7]/td[2]/input")).sendKeys("5");
		
				
		Select UnitMeasure= new Select (driver.findElement(By.xpath(".//*[@id='unitTypesEditorDlg']/div[2]/form/table/tbody/tr[7]/td[2]/select")));
		UnitMeasure.selectByIndex(1);
		
		System.out.println ("All details entered in Unit type details popup");
		
		waittimeMedium();
		
		driver.findElement(By.xpath(".//*[@id='yui-gen0-button']")).click();
		
		
		
	
		waittimeShort();
		driver.findElement(By.xpath(".//*[@id='regForm']/div/div[2]/input[1]")).click();
		
		System.out.println ("Continue button clicked");
		
		Select UnitTYpe= new Select (driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[1]/tbody/tr/td[2]/select")));
		UnitTYpe.selectByIndex(0);
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[2]/tbody/tr/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[2]/tbody/tr/td[2]/input")).sendKeys("07/08/2015");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[2]/tbody/tr/td[4]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[2]/tbody/tr/td[4]/input")).sendKeys("10/08/2015");
		
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[2]/tbody/tr/td[4]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[2]/tbody/tr/td[4]/input")).sendKeys("10/08/2015");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[2]/td[2]/input")).sendKeys("100");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[2]/td[3]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[2]/td[3]/input")).sendKeys("101");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[3]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[3]/td[2]/input")).sendKeys("200");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[3]/td[3]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[3]/td[3]/input")).sendKeys("201");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[4]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[4]/td[2]/input")).sendKeys("300");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[4]/td[3]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[4]/td[3]/input")).sendKeys("301");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[5]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[5]/td[2]/input")).sendKeys("400");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[5]/td[3]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[5]/td[3]/input")).sendKeys("401");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[6]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[6]/td[2]/input")).sendKeys("500");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[6]/td[3]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[6]/td[3]/input")).sendKeys("501");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[7]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[7]/td[2]/input")).sendKeys("600");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[7]/td[3]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[7]/td[3]/input")).sendKeys("601");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[8]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[8]/td[2]/input")).sendKeys("700");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[8]/td[3]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[8]/td[3]/input")).sendKeys("701");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/div[1]/form[1]/div/div[2]/div/table[3]/tbody/tr[1]/td[4]/input")).click();
		
		System.out.println ("Saved Unit Price");
		
		waittimeShort();
		
		driver.findElement(By.xpath(".//*[@id='regForm']/div[2]/input")).click();
		System.out.println ("clicked on 'Build my site' option");
		
		waittimeLong();
		
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[1]/td[2]/input")).sendKeys("ssebastian");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[2]/td[2]/input")).sendKeys("vsc123");
		
		driver.findElement(By.xpath(".//*[@id='Screen']/center/form/table/tbody/tr[4]/td/input[1]")).click();
		System.out.println ("Login credentials entered and clicked on submit button");
		
		waittimeLong(); 
		
		// Trying to find the newly created link. We have to give proper value for site name 
		
		String text = driver.findElement(By.xpath("(//div//span[contains(text(),'Bittu')])/following-sibling::a")).getText();
		System.out.println("The url of newly created page is: " + text);
	}
		

	private static void waittimeShort() 
	{
		try
		{
		  Thread.sleep(5*60*10);
		}
		catch(Exception e)
		{
		}
	}

	private static void waittimeMedium() 
	{

		try
		{
		  Thread.sleep(10*60*10);
		}
		catch(Exception e)
		{
				
		}
		
	}
	
	private static void waittimeLong() 
	{

		try
		{
		  Thread.sleep(25*60*10);
		}
		catch(Exception e)
		{
				
		}
		
	}
	
	private static void waittimeVerylong() 
	{

		try
		{
		  Thread.sleep(50*60*10);
		}
		catch(Exception e)
		{
				
		}
		
	}
}


