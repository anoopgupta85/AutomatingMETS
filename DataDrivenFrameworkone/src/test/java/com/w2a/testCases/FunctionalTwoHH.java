package com.w2a.testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class FunctionalTwoHH extends TestBase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void functionalTwoHH(Hashtable<String,String> data){
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver.findElement(By.xpath(or.getProperty("LoginPageUserName_XPATH"))).sendKeys(data.get("UserName"));
		driver.findElement(By.xpath(or.getProperty("LoginPagePassword_XPATH"))).sendKeys(data.get("Password"));
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e1) {		
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(or.getProperty("LoginPageSignIn_XPATH"))).click();
		wait = new WebDriverWait(driver, 30);
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("HomePageForIndAndFamContinueBtn_XPATH")))); 
		element.click();
		
		if(data.get("TT").equals("Y")){
		
		// Below code is for Time Travel
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		 
		 driver.findElement(By.xpath(or.getProperty("LoginForTTUserName_XPATH"))).sendKeys(data.get("UserName"));
		 driver.findElement(By.xpath(or.getProperty("LoginForTTPswd_XPATH"))).sendKeys(data.get("Password"));
		 driver.findElement(By.xpath(or.getProperty("LoginForTTSignIn_XPATH"))).click();		 
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		}	 
		 // Until this line it is for TT
		
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
		   
		   if (data.get("Env").equals("STST1")){
			   driver.findElement(By.xpath(or.getProperty("InfAbtyouFrstName_XPATH"))).sendKeys(data.get("Fname"));
			   driver.findElement(By.xpath(or.getProperty("InfAbtyouLastName_XPATH"))).sendKeys(data.get("Lname"));
			   }
			   else{
				   driver.findElement(By.xpath(or.getProperty("InfAbtyouFrstName_XPATH"))).sendKeys("SS"+data.get("Fname"));
				   driver.findElement(By.xpath(or.getProperty("InfAbtyouLastName_XPATH"))).sendKeys("SS"+data.get("Lname")); 
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderDD_XPATH"))).click();
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderMale_XPATH"))).click();
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouMaritalStatusDD_XPATH"))).click();
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouMarried_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouDOB_XPATH"))).sendKeys("01/10/1991");
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouDoYouLiveInMNDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouYesILive_XPATH"))).click();
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouAreuHomelessDD_XPATH"))));
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouNoAmNotHomeLess_XPATH"))).click();
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouAddressLine1_XPATH"))));           // Wait to Click on Address Line 1 
			 element.sendKeys("948 field Street");	
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouAddressLine2_XPATH"))).sendKeys("Near Water tunki");
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouAptSuit_XPATH"))).sendKeys("12");
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
				// element.sendKeys("444444144");	
				 element.sendKeys(data.get("SSN"));	
			
				 
				 driver.findElement(By.xpath(or.getProperty("STST1InfyAbtYouSSNReenter_XPATH"))).sendKeys(data.get("SSN"));	 
				 driver.findElement(By.xpath(or.getProperty("STST1MAAreYouaUSCitizenDD_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("STST1MAAreYouaUSCitizenYes_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("STST1MAMoreAboutYouNextBtn_XPATH"))).click();
				 try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("STST1MASSNConfIsThisCorrectSSNDD_XPATH"))));           // Wait to Click on Next Button on Household section
				 element.click(); 
				 driver.findElement(By.xpath(or.getProperty("STST1MASSNConfIsThisCorrectSSNYes_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("STST1MASSNConfNxtBtn_XPATH"))).click();
	
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAPleaseTellUsAbtUrHouseHoldNxtBtn_XPATH"))));           // Wait to Click on Next Button on Household section
			 element.click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldDD_XPATH"))));           // Wait to Click on Drop Down on Other Household Members
			 element.click(); 
			 
			 //  **********  Code for 2 HH starts from here **********************************************************************
			 
			 driver.findElement(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldYes_XPATH"))).click();			
			 driver.findElement(By.xpath(or.getProperty("MAOtherHHMembersNxtBtn_XPATH"))).click();
			 
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			 if (data.get("Env").equals("STST1")){
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("InfAbtyouFrstName_XPATH")))); 			  
			 element.sendKeys(data.get("R1_Fname"));
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouLastName_XPATH"))).sendKeys(data.get("R1_Lname"));
			 } else {
				 element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("InfAbtyouFrstName_XPATH")))); 			  
				 element.sendKeys("SS"+data.get("R1_Fname"));
				 driver.findElement(By.xpath(or.getProperty("InfAbtyouLastName_XPATH"))).sendKeys("SS"+data.get("R1_Lname"));
			 }
				 
			 
			 
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderFemale_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouMaritalStatusDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouMarried_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouDOB_XPATH"))).sendKeys("01/10/1986");
		     driver.findElement(By.xpath(or.getProperty("DoesThisPrsnLiveWthYouDD_XPATH"))).click(); 
			 driver.findElement(By.xpath(or.getProperty("DoesThisPrsnLiveWthYouYes_XPATH"))).click(); 
		     driver.findElement(By.xpath(or.getProperty("PlanToMakeMNHomeDD_XPATH"))).click();
		     driver.findElement(By.xpath(or.getProperty("PlanToMakeMNHomeYes_XPATH"))).click();
		     driver.findElement(By.xpath(or.getProperty("ApplyingForPrsnHighDD_XPATH"))).click();
		     driver.findElement(By.xpath(or.getProperty("ApplyingForPrsnHighYes_XPATH"))).click();
		     driver.findElement(By.xpath(or.getProperty("HHMemberDetailNxtBtn_XPATH"))).click();
		     try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
		     element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveSSNDD_XPATH")))); 
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveSSNYes_XPATH"))).click();
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MASSNTextBox_XPATH"))));           // Wait to Click on Address Line 1 
				// element.sendKeys("444444144");	
		     element.sendKeys(data.get("R1_SSN"));	
		   
				 
				 driver.findElement(By.xpath(or.getProperty("STST1InfyAbtYouSSNReenter_XPATH"))).sendKeys(data.get("R1_SSN"));	 
				 driver.findElement(By.xpath(or.getProperty("STST1MAAreYouaUSCitizenDD_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("STST1MAAreYouaUSCitizenYes_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("HHMemberExtraDetailNxtBtn_XPATH"))).click();
				 try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("STST1MASSNConfIsThisCorrectSSNDD_XPATH"))));           // Wait to Click on Next Button on Household section
				 element.click(); 
				 driver.findElement(By.xpath(or.getProperty("STST1MASSNConfIsThisCorrectSSNYes_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("STST1MASSNConfNxtBtn_XPATH"))).click();
			
		     
		     // Will start from here tomorrow.
			
		     // If Spouse is a US Citizen DD and Answer
		     
		   
		     
		 
		    // More People Page? Click on Do you need to add any more people?
		     
		     try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		     
		     element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldDD_XPATH"))));           
			 element.click(); 
			 
			 // Select No
			 
			 driver.findElement(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldNo_XPATH"))).click();
			 
			 // Click on Next Button
			 
			 driver.findElement(By.xpath(or.getProperty("MAOtherHHMembersWithOneDpndntNxtBtn_XPATH"))).click();
			 
			 //Relation Ship Page 
			 
			 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("PrimaryRltnToScndryDD_XPATH"))));      
			 element.click();
			 
			 //Primary is Spouse of Secondary
			 
			 driver.findElement(By.xpath(or.getProperty("PrimarySpsOfScndry_XPATH"))).click();
			 
			 //Click on Next Button
			 
			 driver.findElement(By.xpath(or.getProperty("RelationShipPageNxtBtn_XPATH"))).click();
			 
			 // Tax Filer Information - Anyone expects to File Taxes
			 
			 //Primary Check Box 
			 
			 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("MAAnyoneExpectToFiletaxes_XPATH"))));           // Wait to Click on check box for anyone filinf taxes
			 element.click(); 
			 
			 //Spouse Check Box
			 
			 driver.findElement(By.xpath(or.getProperty("ScndryTaxFileChkBox_XPATH"))).click();
			 
			 //Click on Next Button
			 
			 driver.findElement(By.xpath(or.getProperty("MATaxFilerInfoNxtBtn_XPATH"))).click();
			 
			 // Married Couple Tax Filing Jointly
			 
			 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("MrdCplFilingJointlyDD_XPATH")))); 
			 element.click();  
			 // Select Yes
			 
			 driver.findElement(By.xpath(or.getProperty("MrdCplFilingJointlyYes_XPATH"))).click(); 
			 
			 //Click on Next
			 
			 driver.findElement(By.xpath(or.getProperty("MrdCplFilingJointlyNxtBtn_XPATH"))).click(); 
			 
			// Click on next Button on Household Summary Page
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAHHSummaryPageNextBtn_XPATH"))));           // Wait to Click on Next button on Household Summary page
			 element.click();
			 
			 // Income Section - Please Tell us about your Household Income
	
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 // Click on Next Page.
			 
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MATellUsYourIncomeNxtBtn_XPATH"))));           // Wait to Click on Next button on Tell us your income page
			 element.click();
			 
			 //Income Information Primary
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 //Click on DD for Does Primary has Income
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveAnyIncomeDD_XPATH"))));           // Wait to Click on Drop down on income information page
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveAnyIncomeYes_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveAnyIncomeNxtBtn_XPATH"))).click();
			 
			 //Enter Income Details Page - 
			 
			 try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 // Income Type Drop Down
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MATypeOfIncomeDD_XPATH"))));           // Wait to Click on Income Type Drop down 
			 element.click();
			 // Wages Before Taxes
			 driver.findElement(By.xpath(or.getProperty("MAIncomeTypeWagesBeforeTaxes_XPATH"))).click();                 // Select Wages Before Taxes
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 // Name Of Employer
			 driver.findElement(By.xpath(or.getProperty("MANameOfEmployer_XPATH"))).sendKeys("Walmart");                           // Input Walmart
			 
			 driver.findElement(By.xpath(or.getProperty("MASeasonalEmployedDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MASeasonalEmployedNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAIncomeAmount_XPATH"))).sendKeys(data.get("Income"));
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
			
			 //Additional Income Details Page - Primary
			 
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MAAdditionalIncomeDetailsNxtBtn_XPATH"))));													    // Click on Next Button on Additional income details
			 element.click();
			 			 
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 // Income Adjustment Page - Primary
			 
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MAIncomeAdjustmentsNxtBtn_XPATH"))));													    // Click on Next Button on Additional income details
			 element.click();
			 
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 // If Next Year Income Question Present - Annual Income Page
			 boolean nxtYrIncomeQ = isElementPresent(By.xpath(or.getProperty("MAAnnualIncomeNextYearIncomeDD_XPATH")));
			 if(nxtYrIncomeQ == true){
				 
				 driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNextYearIncomeDD_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNextYearIncomeYes_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeWithNextYearQNxtBtn_XPATH"))).click();
			 }	
		 
		else {
		driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNxtBtn_XPATH"))).click();
			 }
			 
			 // Dependent Income Questions starts from here - Income Information Page - Dependent
			 
			 try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 //Click on DD for Does Secondary has Income
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveAnyIncomeDD_XPATH"))));           // Wait to Click on Drop down on income information page
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveAnyIncomeYes_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveAnyIncomeNxtBtn_XPATH"))).click(); 
			 
 //Enter Income Details Page - 
			 
			 try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 // Income Type Drop Down
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MATypeOfIncomeDD_XPATH"))));           // Wait to Click on Income Type Drop down 
			 element.click();
			 // Wages Before Taxes
			 driver.findElement(By.xpath(or.getProperty("MAIncomeTypeWagesBeforeTaxes_XPATH"))).click();                 // Select Wages Before Taxes
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 // Name Of Employer
			 driver.findElement(By.xpath(or.getProperty("MANameOfEmployer_XPATH"))).sendKeys("Walmart");                           // Input Walmart
			 
			 driver.findElement(By.xpath(or.getProperty("MASeasonalEmployedDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MASeasonalEmployedNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAIncomeAmount_XPATH"))).sendKeys(data.get("R1_Income"));
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
			
			 //Additional Income Details Page - Secondary
			 
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MAAdditionalIncomeDetailsNxtBtn_XPATH"))));													    // Click on Next Button on Additional income details
			 element.click();
			 			 
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 // Income Adjustment Page - Secondary
			 
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MAIncomeAdjustmentsNxtBtn_XPATH"))));													    // Click on Next Button on Additional income details
			 element.click();
			 
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 // If Next Year Income Question Present - Annual Income Page
			  nxtYrIncomeQ = isElementPresent(By.xpath(or.getProperty("MAAnnualIncomeNextYearIncomeDD_XPATH")));
			 if(nxtYrIncomeQ == true){
				 
				 driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNextYearIncomeDD_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNextYearIncomeYes_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeWithNextYearQNxtBtn_XPATH"))).click();
			 }	
		 
		else {
		driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNxtBtn_XPATH"))).click();
			 }
			 
			//Dependent Income questions finishes here 
			 
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 // Additional Household Info Section
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAMoreAbtYourHHNextBtn_XPATH"))));           // 
			 element.click();
			 try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 pageHeading = driver.findElement(By.xpath(or.getProperty("MAAdditionalInfoHeading_XPATH"))).getText();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 
			 if (pageHeading.equals( "Additional Information for Medicaid/CHIP Applicants")){
				 
				 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAdditionalInfoForMedicaidChipNextBtn_XPATH"))));           // 
				 element.click();
				 try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				 
				 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAEmployerSponsoredCovInfoNextBtn_XPATH"))));           // 
				 element.click();
				 try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				 
			 }
				 else if  (pageHeading.equals("Additional APTC Program Information")){
					 
					 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
					 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MCREAdditionalAPTCProgramNxtBtn_XPATH"))));           // 
					 element.click();	 
				 
					 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAEmployerSponsoredCovInfoNextBtn_XPATH"))));           // 
					 element.click();
					 try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					 
			 }
			 
				 else {
					 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
					 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAEmployerSponsoredCovInfoNextBtn_XPATH"))));           // 
					 element.click(); 
					 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
					 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAnnualIncomeNxtBtn_XPATH"))));           // 
					 element.click();
				 }
			 
			
		//	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAEmployerSponsoredCovInfoNextBtn_XPATH"))));           // 
		//   element.click();
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
		
			 
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown1_XPATH"))));           // 
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown1No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown2_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown2No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown3_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown3No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown4_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown4No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown5_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown5No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown6_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown6No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown7_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown7No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown8_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown8No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown9_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown9No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown10_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown10No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown11_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown11No_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown12_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown12No_XPATH"))).click();
			 
			 boolean maApp = isElementPresent(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown13_XPATH")));
			 if (maApp == true){
				 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown13_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllAplt2HHDropDown13No_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltNextBtn_XPATH"))).click();
				 
			 }
			 else {
				 
				 driver.findElement(By.xpath(or.getProperty("IAAddtnInfoForAllApltNextBtn_XPATH"))).click();
			 }
			
			 try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 boolean medBillText = isElementPresent(By.xpath(or.getProperty("MASummaryMdclBillText_XPATH")));
			 
			 if (medBillText == true){
				
				 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
				 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MASummaryPageNextBtn_XPATH"))));           // 
				 element.click();
				 
			 }
			 
			 else {
				 
				 ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
				 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MCRESummaryPageNextBtn_XPATH"))));           // 
				 element.click();
			 }
			 
			
			 try {
					Thread.sleep(5000);
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
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageFirstName_XPATH"))).sendKeys(data.get("Fname"));
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageLastName_XPATH"))).sendKeys(data.get("Lname"));
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageSubmitBtn_XPATH"))).click();
			 try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 try {
					TestUtil.captureScreenshot();
				} catch (IOException e1) {		
					e1.printStackTrace();
				}
			 driver.switchTo().defaultContent();
			 driver.findElement(By.xpath(or.getProperty("SignOutBtn_XPATH"))).click();
			 try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 try {
					TestUtil.captureScreenshot();
				} catch (IOException e1) {		
					e1.printStackTrace();
				}
	}
	
	
	} }



