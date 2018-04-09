package test_scripts;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporting extends MMT_PreCondition{

	public static ExtentReports extent;
	public static ExtentTest logger;

	@BeforeSuite
	public void startReport(){

		extent = new ExtentReports (System.getProperty("user.dir")+"/test-output/STMExtentReport.html", true);

		extent
		.addSystemInfo("Host Name", "Mac")
		.addSystemInfo("Application", "MakeMyTrip.com")
		.addSystemInfo("User Name", "Arpit");

		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	}

	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){


			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		extent.endTest(logger);
	}
	
	@AfterSuite
	public void endReport() throws InterruptedException{

		System.setProperty("webdriver.gecko.driver", "/Users/Arpit/Documents/Eclipse_Worksapce/java_Project_3RI/ExecutableFile/geckodriver");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/Users/Arpit/Documents/Selenium3_Jars/output");

		Thread.sleep(3000);
		wd.get("file:///Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/test-output/STMExtentReport.html") ; 
		Thread.sleep(3000);
		wd.navigate().refresh();
		ExtentReporting.extent.flush();
	}

}
