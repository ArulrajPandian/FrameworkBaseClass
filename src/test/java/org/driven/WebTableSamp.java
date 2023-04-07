package org.driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTableSamp {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\eclipse-workspace\\AAAAAA\\Driver\\chromedriver.exe" );
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/search?q=ipl+table+2022&rlz=1C1CHBF_enIN1044IN1044&oq=&aqs=chrome.0.35i39i362l7j69i59i450.12691326j0j7&sourceid=chrome&ie=UTF-8");
	    WebElement locator = driver.findElement(By.xpath("//div[@class='sWfpOe']"));
	    
	    List<WebElement> rows = locator.findElements(By.tagName("tr"));
	    
	    File f=new File("C:\\Users\\LENOVO\\eclipse-workspace\\FrameDataDriven\\src\\test\\resources\\Book1.xlsx");
	    FileInputStream fs=new FileInputStream(f);
	    Workbook w=new XSSFWorkbook();
	    Sheet createSheet = w.createSheet("sample");
	    for(int i=0;i<rows.size();i++) {
	    	WebElement row = rows.get(i);
	    	Row createRow = createSheet.createRow(i);
	    	List<WebElement> data = row.findElements(By.tagName("td"));
	    	for(int j=2;j<data.size();j++) {
	    		WebElement webElement = data.get(j);
	    		String text = webElement.getText();
	    		Cell createCell = createRow.createCell(j);
	    		createCell.setCellValue(text);
	    		
	    	}
	    	
	    	 FileOutputStream out=new FileOutputStream(f);
	    	 w.write(out);
	    	 
	    	
	    }
	 
	}

}
