package SeleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SeriesOfActions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
WebDriver driver = new FirefoxDriver();
		
		//Invoking application url
		System.out.println ("Trying to invoke Login page");
		driver.get("http://192.168.158.6:8280/fb/login/login.htm");

		//driver.findElement(By.xpath(".//*[@id='j_username']")).sendKeys("ttttt");
		WebElement txtUsername= driver.findElement(By.xpath(".//*[@id='j_username']"));
		
		Actions builder = new Actions(driver);
		Action seriesOfActions =builder.moveToElement(txtUsername).click().keyDown(txtUsername, Keys.SHIFT).sendKeys(txtUsername,"abcde").keyUp(txtUsername, Keys.SHIFT).doubleClick(txtUsername).contextClick().build();
		
		seriesOfActions.perform();
		
	
	}

}
