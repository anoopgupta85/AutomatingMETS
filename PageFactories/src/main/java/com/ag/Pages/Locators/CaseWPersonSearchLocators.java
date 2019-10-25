package com.ag.Pages.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaseWPersonSearchLocators {
	
	@FindBy(xpath = "//*[@id='app-sections-container-dc_tablist_HCRCASEAPPWorkspaceSection-sbc_tabLabel']") public WebElement HCRCasesAndOutcomes;
	@FindBy(xpath = "//*[@id='curam_layout_ExpandoPane_0']/div[1]/div") public WebElement ShortCutArrow;
	@FindBy(xpath = "//*[@title='Searches']") public WebElement SearchesArrow;
	@FindBy(xpath = "(//*[@title ='Person…'])[1]") public WebElement Person;
	@FindBy(xpath = "//*[@id='__o3id1']") public WebElement FirstName;
	@FindBy(xpath = "//*[@id='__o3id3']") public WebElement LastName;
	@FindBy(xpath = "//*[@id='__o3id5']") public WebElement DOB;
	@FindBy(xpath = "//*[@id='page-action-set-']/a[1]") public WebElement Search;
	@FindBy(xpath = "//*[@class ='personsearchname']/a[1]") public WebElement PersonName;
	@FindBy(xpath = "//*[@id='actionsButton__o3uid3895']") public WebElement Applmenu;
	@FindBy(xpath = "//*[@id='content']/div/div/div[2]/div/div[2]/div[1]/div/div[2]") public WebElement MemberName;
}
