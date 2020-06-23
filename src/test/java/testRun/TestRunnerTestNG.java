package testRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import testSetUp.TestVarSetup;


@CucumberOptions(features="testFeature",glue= {"stepDefinitions"}
,plugin={"json:target/cucumber.json"},monochrome=true)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{
		
		
	
	@AfterClass
	public void scenarioEnd() {
		System.out.println("after class exec");
		try{
			TestVarSetup.driver.close();
		}catch(Exception e) {
			//nothing
		}
		
	}
}
