package com.sgtesting.calculator.sourcecode;

public class Calculator {
	
	/**
	 * Created By:
	 * Reviewed By:
	 * Description:
	 */
	public int addition(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1+num2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Created By:
	 * Reviewed By:
	 * Description:
	 */
	public int multiplication(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1*num2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Created By:
	 * Reviewed By:
	 * Description:
	 */
	public int substraction(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1-num2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
