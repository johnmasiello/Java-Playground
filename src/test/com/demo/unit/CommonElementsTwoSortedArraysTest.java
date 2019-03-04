package com.demo.unit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.demo.hackerrank.CommonElementsTwoSortedArrays;

public class CommonElementsTwoSortedArraysTest {

	@Test
	public void testBinarySearchElementNotInArray() {
		int[] arr = {1,3,5,7};
		assertEquals(4, -1 - Arrays.binarySearch(arr, 8));
	}

	@Test
	public void testCommonElements_NoCommonElements() {
		int[] a 		= {1, 3, 5, 7};
		int[] b 		= {2, 4, 6, 8};
		int[] expected 	= {};
		
		assertArrayEquals(expected, CommonElementsTwoSortedArrays.getCommonElements(b, a));
	}
	
	@Test
	public void testCommonElements_CommonElements() {
		int[] a 		= {1, 3, 5, 7, 23, 54, 55};
		int[] b 		= {2, 4, 6, 8, 23, 28, 55, 56};
		int[] expected 	= {23, 55};
		
		assertArrayEquals(expected, CommonElementsTwoSortedArrays.getCommonElements(b, a));
	}
	
	@Test
	public void testEmptyArray() {
		int[] a 		= {1, 3, 5, 7, 23, 54, 55};
		int[] b 		= {};
		int[] expected 	= {};
		
		assertArrayEquals(expected, CommonElementsTwoSortedArrays.getCommonElements(b, a));
	}
	
	@Test
	public void testSameArray() {
		int[] a 		= {1, 3, 5, 7, 23, 54, 55};
		int[] expected 	= {1, 3, 5, 7, 23, 54, 55};
		
		assertArrayEquals(expected, CommonElementsTwoSortedArrays.getCommonElements(a, a));
	}
	
	@Test
	public void testReflexiveArrays() {
		int[] a 		= {1, 3, 5, 7, 23, 54, 55};
		int[] b 		= {2, 4, 6, 8, 23, 28, 55, 56};
		int[] expected 	= CommonElementsTwoSortedArrays.getCommonElements(b, a);
		
		assertArrayEquals(expected, CommonElementsTwoSortedArrays.getCommonElements(a, b));
	}
}
