package com.w2a.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class MATTSmokeTest extends TestBase{
	
	@Test
	public void MAApplication(){
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver.findElement(By.xpath(or.getProperty("LoginPageUserName_XPATH"))).sendKeys("Zafartc145");
		driver.findElement(By.xpath(or.getProperty("LoginPagePassword_XPATH"))).sendKeys("Welcome1#");
		driver.findElement(By.xpath(or.getProperty("LoginPageSignIn_XPATH"))).click();
		wait = new WebDriverWait(driver, 30);
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("HomePageForIndAndFamContinueBtn_XPATH")))); 
		element.click();
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		 
		 driver.findElement(By.xpath(or.getProperty("LoginForTTUserName_XPATH"))).sendKeys("Zafartc145");
 		 driver.findElement(By.xpath(or.getProperty("LoginForTTPswd_XPATH"))).sendKeys("Welcome1#");
		 driver.findElement(By.xpath(or.getProperty("LoginForTTSignIn_XPATH"))).click();		 
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("ApplyandEnrollWithFinancial_XPATH")))); 
        element.click();
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
		 
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("ApplyingWithoutAssistCheckBox_XPATH")))); 
		 element.click();	
		 
		 driver.findElement(By.xpath(or.getProperty("ApplyingWithoutAssistNextBtn_XPATH"))).click();
		 
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("PleaseTellAbtYouNextBtn_XPATH")))); 
		   element.click();
        
		   //  Information About you
		   try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		   
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouFrstName_XPATH"))).sendKeys("SSRonald");
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouLastName_XPATH"))).sendKeys("SSPitts");
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
			 driver.findElement(By.xpath(or.getProperty("MAInformationAbtYouNextBtn_XPATH"))).click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveSSNDD_XPATH")))); 
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveSSNYes_XPATH"))).click();
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MASSNTextBox_XPATH"))));           // Wait to Click on Address Line 1 
			 element.sendKeys("444444159");	
			//element.sendKeys("567442612");	
			 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAreYouaUSCitizenYes_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAMoreAboutYouNextBtn_XPATH"))).click();
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAPleaseTellUsAbtUrHouseHoldNxtBtn_XPATH"))));           // Wait to Click on Next Button on Household section
			 element.click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldDD_XPATH"))));           // Wait to Click on Drop Down on Other Household Members
			 element.click(); 
			 driver.findElement(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAOtherHHMembersNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			 
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("MAAnyoneExpectToFiletaxes_XPATH"))));           // Wait to Click on check box for anyone filinf taxes
			 element.click(); 
			 driver.findElement(By.xpath(or.getProperty("MATaxFilerInfoNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("MATaxDependentInfoAnyOneDpndDD_XPATH")))); 
			 element.click(); 
			 driver.findElement(By.xpath(or.getProperty("MATaxDependentInfoAnyOneDpndNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MATaxDependentInfoNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAHHSummaryPageNextBtn_XPATH"))));           // Wait to Click on Next button on Household Summary page
			 element.click();
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MATellUsYourIncomeNxtBtn_XPATH"))));           // Wait to Click on Next button on Tell us your income page
			 element.click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveAnyIncomeDD_XPATH"))));           // Wait to Click on Drop down on income information page
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveAnyIncomeYes_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveAnyIncomeNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MATypeOfIncomeDD_XPATH"))));           // Wait to Click on Income Type Drop down 
			 element.click();
			 
			 driver.findElement(By.xpath(or.getProperty("MAIncomeTypeWagesBeforeTaxes_XPATH"))).click();                 // Select Wages Before Taxes
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 driver.findElement(By.xpath(or.getProperty("MANameOfEmployer_XPATH"))).sendKeys("Walmart");                           // Input Walmart
			 driver.findElement(By.xpath(or.getProperty("MASeasonalEmployedDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MASeasonalEmployedNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAIncomeAmount_XPATH"))).sendKeys("12000");
			 driver.findElement(By.xpath(or.getProperty("MAIncomeFrequencyDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAIncomeFrequencyYearly_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAnyOtherIncomeDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAnyOtherIncomeNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAEnterIncomeDetailsNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MAAdditionalIncomeDetailsNxtBtn_XPATH"))));													    // Click on Next Button on Additional income details
			 element.click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 driver.findElement(By.xpath(or.getProperty("MAIncomeAdjustmentsNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAMoreAbtYourHHNextBtn_XPATH"))));           // 
			 element.click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAdditionalInfoForMedicaidChipNextBtn_XPATH"))));           // 
			 element.click();
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAEmployerSponsoredCovInfoNextBtn_XPATH"))));           // 
			 element.click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown1_XPATH"))));           // 
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown1No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown2_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown2No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown3_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown3No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown4_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown4No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown5_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown5No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown6_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown6No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown7_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown7No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown8_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown8No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown9_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown9No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown10_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown10No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown11_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown11No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown12_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown12No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown13_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown13No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltNextBtn_XPATH"))).click();
			 try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MASummaryPageNextBtn_XPATH"))));           // 
			 element.click();
			 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAssisterDD_XPATH"))));           // 
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("MAAssisterNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageFirstCheckBox_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageSecondCheckBox_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageThirdCheckBox_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageFourthCheckBox_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageFirstName_XPATH"))).sendKeys("SSRonald");
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageLastName_XPATH"))).sendKeys("SSPitts");
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageSubmitBtn_XPATH"))).click();
	}
	
 

}
