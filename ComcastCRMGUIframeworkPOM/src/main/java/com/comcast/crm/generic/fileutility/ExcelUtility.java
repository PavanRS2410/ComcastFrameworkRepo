package com.comcast.crm.generic.fileutility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtility 
{
	public String getDataFromExcel(String sheet_name, int row_num, int cell_num) throws Exception
	{
		File f = new File("./testdata/DDT_practice.xlsx");
		FileInputStream fis = new FileInputStream(f);   
		Workbook wbf = WorkbookFactory.create(fis);  
		String data = wbf.getSheet(sheet_name).getRow(row_num).getCell(cell_num).getStringCellValue();  
		wbf.close();
		return data;
	}
	
	public int getRowCount(String sheet_name) throws Exception
	{
		File f = new File("./testdata/DDT_practice.xlsx");
		FileInputStream fis = new FileInputStream(f);   
		Workbook wbf = WorkbookFactory.create(fis);  
		int row_count = wbf.getSheet(sheet_name).getLastRowNum();
		wbf.close();
		return row_count;
	}
	
	public void setDataIntoExcel(String sheet_name, int row_num, int cell_num, String data) throws Exception
	{
		File f = new File("./testdata/DDT_practice.xlsx");
		FileInputStream fis = new FileInputStream(f);   
		Workbook wbf = WorkbookFactory.create(fis);  
		wbf.getSheet(sheet_name).getRow(row_num).createCell(cell_num).setCellValue(data);   
		FileOutputStream fos = new FileOutputStream(f);         
		wbf.write(fos);           
		wbf.close();
	}

}
