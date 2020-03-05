package SeleniumScripts;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; // This is used for explicit wait


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

 
public class DoubleClick 
{
 
    public static void main(String[] args) throws IOException, InterruptedException 
    {
    	

WebDriver driver = new FirefoxDriver();


driver.get("file:///C:/Users/a-4600/Desktop/dbclick.html");
driver.findElement(By.xpath("html/body/p[1]")).click();
System.out.println("Going to double click");
Thread.sleep(4000);
WebElement element = driver.findElement(By.xpath("html/body/p[1]"));
Actions act= new Actions(driver);
act.doubleClick(element);
System.out.println("Done1");

/*
driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_event_dblclick");
System.out.println("Going to single click");
driver.findElement(By.partialLinkText("Double-click on this paragraph")).click();
Thread.sleep(3000);
System.out.println("Going to double click");
WebElement element2 = driver.findElement(By.xpath("html/body/p"));

Actions act2= new Actions(driver);
act2.doubleClick(element2);
System.out.println("Done2");
*/

    }
}
    
    