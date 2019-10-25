package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class SupportingDocumentPage extends Page {

	
	public HouseHoldsSection doInputDocumentNumber(){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath(or.getProperty("INintyFourNumberInput_XPATH"))).sendKeys("78458527451");
		try {
			TestUtil.captureScreenshot(pageName);
		} catch (IOException e) {
		e.printStackTrace();
		}
		driver.findElement(By.xpath(or.getProperty("SuppDocNextButton_XPATH"))).click();
		
		return new HouseHoldsSection();
	}
}
