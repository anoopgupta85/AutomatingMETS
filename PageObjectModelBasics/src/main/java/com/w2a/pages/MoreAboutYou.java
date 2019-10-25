package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class MoreAboutYou extends Page {
	
	public void dohaveSSN(){
		
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
		
	}

	public void doNotHaveSSNButAppliedSSNUSCitizen(){
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveSSNDD_XPATH")))); 
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("MADoYouHaveSSNNo_XPATH"))).click();
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAHaveYouAppliedForSSNDD_XPATH")))); 
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("MAHaveYouAppliedForSSNYes_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenYes_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAMoreAboutYouNextBtn_XPATH"))).click();
		
	}
	
	public void doNotHaveSSNAndNotAppliedSSNUSCitizen(){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveSSNDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MADoYouHaveSSNNo_XPATH"))).click();
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAHaveYouAppliedForSSNDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MAHaveYouAppliedForSSNNo_XPATH"))).click();
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAReasonForNotHavingASSNDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MANoSSNDueToReligiousObj_XPATH"))).click();
	 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenDD_XPATH"))).click();
	 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenYes_XPATH"))).click();
	 driver.findElement(By.xpath(or.getProperty("MAMoreAboutYouNextBtn_XPATH"))).click();
	}
	
	public SupportingDocumentPage doNotHaveSSNButAppliedSSNAndNotUSCitizen(){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveSSNDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MADoYouHaveSSNNo_XPATH"))).click();
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAHaveYouAppliedForSSNDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MAHaveYouAppliedForSSNYes_XPATH"))).click();
	 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenDD_XPATH"))).click();
	 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenNo_XPATH"))).click();
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAreYouaUSNationalDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSNationalNo_XPATH"))).click();
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAreYouLawfullyPresentDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MAAreYouLawfullyPresentYes_XPATH"))).click();
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAImmigrationStatusDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MAImmigrationStatusLPR_XPATH"))).click();
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADidImmigrationStatusQuestionDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MADidImmigrationStatusQuestionNo_XPATH"))).click();
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADidYouEnterBeforeAug221996DD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MADidYouEnterBeforeAug221996No_XPATH"))).click();
	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAResidedInUSForMoreThanFiveYearsDD_XPATH")))); 
	 element.click();
	 driver.findElement(By.xpath(or.getProperty("MAResidedInUSForMoreThanFiveYearsYes_XPATH"))).click();
	 driver.findElement(By.xpath(or.getProperty("MADateOfEntry_XPATH"))).sendKeys("10/10/2010");
	 driver.findElement(By.xpath(or.getProperty("MASupportingDocumentDD_XPATH"))).click();
	 driver.findElement(By.xpath(or.getProperty("MASupportingDocumentI94_XPATH"))).click();
	 TestUtil.captureAScreenshot();
	 driver.findElement(By.xpath(or.getProperty("MAMoreAboutYouNextBtn_XPATH"))).click();
	 
	 return new SupportingDocumentPage();
	}
	
}
