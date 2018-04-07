//package utility;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import test_scripts.Assignment_MMT;
//
//public class ScreenshotCode extends Assignment_MMT{
//
//	public static String GetCurrentTimeStamp()
//	{
//		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
//		Date now = new Date();
//		String strDate = sdfDate.format(now);
//		return strDate;
//	}
//
//	
//	public static void  screenShot() throws Exception {
//		String location = "/Users/Arpit/Documents/Eclipse_Worksapce/mavenTestNG/src/main/resources/ScreenShots/";  //location for images
//
//		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File(location + "ScreenShot_" +GetCurrentTimeStamp().replace("-", "_").replace(" ", "-").replace(":","_").replace(".","_")+ ".png"));
//	}
//
//}
//
