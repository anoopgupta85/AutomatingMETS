package com.learnautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.learnautomation.utilities.ExcelReader;

public class TestBase {

	/*
	 * WebDriver
	 * Peroperties
	 * Logs
	 * Extent Report
	 * DB
	 * Excel
	 * Mail
	 *  
	 * 
	 * 
	 */
	
	public static WebDriver driver;
	public static Properties OR = new Properties ();
	public static Properties config = new Properties ();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");
	
	
	@BeforeSuite
	public void setUp(){
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("Configuration File loaded");
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			log.debug("OR File loaded");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	if(config.getProperty("browser").equals("firefox")) {
		
		driver = new FirefoxDriver();
	}
	else if(config.getProperty("browser").equals("chrome") ){
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();		
	}
	else if(config.getProperty("browser").equals("ie") ){
		//Download the IE server file and change below path incase testing is required in IE
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new InternetExplorerDriver();
	}
	
	driver.get(config.getProperty("CitizenPortalStst1Url "));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")),TimeUnit.SECONDS);
	}
	
	
	
	@AfterSuite
	public void tearDown(){
		
		if(driver  != null){
			
			driver.quit();			
		}
	}
	
}
