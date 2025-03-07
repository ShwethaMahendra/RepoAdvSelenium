package Generic_Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImp implements ITestListener{

	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./FailedScripts.png");
		
		try {
			FileUtils.copyFile(scr, dest);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
