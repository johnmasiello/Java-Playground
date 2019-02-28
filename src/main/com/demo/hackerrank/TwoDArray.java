package com.demo.hackerrank;

public class TwoDArray {
	public static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = sumHourglass(arr, i, j);
                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    private static int sumHourglass(int[][] arr, int offsetX, int offsetY) {
        int sum = 0;
        for (int i = offsetX; i < offsetX + 3; i++) {
            if (i == offsetX + 1)
                sum += arr[i][offsetY + 1];
            else
                for (int j = offsetY; j < offsetY + 3; j++)
                    sum += arr[i][j];
        }
        return sum;
    }
}
