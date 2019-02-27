package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import demo.MyArrayList;

public class TestMyArrayList {
	private MyArrayList<Integer> arrayList;
	private int SIZE;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		arrayList = new MyArrayList<>();
		arrayList.addAll(Arrays.asList(2, 4, 6, 8, 10));
		SIZE = 5;
	}

	@Test(expected = IllegalStateException.class)
	public void testIllegalStateIterator() {
		for (int _ : arrayList) {
			arrayList.add(55);
		}
	}
	
	@Test
	public void testIterator() {
		int size = 0;
		for (int val : arrayList) {
			System.out.println(val);
			size++;
		}
		assertEquals("expected size = " + SIZE + "; actual size = " + size, SIZE, size);
	}

}
