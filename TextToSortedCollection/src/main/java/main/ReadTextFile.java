package main;

import util.CommonUtil;
import util.CustomComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadTextFile {

	/**
	 * Read a text file and return Sorted Collection List which are word and
	 * phrase sorted List
	 * 
	 * @param fileName String
	 * @param separator String
	 * @return List<List<String>>
	 */
	public List<List<String>> getSortedCollectionList(String fileName, String separator) {
		List<List<String>> result = new ArrayList<List<String>>();
		result.add(getSortedWordsList(fileName, separator));
		result.add(getSortedPhrasesList(fileName, separator));
		return result;
	}

	/**
	 * Read a text file and return the Sorted Words List
	 * 
	 * @param fileName String
	 * @param separator String
	 * @return List<String>
	 */
	public List<String> getSortedWordsList(String fileName, String separator) {
		List<String> words = new ArrayList<String>();
		words = CommonUtil.getWordsFromStringList(CommonUtil.parseTextFileToStringList(fileName), separator);
		Collections.sort(words);
		return words;
	}

	/**
	 * Read a text file and return the Sorted Phrases List
	 * 
	 * @param fileName String
	 * @param separator String
	 * @return List<String>
	 */
	public List<String> getSortedPhrasesList(String fileName, String separator) {
		List<String> words = new ArrayList<String>();
		words = CommonUtil.getPhrasesFromStringList(CommonUtil.parseTextFileToStringList(fileName), separator);
		Collections.sort(words, new CustomComparator());
		return words;
	}

}
