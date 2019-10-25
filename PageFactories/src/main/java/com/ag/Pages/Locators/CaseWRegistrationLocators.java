package com.ag.Pages.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaseWRegistrationLocators {
	
	@FindBy(xpath = "//*[@id='app-sections-container-dc_tablist_HCRCASEAPPWorkspaceSection-sbc_tabLabel']") public WebElement HCRCasesAndOutcomes;
	@FindBy(xpath = "//*[@id='curam_layout_ExpandoPane_0']/div[1]/div") public WebElement ShortCutArrow;
	@FindBy(xpath = "//*[@id='dijit_layout_AccordionPane_2_button']/div/span[1]") public WebElement RegistrationArrow;
	@FindBy(xpath = "//*[@id='dijit_layout_AccordionPane_2']/ul/li[1]/a") public WebElement Person;
	@FindBy(xpath = "//*[@id='__o3id1']") public WebElement RegfirstName;
	@FindBy(xpath = "//*[@id='__o3id3']") public WebElement RegLastName;
	@FindBy(xpath = "//*[@id='__o3id5']") public WebElement RegDOB;
	@FindBy(xpath = "//*[@id='widget___o3id6']/div[1]/input") public WebElement RegGenderDD;
	@FindBy(xpath = "//*[@id='__o3id6_popup2']") public WebElement RegGenderMale;
	@FindBy(xpath = "//*[@id='__o3id7']") public WebElement RegApt;
	@FindBy(xpath = "//*[@id='__o3id8']") public WebElement RegStName;
	@FindBy(xpath = "//*[@id='__o3id9']") public WebElement RegCityName;
	@FindBy(xpath = "//*[@id='modal-actions-panel']/div[2]/a") public WebElement RegNextBtn;
	@FindBy(xpath = "//*[@id='__o3ide']") public WebElement RegRegistrationDate;
	@FindBy(xpath = "//*[@id='widget___o3idf']/div[1]/input") public WebElement RegPrefLanguageDD;
	@FindBy(xpath = "//*[@id='__o3idf_popup2']") public WebElement RegPrefLanguageEng;
	@FindBy(xpath = "//*[@id='widget___o3id10']/div[1]/input") public WebElement RegPrefCommunicationDD;
	@FindBy(xpath = "//*[@id='__o3id10_popup2']") public WebElement RegPrefCommunicationMail;
	@FindBy(xpath = "//*[@id='widget___o3id16']/div[1]/input") public WebElement RegCountyDD;
	@FindBy(xpath = "//*[@id='__o3id16_popup19']") public WebElement RegCountyDakota;
	@FindBy(xpath = "//*[@id='widget___o3id17']/div[1]/input") public WebElement RegStateDD;
	@FindBy(xpath = "//*[@id='__o3id17_popup1']") public WebElement RegStateMN;
	@FindBy(xpath = "//*[@id='__o3id18']") public WebElement RegZipCode;
	@FindBy(xpath = "//*[@id='widget___o3id21']/div[1]/input") public WebElement RegPhoneTypeDD;
	@FindBy(xpath = "//*[@id='__o3id21_popup4']") public WebElement RegPhoneTypeMobile;
	@FindBy(xpath = "//*[@id='__o3id22']") public WebElement RegPhoneAreaCode;
	@FindBy(xpath = "//*[@id='__o3id23']") public WebElement RegPhoneExchangeCode;
	@FindBy(xpath = "//*[@id='__o3id24']") public WebElement RegPhoneSubCode;
	@FindBy(xpath = "//*[@id='modal-actions-panel']/div[2]/a[2]") public WebElement RegSaveButton;

}
