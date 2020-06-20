package testSetUp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel extends TestVarSetup{

	
	public static XSSFSheet loadData(String filePath,String sheetName) throws InvalidFormatException, IOException {
		File file=new File(filePath);
		wbook=new XSSFWorkbook(file);
		dataSheet=wbook.getSheet(sheetName);
		return dataSheet;
	}
	
	public static XSSFSheet getDataSheet() {
		try {
			return loadData(System.getProperty("user.dir")+property.getProperty("excelPath"),"Sheet1");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void iterData() {
		for(int i=1;i<getDataSheet().getLastRowNum();i++) {
			if(getDataSheet().getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("Yes")) {	
				loadedData=new HashMap<Object,Object>();
				for(int j=1;j<getDataSheet().getRow(0).getLastCellNum();j++) {
					loadedData.put(getDataSheet().getRow(0).getCell(j).getStringCellValue(), getDataSheet().getRow(i).getCell(j).getStringCellValue());
				}
			}
		}
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
