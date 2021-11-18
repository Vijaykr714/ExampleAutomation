package com.sgtesting.calculator.tests;

import org.junit.Assert;
import org.junit.Test;

import com.sgtesting.calculator.sourcecode.Calculator;

public class SubstractionTestcases {
	
	Calculator calculator=new Calculator();
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void substractTwoPositiveNumbers()
	{
		int expected,actual;
		try
		{
			expected=40;
			actual=calculator.substraction(60,20);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void substractTwoNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=-9;
			actual=calculator.substraction(-13,-4);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void substractPositiveAndNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=33;
			actual=calculator.substraction(30,-3);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void substractPositiveAndZeroNumbers()
	{
		int expected,actual;
		try
		{
			expected=30;
			actual=calculator.substraction(30,0);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
