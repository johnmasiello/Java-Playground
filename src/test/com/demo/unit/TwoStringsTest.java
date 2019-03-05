package com.demo.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.hackerrank.TwoStrings;

public class TwoStringsTest {

	@Test
	public void testYes() {
		assertEquals("YES", TwoStrings.twoStrings("hello", "world"));
	}

	@Test
	public void testNo() {
		assertEquals("NO", TwoStrings.twoStrings("hi", "world"));
	}
}
