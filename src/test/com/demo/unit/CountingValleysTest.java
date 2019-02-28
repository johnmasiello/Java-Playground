package com.demo.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.hackerrank.CountingValleys;

public class CountingValleysTest {
	@Test
	public void test() {
		String hike = "DDUUDDUDUUUD";
		int n = hike.length();
		int expected  = 2;
		
		assertEquals(expected, CountingValleys.countingValleys(n, hike));
	}

}
