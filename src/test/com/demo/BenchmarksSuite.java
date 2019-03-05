package com.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;	
import com.demo.unit.benchmark.*;

@RunWith(Suite.class)
@SuiteClasses({ArrayManipulationBenchmark.class})
public class BenchmarksSuite {

}
