package testSetUp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.utils.FileUtil;

public class FunctionLibrary {

	
	public static void takeScreenShot(WebDriver driver,String fileName) throws IOException {
	     TakesScreenshot ts=(TakesScreenshot)TestVarSetup.driver;
	     File file=ts.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"//ScreenShots//"+fileName+".png"));
	}
}
