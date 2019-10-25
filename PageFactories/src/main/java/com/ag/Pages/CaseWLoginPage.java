package com.ag.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.ag.Base.Page;
import com.ag.Pages.Locators.HomePageLocators;

public class CaseWLoginPage extends Page {
	
	public HomePageLocators home;
	
	public CaseWLoginPage() {
		
		this.home = new HomePageLocators();
		PageFactory.initElements(driver, this.home);
	}

	public void logintoCaseW(){
		
		home.UserName.sendKeys("STSTPWAXG01CW");
		home.PassWord.sendKeys("@Vikram09009");
		home.SignIn.click();
		 try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	
	  
	
}
