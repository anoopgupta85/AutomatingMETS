package com.w2a.testCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;







public class UUQHPSmokeTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void UUQHPApplication(Hashtable<String,String> data) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver.findElement(By.xpath(or.getProperty("LoginPageUserName_XPATH"))).sendKeys(data.get("UserName"));
		driver.findElement(By.xpath(or.getProperty("LoginPagePassword_XPATH"))).sendKeys("Welcome1#");
		driver.findElement(By.xpath(or.getProperty("LoginPageSignIn_XPATH"))).click();
		wait = new WebDriverWait(driver, 30);
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("HomePageForIndAndFamContinueBtn_XPATH")))); 
		element.click();
		
		
		if(data.get("TT").equals("Y")){
		
		 // Below Lines of Code are only for TT
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
	e1.printStackTrace();
		}
	 driver.findElement(By.xpath(or.getProperty("LoginForTTUserName_XPATH"))).sendKeys(data.get("UserName"));
	 driver.findElement(By.xpath(or.getProperty("LoginForTTPswd_XPATH"))).sendKeys("Welcome1#");
	 driver.findElement(By.xpath(or.getProperty("LoginForTTSignIn_XPATH"))).click();		 
	 
		}
		 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("ApplyandEnrollWithoutFinancial_XPATH")))); 
		 element.click();
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		 
		 frames = driver.findElements(By.tagName("iframe"));
		 log.debug(frames.size());
		 driver.switchTo().frame(0);
		 
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("GettingStartedLink_XPATH"))));
		 element.click();
		 
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("ApplyingWithoutAssistCheckBox_XPATH")))); 
		 element.click();	
		 
		 driver.findElement(By.xpath(or.getProperty("ApplyingWithoutAssistNextBtn_XPATH"))).click();
		 
		 try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouFrstName_XPATH"))).sendKeys("Josh");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouLastName_XPATH"))).sendKeys("Kumar");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderMale_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouMaritalStatusDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouNeverMarried_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouDOB_XPATH"))).sendKeys("01/10/1991");
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouDoYouLiveInMNDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouYesILive_XPATH"))).click();
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
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouPlantoMakeMNHomeDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouPlantoMakeMNHomeYes_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouAreYouHispanicDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouAreYouHispanicNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouAreAsianChkbox_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouAreyouapplyingforyourselfDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouAreyouapplyingforyourselfYes_XPATH"))).click();
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouAreUUSCitizenDD_XPATH"))));
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouAreUUSCitizenYes_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouDoYouHaveSSNDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("InfAbtyouDoYouHaveSSNYes_XPATH"))).click();
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouSSNInputBox_XPATH"))));           // Wait to Click on Address Line 1 
		// element.sendKeys("567442638");			 
	 element.sendKeys(data.get("SSN"));	
	//	 element.sendKeys("234567037");
	
		 
		 driver.findElement(By.xpath(or.getProperty("STST1SSNReenterInputBox_XPATH"))).sendKeys(data.get("SSN"));
		 driver.findElement(By.xpath(or.getProperty("STST1InJailDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1InJailNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1MedicareInsuranceDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1MedicareInsuranceNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1TobacoDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1TobacoNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1AmericanalaskanDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1AmericanalaskanNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1PreferredContactDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1PreferredContactMail_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1VoterRegCardDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1VoterRegCardNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1ReceiveNoticesDD_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1ReceiveNoticesMail_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1NextButton_XPATH"))).click();
		 try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("STST1CorrectSSNDD_XPATH")))); 
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("STST1CorrectSSNYES_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("STST1SSNConfirm_NextBtn_XPATH"))).click();
		 try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 	 
	

		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("OthHHMembAnyOneElseInHHDD_XPATH"))));           // Wait to Click on Address Line 1 
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("OthHHMembAnyOneElseInHHNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("OthHHMembAnyOneElseInHHNextBtn_XPATH"))).click();
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("SummaryNextBtn_XPATH"))));           // Wait to Click on Address Line 1 
		 element.click();
		 try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("SignatureMNsureAssisterDD_XPATH"))));           // Wait to Click on Address Line 1 
		 element.click();
		 driver.findElement(By.xpath(or.getProperty("SignatureMNsureAssisterNo_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("SignatureAppChangesCheckBox_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("SignaturePPCheckBox_XPATH"))).click();
		 driver.findElement(By.xpath(or.getProperty("SignatureFName_XPATH"))).sendKeys("Josh");
		 driver.findElement(By.xpath(or.getProperty("SignatureLName_XPATH"))).sendKeys("Kumar");
		 driver.findElement(By.xpath(or.getProperty("SignatureSubmitBtn_XPATH"))).click();
		 Reporter.log("UUQHP application created Successfully - Smoke Test Pass");
		 try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 Reporter.log("<a target = \"_blank\" href = \"H:\\Selenium\\SeleniumSS.jpeg\">Screenshot</a>");
		 Reporter.log("<br>");
		 Reporter.log("<a target = \"_blank\" href = \"H:\\Selenium\\SeleniumSS.jpeg\"><img src =\"H:\\Selenium\\SeleniumSS.jpeg\" height = 200 width = 200></img></a>");
	}
	
	
}
