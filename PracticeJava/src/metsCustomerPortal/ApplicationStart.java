package metsCustomerPortal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class ApplicationStart {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","c:/Selenium/chromedriver.exe");
		
		 //<--------  To setup Chrome Properties not to show Push Notifcations ------->
       Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		
		driver = new ChromeDriver(options);     
	                                                                            // Initiate New Chrome Driver
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();                                                                                   // Maximize the window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                      // Introduce a default wait of 10 seconds   
		driver.get("https://auth.stst2.mnsure.org/login/Login.jsp");   
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("smktst19");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("@Minnesota1");
        driver.findElement(By.xpath("//div/div/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);                                                         // Creating an object for implementing Explicit wait.
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Continue')]"))); 
        element.click();
        
      // SSO Check - Only during time travel. Comment when not in Time Travel.
    Thread.sleep(3000);
      driver.findElement(By.xpath("html/body/center/form/table/tbody/tr[1]/td[2]/input")).sendKeys("smktst19");
       driver.findElement(By.xpath("html/body/center/form/table/tbody/tr[2]/td/input")).sendKeys("@Minnesota1");
       driver.findElement(By.xpath("html/body/center/form/table/tbody/tr[3]/td/font/input[1]")).click();
       Thread.sleep(2000);
       
        //Where you Choose health Coverage
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[1]/ul/li[1]/a"))); 
        element.click();
        Thread.sleep(3000);
        List<WebElement> frames = driver.findElements(By.tagName("iframe")); 
        System.out.println(frames.size());
		for (WebElement frame : frames)
		{
			System.out.println(frame.getAttribute("id"));
		}
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='section-link-0']/span/span[4]/div")));
		element.click();
		System.out.println(element.getText());		
		
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='checkbox-cell']/div[1]/div[1]"))); 
		
        element.click();	
		
	    
		driver.findElement(By.xpath("//*[@id='main']/div/div[5]/table/tbody/tr/td/span/span/span")).click();
	        
	      // About your Section	        
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='section-link-2']/span/span[4]/div")));
		element.click();
		System.out.println(element.getText());	
	       element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div/div[3]/table/tbody/tr/td/span/span"))); 
		   element.click();
         //  Information About you
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//*[@id='__o3id6']")).sendKeys("SSChris");
		   driver.findElement(By.xpath("//*[@id='__o3id8']")).sendKeys("SSJimenez");
		   driver.findElement(By.xpath("//*[@id='widget___o3id9']/div[2]/div[1]/div[1]/input")).click();                       // Click on Suffix Dropdown
		   driver.findElement(By.xpath("//*[@id='__o3id9_popup2']")).click();															   // Select Senior from Drop Down
		   driver.findElement(By.xpath("//*[@id='widget___o3ida']/div[2]/div[1]/div[1]/input")).click();  					   // Click on Gender Dropdown
		   driver.findElement(By.xpath("//*[@id='__o3ida_popup2']")).click();															   // Select Male from Dropdown
		   driver.findElement(By.xpath("//*[@id='widget___o3idb']/div[2]/div[1]/div[1]/input")).click();                        // Select Marital Status Dropdown
		   driver.findElement(By.xpath("//*[@id='__o3idb_popup4']")).click();															   // Never Married
		   driver.findElement(By.xpath("//*[@id='__o3idc']")).sendKeys("01/10/1992");											   //  Input Date of Birth
		   driver.findElement(By.xpath("//*[@id='widget___o3idd']/div[2]/div[1]/div[1]/input")).click();  					   // Click on Do you live in Minnesota
		   driver.findElement(By.xpath("//*[@id='__o3idd_popup2']")).click();															   // Select Yes from Dropdown
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='widget___o3ide']/div[2]/div[1]/div[1]/input")));   // Wait to Click on Are u homeless Dropdown
		   element.click();																																			//  Click on Drop Down	
		   driver.findElement(By.xpath("//*[@id='__o3ide_popup1']")).click();																// Select No from Dropdown.
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='__o3id11']")));           // Wait to Click on Address Line 1 
		   element.sendKeys("924 Fifield St");																										// Input address line 1
		   driver.findElement(By.xpath("//*[@id='__o3id12']")).sendKeys("Near Water tank1");									//  Add Address Line 2
		   driver.findElement(By.xpath("//*[@id='__o3id13']")).sendKeys("236");														// Add Apartment number
		   driver.findElement(By.xpath("//*[@id='__o3id14']")).sendKeys("Eagan");								// Add City
		   driver.findElement(By.xpath("//*[@id='widget___o3id15']/div[2]/div[1]/div[1]/input")).click();                       // Click on County Dropdown
		   driver.findElement(By.xpath("//*[@id='__o3id15_popup19']")).click();															// Select Dakota
		   driver.findElement(By.xpath("//*[@id='widget___o3id16']/div[2]/div[1]/div[1]/input")).click(); 						// Select State Dropdown
		   driver.findElement(By.xpath("//*[@id='__o3id16_popup1']")).click();															// Select Minnesota
		   driver.findElement(By.xpath("//*[@id='__o3id17']")).sendKeys("55077");													// Input zipcode
		   driver.findElement(By.xpath("//*[@id='widget___o3id18']/div[2]/div[1]/div[1]/input")).click(); 						// Click on Is your mailing address same as your home address drop down	
		   driver.findElement(By.xpath("//*[@id='__o3id18_popup2']")).click();															// Select Yes from dropdown
		   driver.findElement(By.xpath("//*[@id='widget___o3id21']/div[2]/div[1]/div[1]/input")).click();                      // Click on Do you plan to make Minnesota your home
		   driver.findElement(By.xpath("//*[@id='__o3id21_popup2']")).click();															// Select Yes from Dropdown
		   driver.findElement(By.xpath("//*[@id='widget___o3id23']/div[2]/div[1]/div[1]/input")).click(); 						// Click on Preferred Contact Method
		   driver.findElement(By.xpath("//*[@id='__o3id23_popup1']")).click();															//  Select Phone from Dropdown
		   driver.findElement(By.xpath("//*[@id='__o3id24']")).sendKeys("847");														// Input first 3 digits of phone number
		   driver.findElement(By.xpath("//*[@id='__o3id25']")).sendKeys("443");														// Input next 3
		   driver.findElement(By.xpath("//*[@id='__o3id26']")).sendKeys("5378");														// Input last 4
		   driver.findElement(By.xpath("//*[@id='widget___o3id27']/div[2]/div[1]/div[1]/input")).click(); 						// Click on Type Drop down
		   driver.findElement(By.xpath("//*[@id='__o3id27_popup4']")).click();															// Select Mobile from drop down
		   driver.findElement(By.xpath("//*[@id='__o3id2c']")).sendKeys("abc@xyz.com");										// Input Email Id
		   driver.findElement(By.xpath("//*[@id='widget___o3id2d']/div[2]/div[1]/div[1]/input")).click();						// Click on What language do you speak most of the time
		   driver.findElement(By.xpath("//*[@id='__o3id2d_popup6']")).click();															// Select English
		   driver.findElement(By.xpath("//*[@id='widget___o3id30']/div[2]/div[1]/div[1]/input")).click();						// Click on What is your preferred written Language
		   driver.findElement(By.xpath("//*[@id='__o3id30_popup5']")).click();															// Select English
		   driver.findElement(By.xpath("//*[@id='widget___o3id32']/div[2]/div[1]/div[1]/input")).click();						// Click on Do you want us to send you  VOTER REGISTRATION
		   driver.findElement(By.xpath("//*[@id='__o3id32_popup1']")).click();															// Select No
		   driver.findElement(By.xpath("//*[@id='widget___o3id33']/div[2]/div[1]/div[1]/input")).click();						// Click on How do you prefer to receive NOTICES
		   driver.findElement(By.xpath("//*[@id='__o3id33_popup1']")).click();															// Select BOTH
		   driver.findElement(By.xpath("//*[@id='widget___o3id34']/div[2]/div[1]/div[1]/input")).click();						// Click on Do you want us to send you a form to name someone as your authorized representative?
		   driver.findElement(By.xpath("//*[@id='__o3id34_popup1']")).click();															// Select No
		   driver.findElement(By.xpath("//*[@id='widget___o3id35']/div[2]/div[1]/div[1]/input")).click();						// Click on Are you applying for yourself?
		   driver.findElement(By.xpath("//*[@id='__o3id35_popup2']")).click();															// Select Yes
		   driver.findElement(By.xpath("//*[@id='main']/div/div[30]/table/tbody/tr/td/span/span")).click();				    // Click o Next Button
		   // Next Page  - More about you
		   Thread.sleep(3000);
		 /*  frames = driver.findElements(By.tagName("iframe"));
		   System.out.println(frames.size());
			for (WebElement frame : frames)
			{
				System.out.println(frame.getAttribute("id"));
			}
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			*/
		   
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='widget___o3id6']/div[2]/div[1]/div[1]/input")));           // Wait to Click on Are you of Hispanic, Latino, or Spanish origin?
		   element.click();	
		   driver.findElement(By.xpath("//*[@id='__o3id6_popup1']")).click();																// Select No for Hispanic
		   driver.findElement(By.xpath(".//*[@id='__o3ide']")).click();   																		// Click on Asian India
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='widget___o3id1c']/div[2]/div[1]/div[1]/input")));    // Click on Do you have a Social Security Number
		   element.click();
		   					
		   driver.findElement(By.xpath("//*[@id='__o3id1c_popup2']")).click();															// Select Yes
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='__o3id1d']")));           // Wait to Click on Social Security NumberMandatory
		   element.sendKeys("444443650");																												// Input SSN
		   driver.findElement(By.xpath("//*[@id='widget___o3id21']/div[2]/div[1]/div[1]/input")).click();						// Click on Are you a US Citizen?
		   driver.findElement(By.xpath("//*[@id='__o3id21_popup2']")).click();							 
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='__o3id1d']")));								// Select Yes
		   driver.findElement(By.xpath("//*[@id='main']/div/div[29]/table/tbody/tr/td/span[2]/span")).click();  				// Click on Next Button
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div/div[3]/table/tbody/tr/td/span/span")));           // Wait to Click on Next Button on Household section
		   element.click();
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='widget___o3id6']/div[2]/div[1]/div[1]/input")));           // Wait to Click on Drop Down on Other Household Members
		   element.click();
		   driver.findElement(By.xpath("//*[@id='__o3id6_popup1']")).click();																// Select No from Drop Down
		   driver.findElement(By.xpath("//*[@id='main']/div/div[6]/table/tbody/tr/td/span[2]/span")).click(); 					// Click on Next Button
		   Thread.sleep(2000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='__o3id6']")));           // Click on Icon for Person
		   element.click();
		   driver.findElement(By.xpath("//*[@id='main']/div/div[5]/table/tbody/tr/td/span[2]/span")).click(); 					// Click on Next Button
		   Thread.sleep(2000);
		   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='widget___o3id7']/div[2]/div[1]/div[1]/input")));           // Click on drop down on Tax Dependent Information page
		   element.click();
		   driver.findElement(By.xpath("//*[@id='__o3id7_popup1']")).click();   															// Select No
		   driver.findElement(By.xpath("//*[@id='main']/div/div[8]/table/tbody/tr/td/span[2]/span")).click();					// Click on Next Button
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div/div[9]/table/tbody/tr/td/span[2]/span")));           // Wait to Click on Next button on Household Summary page
		   element.click();
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div/div[3]/table/tbody/tr/td/span/span")));           // Wait to Click on Next button on Tell us your income page
		   element.click();
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='widget___o3id6']/div[2]/div[1]/div[1]/input")));           // Wait to Click on Drop down on income information page
		   element.click();
		   driver.findElement(By.xpath("//*[@id='__o3id6_popup2']")).click(); 																										// Select Yes
		   driver.findElement(By.xpath("//*[@id='main']/div/div[4]/table/tbody/tr/td/span[2]/span")).click(); 																// Click on Next
		   Thread.sleep(5000);
		   element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='widget___o3id6']/div[2]/div[1]/div[1]/input")));           // Wait to Click on Drop down "Income Type" on Enter income details page
		   element.click();
		   driver.findElement(By.xpath("//*[@id='__o3id6_popup1']")).click();  																									// Select Wage before taxes
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("html/body/form/div/div[3]/div[5]/div/div[2]/div/div/div/div[17]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/div/input")).sendKeys("Walmart");    																		// Input Employer Walmart
		   driver.findElement(By.xpath("//*[@id='widget___o3id9']/div[2]/div[1]/div[1]/input")).click();  																// Click on Seasonal Employed Drop down
		   driver.findElement(By.xpath("//*[@id='__o3id9_popup1']")).click();  																									// Select No
		   driver.findElement(By.xpath("html/body/form/div/div[3]/div[5]/div/div[2]/div/div/div/div[20]/table/tbody/tr/td[2]/table/tbody/tr/td[1]/div/div/input")).sendKeys("18000");   																		// Input income 12080
		   driver.findElement(By.xpath("//*[@id='widget___o3idc']/div[2]/div[1]/div[1]/input")).click();  																// Click on Frequency Drop down
		   driver.findElement(By.xpath("//*[@id='__o3idc_popup9']")).click();  																									// Select Yearly
		   driver.findElement(By.xpath("//*[@id='widget___o3idd']/div[2]/div[1]/div[1]/input")).click();  																// Click on Is their any more income
		   driver.findElement(By.xpath("//*[@id='__o3idd_popup1']")).click();  																								    // Select No
		   driver.findElement(By.xpath("//*[@id='main']/div/div[26]/table/tbody/tr/td/span[2]/span")).click();  														// Click on Next Button
		   Thread.sleep(2000);
		   element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main']/div/div[4]/table/tbody/tr/td/span[2]/span")));													    // Click on Next Button on Additional income details
		   element.click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//*[@id='main']/div/div[4]/table/tbody/tr/td/span[2]/span")).click();  														// Click on Next Button on Income Adjustment
		   Thread.sleep(2100);
		   //In case of Current Date ( Date < 2018) comment below 3 lines of code 
		  driver.findElement(By.xpath("//*[@id='widget___o3id8']/div[2]/div[1]/div[1]/input")).click();                                                                // Click on drop down for question on income in 2018
		 driver.findElement(By.xpath("//*[@id='__o3id8_popup2']")).click();  																									// select Yes
		  driver.findElement(By.xpath("//*[@id='main']/div/div[8]/table/tbody/tr/td/span[2]/span")).click();                            								// Click on Next Button
		   // In case of  Time Travel ( Date >=01/01/2018), Uncomment below line
		   driver.findElement(By.xpath("//*[@id='main']/div/div[7]/table/tbody/tr/td/span[2]/span")).click(); 															// Click on Next Button
		   Thread.sleep(2000);
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div/div[3]/table/tbody/tr/td/span/span")));   															// Click on Next Button on More about your household
		   element.click();
		   //In case of Time Travel, Comment below 2 lines and execute 2 lines below
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div[4]/table/tbody/tr/td/span[2]/span")));  																// Click on Next button on Medicaid/Chip
		  element.click();
		   // Below 2 lines are for Current Date
		//element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div/div[13]/table/tbody/tr/td/span[2]/span")));  																// Click on Next button on Additional APTC Program Info
		 //element.click();
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div/div[3]/table/tbody/tr/td/span[2]/span")));  														// Click on Next Button on Employer Sponsored
		   element.click();
		   Thread.sleep(2000);
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='widget___o3id6']/div[2]/div[1]/div[1]/input")));  														// Click on First Drop down on Additional info for all applicants
		   element.click();
		   driver.findElement(By.xpath("//*[@id='__o3id6_popup1']")).click();                                                                                                           // Select NO for first drop down
		   driver.findElement(By.xpath("//*[@id='widget___o3id8']/div[2]/div[1]/div[1]/input")).click();                                                    // Click on 2nd drop down
		   driver.findElement(By.xpath("//*[@id='__o3id8_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3ida']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 3rd drop down
		   driver.findElement(By.xpath("//*[@id='__o3ida_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3idc']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 4th drop down
		   driver.findElement(By.xpath("//*[@id='__o3idc_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3ide']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 5th drop down
		   driver.findElement(By.xpath("//*[@id='__o3ide_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3id10']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 6th drop down
		   driver.findElement(By.xpath("//*[@id='__o3id10_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3id12']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 7th drop down
		   driver.findElement(By.xpath("//*[@id='__o3id12_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3id14']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 8th drop down
		   driver.findElement(By.xpath("//*[@id='__o3id14_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3id16']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 9th drop down
		   driver.findElement(By.xpath("//*[@id='__o3id16_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3id18']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 10th drop down
		   driver.findElement(By.xpath("//*[@id='__o3id18_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3id1a']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 11th drop down
		   driver.findElement(By.xpath("//*[@id='__o3id1a_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3id1c']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 12th drop down
		   driver.findElement(By.xpath("//*[@id='__o3id1c_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='widget___o3id1e']/div[2]/div[1]/div[1]/input")).click();                                                   // Click on 13th drop down
		   driver.findElement(By.xpath("//*[@id='__o3id1e_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='main']/div/div[32]/table/tbody/tr/td/span[2]/span")).click();
		   Thread.sleep(4000);
		   ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div/div[30]/table/tbody/tr/td/span[2]/span")));  														// Click on Next on Summary
		   //For TT
		 //  element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main']/div/div[31]/table/tbody/tr/td/span[2]/span")));  														// Click on Next on Summary
		   element.click();
		   Thread.sleep(3000);
		   element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='widget___o3id6']/div[2]/div[1]/div[1]/input")));  														// Click on First Drop down on Additional info for all applicants
		   element.click();
		   driver.findElement(By.xpath("//*[@id='__o3id6_popup1']")).click();
		   driver.findElement(By.xpath("//*[@id='__o3ida']")).click();
		   driver.findElement(By.xpath("//*[@id='__o3idb']")).click();
		   driver.findElement(By.xpath("//*[@id='__o3idc']")).click();
		   driver.findElement(By.xpath("//*[@id='__o3idd']")).click();
		   driver.findElement(By.xpath("html/body/form/div/div[3]/div[5]/div/div/div/div/div[16]/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td[1]/div/div/input")).sendKeys("SSChris");
		   driver.findElement(By.xpath("html/body/form/div/div[3]/div[5]/div/div/div/div/div[16]/table/tbody/tr/td[3]/div[2]/table/tbody/tr/td[1]/div/div/input")).sendKeys("SSJimenez");
		   driver.findElement(By.xpath("//*[@id='main']/div/div[18]/table/tbody/tr/td/span/span")).click();
		   
	}

}
