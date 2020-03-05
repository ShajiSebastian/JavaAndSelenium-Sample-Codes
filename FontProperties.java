package SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FontProperties 
{
	 public static void main(String[] args) 
	    {
		 
		 FirefoxProfile profile = new FirefoxProfile();
	        profile.setPreference("network.proxy.type", 1);
	        profile.setPreference("network.proxy.http", "webproxy.ibsplc.com");
	        profile.setPreference("network.proxy.http_port", 80);
	        WebDriver driver = new FirefoxDriver(profile);

	        driver.get("http://192.168.158.6:8280/fb/shop/airfaresearch.htm?ehn=TYO&ln=EN");
	        //Locate text string element to read It's font properties.
	        WebElement text = driver.findElement(By.xpath(".//*[@id='left_content_search']/h3"));
	        
	        //Read font-size property and print It In console.
	        String fontSize = text.getCssValue("font-size");
	        System.out.println("Font Size -> "+fontSize);
	        
	        //Read color property and print It In console.
	        String fontColor = text.getCssValue("color");
	        System.out.println("Font Color -> "+fontColor);
	        
	        //Read font-family property and print It In console.
	        String fontFamily = text.getCssValue("font-family");
	        System.out.println("Font Family -> "+fontFamily);
	        
	        //Read text-align property and print It In console.
	        String fonttxtAlign = text.getCssValue("text-align");
	        System.out.println("Font Text Alignment -> "+fonttxtAlign);
	    }
}
