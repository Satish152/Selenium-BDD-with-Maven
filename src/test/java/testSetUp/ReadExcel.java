package testSetUp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public static List<Map<Object,Object>> iterData(Map<Object,Object> dataMap) {
		List<Map<Object,Object>> list=new ArrayList<Map<Object,Object>>();
		int count=0;
		dataSheet=getDataSheet();
		for(int i=1;i<dataSheet.getLastRowNum()+1;i++) {
			if(dataSheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("Yes")) {	
				dataMap=new HashMap<Object,Object>();
				for(int j=1;j<dataSheet.getRow(0).getLastCellNum();j++) {
					dataMap.put(dataSheet.getRow(0).getCell(j).getStringCellValue(), dataSheet.getRow(i).getCell(j).getStringCellValue());
					try {
						wbook.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				list.add(count, dataMap);
				count=count+1;
			}
		}
		return list;
	}
	
}
