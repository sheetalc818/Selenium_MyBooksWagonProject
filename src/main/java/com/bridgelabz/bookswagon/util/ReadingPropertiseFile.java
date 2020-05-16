package com.bridgelabz.bookswagon.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingPropertiseFile  
{
		public static Workbook wb;
		public static String getProperty(String PROPERTY_FILE_PATH, String key) throws IOException 
		{
			String property = "";
			Properties prop = new Properties();
			try
			{
				prop.load(new FileInputStream(PROPERTY_FILE_PATH));
				property = prop.getProperty(key);
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			return property;
		}
		
		public static String getCellValue(String EXCEL_PATH ,String sheet, int row , int column) 
		{
			String value = "";
			try 
			{
				wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
				value = wb.getSheet(sheet).getRow(row).getCell(column).toString();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return value;
		}

}
