package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=".\\testData\\UserInfo.xlsx"; // taking xl file from testdata
		ExcelUtility xu= new ExcelUtility(path); // creating an object for xu
		
		int totalrows= xu.getRowcount("sheet1");
		int totalcols= xu.getCellcount("Sheet1", 1);
		
		String logindata[][]= new String[totalrows][totalcols];//create for two dimension array which can store data
		
		for(int i=1;i<=totalrows;i++) {  //1 //read the data from xl storing in two dimensional array
			for(int j=0;j<totalcols;j++) {  //0 i is row j is col
				logindata[i-1][j]=xu.getCellData("Sheet1", i, j);  //1,0
			}
		}
		
		return logindata;  // returning two dimension array
		
	}
}
