package com.demo.hackerrank;

public class NewYearChaos {
	public static void minimumBribes(int[] q) {
        int numBribes = 0;
        int i = q.length - 1;

        while (i > -1) {
            if (q[i] > i + 1) {
                // Single bribe
                if (q[i] == i + 2) {
                    q[i] = q[i + 1];
                    q[i + 1] = i + 2;
                    numBribes++;
                } 
                // Double bribe
                else if (q[i] == i + 3) {
                    q[i] = q[i + 1];
                    q[i + 1] = q[i + 2];
                    q[i + 2] = i + 3;
                    numBribes += 2;
                    i++;
                } 
                // More than two bribes
                else {
                    System.out.println("Too chaotic");
                    return;
                }
            } else
                i--;
        }
        System.out.println(String.valueOf(numBribes));
    }
}
