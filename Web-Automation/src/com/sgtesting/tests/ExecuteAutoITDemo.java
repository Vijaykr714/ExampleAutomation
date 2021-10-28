package com.sgtesting.tests;

public class ExecuteAutoITDemo {

	public static void main(String[] args) {
		executeScript();

	}
	
	static void executeScript()
	{
		try
		{
			String path="H:\\ExampleAutomation\\AutoIT\\FinalScenarioOfFileSave.exe";
		//	Runtime.getRuntime().exec(path);
			
			Runtime obj=Runtime.getRuntime();
			obj.exec(path);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
