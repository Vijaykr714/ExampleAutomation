package com.sgtesting.reflectionscenarios;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RunnerScript {
	
	public static void main(String[] args) {
		runnerScriptDemo();

	}
	
	static void runnerScriptDemo()
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		try
		{
			String path=System.getProperty("user.dir");
			System.out.println(path);
			fin=new FileInputStream(path+"\\DataFiles\\TestRunner.xlsx");
			wb=new XSSFWorkbook(fin);
			int sc=wb.getNumberOfSheets();
			for(int s=0;s<sc;s++)
			{
				String sheetname=wb.getSheetName(s);
				sh=wb.getSheet(sheetname);
				System.out.println(sheetname);
				int rc=sh.getPhysicalNumberOfRows();
				for(int r=1;r<rc;r++)
				{
					row=sh.getRow(r);
					cell=row.getCell(0);
					String methodname=cell.getStringCellValue();
					
					cell=row.getCell(1);
					String pkgclassname=cell.getStringCellValue();
					
					Class cls=Class.forName(pkgclassname);
					Object obj=cls.newInstance();
					
					Method method=obj.getClass().getMethod(methodname);
					method.invoke(obj);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
