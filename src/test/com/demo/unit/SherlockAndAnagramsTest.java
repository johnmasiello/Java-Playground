package com.demo.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.hackerrank.SherlockAndAnagrams;

public class SherlockAndAnagramsTest {

	@Test
	public void testEasy() {
		assertEquals(4, SherlockAndAnagrams.sherlockAndAnagrams("abba"));
	}

	
	@Test
	public void testAnnyoing() {
		assertEquals(3, SherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqq"));
	}
}
