package org.poms;

import java.io.IOException;

import org.driven.ExcelRead;
import org.driven.ExcelReadArrayList;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ExecutionTestNg extends BaseClass {

	
	@DataProvider(name="LoginDatas")
	private  Object[][] getData() throws IOException{
	Object[][] reader=ExcelReadArrayList.getdata();
	return reader;
}
	@Test(dataProvider="LoginDatas")
	private void tc01(String user,String pass) {
		getDriver();
		browserLaunch("https://www.facebook.com/");
		PomClassLogin p=new PomClassLogin();
		WebElement userName = p.getUserName();
		sendKey(userName, user);
		WebElement passWord = p.getPassWord();
		sendKey(passWord, pass);
		WebElement login = p.getLogin();
		btnlogn(login);
	}
	
	
	
}
