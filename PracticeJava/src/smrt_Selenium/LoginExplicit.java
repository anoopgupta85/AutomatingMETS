package smrt_Selenium;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class LoginExplicit {
	
	public static WebDriver driver;
	
	// <---------------------- Screenshot Code -------------------------------------------->
	
	public static void captureScreenshot() throws IOException{
			
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

			File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot2, new File(System.getProperty("user.dir")+"\\screenshot\\"+fileName));
			
			}


	public static void main(String[] args) throws IOException {
		
		 System.setProperty("webdriver.chrome.driver","c:/Selenium/chromedriver.exe");   // To utilize Chrome Drive.
		 
		 //<--------  To setup Chrome Properties not to show Push Notifcations ------->
	        Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			
			driver = new ChromeDriver(options);                                                                                    // Initiate New Chrome Driver
			driver.manage().window().maximize();                                                                                   // Maximize the window
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                      // Introduce a default wait of 10 seconds   
			driver.get("https://isds-stst-curam-web-v01:8082/Curam/logon.jsp");                                     // Open Curam website
			driver.findElement(By.xpath(".//*[@id='j_username']")).sendKeys("smrtcasemanager17");     // Input username "smrtcasemanager17" in username field
			driver.findElement(By.xpath(".//*[@id='j_password']")).sendKeys("password");                      // Input password as "password" in password field
			driver.findElement(By.xpath(".//*[@class='ac']")).click();                                                        //  Click on Login
			driver.findElement(By.xpath(".//*[@title='Cases and Outcomes']")).click();                             //  Click on Cases and Outcomes
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));                             // Look for all the frames present on Cases and Outcomes
			/*System.out.println(frames.size());                                                                                          //  Print number of frames present on window
			for (WebElement frame : frames)                                                                                           // Print Class Ids for all the iframes present on screen.
			{
				System.out.println(frame.getAttribute("class"));                                                                  // Fetching iFrames using attribute Clas
			}
			*/
			driver.switchTo().frame(1);                                                                                                     // Switching to iFrame present on Index 1. Figured this out by hit and try. 
			driver.findElement(By.xpath("//*[@id='widget___o3id1']/div[1]")).click();                                 //  Clicking on Client Reference Drop down.
			driver.findElement(By.xpath("//*[@id='__o3id1_popup4']")).click();                                         // Selecting PMI Number from the drop down. 
			driver.findElement(By.xpath("//*[@id='__o3id2']")).sendKeys("08000749");                            // Input PMI Number as 0800749 
			driver.findElement(By.xpath("//*[@id='page-action-set-']/a[1]")).click();                                   //Click on Search Button.
		String parent = driver.getWindowHandle();                                                                                 // Fetching Main Window id 
		System.out.println("Main Window Id is :"+parent);                                                                                                         // Printing Main Window id
			
			WebDriverWait wait = new WebDriverWait(driver, 10);                                                         // Creating an object for implementing Explicit wait.
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sortable_N237B8']/tbody/tr[3]/td[2]/a")));     // added a condition to wait until the PMI Id is clickable.
			captureScreenshot();                                                                                                             //   Take Screenshot of the page.  
			element.click();                                                                                                                       // Click on PMI Number for PDC case.
			
			Set<String> winids = driver.getWindowHandles();                                                                  // Till 94, To move focus to PDC Window
			int count = winids.size();
			System.out.println("Total number of Windows are :"+count);
			Iterator<String> iterate = winids.iterator();
			String first_window = iterate.next();
			System.out.println("PDC Tab window id is first_window :"+first_window);	
			driver.switchTo().window(first_window);
			
			
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Contact']")));      // Introduce Explicit wait for Click on Contact Link
			element.click();         																														     // Click on Contact
			driver.findElement(By.xpath(".//*[@id='ContactFolder-ClientContacts']/div")).click();                              // Click on Contact on Left side
			captureScreenshot();                                                                                                                            // Capture Screenshot  
			driver.switchTo().frame(3);			                                                                                                         // Switch to Frame 4 on the page 
			driver.findElement(By.xpath("//*[@title ='New']")).click();                                                                        //Click on New Link to create a new Contact.
			
			winids = driver.getWindowHandles();			                                                                                         // Checking for New Pop Up Window Id
			iterate = winids.iterator(); 																												     // Initializing the iterator.
			first_window = iterate.next();																												 // Taking the iterator to new window. 					
			System.out.println("Id of the New Contact Window is :"+first_window);										         //  Printing the window handle id
			driver.switchTo().window(first_window);																							     //  Switching the focus to the New Contact pop up window
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='curam_ModalDialog_0_title']")));   // Putting an explicit wait to wait for window to appear.
			
			frames = driver.findElements(By.tagName("iframe"));                                                                           // Up to 116, Checking no. of frames present on screen and printing their ids.
			/*System.out.println(frames.size());
			for (WebElement frame : frames)
			{
				System.out.println(frame.getAttribute("class"));
			}
			*/
			driver.findElement(By.xpath("//*[@title ='Help']")).click();																		  // Click on Help Icon "?"
			
			winids = driver.getWindowHandles();			                                                                                         // Checking for New Help Window Id
			iterate = winids.iterator(); 																												     // Initializing the iterator.
			first_window = iterate.next();																												 // Taking the iterator to new window. 			
			String second_window = iterate.next();
			System.out.println("Id of the Help for New Contact Window is :"+second_window);								 //  Printing the window handle id
			driver.switchTo().window(second_window);																							 // Taking Focus to new Help Window.
			captureScreenshot();																															 // Taking screenshot of new window
			driver.close();          																																 //  Closing the new window
			driver.switchTo().window(first_window);																								 //  Bringing Focus back to Pop up window
			driver.switchTo().frame(7);			
			driver.findElement(By.xpath("//*[contains(text(),'Create a contact from a registered participant.')]")).click();
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='widget___o3id0']/div[1]/input")));      // Introduce Explicit wait for Click on Contact dropdown Link
			element.click(); 																																								 // Click on the element 
			driver.findElement(By.xpath("//*[@id='__o3id0_popup3']")).click();																					 // Select Person from Drop down				
			driver.findElement(By.xpath("//*[@id='__o3fwp.ACTION.details$contactDtls$contactConRoleID_a']")).click();                  // Click on Search icon
			winids = driver.getWindowHandles();		
			iterate = winids.iterator();
			first_window = iterate.next();
			System.out.println("ID of Person Search Window is :"+first_window);
			driver.switchTo().window(first_window);
			
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='curam_ModalDialog_1']/div[1]/span[2]")));
			element.click();
			winids = driver.getWindowHandles();			                                                                                         // Checking for New Help Window Id
			iterate = winids.iterator(); 																												     // Initializing the iterator.
			first_window = iterate.next();																												 // Taking the iterator to new window. 			
			second_window = iterate.next();
			System.out.println("Id of the Help for Person Search Window is :"+second_window);								 //  Printing the window handle id
			driver.switchTo().window(second_window);																							 // Taking Focus to new Help Window.
			captureScreenshot();																															 // Taking screenshot of new window
			driver.close();          																																 //  Closing the new window
			driver.switchTo().window(first_window);																			 					 //  Coming back to Person Search Screen	
			driver.switchTo().frame("iframe-curam_ModalDialog_1");                                                                      //  Switching to frame where First Name is located
			driver.findElement(By.xpath("//*[@title='First Name'][@name ='__o3id1']")).sendKeys("jay");			     // Input first name as Jay
			driver.findElement(By.xpath("//*[@id='widget___o3id6']/div[1]")).click();			                                     //  Click on Gender Drop down
			driver.findElement(By.xpath("//*[@id='__o3id6_popup2']")).click();			                                             //  Select Male 
			driver.findElement(By.xpath("//*[@id='page-action-set-']/a[1]/span/span/span")).click();                        //  Click on Search 
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sortable_N203DD']/tbody/tr[1]/td[1]/span/a/span/span/span")));
			element.click();
			winids = driver.getWindowHandles();			                                                                                         // Checking for New Help Window Id
			iterate = winids.iterator(); 	
			System.out.println("Total number of Screens are :"+winids.size());
			first_window = iterate.next();																								 // Taking the iterator to new window. 					
			System.out.println("Id of the Main Window is :"+first_window);
			driver.switchTo().window(first_window);
			frames = driver.findElements(By.tagName("iframe"));                                                                           // Up to 116, Checking no. of frames present on screen and printing their ids.
			/*System.out.println(frames.size());
			for (WebElement frame : frames)
			{
				System.out.println(frame.getAttribute("class"));
			}
			*/
			driver.switchTo().frame(7);                                                                                                 //  
			driver.findElement(By.xpath("//*[@id='widget___o3id1']/div[1]")).click();                            // 
			driver.findElement(By.xpath("//*[@id='__o3id1_popup12']")).click();
			driver.findElement(By.xpath("//*[@id='modal-actions-panel']/div/a[1]/span/span/span")).click();
	}

}
