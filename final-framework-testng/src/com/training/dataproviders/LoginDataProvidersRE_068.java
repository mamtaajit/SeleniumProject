package com.training.dataproviders;
import java.util.List;
import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.LoginBean_066;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead_068;
import com.training.readexcel.ReadExcel;

public class LoginDataProvidersRE_068
{

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			

			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
		@DataProvider(name = "excel-inputs")    
		public Object[][] getExcelData(){     
			//    String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx";        
			String fileName ="C:/IBM java/Mamta/RealestateTestData.xlsx";    
			int START_ROW = 1;
			int START_COL = 0;
			int TOTAL_ROWS = 3;
			int TOTAL_COLUMNS = 4;
			
			return new ApachePOIExcelRead_068().getExcelContent(fileName,"testdata068",START_ROW, START_COL, TOTAL_ROWS, TOTAL_COLUMNS);
		}
	
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/IBM java/Mamta/testdata.xls", "Sheet1"); 
	}
}
