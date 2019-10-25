package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class HHMembersDetails extends Page{
	
	public HHMemberExtraDetails doADDHHMember(){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath(or.getProperty("InfAbtyouFrstName_XPATH"))).sendKeys("SSDonaldOne");
		driver.findElement(By.xpath(or.getProperty("InfAbtyouMdlName_XPATH"))).sendKeys("Mangal");
		driver.findElement(By.xpath(or.getProperty("InfAbtyouLastName_XPATH"))).sendKeys("SSSteveOne");
		driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderDD_XPATH"))).click();
		driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderFemale_XPATH"))).click();
		driver.findElement(By.xpath(or.getProperty("InfAbtyouMaritalStatusDD_XPATH"))).click();
		driver.findElement(By.xpath(or.getProperty("InfAbtyouMarried_XPATH"))).click();
		driver.findElement(By.xpath(or.getProperty("InfAbtyouDOB_XPATH"))).sendKeys("01/10/1991");
		driver.findElement(By.xpath(or.getProperty("DoesThisPersonLiveWithYouDD_XPATH"))).click();
		driver.findElement(By.xpath(or.getProperty("DoesThisPersonLiveWithYouYes_XPATH"))).click();
		driver.findElement(By.xpath(or.getProperty("PlanToMakeMNHomeDD_XPATH"))).click();
		driver.findElement(By.xpath(or.getProperty("PlanToMakeMNHomeYes_XPATH"))).click();
		driver.findElement(By.xpath(or.getProperty("AreYouApplyingForThePersonHighLightedDD_XPATH"))).click();
		driver.findElement(By.xpath(or.getProperty("AreYouApplyingForThePersonHighLightedYes_XPATH"))).click();
		try {
			TestUtil.captureScreenshot(pageName);
		} catch (IOException e) {
		e.printStackTrace();
		}
		driver.findElement(By.xpath(or.getProperty("HHMembersNextBtn_XPATH"))).click();
		
		return new HHMemberExtraDetails();
	}

}
