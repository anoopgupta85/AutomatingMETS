package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("UUQHP application Not Created");
		Reporter.log("<a target = \"_blank\" href = "+TestUtil.screenShotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target = \"_blank\" href = "+TestUtil.screenShotName + "><img src ="+TestUtil.screenShotName + " height = 200 width = 200></img></a>");
		
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Application Creation Failed with exception : "+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenShotName));
		report.endTest(test);
		report.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		
		test = report.startTest(result.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("UUQHP application created - smoke Test Passed");
		Reporter.log("<a target = \"_blank\" href = "+TestUtil.screenShotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target = \"_blank\" href = "+TestUtil.screenShotName + "><img src ="+TestUtil.screenShotName + " height = 200 width = 200></img></a>");
		
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"Application Created Succesfully");
		report.endTest(test);
		report.flush();
	}

}
