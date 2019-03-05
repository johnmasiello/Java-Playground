package com.demo.hackerrank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SherlockAndAnagrams {
	public static int sherlockAndAnagrams(String s) {
        HashMap<String, Set<Integer>> hashmap = new HashMap<>();
        String substr;
        int numberOfAnagramPairs = 0;
        
        // Find the anagram pairs for substrings of length 1,
        // by first building a hashmap
        for (int i = 0; i < s.length(); i++) {
            substr = s.substring(i, i + 1);
            if (hashmap.containsKey(substr)) {
                hashmap.get(substr).add(i);
            } else {
                hashmap.put(substr, new TreeSet<>(Collections.singleton(i)));
            }
        }
        
        // Find the number of combinations of anagram pairs,
        // given anagrams occur when there are multiple instances of a substring
        for (Set<Integer> setIndicies : hashmap.values()) {
            if (setIndicies.size() < 2)
                continue;
            numberOfAnagramPairs += numberOfPairsOfSetOfSizeN(setIndicies.size());
        }
        
        return numberOfAnagramPairs > 0 ? numberOfAnagramPairs +
        		computeNthDegreeAnagramPairCount(2, s, hashmap) :
        			0;
    }
	
	// Define An Anagram substring by its leftmost index
	private static final int computeNthDegreeAnagramPairCount(int n, String s,
			HashMap<String, Set<Integer>> inputMap) {
		
		HashMap<String, Set<Integer>> hashmap = new HashMap<>();
		final int RIGHTMOST_INDEX = s.length() - n + 1;
		int numberOfAnagramPairs = 0;
		Set<Integer> anagramPairIndicies;
		String substrAnchor, substr;
		
		// Find all of the substrings by going either one character to the left
		// or one character to the right, using the substrings in 
		// inputMap as 'anchors'
		for (Map.Entry<String, Set<Integer>> entry : inputMap.entrySet()) {
			if (entry.getValue().size() < 2 && 
					n == 2)
				continue;
			substrAnchor = entry.getKey();
			anagramPairIndicies = entry.getValue();
			for (int index : anagramPairIndicies) {
				// Prepend the adjacent left character
				if (index > 0) {
					substr = buildIsomorphicAnagram(substrAnchor, s.charAt(index - 1));
					if (hashmap.containsKey(substr)) {
		                hashmap.get(substr).add(index - 1);
		            } else {
		                hashmap.put(substr, new TreeSet<>(Collections.singleton(index - 1)));
		            }
				}
				
				// append the adjacent right character
				if (index < RIGHTMOST_INDEX) {
					substr = buildIsomorphicAnagram(substrAnchor, s.charAt(index + n - 1));
					if (hashmap.containsKey(substr)) {
		                hashmap.get(substr).add(index);
		            } else {
		                hashmap.put(substr, new TreeSet<>(Collections.singleton(index)));
		            }
				}
			}
		}
		
		// Find the number of combinations of anagram pairs,
        // given anagrams occur when there are multiple instances of a substring
        for (Set<Integer> setIndicies : hashmap.values()) {
            if (setIndicies.size() < 2)
                continue;
            numberOfAnagramPairs += numberOfPairsOfSetOfSizeN(setIndicies.size());
        }
        
        return n >= s.length() ? numberOfAnagramPairs :
        	numberOfAnagramPairs + computeNthDegreeAnagramPairCount(++n, s, hashmap);
	}
	
	private static String buildIsomorphicAnagram(String x, char addChar) {
		int i = 0;
		for (; i < x.length(); i++) {
			if (addChar <= x.charAt(i))
				break;
		}
		return new StringBuilder(x.substring(0, i))
				.append(addChar)
				.append(x.substring(i))
				.toString();
	}
	
	private static int numberOfPairsOfSetOfSizeN(int n) {
		return n * (n - 1) / 2;
	}
}
