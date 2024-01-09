package readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException
	{
		File file = new File(filePath+"\\"+fileName);                     //Create a object of File class to open xlsx file	  
		FileInputStream inputStream = new FileInputStream(file);          //Create an object of FileInputStream class to read excel file
		Workbook sk = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));      //Find the file extension by spliting file name in substing and getting only extension name

		if(fileExtensionName.equals(".xlsx"))                          //Check condition if the file is xlsx file
		{

			sk = new XSSFWorkbook(inputStream);                  //If it is xlsx file then create object of XSSFWorkbook class
		}
		else if(fileExtensionName.equals(".xls"))                        	  //Check condition if the file is xls file
		{

			sk = new HSSFWorkbook(inputStream);                   //If it is xls file then create object of XSSFWorkbook class
		}
		Sheet  ub = sk.getSheet(sheetName);                     //Read sheet inside the workbook by its name		
		return ub; 
	}

}
