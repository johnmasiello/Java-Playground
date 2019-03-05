package com.demo.more.playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashSolutionPairs {
	public static void hashSolutionPairs() {
		String function = "(a^3 + b^3) / 2";
		
		HashMap<Integer, List<List<Integer>>> hashmap = new HashMap<>();
		hashmap.put(28, Arrays.asList(
				Arrays.asList(1, 3),
				Arrays.asList(3, 1)
				));
		System.out.println(Arrays.deepToString(hashmap.get(28).toArray()));
	}
}
