package main;

import junit.UnitTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
	
	private static String exampleFileName = "example.txt";
	private static String separator = " ";
	
	public static void main(String[] args) {
		
		// Run unit test for checking ReadTextFile functions
		Result result = JUnitCore.runClasses(UnitTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
		
		// Run Main Function
		System.out.println("-----------Main Function-----------");
		List<String> wordList = new ArrayList<String>();
		List<String> phraseList = new ArrayList<String>();
		List<List<String>> collectionList = new ArrayList<List<String>>();
		ReadTextFile ob = new ReadTextFile();
		try {
			collectionList = ob.getSortedCollectionList(exampleFileName, separator);
			
			wordList = collectionList.get(0);
			System.out.println("Word List:" + wordList.toString());
			
			phraseList = collectionList.get(1);
			System.out.println("Phrase List:" + phraseList.toString());
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}

}
