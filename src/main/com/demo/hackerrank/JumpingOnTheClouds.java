package com.demo.hackerrank;

public class JumpingOnTheClouds {
	public static int jumpingOnClouds(int[] c) {
        int len = c.length;
        int jumps = 0;
        int index = 0;

        while (index < len - 2) {
            if (c[index + 2] == 0) {
                index += 2;
            } else {
                index++;
            }
            jumps++;
        }
        if (index == len - 2) {
            jumps++;
        }
        return jumps;
    }
}
