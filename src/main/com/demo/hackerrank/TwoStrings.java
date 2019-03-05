package com.demo.hackerrank;

import java.util.HashMap;

public class TwoStrings {
	public static String twoStrings(String s1, String s2) {
		String hashStr = s1.length() > s2.length() ? s1 : s2;
		String searchStr = s1 != hashStr ? s1 : s2;
		
		final int ALPHABET = 26;
		int count = 0;
		
		HashMap<Character, Boolean> letters = new HashMap<>();
		
		char[] chars = hashStr.toCharArray();
		
		for (char c : chars) {
			if (!letters.containsKey(c)) {
				letters.put(c, true);
				count++;
				if (count == ALPHABET)
					break;
			}
		}
	
		chars = searchStr.toCharArray();
		
		for (char c : chars)
			if (letters.containsKey(c))
				return "YES";
				
		return "NO";
	}
}
