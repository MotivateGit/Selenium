package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnGroups {

	@Test(groups = "group1")
	public static void group1() {

		Assert.assertTrue(true);

	}

	@Test(groups = "group2")
	public static void group2() {
		Assert.assertTrue(true);
	}

	@Test(dependsOnGroups = { "group1", "group2" })
	public static void group3() {

		System.out.println("Group 3 got passed, bcoz dependent groups are passed...");
	}
}
