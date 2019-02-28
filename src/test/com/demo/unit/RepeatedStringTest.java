package com.demo.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.hackerrank.RepeatedString;

public class RepeatedStringTest {

	@Test
	public void test() {
		assertEquals(7, RepeatedString.repeatedString("aba", 10));
		assertEquals(4, RepeatedString.repeatedString("abcac", 10));
	}

}
