package testSetUp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import io.cucumber.java.Scenario;

public class DynamicTestNG extends ReadExcel{		
	
	
	public static void testRun()
	{
		
		
		XmlSuite suite = new XmlSuite();
		suite.setName("Testing");
		suite.setVerbose(1);
		
		
		XmlTest test = new XmlTest(suite);
		test.setName("Tests");
		test.addParameter("browser", "chrome");
		test.setPreserveOrder(true);
		
	  XmlClass testclass=new XmlClass("testRun.TestRunnerTestNG");
      List<XmlClass> classes = new ArrayList<XmlClass>();	
	  classes.add(testclass);
	  test.setXmlClasses(classes);
				
	  TestNG testng=new TestNG();
	  List<XmlSuite> suites=new ArrayList<XmlSuite>();
	  suites.add(suite);
	  testng.setXmlSuites(suites);
      testng.run();
		
		
	}
	
}
