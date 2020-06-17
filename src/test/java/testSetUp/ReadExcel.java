package testSetUp;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static XSSFSheet getSheet(String filePath,String sheetName) throws InvalidFormatException, IOException {
		File file=new File(filePath);
		XSSFWorkbook wbook=new XSSFWorkbook(file);
		return null;
		
	}
}
