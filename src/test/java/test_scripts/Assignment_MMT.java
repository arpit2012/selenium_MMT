package test_scripts;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assignment_MMT {

	public static WebDriver wd;
	Properties uiProp = new Properties();
	Properties dataProp = new Properties();
	@Test

	public  void MMT() throws Exception{
		System.out.println("start");
		FileInputStream fisUI=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/objectRepository/UI.property");
		uiProp.load(fisUI);
		FileInputStream fisData=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/DataMAP/Data.property");
		dataProp.load(fisData);
		
		
		System.setProperty("webdriver.gecko.driver", "/Users/Arpit/Documents/Eclipse_Worksapce/java_Project_3RI/ExecutableFile/geckodriver");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/Users/Arpit/Documents/Selenium3_Jars/output");

		wd = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(wd, 10);

		wd.get("https://www.makemytrip.com");
		wd.manage().window().maximize();
		//Login Code		
		//utility.ScreenshotCode.screenShot();
		wd.findElement(By.id(uiProp.getProperty("loginButton"))).click();;
		System.out.println("clicked on Login Button");
		//utility.ScreenshotCode.screenShot();
		wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.id("ch_login_email"))));
		wd.findElement(By.id("ch_login_email")).sendKeys(dataProp.getProperty("userid"));
		wd.findElement(By.id("ch_login_password")).sendKeys(dataProp.getProperty("password"));
		System.out.println("Successfully entered login_Id password");
		Thread.sleep(2000);
		//utility.ScreenshotCode.screenShot();
		wd.findElement(By.id("ch_login_btn")).click();
		System.out.println("clicked on Login Button");
		Thread.sleep(2000);
		//utility.ScreenshotCode.screenShot();
		//	boolean popupPresent=wait.until(ExpectedConditions.elementToBeClickable(By.id("failed_wallet_got_it"))).isDisplayed();

		//	System.out.println(popupPresent);
		//		if(popupPresent ==  true)
		//		{
		//			wd.findElement(By.id("failed_wallet_got_it")).click();
		//		}

		//Source-Destination Entry			
		wd.findElement(By.id("hp-widget__sfrom")).clear();
		wd.findElement(By.id("hp-widget__sfrom")).sendKeys("PNQ");
		Thread.sleep(1000);
		//utility.ScreenshotCode.screenShot();
		WebElement sourcePlace = wd.findElement(By.id("ui-id-1"));
		Thread.sleep(1000);
		//utility.ScreenshotCode.screenShot();
		wait.until(ExpectedConditions.visibilityOf(sourcePlace));
		Thread.sleep(1000);
		List<WebElement> sourceOptionToSelect = sourcePlace.findElements(By.tagName("li"));
		Thread.sleep(1000);
		for(WebElement optionSource : sourceOptionToSelect)
		{
			if(optionSource.getText().contains("Pune, India"))
			{
				System.out.println("Selected : "+optionSource.getText());
				optionSource.click();
				break;
			}
		}

		wd.findElement(By.id("hp-widget__sTo")).clear();
		wd.findElement(By.id("hp-widget__sTo")).sendKeys("DEL");
		Thread.sleep(1000);
		//utility.ScreenshotCode.screenShot();
		WebElement destinationPlace = wd.findElement(By.id("ui-id-2"));
		Thread.sleep(1000);
		//utility.ScreenshotCode.screenShot();
		wait.until(ExpectedConditions.visibilityOf(destinationPlace));
		Thread.sleep(1000);
		List<WebElement> destinationOptionToSelect = destinationPlace.findElements(By.tagName("li"));
		Thread.sleep(1000);
		for(WebElement optionDestination : destinationOptionToSelect)
		{
			if(optionDestination.getText().contains("Delhi, India"))
			{
				System.out.println("Selected : "+optionDestination.getText());
				optionDestination.click();
				break;
			}
		}
		
		//Choosing Date
		wd.findElement(By.id("hp-widget__depart")).click();
		List<WebElement> allDates = wd.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table/tbody[1]//td"));

		for(WebElement ele:allDates)
		{

			String date=ele.getText();
			
			if(date.contains("28"))
			{
				ele.click();
				Thread.sleep(1000);
				break;
			}
		}
		
		wd.findElement(By.id("searchBtn")).click();;
		System.out.println("Clicked on Search Button");
		Thread.sleep(2000);
		
		wd.findElement(By.id("price")).click();
		System.out.println("Clicked on Sort by Price");
		Thread.sleep(1000);
		
		wd.findElement(By.xpath("//*[@id='content']/div/div[5]/div[5]/div[2]/div[5]/div/div[2]/div[7]/p/a")).click();
		System.out.println("Clicked on Book Button");
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(1000);
		
//		if(wd.findElement(By.id("offer")).isSelected())
//		{
//		WebElement radio =wd.findElement(By.id("offer1"));
//		radio.click();
//		Thread.sleep(2000);
//		System.out.println("Clicked on Radio Button");
//		}
//		else
//		{
//			System.out.println("failed to Click on radio button");
//		}
		
		wd.findElement(By.id("continueToReview")).click();
		System.out.println("Clicked on Continue Button");
		Thread.sleep(1000);
		
		wd.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div[4]/div[1]/div/div[1]/div/div/div/div/p[1]/span[2]/input")).sendKeys("Arpit");
		wd.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div[4]/div[1]/div/div[1]/div/div/div/div/p[1]/span[3]/input")).sendKeys("Agrawal");
		wd.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div[4]/div[1]/div/div[3]/p[2]/span[3]/input")).sendKeys("7030566688");
		System.out.println("Passanger details entered");
		
		js.executeScript("window.scrollBy(0,1000)");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Continue to payment")));
		wd.findElement(By.linkText("Continue to payment")).click();;
		System.out.println("Click on Continue to payment");
		
		Thread.sleep(15000);
		
		wd.findElement(By.id("CC")).click();
		System.out.println("Clicked on Credit/Debit Cards");
		
		wd.findElement(By.id("PAYMENT_cardNumber")).sendKeys("123456");
		wd.findElement(By.id("PAYMENT_nameOnCard")).sendKeys("Arpit Agrawal");
		
		//wd.quit();

	}

}
