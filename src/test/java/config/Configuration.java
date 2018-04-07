//package config;
//
//import java.io.FileInputStream;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class Configuration {
//
//	public static WebDriver wd;
//	public static Properties uiProp = new Properties();
//	public static Properties dataProp = new Properties();
//	
//	public void config() throws Exception
//	{
//		FileInputStream fisUI=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/objectRepository/UI.property");
//		uiProp.load(fisUI);
//		FileInputStream fisData=new FileInputStream("/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/DataMAP/Data.property");
//		dataProp.load(fisData);
//		
//		
//		System.setProperty("webdriver.gecko.driver", "/Users/Arpit/Documents/Eclipse_Worksapce/java_Project_3RI/ExecutableFile/geckodriver");
//		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/Users/Arpit/Documents/Selenium3_Jars/output");
//	}
//}
