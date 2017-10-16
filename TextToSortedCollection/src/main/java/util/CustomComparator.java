package util;

import java.util.Comparator;

public class CustomComparator implements Comparator<String> {

	/**
	 * Compare the length of two string
	 * 
	 * @param str1 String
	 * @param str2 String
	 * @return List<String>
	 */
	public int compare(String str1, String str2) {
		if (str1.length() > str2.length()) {
			return 1;
		} else if (str1.length() < str2.length()) {
			return -1;
		} else {
			return str1.compareToIgnoreCase(str2);
		}
	}
}
