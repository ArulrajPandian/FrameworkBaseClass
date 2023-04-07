package org.driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadColum {
	public static void getdata() throws IOException{
		try {
			
		
		File f=new File("C:\\Users\\LENOVO\\Desktop\\first.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fs);
		Sheet sheet = w.getSheet("sample");
		Iterator<Row> iterator = sheet.iterator();
		while(iterator.hasNext()) {
			Row row = iterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch(cell.getCellType()) {
				case STRING:
					System.out.println(cell.getStringCellValue()+"\t\t\t\t");
				default:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat s=new SimpleDateFormat();
						 String string = s.format(dateCellValue);
						 System.out.println(string+"\t\t\t\t");
					}
					else {
						double numericCellValue = cell.getNumericCellValue();
						long l=(long) numericCellValue;
						BigDecimal valueOf = BigDecimal.valueOf(l);
						  String string = valueOf.toString();
						  System.out.println(string+"\t\t\t\t\t");
					
				}
			}
		}
		
		
		
		
		
	}
		
	

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

	

