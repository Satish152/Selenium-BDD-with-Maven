package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import com.google.j2objc.annotations.Property;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.messages.Messages.GherkinDocument.Feature.Step;
import io.cucumber.messages.internal.com.google.common.net.MediaType;
import testSetUp.FunctionLibrary;
import testSetUp.ReadExcel;
import testSetUp.TestVarSetup;

public class Hooks {
	TestVarSetup setup=new TestVarSetup();
	@Before
	public void methodExecStart(Scenario result) throws IOException {
		System.out.println("Scanario Execution started "+result.getName());
		setup.file=new File(System.getProperty("user.dir")+"\\TestData\\config.properties");
		setup.fis=new FileInputStream(setup.file);
		setup.property=new Properties();
	setup.property.load(setup.fis);
		
	}
	
	@AfterStep
	public void TestExecEnds(Scenario result) throws IOException {
		System.out.println("Step Execution Completed");
		Date date=new Date();
		SimpleDateFormat now=new SimpleDateFormat("dd-MM-YY_HH:mm:SS");
	if(result.getStatus()==Status.FAILED) {
		FunctionLibrary.takeScreenShot(TestVarSetup.driver, "TestRunImage"+now.format(date)+".png");
		final byte[] screenshot=((TakesScreenshot)setup.driver).getScreenshotAs(OutputType.BYTES);
		result.attach(screenshot, MediaType.PNG.toString(), "image/png");
	setup.driver.close();
	setup.driver.quit();
	System.out.println("Step Execution Completed and Reports Generated");
	}
	}
	
	
	
}
