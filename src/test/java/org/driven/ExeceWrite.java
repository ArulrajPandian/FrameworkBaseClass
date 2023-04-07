package org.driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExeceWrite  {

	public static void main(String[] args) throws IOException {
		
		File f=new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameDataDriven\\src\\test\\resources\\Book2.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook w=new XSSFWorkbook();
		Sheet createSheet = w.createSheet("sample");
	
		String[][] getdata = ExcelReadArrayList.getdata();
		for(int i=0;i<getdata.length;i++) {
			Row createRow = createSheet.createRow(i);
			for(int j=0;j<getdata[i].length;j++) {
				Cell createCell = createRow.createCell(j);
				
				String String = getdata[i][j];
				createCell.setCellValue(String);
				//System.out.println(String);
				
			}
			FileOutputStream out=new FileOutputStream(f);
			w.write(out);
		}
		
}
}