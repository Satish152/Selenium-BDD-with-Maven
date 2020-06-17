package stepDefinitions;

import io.cucumber.java.en.Given;
import testSetUp.Hooks;
import testSetUp.TestSetup;

public class LoginTest extends TestSetup{

	@Given("Test given")
	public void test(){

		//TestSetup.browserInit("chrome", "https://google.com");
		System.out.println("test");
	}
}
