package com.ag.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.ag.Base.Page;
import com.ag.Pages.Locators.CaseWRegistrationLocators;

public class CaseWRegistration extends Page {
	
	public CaseWRegistrationLocators  registration;
	
	public CaseWRegistration(){
		
		this.registration = new CaseWRegistrationLocators();
		PageFactory.initElements(driver, this.registration);		
	}
	
	public void doCaseWRegistration() {
		
		registration.HCRCasesAndOutcomes.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		 registration.ShortCutArrow.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		 registration.RegistrationArrow.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		 registration.Person.click();
		 
		 frames = driver.findElements(By.tagName("iframe"));
	      driver.switchTo().frame(4);
	      try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      registration.RegfirstName.sendKeys("SSBerlin");
	      registration.RegLastName.sendKeys("SSHouse");
	      registration.RegDOB.sendKeys("01/10/1990");
	      registration.RegGenderDD.click();
	      try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
	      registration.RegGenderMale.click();
	      registration.RegApt.sendKeys("11");
	      registration.RegStName.sendKeys("123 Ashley Ln");
	      registration.RegCityName.sendKeys("Eagan");
	      registration.RegNextBtn.click();
	      try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
	      registration.RegRegistrationDate.sendKeys(Keys.chord(Keys.CONTROL, "a"),"09/01/2019");
	      registration.RegPrefLanguageDD.click();
	      try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
	      registration.RegPrefLanguageEng.click();
	      registration.RegPrefCommunicationDD.click();
	      try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
	      registration.RegPrefCommunicationMail.click();
	      registration.RegCountyDD.click();
	      try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
	      registration.RegCountyDakota.click();
	      registration.RegStateDD.click();
	      try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
	      registration.RegStateMN.click(); 
	      registration.RegZipCode.sendKeys("55077");
	      registration.RegPhoneTypeDD.click();
	      try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
	      registration.RegPhoneTypeMobile.click();
	      registration.RegPhoneAreaCode.sendKeys("847");
	      registration.RegPhoneExchangeCode.sendKeys("442");
	      registration.RegPhoneSubCode.sendKeys("4545");
	      registration.RegSaveButton.click();
	}

}
