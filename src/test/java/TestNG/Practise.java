package TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practise {
	@Parameters({ "URL","USN" })
	@Test
	public void practise(String url,String usn) {
		System.out.println(url);
		System.out.println("I am TestNG");
		System.out.println(usn);
	}

	@Test
	public void pract() {
		System.out.println("I am");
	}

	@AfterSuite
	public void afterSuit() {
		System.out.println("i will finish");
	}
}
