package test_scripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Assignment_MMT {

	public static WebDriver wd;
	public static WebDriverWait wait;
	Properties LoginPageUIProp = new Properties();
	Properties SearchPageUIProp = new Properties();
	Properties SelectFlightUIProp = new Properties();
	Properties ReviewPageUIProp = new Properties();
	Properties EnterPassengerDetailsUIProp = new Properties();
	Properties PaymentDetailsUIProp = new Properties();
	Properties dataProp = new Properties();
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void startReport(){

		extent = new ExtentReports (System.getProperty("user.dir")+"/test-output/STMExtentReport.html", true);

		extent
		.addSystemInfo("Host Name", "Mac")
		.addSystemInfo("Application", "MakeMyTrip.com")
		.addSystemInfo("User Name", "Arpit");

		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	}

	public void login() throws Exception{

		FileInputStream fisLoginUI=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/objectRepository/LoginPageUI.property");
		LoginPageUIProp.load(fisLoginUI);

		wait = new WebDriverWait(wd, 10);
		//utility.ScreenshotCode.screenShot();
		wd.findElement(By.id(LoginPageUIProp.getProperty("loginIcon"))).click();;
		System.out.println("clicked on Login Button");
		//utility.ScreenshotCode.screenShot();
		wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.id("ch_login_email"))));
		wd.findElement(By.id(LoginPageUIProp.getProperty("loginId"))).sendKeys(dataProp.getProperty("userid"));
		wd.findElement(By.id(LoginPageUIProp.getProperty("loginPassword"))).sendKeys(dataProp.getProperty("password"));
		System.out.println("Successfully entered login_Id password");
		Thread.sleep(2000);
		//utility.ScreenshotCode.screenShot();
		wd.findElement(By.id(LoginPageUIProp.getProperty("loginButton"))).click();
		System.out.println("clicked on Login Button");
		Thread.sleep(2000);
	}

	public void search() throws Exception{

		FileInputStream fisSearchUI=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/objectRepository/SearchFlightPageUI.property");
		SearchPageUIProp.load(fisSearchUI);
		wait = new WebDriverWait(wd, 10);
		//Source-Destination Entry			
		wd.findElement(By.id(SearchPageUIProp.getProperty("searchFrom"))).clear();
		wd.findElement(By.id(SearchPageUIProp.getProperty("searchFrom"))).sendKeys(dataProp.getProperty("sourceCode"));
		Thread.sleep(1000);
		//utility.ScreenshotCode.screenShot();
		WebElement sourcePlace = wd.findElement(By.id(SearchPageUIProp.getProperty("searchSourcePlace")));
		Thread.sleep(1000);
		//utility.ScreenshotCode.screenShot();
		wait.until(ExpectedConditions.visibilityOf(sourcePlace));
		Thread.sleep(1000);
		List<WebElement> sourceOptionToSelect = sourcePlace.findElements(By.tagName(SearchPageUIProp.getProperty("searchListTag")));
		Thread.sleep(1000);
		for(WebElement optionSource : sourceOptionToSelect)
		{
			if(optionSource.getText().contains(dataProp.getProperty("sourceName")))
			{
				System.out.println("Selected : "+optionSource.getText());
				optionSource.click();
				break;
			}
		}

		wd.findElement(By.id(SearchPageUIProp.getProperty("searchTo"))).clear();
		wd.findElement(By.id(SearchPageUIProp.getProperty("searchTo"))).sendKeys(dataProp.getProperty("destinationCode"));
		Thread.sleep(1000);
		//utility.ScreenshotCode.screenShot();
		WebElement destinationPlace = wd.findElement(By.id(SearchPageUIProp.getProperty("searchDestinationPlace")));
		Thread.sleep(1000);
		//utility.ScreenshotCode.screenShot();
		wait.until(ExpectedConditions.visibilityOf(destinationPlace));
		Thread.sleep(1000);
		List<WebElement> destinationOptionToSelect = destinationPlace.findElements(By.tagName(SearchPageUIProp.getProperty("searchListTag")));
		Thread.sleep(1000);
		for(WebElement optionDestination : destinationOptionToSelect)
		{
			if(optionDestination.getText().contains(dataProp.getProperty("destinationName")))
			{
				System.out.println("Selected : "+optionDestination.getText());
				optionDestination.click();
				break;
			}
		}

		//Choosing Date
		wd.findElement(By.id(SearchPageUIProp.getProperty("searchCalender"))).click();
		List<WebElement> allDates = wd.findElements(By.xpath(SearchPageUIProp.getProperty("searchCalnederDates")));

		for(WebElement ele:allDates)
		{
			String date=ele.getText();
			if(date.contains(dataProp.getProperty("date")))
			{
				ele.click();
				Thread.sleep(1000);
				break;
			}
		}

		wd.findElement(By.id(SearchPageUIProp.getProperty("searchButton"))).click();
		System.out.println("Clicked on Search Button");
		Thread.sleep(2000);

	}

	public void selectFlight() throws Exception{

		FileInputStream fisSerchFlightUI=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/objectRepository/SelectFlight.property");
		SelectFlightUIProp.load(fisSerchFlightUI);

		wd.findElement(By.id(SelectFlightUIProp.getProperty("selectFlightSortByPrice"))).click();
		System.out.println("Clicked on Sort by Price");
		Thread.sleep(1000);

		wd.findElement(By.xpath(SelectFlightUIProp.getProperty("selectFlightClickOnBook"))).click();
		System.out.println("Clicked on Book Button");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,1000)");

		Thread.sleep(1000);
	}

	public void reviewPage() throws Exception{
		FileInputStream fisReviewPageUI=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/objectRepository/ReviewPage.property");
		ReviewPageUIProp.load(fisReviewPageUI);

		wd.findElement(By.id(ReviewPageUIProp.getProperty("reviewPageContinueToReview"))).click();
		System.out.println("Clicked on Continue Button");
		Thread.sleep(1000);
	}

	public void enterPassangerDetails() throws Exception{

		FileInputStream fisPassengerDetailsUI=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/objectRepository/EnterPassengerDetails.property");
		EnterPassengerDetailsUIProp.load(fisPassengerDetailsUI);

		wd.findElement(By.xpath(EnterPassengerDetailsUIProp.getProperty("enterPassengerDetails_firstName"))).sendKeys(dataProp.getProperty("firstName"));
		wd.findElement(By.xpath(EnterPassengerDetailsUIProp.getProperty("enterPassengerDetails_lastName"))).sendKeys(dataProp.getProperty("lastName"));
		wd.findElement(By.xpath(EnterPassengerDetailsUIProp.getProperty("enterPassengerDetails_Mobile"))).sendKeys(dataProp.getProperty("Mobile"));
		System.out.println("Passanger details entered");

		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,1000)");

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(EnterPassengerDetailsUIProp.getProperty("enterPassengerDetails_ContinueToPayment"))));
		wd.findElement(By.linkText(EnterPassengerDetailsUIProp.getProperty("enterPassengerDetails_ContinueToPayment"))).click();;
		System.out.println("Click on Continue to payment");

		Thread.sleep(15000);

	}

	public void paymentDetails() throws Exception{
		FileInputStream fisPaymentDetailsUI=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/objectRepository/PaymentDetails.property");
		PaymentDetailsUIProp.load(fisPaymentDetailsUI);

		wd.findElement(By.id(PaymentDetailsUIProp.getProperty("payemnetDetails_PaymentMethod"))).click();
		System.out.println("Clicked on Credit/Debit Cards");

		wd.findElement(By.id(PaymentDetailsUIProp.getProperty("payemnetDetails_CardNumber"))).sendKeys(dataProp.getProperty("cardNumber"));
		wd.findElement(By.id(PaymentDetailsUIProp.getProperty("payemnetDetails_NameOnCard"))).sendKeys(dataProp.getProperty("fullName"));

		Select expMonth=new Select(wd.findElement(By.id(PaymentDetailsUIProp.getProperty("payemnetDetails_ExpiryMonth"))));
		Select expYear=new Select(wd.findElement(By.id(PaymentDetailsUIProp.getProperty("payemnetDetails_ExpiryYear"))));

		expMonth.selectByVisibleText(dataProp.getProperty("expiryMonth"));
		expYear.selectByVisibleText(dataProp.getProperty("expiryYear"));

		wd.findElement(By.id(PaymentDetailsUIProp.getProperty("payemnetDetails_CVV"))).sendKeys(dataProp.getProperty("CVV"));
		wd.findElement(By.id(PaymentDetailsUIProp.getProperty("payemnetDetails_ChooseToSaveCardDetails"))).click();
		wd.findElement(By.id(PaymentDetailsUIProp.getProperty("payemnetDetails_ProceedToPay"))).click();
	}

	@Test
	public void MMT_end_to_end() throws Exception{
		FileInputStream fisData=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/DataMAP/Data.property");
		dataProp.load(fisData);

		System.setProperty("webdriver.gecko.driver", "/Users/Arpit/Documents/Eclipse_Worksapce/java_Project_3RI/ExecutableFile/geckodriver");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/Users/Arpit/Documents/Selenium3_Jars/output");
		wd = new FirefoxDriver();
		wd.get(dataProp.getProperty("URL"));
		wd.manage().window().maximize();

		logger = extent.startTest("MMT_end_to_end");

		login();
		logger.log(LogStatus.PASS, "Test Case Passed is MMT_Login");
		search();
		logger.log(LogStatus.PASS, "Test Case Passed is MMT_Search");
		selectFlight();
		logger.log(LogStatus.PASS, "Test Case Passed is MMT_SelectFlight");
		reviewPage();
		logger.log(LogStatus.PASS, "Test Case Passed is MMT_ReviewPage");
		enterPassangerDetails();
		logger.log(LogStatus.PASS, "Test Case Passed is MMT_EnterPassangerDetails");
		paymentDetails();
		logger.log(LogStatus.PASS, "Test Case Passed is MMT_PaymentDetails");
	}

	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){


			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() throws InterruptedException{

		System.setProperty("webdriver.gecko.driver", "/Users/Arpit/Documents/Eclipse_Worksapce/java_Project_3RI/ExecutableFile/geckodriver");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/Users/Arpit/Documents/Selenium3_Jars/output");
		
		Thread.sleep(3000);
		wd=new FirefoxDriver();
		wd.manage().window().maximize();
		wd.get("file:///Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/test-output/STMExtentReport.html") ; 
		wd.navigate().refresh();
		extent.flush();
		extent.close();
	}
}

//Arpit Agrawal

