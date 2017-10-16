package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommonUtil {

	/**
	 * Check if the list is empty or not
	 * 
	 * @param list List<T>
	 * @return boolean
	 */
	public static boolean isEmptyList(List list) {
		boolean returnValue = true;
		if (list != null && list.size() > 0) {
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * Return true if newString is null or empty false otherwise.
	 * 
	 * @param aNewString String
	 * @return boolean
	 */
	public static boolean isEmptyString(String aNewString) {
		boolean returnValue = true;
		if (aNewString != null && !aNewString.trim().equals("")) {
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * Check if a string s is a word or a phrase.
	 * 
	 * @param s String
	 * @param separator String
	 * @return boolean
	 */
	public static boolean isStringAWordInsteadOfPhrase(String s, String separator) {
		boolean isAWord = false;
		if (!isEmptyString(s)) {
			String[] wordsArray = s.split(separator);
			if (wordsArray.length == 1) {
				isAWord = true;
			}
		}
		return isAWord;
	}

	/**
	 * Return Words From String List.
	 * 
	 * @param list List<String>
	 * @return List<String>
	 */
	public static List<String> getWordsFromStringList(List<String> list, String separator) {
		List<String> wordList = new ArrayList<String>();
		if (!isEmptyList(list)) {
			for (String str : list) {
				if (isStringAWordInsteadOfPhrase(str, separator)) {
					wordList.add(str);
				}
			}
		}
		return wordList;
	}

	/**
	 * Return Phrases From String List.
	 * 
	 * @param list List<String>
	 * @return List<String>
	 */
	public static List<String> getPhrasesFromStringList(List<String> list, String separator) {
		List<String> phraseList = new ArrayList<String>();
		if (!isEmptyList(list)) {
			for (String str : list) {
				if (!isStringAWordInsteadOfPhrase(str, separator)) {
					phraseList.add(str);
				}
			}
		}
		return phraseList;
	}

	/**
	 * Read a text file and parse its content to a String List.
	 * 
	 * @param fileName String
	 * @return String
	 */
	public static List<String> parseTextFileToStringList(String fileName) {

		BufferedReader br = null;
		List<String> list = new ArrayList<String>();

		try {
			// Get file from src folder
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(fileName);
			String strCurrentLine = null;

			br = new BufferedReader(new InputStreamReader(is));

			while ((strCurrentLine = br.readLine()) != null) {
				list.add(strCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return list;

	}

}
