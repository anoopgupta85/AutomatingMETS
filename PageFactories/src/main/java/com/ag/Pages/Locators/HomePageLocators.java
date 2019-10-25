package com.ag.Pages.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
	
	@FindBy(xpath = "//*[@id='username']") public WebElement UserName;
	@FindBy(xpath = "//*[@id='password']") public WebElement PassWord;
	@FindBy(xpath = "//div/div/button") public WebElement SignIn;
	
	
	
}
