package com.demo.unit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.demo.hackerrank.CountTriplets;

public class CountTripletsTest {

	@Test
	public void test() {
		assertEquals(34, 
				CountTriplets.countTriplets(Arrays.asList(3l, 3l, 9l,9l,27l,9l,9l,9l,27l,27l,27l), 3));
	}

	@Test
	public void test2() {
		assertEquals(47, 
				CountTriplets.countTriplets(Arrays.asList(3l, 3l, 9l,3l,9l,27l,9l,9l,9l,27l,27l,27l), 3));
	}
	
	@Test
	public void test0() {
		assertEquals(6, 
				CountTriplets.countTriplets(Arrays.asList(1l,3l,9l,9l,27l,81l), 3));
	}
}
