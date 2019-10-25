package com.ag.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ag.Base.Page;
import com.ag.Pages.Locators.CaseWPersonSearchLocators;

public class CaseWPersonSearch extends Page {
	
	public CaseWPersonSearchLocators search;
	
	public CaseWPersonSearch() {
		
		this.search = new CaseWPersonSearchLocators();
		PageFactory.initElements(driver, this.search);			
	}
	
	public void doPersonSearch(){
		
		search.HCRCasesAndOutcomes.click();
		search.ShortCutArrow.click();
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		search.SearchesArrow.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		search.Person.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 frames = driver.findElements(By.tagName("iframe"));
		 System.out.println(frames.size());
		 for (WebElement e1 : frames) {
			 
			 System.out.println("Frame Id :"+e1.getAttribute("id"));	 
			 System.out.println("Frame Name :"+e1.getAttribute("name"));
		 }
		
		 driver.switchTo().defaultContent();
          driver.switchTo().frame(1);
          
	      try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    search.FirstName.sendKeys("SSBerlin");
	      search.LastName.sendKeys("SSHouse");
	      search.DOB.sendKeys("01/10/1990");
	      search.Search.click();
	      try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      search.PersonName.click();
	      try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      driver.switchTo().defaultContent();
	      try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
			 
			 search.Applmenu.click();
	      
	 //     search.Applmenu.click();
	      
		
	}

}
