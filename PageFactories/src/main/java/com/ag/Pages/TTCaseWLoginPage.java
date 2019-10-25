package com.ag.Pages;

import org.openqa.selenium.support.PageFactory;

import com.ag.Base.Page;
import com.ag.Pages.Locators.HomePageLocators;
import com.ag.Pages.Locators.TTCaseWLoginLocators;

public class TTCaseWLoginPage extends Page {
	
	public TTCaseWLoginLocators ttcwlogin;
	
	public TTCaseWLoginPage(){
		
		this.ttcwlogin = new TTCaseWLoginLocators();
		PageFactory.initElements(driver, this.ttcwlogin);
	}
	
	public void logintoCWTT(){
		
		ttcwlogin.TTUserName.sendKeys("STSTPWAXG01CW");
		ttcwlogin.TTPassword.sendKeys("@Vikram09009");
		ttcwlogin.TTSignIn.click();
	}
	}


