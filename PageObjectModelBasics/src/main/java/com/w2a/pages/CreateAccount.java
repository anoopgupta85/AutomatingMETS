package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class CreateAccount {
	
	WebDriver driver;
	
	

   
	
	public void doClickOnNext(){
		
		 driver.findElement(By.xpath("//*[@id='content_leftblock_nav_705']/div[2]/form/div[2]/a/button")).click();
		
	}

	public void doClickOnCancel(){
		
		driver.findElement(By.xpath("//*[@id='content_leftblock_nav_705']/div[2]/form/div[2]/button")).click();
	}
}
