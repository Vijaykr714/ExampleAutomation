package com.sgtesting.actitime.driverscript;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import com.sgtesting.actitime.datatable.Datatable;
import com.sgtesting.actitime.tests.HomePage;
import com.sgtesting.actitime.tests.Initialize;
import com.sgtesting.actitime.tests.LoginLogout;
import com.sgtesting.actitime.tests.Users;

public class DriverScript {
	public static WebDriver oBrowser=null;
	public static String strPath=null;
	public static String controllerFileName=null;
	public static Datatable datatable=null;
	public static String testScriptDataFile=null;
	public static void main(String[] args) {
		try
		{
			strPath=System.getProperty("user.dir");
			controllerFileName=strPath+"\\Controller\\data_Controller.xlsx";
			datatable=new Datatable();
			int controllerRowCount=datatable.rowCount(controllerFileName, "Scenarios");
			for(int tcid=0;tcid<controllerRowCount;tcid++)
			{
				String testcaseid=datatable.getCellData(controllerFileName, "Scenarios", "TestcaseID", tcid+2);
				String testcasename=datatable.getCellData(controllerFileName, "Scenarios", "TestcaseName", tcid+2);
				String testcasedesc=datatable.getCellData(controllerFileName, "Scenarios", "Description", tcid+2);
				String runstatus=datatable.getCellData(controllerFileName, "Scenarios", "RunStatus", tcid+2);
				System.out.println("testcaseid :"+testcaseid);
				System.out.println("testcasename :"+testcasename);
				System.out.println("testcasedesc :"+testcasedesc);
				System.out.println("runstatus :"+runstatus);
				if(runstatus.equalsIgnoreCase("yes"))
				{
					oBrowser=Initialize.launchBrowser();
					testScriptDataFile=strPath+"\\TestScriptDataFiles\\"+testcasename+".xlsx";
					int testscriptsRowCount=datatable.rowCount(testScriptDataFile, testcaseid);
					for(int tsid=0;tsid<testscriptsRowCount;tsid++)
					{
						String testscriptid=datatable.getCellData(testScriptDataFile, testcaseid, "TestScriptID", tsid+2);
						String testscriptdesc=datatable.getCellData(testScriptDataFile, testcaseid, "Description", tsid+2);
						String testmethodname=datatable.getCellData(testScriptDataFile, testcaseid, "MethodName", tsid+2);
						String testpkgclassname=datatable.getCellData(testScriptDataFile, testcaseid, "PackageClassName", tsid+2);
						System.out.println("testscriptid :"+testscriptid);
						System.out.println("testscriptdesc :"+testscriptdesc);
						System.out.println("testmethodname :"+testmethodname);
						System.out.println("testpkgclassname :"+testpkgclassname);
						
						Class driverparam[]=new Class[1];
						driverparam[0]=WebDriver.class;
						
						Class classObject=Class.forName(testpkgclassname);
						Object obj=classObject.newInstance();
						
						Method method=obj.getClass().getMethod(testmethodname, driverparam);
						method.invoke(obj, oBrowser);
					}
				}
				System.out.println("++++++++++++++++++++++++++++++++++");
			}
		}catch(Exception e)
		{
			e.printStackTrace();		
		}

	}

}
