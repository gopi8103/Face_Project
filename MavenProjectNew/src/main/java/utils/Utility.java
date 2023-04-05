package utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String CaptureScreenshot(WebDriver driver,String testID)   {
	
		String timeStamp=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("test-output\\FailTestScreenshots"+"Test10" + "="+ timeStamp +".jpeg");
	
		
	try {
		FileHandler.copy(src, dest);
	}
	catch (Exception e) {
	
	}
		   
	   return testID;
			   
	   	
	 }
	
		public static String getExcelData(String Sheet1,int row,int cell)   {
		
		String path="src\\main\\resources\\data\\Book1.xlsx";
	
		String data="";
		
		try {
			FileInputStream	file = new FileInputStream(path);
			Workbook book = WorkbookFactory.create(file);
			 data=book.getSheet(Sheet1).getRow(row).getCell(cell).getStringCellValue();

		} catch (Exception  e) {
		
		}
	
		return data;
	}
		public static int getNumricData(String path,String Sheet1) {
			int data=0;
			try {
				FileInputStream	file = new FileInputStream(path);
				Workbook book = WorkbookFactory.create(file);
			    data=book.getSheet(Sheet1).getLastRowNum();	
			}
			catch(Exception e) {
				
			}
			return data;
		}
		
		
		
	}
		

	



	


