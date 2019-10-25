package com.w2a.rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class TestDropDwonIf extends TestBase {

	
	@Test
	public void MAApplication(){
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver.findElement(By.xpath(or.getProperty("LoginPageUserName_XPATH"))).sendKeys("Zafartc86");
		driver.findElement(By.xpath(or.getProperty("LoginPagePassword_XPATH"))).sendKeys("Welcome1#");
		driver.findElement(By.xpath(or.getProperty("LoginPageSignIn_XPATH"))).click();
		wait = new WebDriverWait(driver, 30);
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("HomePageForIndAndFamContinueBtn_XPATH")))); 
		element.click();
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		 
		 driver.findElement(By.xpath(or.getProperty("LoginForTTUserName_XPATH"))).sendKeys("Zafartc86");
 		 driver.findElement(By.xpath(or.getProperty("LoginForTTPswd_XPATH"))).sendKeys("Welcome1#");
		 driver.findElement(By.xpath(or.getProperty("LoginForTTSignIn_XPATH"))).click();		 
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("ApplyandEnrollWithFinancial_XPATH")))); 
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
		   
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouFrstName_XPATH"))).sendKeys("SSRonald");
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouLastName_XPATH"))).sendKeys("SSPitts");
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderDD_XPATH"))).click();
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouGenderMale_XPATH"))).click();
		   driver.findElement(By.xpath(or.getProperty("InfAbtyouMaritalStatusDD_XPATH"))).click();
		//   driver.findElement(By.xpath(or.getProperty("InfAbtyouNeverMarried_XPATH"))).click();		  
		   
		   WebElement maritalStatusList =  driver.findElement(By.xpath("//*[@id='__o3idb_popup']"));
		   Select select = new Select(maritalStatusList);
		   
		   
		    List< WebElement> options = select.getOptions();
		   for(int i = 0; i<options.size(); i++){
			   
			   System.out.println(options.get(i).getText());  
			   
		   }
		/*   String maritalStatus = driver.findElement(By.xpath("//*[@id='widget___o3idb']/div[2]/div[1]/div[2]/input[@value='MS6']")).getText();
		   System.out.println(maritalStatus);
		   if(maritalStatus.equals("Never Married")){
			   
			   System.out.println("Logic successful");
		   }
		   else {
			   
			   System.out.println("Logic Fail");
		   }
		*/   
		   
}
}