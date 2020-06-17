package testRun;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


@CucumberOptions(features="testFeature",glue= {"stepDefinitions"}
,plugin={"json:target/cucumber.json"},monochrome=true)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	@Parameters({"browserName"})
	@BeforeClass
	public static void browserInit(String browserName)
	{
		 if(browserName.equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
		      driver=new ChromeDriver();
		 }else if(browserName.equals("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
		      driver=new FirefoxDriver();
		 }
		 driver.manage().window().maximize();
         driver.get("https://google.com");
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
      
	}
	
	@AfterClass
	public static void setup()
	{
        driver.close();
        driver.quit();
	}

}
