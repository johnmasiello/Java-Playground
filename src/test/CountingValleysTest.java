package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import demo.CountingValleys;

public class CountingValleysTest {
	@Test
	public void test() {
		String hike = "DDUUDDUDUUUD";
		int n = hike.length();
		int expected  = 2;
		
		assertEquals(expected, CountingValleys.countingValleys(n, hike));
	}

}
