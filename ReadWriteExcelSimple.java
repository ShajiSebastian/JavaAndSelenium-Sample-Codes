package SeleniumScripts;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import 
 org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import 
 org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class ReadWriteExcelSimple 

{
	
	
	public static void main(String...strings) throws IOException, InterruptedException
	   {
		   
	   
	   //Create a object of Read data from excel.
		
		
		FileInputStream fis = new FileInputStream("D:\\Shaji\\DATA.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("test");
		
	   ReadWriteExcelSimple objReadFile = new ReadWriteExcelSimple();

	   //objReadFile.readExcel(filePath,"ExportExcel.xlsx","ExcelvscDemo");
	   objReadFile.readExcel();
	   
	   //Create an array with the data in the same order in which you expect to be filled in excel file
	   
	   String[] valueToWrite = {"Shaji","Jency","Titto"};

	   //  Create a object of write data into an excel
	   ReadWriteExcelSimple objWriteFile = new ReadWriteExcelSimple();

	   //objWriteFile.writeExcel(System.getProperty("user.dir")+"\\src\\excelExportAndFileIO","ExportExcel.xlsx","ExcelGuru99Demo",valueToWrite);
	   objWriteFile.writeExcel(valueToWrite);

	   System.out.println("Read and Write actions completed successfully");
	   
	   }

	// *********************** Trying to read from an excel **************************************************************
	
	public void readExcel() throws IOException
	// public void readExcel(String filePath,String fileName,String sheetName) throws IOException
	   {
		System.out.println("Starts execution of reading an excel");   
		
		String filePath= "D:\\Shaji\\Selenium\\SeleniumScriptsFiles";
		String fileName= "VSC_Selenium_TestData.xlsx";
		String sheetName= "VSC";
		
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
   
		System.out.println("Trying to read data from excel and writing in Console\n");

		Sheet vscSheet = vscWorkbook.getSheet(sheetName);

		//Find number of rows in excel file

		int rowCount = vscSheet.getLastRowNum()-vscSheet.getFirstRowNum();

		//Create a loop over all the rows of excel file to read it

		for (int i = 0; i < rowCount+1; i++) 
			{
			Row row = vscSheet.getRow(i);

			//Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) 
				{

				//Print excel data in console
				System.out.print(row.getCell(j).getStringCellValue()+" | ");

				}

			System.out.println();

			 }

       }

 
// *********************** Trying to write into an excel **************************************************************

    	
	public void writeExcel(String[] dataToWrite) throws IOException
	//public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite) throws IOException{
		{
	   System.out.println("\nStarts execution of writing into an excel");  
        //Create a object of File class to open xlsx file
	   String filePath = "D:\\Shaji\\Selenium\\SeleniumScriptsFiles";
	   String fileName = "VSC_Selenium_Output.xlsx";
	   String sheetName ="Output";
	   
       //File file =    new File("D:\\Shaji\\Selenium\\SeleniumScriptsFiles"+"\\"+"VSC_Selenium_Output.xlsx");
	   File file =    new File(filePath+"\\"+fileName);
       
	   //Create an object of FileInputStream class to read excel file
       FileInputStream inputStream = new FileInputStream(file);
       Workbook vscWorkbook = null;
 
       //Find the file extension by splitting file name in substring and getting only extension name
       System.out.println("Checking the file type of output file");
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
 
         
 
    //Read excel sheet by sheet name  
        System.out.println("Trying to read output excel sheet to find till which row the data is already present");
 
    Sheet sheet = vscWorkbook.getSheet(sheetName);
 
    //Get the current count of rows in excel file
     int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
 
    //Get the first row from the sheet
     Row row = sheet.getRow(0);
 
    //Create a new row and append it at last of sheet
    System.out.println("creating a new row (appending)");
 
    Row newRow = sheet.createRow(rowCount+1);
 
    //Create a loop over the cell of newly created Row
    
    System.out.println("wirting data into newly created row\n");
 
    for(int j = 0; j < row.getLastCellNum(); j++)
    {
 
        Cell cell = newRow.createCell(j); 
        cell.setCellValue(dataToWrite[j]);
 
    }
 
    //Close input stream
 
    inputStream.close();
 
    //Create an object of FileOutputStream class to create write data in excel file
 
    FileOutputStream outputStream = new FileOutputStream(file);
 
    //write data in the excel file
 
    vscWorkbook.write(outputStream);
 
    //close output stream
 
    outputStream.close();
 
     }
 
  }


