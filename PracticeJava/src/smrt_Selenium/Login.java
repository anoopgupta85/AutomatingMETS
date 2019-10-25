package smrt_Selenium;

import java.awt.image.BufferedImage;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;


public class Login {
	
	public static WebDriver driver;
	
public static void captureScreenshot() throws IOException{
		
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

		//File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshot2, new File(System.getProperty("user.dir")+"\\screenshot\\"+fileName));
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
	    ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"\\screenshot\\"+fileName));
	
	}



	public static void main(String[] args) throws InterruptedException, IOException {
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://isds-stst-curam-web-v01:8082/Curam/logon.jsp");
		driver.findElement(By.xpath(".//*[@id='j_username']")).sendKeys("smrtcasemanager17");
		driver.findElement(By.xpath(".//*[@id='j_password']")).sendKeys("password");
		driver.findElement(By.xpath(".//*[@class='ac']")).click();
		driver.findElement(By.xpath(".//*[@title='Cases and Outcomes']")).click();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement frame : frames)
		{
			System.out.println(frame.getAttribute("class"));
		}
		
		driver.switchTo().frame(1);
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//*[@id='widget___o3id1']/div[1]")).click();
		
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//*[@id='__o3id1_popup4']")).click();
		driver.findElement(By.xpath("//*[@id='__o3id2']")).sendKeys("08000749");
		driver.findElement(By.xpath("//*[@id='page-action-set-']/a[1]")).click();
		
		Thread.sleep(5000);	
		captureScreenshot();
		
		driver.findElement(By.xpath("//*[@id='sortable_N237B8']/tbody/tr[3]/td[2]/a")).click();
		
		Thread.sleep(5000);
		Set<String> winids = driver.getWindowHandles();
		System.out.println("Total number of Screens are :"+winids.size());
		Iterator<String> iterate = winids.iterator();
		String first_window = iterate.next();
		System.out.println(first_window);	 
		driver.switchTo().window(first_window);
		
		frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement frame : frames)
		{
			System.out.println(frame.getAttribute("class"));
		}

		

		driver.findElement(By.xpath("//*[@title='Contact']")).click();
		
		driver.findElement(By.xpath(".//*[@id='ContactFolder-ClientContacts']/div")).click();
		
		driver.switchTo().frame(3);
		
		driver.findElement(By.xpath("//*[@title ='New']")).click();
		
		Thread.sleep(5000);
		
		winids = driver.getWindowHandles();
		
		
		iterate = winids.iterator();
		first_window = iterate.next();
		//String second_window = iterate.next();
		//System.out.println(second_window);	
		driver.switchTo().window(first_window);
		
		frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement frame : frames)
		{
			System.out.println(frame.getAttribute("class"));
		}
		
		driver.findElement(By.xpath("//*[@title ='Help']")).click();
		
		driver.switchTo().frame(7);
		
		driver.findElement(By.xpath("//*[contains(text(),'Create a contact from a registered participant.')]")).click();
		
		Thread.sleep(5000);
		
		//<------------------  New Contact Screen---------->
		
		driver.findElement(By.xpath("//*[@id='widget___o3id0']/div[1]/input")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='__o3id0_popup3']")).click();
		
		driver.findElement(By.xpath("//*[@id='__o3fwp.ACTION.details$contactDtls$contactConRoleID_a']")).click();
		
		Thread.sleep(5000);
		
		frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement frame : frames)
		{
			System.out.println(frame.getAttribute("id"));
		}
		
		winids = driver.getWindowHandles();		
		iterate = winids.iterator();
		first_window = iterate.next();
		driver.switchTo().window(first_window);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='curam_ModalDialog_1']/div[1]/span[2]")).click();
		
		frames = driver.findElements(By.tagName("iframe"));
		/*System.out.println(frames.size());
		for (WebElement frame : frames)
		{
			System.out.println(frame.getAttribute("id"));
		}
		*/
		driver.switchTo().frame("iframe-curam_ModalDialog_1");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@title='First Name'][@name ='__o3id1']")).sendKeys("jay");
		
		driver.findElement(By.xpath("//*[@id='widget___o3id6']/div[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='__o3id6_popup2']")).click();
		
		driver.findElement(By.xpath("//*[@id='page-action-set-']/a[1]/span/span/span")).click();
		
		//driver.quit();
	
	
		
		 
		 
		 
	}

}
