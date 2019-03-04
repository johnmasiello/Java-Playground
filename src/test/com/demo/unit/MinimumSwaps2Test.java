package com.demo.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.hackerrank.MinimumSwaps2;

public class MinimumSwaps2Test {

	@Test
	public void test() {
		assertEquals(3, MinimumSwaps2.minimumSwaps(new int[] {4,3,1,2}));
		assertEquals(3, MinimumSwaps2.minimumSwaps(new int[] {2,3,4,1,5}));
		assertEquals(3, MinimumSwaps2.minimumSwaps(new int[] {1,3,5,2,4,6,7}));
	}

}
