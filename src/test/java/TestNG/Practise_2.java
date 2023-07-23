package TestNG;

import org.testng.annotations.Test;

public class Practise_2 {

	@Test(groups = {"smoake"})
	public void loginCar() {
		System.out.println("I am WebLogin car");
	}

	@Test()
	public void mobileLoginCar() {
		System.out.println("I am MobileLoginn car");
	}
	
	@Test
	public void loginAPICar() {
		System.out.println("I am API car");
	}
}
