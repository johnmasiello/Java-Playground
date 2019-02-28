package test;

import org.junit.Test;

import demo.JumpingOnTheClouds;

import org.junit.Assert;

public class JumpingOnTheCloudsTest {
	@Test
	public void testJumpingClouds() {
		Assert.assertEquals(3, JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 0, 0, 0, 1, 0}));
		Assert.assertEquals(4, JumpingOnTheClouds.jumpingOnClouds(new int[] {0, 0, 0, 0, 0, 0, 0, 0}));
	}
}
