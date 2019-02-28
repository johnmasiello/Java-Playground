package com.demo.hackerrank;

public class RepeatedString {
	public static long repeatedString(String s, long n) {
        return countA(s) * (n / s.length()) + countA(s.substring(0, (int)(n % s.length())));
    }

    private static long countA(String s) {
        //return s.length() - s.replace("a", "").length();
    	char[] letters = s.toCharArray();
    	int count = 0;
    	for (char l : letters)
    		if (l == 'a')
    			count++;
    	return count;
    }
}
