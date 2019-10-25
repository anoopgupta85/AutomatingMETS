package com.g2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.g2a.utilities.ExcelReader;



public class TestBase {
	
	/*
	 * Intializing WebDriver - Done
	 * Initializing Properties - Done
	 * Initializing Logs - log4J jar, .log files, log4j.properties
	 * Initializing ExtentReports
	 * Initializing DB
	 * Initializing Excel REading
	 * Initializing Mail sending
	 * ReportnG, ExtentReports
	 * Jenkins
	 * 
	 */
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testData.xlsx");
	public static WebDriverWait wait;
	
	@BeforeSuite
	public void setUp(){
		
		if(driver == null){
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config File loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR File loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(config.getProperty("browser").equals("firefox")){
				
				driver = new FirefoxDriver();
				
			}
			else if (config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				
				driver = new ChromeDriver(options);                                            
			}
			
			driver.get(config.getProperty("useridcreationSTST2Url"));
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS); 
			wait = new WebDriverWait(driver,10);
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

	@AfterSuite
	public void tearDown(){
		
		if(driver !=  null){
		driver.quit();
		}
		
		
	}
	
	
}
