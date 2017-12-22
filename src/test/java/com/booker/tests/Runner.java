package com.booker.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class Runner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(
		    	CreateEntryTest.class,
		    	DeleteEntryTest.class,
				CreateAndDeleteEntriesTest.class
				
				);
		System.out.println("Total number of tests: " + result.getRunCount());
		System.out.println("Total number of tests failed: " + result.getFailureCount());
 
		for(Failure failure : result.getFailures())	{
			System.out.println(failure.getMessage());
		}
	}
}
