package io.mosip.report;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





/**
 * Extent Report Listener
 * 
 * @author Arjun, Vignesh
 *
 */
public class ExtentReportListener implements ITestListener {
	protected static ExtentReports reports;
	protected static ExtentTest test;

	public void onTestStart(ITestResult result) {
		reports.addSystemInfo("Environment", System.getProperty("env.user"));
		reports.addSystemInfo("Deployment Version", CustomTestNGReporter.getBuildTag());
		test = reports.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + "testcase is started");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName() + "testcase is passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, result.getName() + "testcase is failed");
		test.log(LogStatus.ERROR, "LOG", result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName() + "test is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on test sucess within percentage");
	}

	public void onStart(ITestContext context) {
		reports = new ExtentReports(
				"extent-report-" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + ".html");
	}

	public void onFinish(ITestContext context) {
		reports.endTest(test);
		reports.flush();
	}
}