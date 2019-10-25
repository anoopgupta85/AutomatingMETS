package LoginPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class SigninPage extends Page {
	
		public ContinuePage doSignIn(String UserName, String Password){
			
	
			driver.findElement(By.xpath(or.getProperty("LoginPageUserName_XPATH"))).sendKeys(UserName);
		 	driver.findElement(By.xpath(or.getProperty("LoginPagePassword_XPATH"))).sendKeys(Password);
		 	try {
				TestUtil.captureScreenshot(pageName);
			} catch (IOException e) {
			e.printStackTrace();
			}
			driver.findElement(By.xpath(or.getProperty("LoginPageSignIn_XPATH"))).click();
			wait = new WebDriverWait(driver, 30);
			
			return new ContinuePage();
			
	}

}
