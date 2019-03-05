package com.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.demo.unit.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestMyArrayList.class,
	CountingValleysTest.class,
	JumpingOnTheCloudsTest.class,
	RepeatedStringTest.class,
	TwoDArrayTest.class,
	ArrayLeftRotationTest.class,
	NewYearChaosTest.class,
	MinimumSwaps2Test.class,
	ArrayManipulationTest.class,
	CommonElementsTwoSortedArraysTest.class,
	PermutationsAsSubstringsTest.class,
	TwoStringsTest.class,
	SherlockAndAnagramsTest.class
})
public class TestSuite {
}
