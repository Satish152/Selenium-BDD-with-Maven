package testSetUp;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;


public class TestVarSetup{

	public static WebDriver driver;
	public static FileInputStream fis;
	public static File file;
	public static Properties property;
	public static List<Map<Object,Object>> dataList=new ArrayList<Map<Object,Object>>();
	public static Map<Object,Object> loadedData;
	public static XSSFWorkbook wbook;
	public static XSSFSheet dataSheet;

}
