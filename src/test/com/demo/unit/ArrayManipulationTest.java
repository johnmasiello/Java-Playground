package com.demo.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.hackerrank.ArrayManipulation;

public class ArrayManipulationTest {

	@Test
	public void test1() {
		int n = 5;
		int[][] manip = new int[][] {
			{1,2,100},
			{2,5,100},
			{3,4,100}
		};
		assertEquals(200, ArrayManipulation.arrayManipulation(n, manip));
	}

	@Test
	public void test2() {
		int n = 10;
		int[][] manip = new int[][] {
			{1,5,3},
			{4,8,7},
			{6,9,1}
		};
		assertEquals(10, ArrayManipulation.arrayManipulation(n, manip));
	}
}
