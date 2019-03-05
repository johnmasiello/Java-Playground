package com.demo.unit.benchmark;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.demo.hackerrank.ArrayManipulation;

public class ArrayManipulationBenchmark {
	private int query_size;
	private int [][] queries;
	private Scanner scanner;
	
	@Before
	public void init() throws Exception {
		scanner = new Scanner(new File("/Users/revature/Documents/Java-Playground/input07.txt"));
		
		String[] nm = scanner.nextLine().split(" ");

        query_size = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);
        
        queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }
        scanner.close();
	}

	// Doing Benchmarks
	@Ignore
	@Test
	public void crunchUsingBasicAlgo() {
		assertEquals(2497169732L,
				ArrayManipulation.arrayManipulation_basic(query_size, queries));
	}
	
	// Doing Benchmarks
	@Ignore
	@Test
	public void crunchUsingImprovedAlgo() {
		assertEquals(2497169732L,
				ArrayManipulation.arrayManipulation_Query(query_size, queries));
	}
	
	// Doing Benchmarks
	@Test
	public void crunchUsingArrayDifferencesAlgorithm() {
		assertEquals(2497169732L,
				ArrayManipulation.arrayManipulation(query_size, queries));
	}
}
