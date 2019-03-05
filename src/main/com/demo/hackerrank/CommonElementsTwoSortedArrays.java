package com.demo.hackerrank;

import java.util.Arrays;

public class CommonElementsTwoSortedArrays {
	public static int[] getCommonElements(int[] a, int[] b) {
		if (a.length == 0 || b.length == 0) {
			return new int[0];
		}
		
		int[] result = new int[a.length > b.length ? a.length : b.length];
		int size = 0;
		int searchIndex = 0;
		
		int[] src, target, swap;
		
		// src needs to start with the array with the lesser first-element
		if (a[0] < b[0]) {
			src = a;
			target = b;
		} else {
			src = b;
			target = a;
		}
		
		while (searchIndex < src.length) {
			searchIndex = Arrays.binarySearch(target, src[searchIndex]);
			if (searchIndex < 0) {
				searchIndex = -1 - searchIndex;
			} else {
				result[size++] = target[searchIndex];
				searchIndex++;
			}
			swap = src;
			src = target;
			target = swap;
		}
		return Arrays.copyOf(result, size);
	}
}
