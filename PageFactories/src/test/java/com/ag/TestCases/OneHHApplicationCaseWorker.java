package com.ag.TestCases;

import com.ag.Base.Page;
import com.ag.Pages.CaseWLoginPage;
import com.ag.Pages.CaseWPersonSearch;
import com.ag.Pages.CaseWRegistration;

public class OneHHApplicationCaseWorker {

	public static void main(String[] args) {
	
		
		Page.initConfiguration();
		CaseWLoginPage  login = new CaseWLoginPage();
		login.logintoCaseW();
	/*CaseWRegistration registration = new CaseWRegistration();
		registration.doCaseWRegistration();
		*/
		CaseWPersonSearch search = new CaseWPersonSearch();
		search.doPersonSearch();

	}

}
