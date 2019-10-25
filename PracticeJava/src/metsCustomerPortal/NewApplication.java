package metsCustomerPortal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class NewApplication {
	
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
		
		driver = new ChromeDriver(options);                                                                                    // Initiate New Chrome Driver
		driver.manage().window().maximize();                                                                                   // Maximize the window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                      // Introduce a default wait of 10 seconds   
		driver.get("https://auth.stst2.mnsure.org/NORIDP/?account_type=Individual");    
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
        driver.findElement(By.xpath("//*[@id='ssn_3']")).sendKeys("3410");
        driver.findElement(By.xpath("//*[@id='date_of_birth']")).sendKeys("01/10/1990");
       // driver.findElement(By.xpath("//*[@id='accept_box']")).click();
        driver.findElement(By.xpath("//*[@id='next']")).click();
       
        //   Please answer following questions screen
        
        WebDriverWait wait = new WebDriverWait(driver, 10);                                                         // Creating an object for implementing Explicit wait.
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='next']"))); 
        element.click();
       Thread.sleep(1000);
        
        //Account Information Page
        driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys("Testcsee62");
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
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Sign In')]")));
        element.click();
        driver.quit();
        
        // Sign In Screen
        
        //driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Testcase3");
        //driver.findElement(By.xpath("//*[@id='password']")).sendKeys("@Minnesota1");
	}

}
