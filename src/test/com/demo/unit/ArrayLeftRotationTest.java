package com.demo.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.hackerrank.ArrayLeftRotation;

public class ArrayLeftRotationTest {

	@Test
	public void test() {
		assertArrayEquals(new int[]{5, 1, 2, 3, 4}, 
				ArrayLeftRotation.rotLeft(new int[]{1,2,3,4,5}, 
						4));
	}

}
