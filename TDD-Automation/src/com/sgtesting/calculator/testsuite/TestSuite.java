package com.sgtesting.calculator.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({com.sgtesting.calculator.tests.AdditionTestcases.class,
		com.sgtesting.calculator.tests.MultiplicationTestcases.class,
		com.sgtesting.calculator.tests.SubstractionTestcases.class})
public class TestSuite {

}
