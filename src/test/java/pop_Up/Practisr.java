package pop_Up;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Practisr {

	@Test()
	public void practise() throws Throwable {
		Thread.sleep(3000);
		System.out.println("chethan");
	}

	@DataProvider(parallel = true)
	public void practise1() throws Throwable {
		Thread.sleep(3000);
		System.out.println("chethan");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(false, false);
		softAssert.assertAll();
	}
}
