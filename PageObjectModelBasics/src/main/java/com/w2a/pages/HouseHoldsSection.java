package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class HouseHoldsSection extends Page {

	public OtherHHMembers doHouseHoldNext(){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAPleaseTellUsAbtUrHouseHoldNxtBtn_XPATH"))));           // Wait to Click on Next Button on Household section
		 try {
				TestUtil.captureScreenshot(pageName);
			} catch (IOException e) {
			e.printStackTrace();
			}
		 element.click();
		 
		 return new OtherHHMembers();
	}
	
}
