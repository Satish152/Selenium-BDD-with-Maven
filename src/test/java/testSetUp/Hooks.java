package testSetUp;

import org.testng.Assert;
import org.testng.ITestResult;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@After
	public void methodExecEnds(ITestResult result) {
		if (result.FAILURE == result.getStatus()) {
			Assert.assertTrue(false);
		}
		System.out.println("Method Execution ended");
	}

	@Before
	public void Start(ITestResult result) {
		TestSetup.browserInit("chrome");
		System.out.println("Method Execution ended");
	}

}
