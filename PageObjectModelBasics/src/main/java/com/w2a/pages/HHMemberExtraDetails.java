package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class HHMemberExtraDetails extends Page {
	
	public void doAddSSNPregNo(){
		
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveSSNDD_XPATH")))); 
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("MADoYouHaveSSNYes_XPATH"))).click();
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MASSNTextBox_XPATH"))));           // Wait to Click on Address Line 1 
		 element.sendKeys("444444135");	
		 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenYes_XPATH"))).click();
		 try {
				TestUtil.captureScreenshot(pageName);
			} catch (IOException e) {
			e.printStackTrace();
			}
		 driver.findElement(By.xpath(or.getProperty("MAMoreAboutYouNextBtn_XPATH"))).click();		 
	}

	public void doAddSSNPregYes(){
		
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveSSNDD_XPATH")))); 
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("MADoYouHaveSSNYes_XPATH"))).click();
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MASSNTextBox_XPATH"))));           // Wait to Click on Address Line 1 
		 element.sendKeys("444444136");	
		 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenYes_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("IsFemaleCurrentlyPregnantDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("IsFemaleCurrentlyPregnantYes_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("HowManyChildrenExpecting_XPATH"))).sendKeys("1");
		 driver.findElement(By.xpath(or.getProperty("CurrentlyPregDueDate_XPATH"))).sendKeys("12/10/2010");
		 TestUtil.captureAScreenshot();
		 driver.findElement(By.xpath(or.getProperty("MAMoreAboutYouNextBtn_XPATH"))).click();	
		 
	}
	
}
