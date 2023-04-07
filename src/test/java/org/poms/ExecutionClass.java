package org.poms;

import org.openqa.selenium.WebElement;

public class ExecutionClass extends BaseClass {

	public static void main(String[] args) {
		getDriver();
		browserLaunch("https://www.facebook.com/");
		PomClassLogin p=new PomClassLogin();
		WebElement userName = p.getUserName();
		sendKey(userName, "raj12345");
		WebElement passWord = p.getPassWord();
		sendKey(passWord, "123456");
		WebElement login = p.getLogin();
		btnlogn(login);
		
	}
	

}
