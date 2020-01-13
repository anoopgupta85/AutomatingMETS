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

public class SmokeTest extends TestBase{

	
/* *********************************************************	
 * Project : Federal Tax Credit 
 * @author  Anoop Gupta
 * @version  4.11.1
 * @since 2017 - 03 -10
 * Coding Language Used : Java, Selenium
 *  
 * <h1> Submit the Citizen Portal application for Federal Tax Credit Project<h1>
 * 
 */
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void smokeTest(Hashtable<String,String> data){
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver.findElement(By.xpath(or.getProperty("LoginPageUserName_XPATH"))).sendKeys(data.get("UserName"));   //<Anoop Gupta>Input User Name
		driver.findElement(By.xpath(or.getProperty("LoginPagePassword_XPATH"))).sendKeys(data.get("Password"));      //<Anoop Gupta>Input Password
		try {
			TestUtil.captureScreenshot();                                  //<Anoop Gupta> Capture screenshot after input Login and password
		} catch (IOException e1) {		
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(or.getProperty("LoginPageSignIn_XPATH"))).click();        //<Anoop Gupta> Clicked on SignIn Button
		wait = new WebDriverWait(driver, 30);
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("HomePageForIndAndFamContinueBtn_XPATH"))));  // <Anoop Gupta> Wait for Continue button to be enabled.
		element.click();    // <Anoop Gupta> Click on Continue button.
		
		if(data.get("TT").equals("Y")){                  // <Anoop Gupta> apply condition for Time Travel.
		
		//<Anoop Gupta> Below code is for Time Travel
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		 
		 driver.findElement(By.xpath(or.getProperty("LoginForTTUserName_XPATH"))).sendKeys(data.get("UserName"));  //<Anoop Gupta>Input User Name
		 driver.findElement(By.xpath(or.getProperty("LoginForTTPswd_XPATH"))).sendKeys(data.get("Password"));  //<Anoop Gupta>Input Password
		 driver.findElement(By.xpath(or.getProperty("LoginForTTSignIn_XPATH"))).click();		  //<Anoop Gupta> Clicked on SignIn Button
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		}	 
		 //<Anoop Gupta> Until this line it is for TT
		
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("ApplyandEnrollWithFinancial_XPATH"))));   //<Anoop Gupta> Click on Apply and Enroll with Financial Aid.
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
		   }
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
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("InfAbtyouAddressLine1_XPATH"))));           //<Anoop Gupta>Wait to Click on Address Line 1 
			 element.sendKeys("948 field Street");	
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouAddressLine2_XPATH"))).sendKeys("Near Water tunki");
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouAptSuit_XPATH"))).sendKeys("12");
			 driver.findElement(By.xpath(or.getProperty("InfAbtyouCity_XPATH"))).sendKeys("IGHeights");
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
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MASSNTextBox_XPATH"))));          //<Anoop Gupta> Wait to Click on Address Line 1 
				// element.sendKeys("444444144");	
				 element.sendKeys(data.get("SSN"));	
		
				 //<Anoop Gupta> Updated the code for recent application changes due to Federal Tax Credit. 
				 driver.findElement(By.xpath(or.getProperty("STST1InfyAbtYouSSNReenter_XPATH"))).sendKeys(data.get("SSN"));	 
				 driver.findElement(By.xpath(or.getProperty("STST1MAAreYouaUSCitizenDD_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("STST1MAAreYouaUSCitizenYes_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("STST1MAMoreAboutYouNextBtn_XPATH"))).click();
				 try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			//	 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("STST1MASSNConfIsThisCorrectSSNDD_XPATH"))));           //<Anoop Gupta>Wait to Click on Next Button on Household section
				 element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("STST1MASSNConfIsThisCorrectSSNDD_XPATH"))));  
				 element.click(); 
				// driver.findElement(By.xpath(or.getProperty("STST1MASSNConfIsThisCorrectSSNDD_XPATH"))).click(); 
				 driver.findElement(By.xpath(or.getProperty("STST1MASSNConfIsThisCorrectSSNYes_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("STST1MASSNConfNxtBtn_XPATH"))).click();
	
			 try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAPleaseTellUsAbtUrHouseHoldNxtBtn_XPATH"))));          //<Anoop Gupta>Wait to Click on Next Button on Household section
			 element.click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldDD_XPATH"))));          //<Anoop Gupta> Wait to Click on Drop Down on Other Household Members
			 element.click(); 
			 driver.findElement(By.xpath(or.getProperty("MAAnyoneElseInHouseHoldNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAOtherHHMembersNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			 
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("MAAnyoneExpectToFiletaxes_XPATH"))));         //<Anoop Gupta> Wait to Click on check box for anyone filinf taxes
			 element.click(); 
			 
			 driver.findElement(By.xpath(or.getProperty("MATaxFilerInfoNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(or.getProperty("MATaxDependentInfoAnyOneDpndDD_XPATH")))); 
			 element.click(); 
			 driver.findElement(By.xpath(or.getProperty("MATaxDependentInfoAnyOneDpndNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MATaxDependentInfoNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAHHSummaryPageNextBtn_XPATH"))));         //<Anoop Gupta>Wait to Click on Next button on Household Summary page
			 element.click();
			 try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MATellUsYourIncomeNxtBtn_XPATH"))));           //<Anoop Gupta>Wait to Click on Next button on Tell us your income page
			 element.click();
			 try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 boolean AnnualIncome = isElementPresent(By.xpath(or.getProperty("MADoYouHaveAnyIncomeDD_XPATH"))); 
			 
			System.out.println(AnnualIncome);
			 
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MADoYouHaveAnyIncomeDD_XPATH"))));           //<Anoop Gupta> Wait to Click on Drop down on income information page
			 element.click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveAnyIncomeYes_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MADoYouHaveAnyIncomeNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 
			 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MATypeOfIncomeDD_XPATH"))));          //<Anoop Gupta> Wait to Click on Income Type Drop down 
			 element.click();
			 
			 driver.findElement(By.xpath(or.getProperty("MAIncomeTypeWagesBeforeTaxes_XPATH"))).click();                //<Anoop Gupta>Select Wages Before Taxes
			 try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 //<Anoop Gupta> Updated below code to fix defect 33305 and 33306 for Federal Tax Credit Project.
			 driver.findElement(By.xpath(or.getProperty("MANameOfEmployer_XPATH"))).sendKeys("Walmart");                           //<Anoop Gupta> Input Walmart
			 driver.findElement(By.xpath(or.getProperty("MASeasonalEmployedDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MASeasonalEmployedNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAIncomeAmount_XPATH"))).sendKeys(data.get("Income"));
			 driver.findElement(By.xpath(or.getProperty("MAIncomeFrequencyDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAIncomeFrequencyYearly_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAnyOtherIncomeDD_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAAnyOtherIncomeNo_XPATH"))).click();
			 driver.findElement(By.xpath(or.getProperty("MAEnterIncomeDetailsNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			 
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("MAAdditionalIncomeDetailsNxtBtn_XPATH"))));													   //<Anoop Gupta> Click on Next Button on Additional income details
			 element.click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 driver.findElement(By.xpath(or.getProperty("MAIncomeAdjustmentsNxtBtn_XPATH"))).click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 boolean nxtYrIncomeQ = isElementPresent(By.xpath(or.getProperty("MAAnnualIncomeNextYearIncomeDD_XPATH")));
			 if(nxtYrIncomeQ == true){
				 
				 driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNextYearIncomeDD_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNextYearIncomeYes_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeWithNextYearQNxtBtn_XPATH"))).click();
			 }	
		 
		else {
		driver.findElement(By.xpath(or.getProperty("MAAnnualIncomeNxtBtn_XPATH"))).click();
			 }
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAMoreAbtYourHHNextBtn_XPATH"))));           // 
			 element.click();
			 try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 pageHeading = driver.findElement(By.xpath(or.getProperty("MAAdditionalInfoHeading_XPATH"))).getText();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 
			 
			 if (pageHeading.equals( "Additional Information for Medicaid/CHIP Applicants")){
				 
				 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAAdditionalInfoForMedicaidChipNextBtn_XPATH"))));           // 
				 element.click();
				 try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				 
				 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("MAEmployerSponsoredCovInfoNextBtn_XPATH"))));           // 
				 element.click();
				 try {
						Thread.sleep(5000);
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
							Thread.sleep(5000);
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
					Thread.sleep(5000);
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
			 
			 boolean maApp = isElementPresent(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown13_XPATH")));
			 if (maApp == true){
				 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown13_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltDropDown13No_XPATH"))).click();
				 driver.findElement(By.xpath(or.getProperty("MAAddtnInfoForAllApltNextBtn_XPATH"))).click();
				 
			 }
			 else {
				 
				 driver.findElement(By.xpath(or.getProperty("IAAddtnInfoForAllApltNextBtn_XPATH"))).click();
			 }
			
			 try {
					Thread.sleep(6000);
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
					Thread.sleep(8000);
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
			  if (data.get("Env").equals("STST1")){
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageFirstName_XPATH"))).sendKeys(data.get("Fname"));
			 driver.findElement(By.xpath(or.getProperty("MAFinalPageLastName_XPATH"))).sendKeys(data.get("Lname"));
			  }
			  else {
					 driver.findElement(By.xpath(or.getProperty("MAFinalPageFirstName_XPATH"))).sendKeys("SS" + data.get("Fname"));
					 driver.findElement(By.xpath(or.getProperty("MAFinalPageLastName_XPATH"))).sendKeys("SS" +data.get("Lname"));  
			  }
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
			 
	}
	
	
}
