package com.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.demo.unit.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestMyArrayList.class,
	CountingValleysTest.class,
	JumpingOnTheCloudsTest.class,
	RepeatedStringTest.class
})
public class TestSuite {
}
