package com.checkerSoftware.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.checkerSoftware.base.BaseClass;

public class ExcelSheet extends BaseClass{
	
	public static void ExcelTesting(String sheetName ,String time ,double ExecutionTime) throws IOException  {
		
		FileInputStream fip = new FileInputStream("C:\\Users\\Dhanraj\\Desktop\\TimeExe.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fip);
		int sheets = wb.getNumberOfSheets();
		XSSFSheet sheet;
		int row =0;
		int coloumn =0;
		for(int i=0; i<sheets; i++) {
			if(wb.getSheetName(i).equalsIgnoreCase(sheetName)) {
				sheet = wb.getSheetAt(i);
			
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int c = 0;
				
			while(ce.hasNext()) {
				Cell value = ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("Date of Execution")) {
					coloumn =c;
				}
				c++;
			}
			System.out.println(coloumn);
			
			int  rc=0;
			int lastRow=0;
			while(rows.hasNext()) {
				Row r=rows.next();
				
				++rc;
				lastRow =rc+1;
			}
			
			System.out.println(lastRow);
			
			
			XSSFRow newRow = sheet.createRow(lastRow);
			newRow.createCell(coloumn).setCellValue(time);
			newRow.createCell(coloumn+1).setCellValue(ExecutionTime);
			
			
			
			
			 FileOutputStream fos = new FileOutputStream(new File ("C:\\Users\\Dhanraj\\Desktop\\TimeExe.xlsx"));
			 wb.write(fos);
			 wb.close(); 
				}
		
			
		}
		
		
	}
	
public static void ExcelpreProd(String sheetName, String time ,double ExecutionTime) throws IOException  {
		
	FileInputStream fip = new FileInputStream("C:\\Users\\Dhanraj\\Desktop\\TimeExe.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fip);
	int sheets = wb.getNumberOfSheets();
	XSSFSheet sheet;
	int row =0;
	int coloumn =0;
	for(int i=0; i<sheets; i++) {
		if(wb.getSheetName(i).equalsIgnoreCase(sheetName)) {
			sheet = wb.getSheetAt(i);
		
			Iterator<Row> rows = sheet.iterator();
			Row firstRow = rows.next();
			Iterator<Cell> ce = firstRow.cellIterator();
			int c = 0;
			
		while(ce.hasNext()) {
			Cell value = ce.next();
			if(value.getStringCellValue().equalsIgnoreCase("Date of Execution")) {
				coloumn =c;
			}
			c++;
		}
		System.out.println(coloumn);
		
		int  rc=0;
		int lastRow=0;
		while(rows.hasNext()) {
			Row r=rows.next();
			
			++rc;
			lastRow =rc+1;
		}
		
		System.out.println(lastRow);
		
		
		XSSFRow newRow = sheet.createRow(lastRow);
		newRow.createCell(coloumn).setCellValue(time);
		newRow.createCell(coloumn+1).setCellValue("");
		newRow.createCell(coloumn+2).setCellValue("");
		newRow.createCell(coloumn+3).setCellValue(ExecutionTime);
		
		
		
		 FileOutputStream fos = new FileOutputStream(new File ("C:\\Users\\Dhanraj\\Desktop\\TimeExe.xlsx"));
		 wb.write(fos);
		 wb.close(); 
			}
	
		
	}
		
		
	}

	
	

}
