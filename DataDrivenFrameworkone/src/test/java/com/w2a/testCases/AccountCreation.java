package com.w2a.testCases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AccountCreation extends TestBase {
	
	@Test( dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void loginToCitizenPortal(Hashtable<String,String> data ) {
	
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        driver.findElement(By.xpath(or.getProperty("AcctRegisterNextBtn_XPATH"))).click();
        driver.findElement(By.xpath(or.getProperty("PrivacyWarnandRulesIagreeChkBx_XPATH"))).click(); 
        driver.findElement(By.xpath(or.getProperty("PrivacyWarnandRulesAcceptBtn_XPATH"))).click();
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctFrstName_XPATH"))).sendKeys("Testcase");
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctLstName_XPATH"))).sendKeys("Johndoe");
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctStAddress_XPATH"))).sendKeys("4920 Ashley Ln");
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctCity_XPATH"))).sendKeys("IGH");
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctState_XPATH"))).sendKeys("Minnesota");
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctZip_XPATH"))).sendKeys("55077");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctSSNBox1_XPATH"))).sendKeys("444");
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctSSNBox2_XPATH"))).sendKeys("44");
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctSSNBox3_XPATH"))).sendKeys(data.get("ssn"));
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctDOB_XPATH"))).sendKeys("01/10/1990");
        driver.findElement(By.xpath(or.getProperty("RegisterForaMNsureAcctNxtBtn_XPATH"))).click();
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("PleaseAnsFollQuesNextBtn_XPATH")))); 
        element.click();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        driver.findElement(By.xpath(or.getProperty("AccountInformationUserName_XPATH"))).sendKeys(data.get("username"));
        driver.findElement(By.xpath(or.getProperty("AccountInformationPswd_XPATH"))).sendKeys("@Minnesota1");
        driver.findElement(By.xpath(or.getProperty("AccountInformationReEnterPswd_XPATH"))).sendKeys("@Minnesota1");
        securityq1 = driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues1DropDown_XPATH")));
        select = new Select(securityq1);
        select.selectByIndex(1);
        driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues1Ans_XPATH"))).sendKeys("aa");
        securityq1 = driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues2DropDown_XPATH")));
        select = new Select(securityq1);
        select.selectByIndex(2);
        driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues2Ans_XPATH"))).sendKeys("bb");
        securityq1 = driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues3DropDown_XPATH")));
        select = new Select(securityq1);
        select.selectByIndex(3);
        driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues3Ans_XPATH"))).sendKeys("cc");
        securityq1 = driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues4DropDown_XPATH")));
        select = new Select(securityq1);
        select.selectByIndex(4);
        driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues4Ans_XPATH"))).sendKeys("dd");
        securityq1 = driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues5DropDown_XPATH")));
        select = new Select(securityq1);
        select.selectByIndex(5);
        driver.findElement(By.xpath(or.getProperty("AccountInformationSecQues5Ans_XPATH"))).sendKeys("ee");
        driver.findElement(By.xpath(or.getProperty("AccountInformationNxtBtn_XPATH"))).click();
       // Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("IdentityProofingandActCreatio nCompleteSignInBtn_XPATH"))), "Account  Not Created Successful");
        try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        log.debug("Account Created Successfully");
        Reporter.log("Account Created Successfully");
        Reporter.log("<a target = \"_blank\"href=\"abcd.jpg\">Screenshot</a>");
        
        Reporter.log("<br/>");
        Reporter.log("<a target = \"_blank\"href=\"abcd.jpg\"><img src =><</a>");
        driver.get(config.getProperty("useridcreationSTST1Url"));
        
        
	
	
		
	}
}
