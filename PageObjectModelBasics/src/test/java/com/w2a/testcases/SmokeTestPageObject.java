package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.AssistancePages.AboutYouSection;
import com.w2a.AssistancePages.ApplywAndWithAssist;
import com.w2a.pages.ApplyAndEnroll;
import com.w2a.pages.InformationAboutYou.InformationAbtYou;
import com.w2a.utilities.TestUtil;

import LoginPages.ContinuePage;
import LoginPages.SigninPage;
import LoginPages.TTLoginPage;

public class SmokeTestPageObject extends BaseTest {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void smokeTest(Hashtable<String,String> data){
		
		SigninPage  sp = new SigninPage();
		ContinuePage cp = sp.doSignIn(data.get("UserName"), data.get("Password"));
		if(data.get("TT").equals("Y")){
		TTLoginPage tlp = cp.doClickOnContinueTT();	
		ae = tlp.doLoginTT(data.get("UserName"), data.get("Password"));
													}
		else{
			ae = cp.doClickOnContinue();
		}
		ApplywAndWithAssist awa = ae.doClickWithFinancialHelp();
		AboutYouSection ays = awa.doClickOnNext();
		InformationAbtYou iay = ays.doClickOnNextOnAYS();
	//	iay.doInputInformationBeforeHomeless();
		iay.doNoHomeless();
}
}