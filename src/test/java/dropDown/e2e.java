package dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class e2e {

	@Test
	public void e2e() throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Click on from drop down
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// select banglore from the drop down
		driver.findElement(By.xpath("//a[text()=' Bengaluru (BLR)']")).click();
		Thread.sleep(3000);
		// select chennai from To drop down
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation1')]//a[text()=' Chennai (MAA)']")).click();
		Thread.sleep(2000);
		// click on the current date
		driver.findElement(By.xpath("//td[contains(@class,' ui-datepicker-days-cell')]")).click();
		// Validate Return Date is Disabled
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It is Disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		// Click on Senior citizen check box
		driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
		Thread.sleep(2000);
		// click on Adult drop down
		driver.findElement(By.id("divpaxinfo")).click();
		// To select 5 Adult
		int i = 5;
		for (int j = 1; j < 5; j++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		// click on Search options
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
}
