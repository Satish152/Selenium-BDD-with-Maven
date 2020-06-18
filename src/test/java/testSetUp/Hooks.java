package testSetUp;

import org.testng.Assert;
import org.testng.ITestResult;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Hooks {
	
	@After
	public void methodExecEnds(Scenario result) {
		if (result.getStatus()==Status.FAILED) {
			Assert.assertTrue(false);
		}
		System.out.println("Method Execution ended");
	}

}
