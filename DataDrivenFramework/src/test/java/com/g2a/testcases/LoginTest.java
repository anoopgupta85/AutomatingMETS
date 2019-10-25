package com.g2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.g2a.base.TestBase;

public class LoginTest extends TestBase{
	
	@Test(dataProvider = "getData")
	
	public void loginUserPortal(String username,String ssn ) throws InterruptedException{
		
		Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        driver.findElement(By.xpath("//*[@id='content_leftblock_nav_705']/div[2]/form/div[2]/a/button")).click();
        driver.findElement(By.xpath("//*[@id='accept_box']")).click(); 
        driver.findElement(By.xpath("//*[@id='content_leftblock_nav_705']/div[2]/form/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Testcase");
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("johndoe");
        driver.findElement(By.xpath("//*[@id='street_address']")).sendKeys("4920 Ashley Ln");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("IGH");
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Minnesota");
        driver.findElement(By.xpath("//*[@id='zip']")).sendKeys("55077");
        driver.findElement(By.xpath("//*[@id='ssn_1']")).sendKeys("444");
        driver.findElement(By.xpath("//*[@id='ssn_2']")).sendKeys("44");
        driver.findElement(By.xpath("//*[@id='ssn_3']")).sendKeys(ssn);
        driver.findElement(By.xpath("//*[@id='date_of_birth']")).sendKeys("01/10/1990");
        driver.findElement(By.xpath("//*[@id='next']")).click();
        //WebDriverWait wait = new WebDriverWait(driver, 10);                                                         // Creating an object for implementing Explicit wait.
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='next']"))); 
        element.click();
       Thread.sleep(1000);
       driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys(username);
       driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("@Minnesota1");
       driver.findElement(By.xpath("//*[@id='reenter_password']")).sendKeys("@Minnesota1");
       
       WebElement securityq1 = driver.findElement(By.xpath("//*[@id='ques1']"));
       
       Select select = new Select(securityq1);
       
       select.selectByIndex(1);
       driver.findElement(By.xpath("//*[@id='answer1']")).sendKeys("aa");
       
       
       securityq1 = driver.findElement(By.xpath("//*[@id='ques2']"));
       select = new Select(securityq1);
       select.selectByIndex(2);
       driver.findElement(By.xpath("//*[@id='answer2']")).sendKeys("bb");
       
       securityq1 = driver.findElement(By.xpath("//*[@id='ques3']"));
       select = new Select(securityq1);
       select.selectByIndex(3);
       driver.findElement(By.xpath("//*[@id='answer3']")).sendKeys("cc");
       
       securityq1 = driver.findElement(By.xpath("//*[@id='ques4']"));
       select = new Select(securityq1);
       select.selectByIndex(4);
       driver.findElement(By.xpath("//*[@id='answer4']")).sendKeys("dd");
       
       securityq1 = driver.findElement(By.xpath("//*[@id='ques5']"));
       select = new Select(securityq1);
       select.selectByIndex(5);
       driver.findElement(By.xpath("//*[@id='answer5']")).sendKeys("ee");
      // Thread.sleep(1000);
       
       driver.findElement(By.xpath("//*[@id='next']")).click();
       
       //Identity Proofing and obtaining an account is complete
       //element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Sign In')]")));
       //element.click();
		/*
		 * driver.findElement(By.xpath(OR.getProperty("userName"))).sendKeys("username");
		log.debug("User Name Input successfully");
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("@Minnesota1");
		log.debug("Password Input successfully");
		driver.findElement(By.xpath(OR.getProperty("loginButton"))).click();
		//Assert.assertTrue(isElementPresent());
		log.debug("User Logged In successfully");
		
		*/
	}
	
	
	@DataProvider
	public Object [][] getData(){
		String sheetName = "LoginTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum = 2; rowNum <=rows; rowNum++) {
			
			for(int colNum =0; colNum < cols; colNum++) {
				
			data[rowNum -2][colNum] = 	excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
		
	}
	
		
		
	}


