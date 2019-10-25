package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.AssistancePages.AboutYouSection;
import com.w2a.AssistancePages.ApplywAndWithAssist;
import com.w2a.pages.ApplyAndEnroll;
import com.w2a.pages.HHMemberExtraDetails;
import com.w2a.pages.HHMembersDetails;
import com.w2a.pages.HouseHoldsSection;
import com.w2a.pages.MoreAboutYou;
import com.w2a.pages.OtherHHMembers;
import com.w2a.pages.SupportingDocumentPage;
import com.w2a.pages.InformationAboutYou.InformationAbtYou;
import com.w2a.utilities.TestUtil;

import LoginPages.ContinuePage;
import LoginPages.SigninPage;
import LoginPages.TTLoginPage;

public class LoginTest extends BaseTest {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void loginTest(Hashtable<String,String> data) {
		
		SigninPage  sp = new SigninPage();
		ContinuePage cp = sp.doSignIn(data.get("UserName"), data.get("Password"));
		TTLoginPage tlp = cp.doClickOnContinueTT();
		ApplyAndEnroll ae = tlp.doLoginTT(data.get("UserName"), data.get("Password"));
		ApplywAndWithAssist awa = ae.doClickWithFinancialHelp();
		AboutYouSection ays = awa.doClickOnNext();
		InformationAbtYou iay = ays.doClickOnNextOnAYS();
	//	iay.doInputInformationBeforeHomeless();
		iay.doHomeless();
		MoreAboutYou mbu = iay.doGoToSSNPage();
		SupportingDocumentPage sdp = mbu.doNotHaveSSNButAppliedSSNAndNotUSCitizen();
		HouseHoldsSection hhs = sdp.doInputDocumentNumber();
		OtherHHMembers ohh = hhs.doHouseHoldNext();
		HHMembersDetails md = ohh.OtherHHMembersYes();
		HHMemberExtraDetails med = md.doADDHHMember();
		med.doAddSSNPregYes();
		
		
	}

/*	@DataProvider
	public Object [][] getData(){
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object [][] data = new Object [rows -1][cols];
		
		for(int rowNum = 2; rowNum <= rows; rowNum++) {
			
			for (int colNum =0; colNum < cols; colNum++){
				
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum)
			}
		}
	}*/
}

