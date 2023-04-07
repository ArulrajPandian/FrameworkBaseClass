package org.poms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
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
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import net.bytebuddy.implementation.FixedValue;

public class BaseClass {
	public static WebDriver driver;
	public static WebElement findElement;;
	
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	public static void browserLaunch(String url) {
		driver.get(url);
	}
	
	public static WebElement locator(String locatorType,String locatorValue ) {
		if(locatorType.equals("id")) {
			findElement=driver.findElement(By.id(locatorValue));
			return findElement;
		}
		else if(locatorType.equals("name")) {
			findElement=driver.findElement(By.name(locatorValue));
			return findElement;
		}

		else if(locatorType.equals("xpath")) {
			findElement=driver.findElement(By.xpath(locatorValue));
			return findElement;
			
		}
		
		else if(locatorType.equals("className")) {
			WebElement findElement = driver.findElement(By.className(locatorValue));
			return findElement;
		}
		else {
			return findElement;
		}
	}
	
	public static void sendKey(WebElement finElement, String keytosend)  {
			
		finElement.sendKeys(keytosend);
	}
	public static  void btnlogn(WebElement findElement) {
	   findElement.click();

	}
	
	public static String[][] getdats() throws IOException {
		File f=new File("C:\\Users\\LENOVO\\Desktop\\first.xlsx");
		FileInputStream fs=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fs);
		Sheet sheet = w.getSheet("sample");
		List<ArrayList<String>> obj=new ArrayList<>();
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			Row row = sheet.getRow(i);
			ArrayList<String> rows = new ArrayList<>();
			for(int j=0;j<row.getPhysicalNumberOfCells();j++)
			{
				Cell cell = row.getCell(j);
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
	
	
	public static  void selectIndex(WebElement element,int value) {
		
		Select s=new Select(element);
		if(element.equals("index")) {
			s.selectByIndex(value);
			
		}

	}
	
	public static void Select(WebElement elemnet,String value){
		Select s=new Select(elemnet);
		if(elemnet.equals("Visible")) {
			s.selectByVisibleText(value);
		}
		else {
			s.selectByValue(value);
		}
	}
	
	}
	
	
	
	
	




