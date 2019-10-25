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

public class EditContact {

		
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
			driver.findElement(By.xpath("//*[@id='list-actions-menu-N26058_1']")).click();
			driver.findElement(By.xpath("//*[contains(text(),'Edit')]")).click();
			
			winids = driver.getWindowHandles();			                                                                                         // Checking for New Pop Up Window Id
			iterate = winids.iterator(); 																												     // Initializing the iterator.
			first_window = iterate.next();																												 // Taking the iterator to new window. 					
			System.out.println("Id of the New Contact Window is :"+first_window);										         //  Printing the window handle id
			driver.switchTo().window(first_window);		
			frames = driver.findElements(By.tagName("iframe")); 
			driver.switchTo().frame(7);         
			driver.findElement(By.xpath("//*[@id='widget___o3id0']/div[1]")).click(); 
			driver.findElement(By.xpath("//*[@id='__o3id0_popup10']")).click();
			driver.findElement(By.xpath("//*[@id='__o3id4']")).sendKeys("Added a Comment_again");
			captureScreenshot();
			driver.findElement(By.xpath("//*[@id='modal-actions-panel']/div/a[1]/span/span/span")).click();
			winids = driver.getWindowHandles();			                                                                                         // Checking for New Pop Up Window Id
			iterate = winids.iterator(); 																												     // Initializing the iterator.
			first_window = iterate.next();																												 // Taking the iterator to new window. 					
			System.out.println("Id of the New Contact Window is :"+first_window);										         //  Printing the window handle id
			driver.switchTo().window(first_window);		
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Contact']")));
			captureScreenshot();
			
		

	}

}
