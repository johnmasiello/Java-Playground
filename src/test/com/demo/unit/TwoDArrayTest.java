package com.demo.unit;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.demo.hackerrank.TwoDArray;

public class TwoDArrayTest {
	private int[][] arr;
	
	@Before
	public void init() {
		arr = new int[6][6];
		String input;
		
		input = "1 1 1 0 0 0\r\n" + 
				"0 1 0 0 0 0\r\n" + 
				"1 1 1 0 0 0\r\n" + 
				"0 0 2 4 4 0\r\n" + 
				"0 0 0 2 0 0\r\n" + 
				"0 0 1 2 4 0";
		
		parseIt(input, arr);
	}
	
	private void parseIt(String input, int[][] arr) {
		Scanner scanner = new Scanner(input);
		
		Scanner nextLine;
		int i, j;
		i = j = 0;
		
		while (scanner.hasNextLine()) {
			nextLine = new Scanner(scanner.nextLine());
			j = 0;
			while (nextLine.hasNextInt()) {
				arr[i][j++] = nextLine.nextInt();
			}
			i++;
			nextLine.close();
		}
		scanner.close();
	}

	@Test
	public void test() {
		System.out.println("TwoDArrayTest");
		assertEquals(19, TwoDArray.hourglassSum(arr));
	}
	
	@Test
	@Ignore
	public void testAnotherMatrix() {
		String m = 
				"1 1 1 0 0 0\r\n" + 
				"0 1 0 0 0 0\r\n" + 
				"1 1 1 0 0 0\r\n" + 
				"0 9 2 -4 -4 0\r\n" + 
				"0 0 0 -2 0 0\r\n" + 
				"0 0 -1 -2 -4 0";
		parseIt(m, arr);
		assertEquals(13, TwoDArray.hourglassSum(arr));
	}

}