package com.demo.unit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.demo.hackerrank.PermutationsAsSubstrings;

public class PermutationsAsSubstringsTest {

	@Test
	public void test() {
		List<String> result = PermutationsAsSubstrings.getAllPermutations(("xacxzaa"), "fxaazxacaaxzoecazxaxaz");
		
		assertArrayEquals(new String[] {"xaazxac", "zxacaax", "xacaaxz", "cazxaxa"},
				result.toArray());
	}

}
