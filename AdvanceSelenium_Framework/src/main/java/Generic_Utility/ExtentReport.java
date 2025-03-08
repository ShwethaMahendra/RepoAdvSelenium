package Generic_Utility;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	//get override method, rightclick-source-override/implement method
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
	}

	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	
	public void onStart(ITestContext context) {
	String time = new Date().toString().replace(" ", "_").replace(":", "_");
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+time);
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("VtigerReport");
	spark.config().setReportName("Shwetha");
	
	//system configuration
	report= new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("platform", "windows");
	report.setSystemInfo("executedBy", "Shwetha");
	report.setSystemInfo("reviewedBy", "Shobha");
	
	}

	
	public void onFinish(ITestContext context) {
	
		report.flush();
	}

	
}
