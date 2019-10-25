package LoginPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.w2a.base.Page;
import com.w2a.pages.ApplyAndEnroll;
import com.w2a.utilities.TestUtil;

public class ContinuePage extends Page {
	
	public TTLoginPage doClickOnContinueTT(){
		
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		try {
			TestUtil.captureScreenshot(pageName);
		} catch (IOException e) {
		e.printStackTrace();
		}
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("HomePageForIndAndFamContinueBtn_XPATH")))); 
		element.click();
				return new TTLoginPage();		
	}

	public ApplyAndEnroll doClickOnContinue(){
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		try {
			TestUtil.captureScreenshot(pageName);
		} catch (IOException e) {
		e.printStackTrace();
		}
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("HomePageForIndAndFamContinueBtn_XPATH")))); 
		element.click();
				return new ApplyAndEnroll();		
		
	}
		
}
