package com.w2a.testcases;

import org.testng.annotations.AfterSuite;

import com.w2a.base.Page;

public class BaseTest extends Page{
	
	@AfterSuite
	public void teardown(){
		
		//Page.quit();
	}

}
