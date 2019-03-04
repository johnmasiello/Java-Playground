package com.demo.hackerrank;

public class MinimumSwaps2 {
	public static int minimumSwaps(int[] arr) {
        int i = 0;
        int totalNumberOfSwaps = 0;
        int swap;

        while (i < arr.length) {
            if (arr[i] == i + 1) {
                i++;
                continue;
            }
            swap = arr[i];
            arr[i] = arr[swap - 1];
            arr[swap - 1] = swap;
            totalNumberOfSwaps++;
        }
        return totalNumberOfSwaps;
    }
}
