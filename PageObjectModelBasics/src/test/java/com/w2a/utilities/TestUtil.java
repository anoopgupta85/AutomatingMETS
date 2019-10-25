package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.Page;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class TestUtil extends Page {
	
	public static String screenShotPath;
	public static String screenShotName;
	public static void captureScreenshot(String pageName) throws IOException {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		screenShotName = pageName+"_" + d.toString().replace(":", "_").replace(" ", "_") + ".jpeg";
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\" + screenShotName));
		
	}
	
	public static void captureAScreenshot(){
		
		Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(10000)).takeScreenshot(driver);
		Date d = new Date();
		screenShotName = d.toString().replace(":", "_").replace(" ", "_") + ".PNG";
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\" + screenShotName));
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	@DataProvider(name ="dp")
	public Object [ ][ ] getData(Method m) {
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][1];
		
		Hashtable<String,String> table = null;
		
		for (int rowNum = 2; rowNum <=rows; rowNum++) {
			
			table = new Hashtable<String,String>();
			
			
			for(int colNum =0; colNum < cols; colNum++) {
				
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				
			data[rowNum -2][0] = 	table;
			}
		}
		
		return data;
		
	}
	

}
