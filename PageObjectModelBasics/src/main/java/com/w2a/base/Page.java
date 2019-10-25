package com.w2a.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.pages.ApplyAndEnroll;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.Extentmanager;

public class Page {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static WebDriverWait wait;
	public static WebElement element; 
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\w2a\\excel\\testData.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static FileInputStream fis;
	public ExtentReports rep = Extentmanager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static List<WebElement> frames;
	public static String pageName;
	public static ApplyAndEnroll ae;
    
	
@BeforeSuite	
public void setUp() {
		if (driver == null)
		{
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\w2a\\properties\\Config.properties");
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
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\w2a\\properties\\OR.properties");
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

	
		@BeforeTest
		public void LaunchBrowser(){
		{
			if (config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\com\\w2a\\executables\\chromedriver.exe");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				
				driver = new ChromeDriver(options);         
				log.debug("Browser Launched");
				}
			else if (config.getProperty("browser").equals("firefox")) 
			{
				driver = new FirefoxDriver();
			}
			else if (config.getProperty("browser").equals("ie"))
			{
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\com\\w2a\\executables\\IEDriverServer.exe");	
			}
			
			driver.get(config.getProperty("CitizenPortalStst2Url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
			log.debug("Citizen Portal Launched");
		}
	
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
		
	
		
		
		public static void quit(){
			
			//driver.quit();
		}
	}


