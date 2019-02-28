package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	TestMyArrayList.class,
	CountingValleysTest.class,
	JumpingOnTheCloudsTest.class
})
public class TestSuite {
}
