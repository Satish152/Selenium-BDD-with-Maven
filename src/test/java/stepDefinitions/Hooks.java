package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
	ReadExcel.iterData();
		
	}
	
	@AfterStep
	public void TestExecEnds(Scenario result) {
		System.out.println("Step Execution Completed");
	if(result.getStatus()==Status.FAILED) {
	setup.driver.close();
	setup.driver.quit();
	System.out.println("Step Execution Completed and Reports Generated");
	}
	}
	
	
	
}
