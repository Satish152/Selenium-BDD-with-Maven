package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import testSetUp.ReadExcel;
import testSetUp.TestVarSetup;

public class LoginTest extends TestVarSetup{

	@Given("Open the {string} browser")
	public void browserInit(String browserName){

		 if(browserName.equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 System.setProperty("webdriver.chrome.silentOutput", "true");
		      driver=new ChromeDriver();
		 }else if(browserName.equals("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
		      driver=new FirefoxDriver();
		 }
		 driver.manage().window().maximize();
       
	}
	
	@Given("load the url")
	public void loadTheURL(){

		  driver.get(TestVarSetup.property.getProperty("url"));
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@Given("search text")
	public void SearchText(){
		dataList=ReadExcel.iterData(loadedData);
		for(int i=0;i<dataList.size();i++) {
			loadedData=dataList.get(i);
		       System.out.println(loadedData.get("Username"));
		       System.out.println(loadedData.get("Password"));
		}
	}
}
