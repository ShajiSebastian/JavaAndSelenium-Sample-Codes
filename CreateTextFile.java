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

 
public class CreateTextFile 
{
 
    public static void main(String[] args) throws IOException 
    {
    	
    	//creating new file
    	File f = new File("D:\\temp1.txt");
    	f.createNewFile();
    	System.out.println("Fle created");
    	
    	//writing into file
    	FileWriter w= new FileWriter("D:\\temp1.txt");
    	BufferedWriter out = new BufferedWriter(w);
    	out.write("Shaji Sebastian");
    	out.newLine();
    	out.write("Kochupurayil House");
    	out.flush();
    	System.out.println("Written into file");
    	
    	//To read file
    	FileReader r = new FileReader("D:\\temp1.txt");
    	BufferedReader br = new BufferedReader(r);  
    	String  x= "";
    	while ((x=br.readLine()) != null)
    	{
    		System.out.println(x);
    	}    	
    	System.out.println("Reading completed");
    	
    	}
}
    
    