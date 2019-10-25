package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.AssistancePages.AboutYouSection;
import com.w2a.AssistancePages.ApplywAndWithAssist;
import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class ApplyAndEnroll extends Page{
	
	
	public ApplywAndWithAssist doClickWithFinancialHelp(){
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		 
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("ApplyandEnrollWithFinancial_XPATH")))); 
		pageName = ApplyAndEnroll.class.getName();
		try {
			TestUtil.captureScreenshot(pageName);
		} catch (IOException e) {
		e.printStackTrace();
		}
     element.click();
     
     return new ApplywAndWithAssist();
				
	}

	public ApplywAndWithAssist doClickWithoutFinancialHelp(){
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
	
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("ApplyandEnrollWithoutFinancial_XPATH"))));
		pageName = ApplyAndEnroll.class.getName();
		try {
			TestUtil.captureScreenshot(pageName);
		} catch (IOException e) {
		e.printStackTrace();
		}
  element.click();
  
  return new ApplywAndWithAssist();
	}
}
