package org.poms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClassLogin extends BaseClass {
	
	public PomClassLogin() {
		
		
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(id="username") 
		private WebElement userName;
		
		public WebElement getUserName() {
			return userName;
		}
		@FindBy(id="password")
		private WebElement passWord;
		public WebElement getPassWord() {
			return passWord;
		}
		
		@FindBy(name="login")
		private WebElement login;
		public WebElement getLogin() {
			return login;
		}
		
		
		
		
		
		
		
		
	}

