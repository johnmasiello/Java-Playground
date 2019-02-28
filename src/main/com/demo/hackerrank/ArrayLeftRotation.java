package com.demo.hackerrank;

public class ArrayLeftRotation {
	 public static int[] rotLeft(int[] a, int d) {

	 	 final int LEN = a.length;
		 int[] result = new int[LEN];
		 
		 for (int i = 0; i < LEN; i++) {
			 result[(i - d + LEN) % LEN] = a[i];
		 }
		 return result;
    }
}
