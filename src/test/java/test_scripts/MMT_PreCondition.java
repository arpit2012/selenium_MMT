package test_scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class MMT_PreCondition {

	public static WebDriver wd;
	static Properties dataProperty = new Properties();
	
	@BeforeSuite
	public static void OpenBrowserAndLink() throws IOException {
		
		FileInputStream fisData=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/DataMAP/Data.property");
		dataProperty.load(fisData);
		
		System.setProperty("webdriver.gecko.driver", "/Users/Arpit/Documents/Eclipse_Worksapce/java_Project_3RI/ExecutableFile/geckodriver");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/Users/Arpit/Documents/Selenium3_Jars/output");
		wd = new FirefoxDriver();
		wd.get(dataProperty.getProperty("URL"));
		wd.manage().window().maximize();
	}
}


//Arpit Agrawal