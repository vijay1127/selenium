package mavenProject.Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class NewMain {
	
	Globals gb = new Globals();
	
	//This is Main method
	
	@Test
	public void GetDataClass() throws Exception{
	try{
		
		int RowSize =0;
		int ColumnSize = 0;
		List<String> HeaderValue = new LinkedList<String>();
		List<String> RowData = new LinkedList<String>();
		
		DataFormatter formatter = new DataFormatter();
		
		File TestFileData = new File("C:/Users/Satish/workspace/Selenium/Data/TestData.xlsx");
		FileInputStream ReadWriteExcel = new FileInputStream(TestFileData);
		
		Workbook TestDataWb = new XSSFWorkbook(ReadWriteExcel);
		Sheet DataSheet = TestDataWb.getSheet("TestData");
		
		RowSize = DataSheet.getLastRowNum()-DataSheet.getFirstRowNum();
		for(int RowNum=0;RowNum<=RowSize;){
			ColumnSize = DataSheet.getRow(RowNum).getLastCellNum();
			for(int ColNum=0;ColNum<=ColumnSize-1;ColNum++){
				if(RowNum==0){
					String CellValue = formatter.formatCellValue(DataSheet.getRow(RowNum).getCell(ColNum));
					HeaderValue.add(CellValue);
				}
			}
			break;
		}
		for(int RowNum=1;RowNum<=RowSize;RowNum++){
			for(int ColNum=0;ColNum<=ColumnSize-1;ColNum++){
				String CallValue = formatter.formatCellValue(DataSheet.getRow(RowNum).getCell(ColNum));
				RowData.add(CallValue);
			}
			if(RowData.get(2).equals("Y")){
				for(int i=0;i<=ColumnSize-1;i++){
					gb.GetData.put(HeaderValue.get(i), RowData.get(i));
				}
				EngineClass.ExecuteTestCase();
			}
			gb.GetData.clear();
			RowData.clear();
		}
		
		TestDataWb.close();
	}
	catch(Exception E){
		throw E;
	}

	}
}