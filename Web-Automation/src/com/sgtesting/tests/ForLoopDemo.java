package com.sgtesting.tests;

import org.apache.log4j.Logger;

public class ForLoopDemo {
	public static Logger log=Logger.getLogger("For Loop Result :");
	
	public static void main(String[] args) {
		log.info("For Loop Starts here ....");
		for(int i=20;i<=40;i++)
		{
			if(i%2==0)  log.info("Even Number :"+i);
		}
		log.info("For Loop Ends here ....");
	}

}
