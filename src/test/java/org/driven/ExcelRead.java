package org.driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelRead {
	public static String[][] getdata() throws IOException {
		File f=new File("C:\\Users\\LENOVO\\Desktop\\first.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fs);
		Sheet sheet = w.getSheet("sample");
		List<ArrayList<String>> obj=new ArrayList<>();
		for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {
			//ArrayList<String> arrayList = obj.get(i);
			Row row = sheet.getRow(i);
			System.out.println(sheet);
			ArrayList<String> rows = new ArrayList<>();
			for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
				Cell cell = row.getCell(0);
				CellType cellType = cell.getCellType();
				String stringCellValue="";
				switch(cellType) {
				case STRING:
					 stringCellValue = cell.getStringCellValue();
					break;
				default:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat s=new SimpleDateFormat();
						stringCellValue= s.format(dateCellValue);
					}
					else {
						double numericCellValue = cell.getNumericCellValue();
						long l=(long) numericCellValue;
						BigDecimal valueOf = BigDecimal.valueOf(l);
						 stringCellValue = valueOf.toString();
					}
				
			}
				rows.add(stringCellValue);
				
		}
			obj.add(rows);
		}
		String s[][]= new String[obj.size()][obj.get(0).size()];
		for(int i=0;i<obj.size();i++) {
			ArrayList<String> arrayList = obj.get(i);
			for(int j=0;j<arrayList.size();j++) {
				s[i][j]=arrayList.get(j);
			}
		}
		
		return s;
	}
	public static void main(String[] args) throws IOException {
		String[][] getdata = getdata();
		for (int i = 0; i < getdata.length; i++) {
			
			String[] strings = getdata[i];
			for (int j = 0; j < strings.length; j++) {
				
				String string = getdata[i][j].toString();
				System.out.println(string);
			}
		}
	}
	}




