package com.demo.hackerrank;

public class CountingValleys {
	public static int countingValleys(int n, String s) {
        final int SEA_LEVEL = 0;

        int numValley = 0;
        int altitude = SEA_LEVEL;
        boolean inAValley = false;

        for (int i = 0; i < n; i++) {
            if (altitude == SEA_LEVEL) {
                if (inAValley) {
                    numValley++;
                }
                inAValley = descend(s.charAt(i));
            }
            if (descend(s.charAt(i)))
                altitude--;
            else
                altitude++;
        }
        if (altitude == SEA_LEVEL && inAValley)
            numValley++;
        return numValley;
    }

    private static boolean descend(char token) {
        return token == 'D';
    }
}
