package com.demo.hackerrank;

import java.util.LinkedList;
import java.util.List;

public class PermutationsAsSubstrings {
	public static List<String> getAllPermutations(String substr, String s) {
		List<String> result = new LinkedList<>();
		
		int len = substr.length();
		String tryStr;
		
		for (int i = 0; i < s.length() - len + 1; i++) {
			tryStr = s.substring(i, i + len);
			if (isXPermutationOfY(tryStr, substr)) {
				result.add(tryStr);
			}
		}
		return result;
	}
	
	private static boolean isXPermutationOfY(String x, String y) {
		char[] chars = x.toCharArray();
		
		for (char letter : chars) {
			y = y.replaceFirst(String.valueOf(letter), "");
		}
		return y.length() == 0;
	}
}
