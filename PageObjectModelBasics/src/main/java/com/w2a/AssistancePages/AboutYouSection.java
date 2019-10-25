package com.w2a.AssistancePages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.Page;
import com.w2a.pages.InformationAboutYou.InformationAbtYou;
import com.w2a.utilities.TestUtil;

public class AboutYouSection extends Page {
	
	public InformationAbtYou doClickOnNextOnAYS(){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("PleaseTellAbtYouNextBtn_XPATH"))));
	 pageName = AboutYouSection.class.getName();
	 try {
		
			TestUtil.captureScreenshot(pageName);
		} catch (IOException e) {
		e.printStackTrace();
		}
	   element.click();
    
	
	   try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   return new InformationAbtYou();
	   
	}

}
