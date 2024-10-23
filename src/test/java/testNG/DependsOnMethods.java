package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {

	@Test
	public static void ParentTest() {
		Assert.assertTrue(true);
	}

	@Test(dependsOnMethods = "ParentTest")
	public static void ChildTest() {
		System.out.println("Parent Test method got passed, so child test also got passed...");
	}

}
