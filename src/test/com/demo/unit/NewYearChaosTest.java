package com.demo.unit;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.demo.hackerrank.NewYearChaos;

public class NewYearChaosTest {

	@Test
	public void test() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use your special stream
		System.setOut(ps);
		
		NewYearChaos.minimumBribes(new int[] {5,1,2,3,7,8,6,4});
		NewYearChaos.minimumBribes(new int[] {1,2,5,3,7,8,6,4});
		
		// Put things back
		System.out.flush();
		System.setOut(old);
		
		assertArrayEquals(new String[] {"Too chaotic",  "7"},
				baos.toString().split("\r\n"));
	}

}
