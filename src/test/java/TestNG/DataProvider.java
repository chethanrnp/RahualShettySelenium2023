package TestNG;

import org.testng.annotations.Test;

public class DataProvider {
	/*
	 * data provider helps run a test case with diffrent data
	 */
	@Test(dataProvider = "getData")
	public void dataProvider(String usn, String psw) {
		System.out.println(usn);
		System.out.println(psw);
	}

	@org.testng.annotations.DataProvider
	public Object[][] getData() {
		Object[][] a = new Object[3][2];
		a[0][0] = "USN1";
		a[0][1] = "PSW1";
		a[1][0] = "USN2";
		a[1][1] = "PSW2";
		a[2][0] = "USN3";
		a[2][1] = "PSW3";
		return a;
	}
}
