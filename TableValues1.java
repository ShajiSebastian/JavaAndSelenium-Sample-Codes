package SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableValues1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///D:/Shaji/Documents/shaji.htm");
		System.out.println ("Application url invoked");
		
		String innerText=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[4]/td[5]/p")).getText();
		System.out.println("The value read from table is :" + innerText);
		driver.quit();
	
	}

}
