package com.w2a.testCases;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CWSmokeTest extends TestBase {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void cwSmokeTest(Hashtable<String,String> data){
	
	System.setProperty("org.uncommons.reportng.escape-output", "false");
	driver.findElement(By.xpath(or.getProperty("LoginPageUserName_XPATH"))).sendKeys(data.get("UserName"));
	driver.findElement(By.xpath(or.getProperty("LoginPagePassword_XPATH"))).sendKeys(data.get("Password"));
	driver.findElement(By.xpath(or.getProperty("LoginPageSignIn_XPATH"))).click();
	wait = new WebDriverWait(driver, 30);
	
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
}

try {
	Thread.sleep(3000);
} catch (InterruptedException e1) {
e1.printStackTrace();
}

driver.findElement(By.xpath(or.getProperty("HCRCasesandOutcomesLink_XPATH"))).click();	

frames = driver.findElements(By.tagName("iframe"));
driver.switchTo().frame(1);

try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
driver.findElement(By.xpath(or.getProperty("Reference_XPATH"))).sendKeys(data.get("SSN"));
driver.findElement(By.xpath(or.getProperty("SearchBtn_XPATH"))).click();
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
driver.findElement(By.xpath(or.getProperty("PersonName_XPATH"))).click();
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

Set<String> windowIds = driver.getWindowHandles();
Iterator<String> iterator = windowIds.iterator();
String first_Window = iterator.next();
System.out.println(first_Window);
//String second_Window = iterator.next();
//System.out.println(second_Window);
//String third_Window = iterator.next();
//System.out.println(third_Window);
driver.switchTo().defaultContent();
frames = driver.findElements(By.tagName("iframe"));
System.out.println(frames.size());
driver.switchTo().frame(3);
driver.findElement(By.xpath(or.getProperty("ICLink_XPATH"))).click();


}	 



}