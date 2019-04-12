package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getDataFromExcel(){

			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			
			try {
				reader = new Xls_Reader("C:\\Users\\girishn3\\eclipse-workspace\\DataDrivenTests\\src\\main\\java\\com\\testdata\\PAN_Data.xlsx");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (int rowNum = 2; rowNum <= reader.getRowCount("Data"); rowNum++) {
				
					String firstName = reader.getCellData("Data", "firstname", rowNum);
					String lastName = reader.getCellData("Data", "lastname", rowNum);
					String middleName = reader.getCellData("Data", "middlename", rowNum);
					String mobile = reader.getCellData("Data", "mobileno", rowNum);
					String appType = reader.getCellData("Data", "apptype", rowNum);
					String category = reader.getCellData("Data", "category", rowNum);
					
					
					Object ob[] = {firstName, lastName, middleName, mobile,appType,category};
					myData.add(ob);
					
			}
			return myData;
		
	}
	
	
	
	

}
