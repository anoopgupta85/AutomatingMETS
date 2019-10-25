package com.ag.Pages.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TTCaseWLoginLocators {
	
	@FindBy(xpath = "//*[@id='c2']") public WebElement TTUserName;
	@FindBy(xpath = "//*[@id='c3']") public WebElement TTPassword;
	@FindBy(xpath = "//*[@value ='Sign In']") public WebElement TTSignIn;
}
