package com.w2a.pages.InformationAboutYou;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.Page;
import com.w2a.pages.MoreAboutYou;
import com.w2a.utilities.TestUtil;

public class InformationAbtYou extends Page {
	
	public void doInputInformationBeforeHomeless(String FName, String LName, String DOB ){
		
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		   
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouFrstName_XPATH"))).sendKeys("SSDonald");
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouLastName_XPATH"))).sendKeys("SSSteve");
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderDD_XPATH"))).click();
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderMale_XPATH"))).click();
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouMaritalStatusDD_XPATH"))).click();
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouMarried_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouDOB_XPATH"))).sendKeys("01/10/1985");
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouDoYouLiveInMNDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouYesILive_XPATH"))).click();
			 	
	}

	public void doNoHomeless(){
		
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouAreuHomelessDD_XPATH"))));
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouNoAmNotHomeLess_XPATH"))).click();
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouAddressLine1_XPATH"))));           // Wait to Click on Address Line 1 
		 element.sendKeys("926 field St");	
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouAddressLine2_XPATH"))).sendKeys("Near Water Tank");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouAptSuit_XPATH"))).sendKeys("11");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouCity_XPATH"))).sendKeys("Inver Grove Heights");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouCountyDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouCountyDakota_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouStateDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouStateMN_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouZipCode_XPATH"))).sendKeys("55077");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouMailingAdrSameAsHomeDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouMailingAdrSameAsHomeYes_XPATH"))).click();
		
	}
	
	public void doHomeless(){
		
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouAreuHomelessDD_XPATH"))));
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouAmHomeLess_XPATH"))).click();
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouCountyYouLiveInDD_XPATH"))));
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouCountyYouDakota_XPATH"))).click();
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouYouMailingAddressDD_XPATH"))));
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouYouMailingAddressYes_XPATH"))).click();
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouHLMailingAddr1_XPATH"))));           // Wait to Click on Address Line 1 
		 element.sendKeys("926 field St");	
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouHLMailingAddr2_XPATH"))).sendKeys("Near Water Tank");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouHLAptSuite_XPATH"))).sendKeys("11");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouHLCity_XPATH"))).sendKeys("Inver Grove Heights");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouHLCountyDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouHLCountyDakota_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouHLStateDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouHLStateMN_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouHLZip_XPATH"))).sendKeys("55077");
	}
	
	public MoreAboutYou doGoToSSNPage(){
		
		driver.findElement(By.xpath(or.getProperty("InfAbtyouPlantoMakeMNHomeDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouPlantoMakeMNHomeYes_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAPreferredContactMethodDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAPreferredContactMethodMail_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAVoterRegCardDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAVoterRegCardNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAPreferToReceiveNoticeDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAPreferToReceiveNoticeMail_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAAuthroizedRepresentativeDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAAuthroizedRepresentativeNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAApplyingForUrselfDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("MAApplyingForUrselfYes_XPATH"))).click();
		 try {
				TestUtil.captureScreenshot(pageName);
			} catch (IOException e) {
			e.printStackTrace();
			}
		 driver.findElement(By.xpath(or.getProperty("MAInformationAbtYouNextBtn_XPATH"))).click();
		 
		 return new MoreAboutYou();
	}
}
