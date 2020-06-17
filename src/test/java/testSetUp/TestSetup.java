package testSetUp;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSetup{

	public static WebDriver driver;
	
@BeforeClass
	public static void browserInit(String browserName)
	{
		/*htmlReport=new ExtentHtmlReporter("/OpenCart/Reports/TestReport_"+dtf.format(now)+".html")
	reports=new ExtentReports();
		reports.attachReporter(htmlReport);
			testReport=reports.createTest("")*/
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

	/*@Before
	public void methodExecStart() {
		System.out.println("Method execution started");
	}*/

	
	
/*	//@org.junit.AfterClass
	@AfterClass
	public void tearDown() {
	driver.close();
}*/

}
