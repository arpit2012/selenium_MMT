package test_scripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class MMT_VerifyHomePageTitle extends MMT_PreCondition{

	@Test

	public void verifyTitle() throws InterruptedException {
		
		ExtentReporting.logger = ExtentReporting.extent.startTest("verifyTitle");

		wd.get(dataProperty.getProperty("URL"));	
		System.out.println(wd.getTitle());
		
		ExtentReporting.logger.log(LogStatus.PASS, "Test Case Passed is verifyTitle");
		
		Thread.sleep(2000);

	}

}
