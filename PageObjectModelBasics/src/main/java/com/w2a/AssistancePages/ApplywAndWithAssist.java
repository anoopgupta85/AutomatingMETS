package com.w2a.AssistancePages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class ApplywAndWithAssist extends Page {
	
	public AboutYouSection doClickOnNext(){
		
		  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        frames = driver.findElements(By.tagName("iframe"));
	        driver.switchTo().frame(0);
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("GettingStartedLink_XPATH"))));
			 element.click();
			 pageName = ApplywAndWithAssist.class.getName();
			 try {
					TestUtil.captureScreenshot(pageName);
				} catch (IOException e) {
				e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("ApplyingWithoutAssistCheckBox_XPATH")))); 
			 element.click();	
			 
			 driver.findElement(By.xpath(or.getProperty("ApplyingWithoutAssistNextBtn_XPATH"))).click();
			 
			 return new AboutYouSection();
			 
	}

}
