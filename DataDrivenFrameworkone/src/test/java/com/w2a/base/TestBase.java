package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.Extentmanager;
import com.w2a.utilities.TestUtil;



public class TestBase {
	
	/*
	 *  WebDriver - done
	 *  Properties - done
	 *  Logs - log4j jar, log4j.properties, logger class
	 * Extent Reports
	 * DB
	 * Excel
	 * mail
	 * 
	 */
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	public static WebElement element; 
	public static String pageHeading;
	public static String qText;
	public static WebElement securityq1;
	public static Select select;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testData.xlsx");
	public static List<WebElement> frames;
	public ExtentReports report = Extentmanager.getInstance();
	public static ExtentTest test;
	static WebElement dropdown;
	
	
	@BeforeSuite
	public void setUp() {
		
		if (driver == null){
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
		
				e.printStackTrace();
			}
			
			try {
				config.load(fis);
				log.debug("Config File loaded");
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
		
				e.printStackTrace();
			}
			
			try {
				or.load(fis);
				log.debug("OR  File loaded");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
		@BeforeMethod
		public void LaunchBrowser(){
			if (config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				prefs.put("profile.useAutomationExtension", false);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox");
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("start-maximized");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-gpu");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-session-crashed-bubble");
				options.addArguments("--remote-debugging-port=7780");
				
				driver = new ChromeDriver(options);         
				log.debug("Browser Launched");
				}
			else if (config.getProperty("browser").equals("firefox")) 
			{
				driver = new FirefoxDriver();
			}
			else if (config.getProperty("browser").equals("ie"))
			{
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");	
			}
			
			driver.get(config.getProperty("CitizenPortaliDevUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
			log.debug("Citizen Portal Launched");
			
		}
	
		public void click( String locator) {
			if(locator.endsWith("_XPATH")){
			driver.findElement(By.xpath(or.getProperty(locator))).click();
			} else if(locator.endsWith("_CSS")){
				driver.findElement(By.cssSelector(or.getProperty(locator))).click();	
			}
			test.log(LogStatus.INFO, "Clicking on : "+locator);
		}
		
		public static void verifyEquals( String expected, String actual) throws Throwable{
			
			try{
				
				Assert.assertEquals(actual, expected);
				
			} catch( Throwable t){
				
				TestUtil.captureScreenshot();
				//ReportNG
				Reporter.log("<br>"+"Verfication failure : "+t.getMessage()+"<br>");
				Reporter.log("<a target = \"_blank\" href = "+TestUtil.screenShotName + "><img src ="+TestUtil.screenShotName + " height = 200 width = 200></img></a>");
				Reporter.log("<br>");
				//Extent Report
				test.log(LogStatus.FAIL, "Verfication failed with exception : "+ t.getMessage());
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenShotName));
				
			}			
		}
		
		
		public void select( String locator, String value){
			
			if(locator.endsWith("_XPATH")){
				dropdown = driver.findElement(By.xpath(or.getProperty(locator)));
		} else if(locator.endsWith("_CSS")){
		dropdown =	driver.findElement(By.cssSelector(or.getProperty(locator)));
		}
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
			test.log(LogStatus.INFO, "Selecting from Drop down : "+locator+" value as "+value);
			}
			
			
		
		
public void type( String locator, String value) {
	if(locator.endsWith("_XPATH")){
			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
	} else if(locator.endsWith("_CSS")){
		driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
	}
			test.log(LogStatus.INFO, "Typing in : "+locator+" entered value as "+value);
		}
		
		
	public boolean isElementPresent(By by){
		
		try{
			driver.findElement(by);
			return true;
		}
		
		catch(NoSuchElementException e){
			
			return false;		
		}
		
	}

	
	
	@AfterMethod
	public void tearDown(){
		if(driver != null){
			
			
			
driver.close();


driver.quit();


		}
	}
	
	

}
