package LoginPages;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;

import com.w2a.base.Page;
import com.w2a.pages.ApplyAndEnroll;
import com.w2a.utilities.TestUtil;

public class TTLoginPage extends Page{
	
	public  ApplyAndEnroll doLoginTT(String UserName, String Password){
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
			e1.printStackTrace();
			}
		 
		 driver.findElement(By.xpath(or.getProperty("LoginForTTUserName_XPATH"))).sendKeys(UserName);
		 driver.findElement(By.xpath(or.getProperty("LoginForTTPswd_XPATH"))).sendKeys(Password);
		 try {
				TestUtil.captureScreenshot(pageName);
			} catch (IOException e) {
			e.printStackTrace();
			}
		 driver.findElement(By.xpath(or.getProperty("LoginForTTSignIn_XPATH"))).click();	
		 
		 return new ApplyAndEnroll();
	}

}
