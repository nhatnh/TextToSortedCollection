package junit;

import main.ReadTextFile;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UnitTest {

	private String fileName;
	private String separator;

	@Before
	public void setUp() {
		fileName = "example.txt";
		separator = " ";
	}
	
	@Test
	public void testCase_getSortedCollectionList() {
		List<List<String>> collectionList = new ArrayList<List<String>>();
		ReadTextFile obj = new ReadTextFile();
		List<String> expectedWordList = Arrays.asList("apple", "hello", "regards", "sincerely", "thanks");
		List<String> expectedPhraseList = Arrays.asList("bye bye", "thank you very much", "have a good day ah blah",
				"hope you are doing well", "it was nice to meet you");
		System.out.println("---------Processed Collection Unit Test---------");
		try {
			collectionList = obj.getSortedCollectionList(fileName, separator);
			assertNotNull("List is not null", collectionList);
			assertEquals("List contains 2 sub list", 2, collectionList.size());
			
			System.out.println("Expected Word List: " + expectedWordList.toString());
			System.out.println("Word List After Processing: " + collectionList.get(0).toString());
			
			System.out.println("Expected Phrase List: " + expectedPhraseList.toString());
			System.out.println("Word List After Processing: " + collectionList.get(1).toString());

			assertEquals("Check if word list is sorted", expectedWordList, collectionList.get(0));
			assertEquals("Check if phrase list is sorted", expectedPhraseList, collectionList.get(1));
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Test
	public void testCase_getSortedWordsList() {
		List<String> list = new ArrayList<String>();
		ReadTextFile obj = new ReadTextFile();
		List<String> expectedList = Arrays.asList("apple", "hello", "regards", "sincerely", "thanks");
		System.out.println("---------Word List Unit Test---------");
		try {
			list = obj.getSortedWordsList(fileName, separator);
			assertNotNull("List is not null", list);

			System.out.println("Expected Word List: " + expectedList.toString());
			System.out.println("Word List After Processing: " + list.toString());

			assertEquals("Check if word list is sorted", expectedList, list);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Test
	public void testCase_getSortedPhrasesList() {
		List<String> list = new ArrayList<String>();
		ReadTextFile obj = new ReadTextFile();
		List<String> expectedList = Arrays.asList("bye bye", "thank you very much", "have a good day ah blah",
				"hope you are doing well", "it was nice to meet you");
		System.out.println("---------Phrase List Unit Test---------");
		try {
			list = obj.getSortedPhrasesList(fileName, separator);
			assertNotNull("List is not null", list);

			System.out.println("Expected Phrase List: " + expectedList.toString());
			System.out.println("Phrase List After Processing: " + list.toString());

			assertEquals("Check if phrase list is sorted", expectedList, list);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
