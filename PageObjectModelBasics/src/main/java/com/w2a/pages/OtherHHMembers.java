package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class OtherHHMembers extends Page {
	
	public HHMembersDetails OtherHHMembersNo(){
		
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldDD_XPATH"))));           // Wait to Click on Drop Down on Other Household Members
		 element.click(); 
		 driver.findElement(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldNo_XPATH"))).click();
		 try {
				TestUtil.captureScreenshot(pageName);
			} catch (IOException e) {
			e.printStackTrace();
			}
		 driver.findElement(By.xpath(or.getProperty("MAOtherHHMembersNxtBtn_XPATH"))).click();
		 
		 return new HHMembersDetails();
	}

	public HHMembersDetails OtherHHMembersYes(){
		
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldDD_XPATH"))));           // Wait to Click on Drop Down on Other Household Members
		 element.click(); 
		 driver.findElement(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldYes_XPATH"))).click();
		 try {
				TestUtil.captureScreenshot(pageName);
			} catch (IOException e) {
			e.printStackTrace();
			}
		 driver.findElement(By.xpath(or.getProperty("MAOtherHHMembersNxtBtn_XPATH"))).click();
		 
		 return new HHMembersDetails();
		 
	}
	
}
