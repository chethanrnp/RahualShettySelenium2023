package TestNG;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Practise_3 {

	@Test(dependsOnMethods = { "mobileLoginBike" }, groups = { "Smoke" })
	public void webLoginBike() {
		System.out.println("I am WebLogin bike");
		Assert.assertFalse(true);
	}

	@Test(groups = { "smoake" })
	public void mobileLoginBike() {
		System.out.println("I am MobileLogin bike");
	}

	@Test(timeOut = 4000)
	public void loginAPIBike() {
		System.out.println("I am API bike");
	}

	@BeforeSuite()
	public void beforeSuit() {
		System.out.println("I will begain");
	}
}
