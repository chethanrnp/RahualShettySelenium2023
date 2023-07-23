package enabledAndDisabled;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practiseEnableAndDisable {

	@Test
	public void practiseEnableAndDisable() throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Get the Attribute in Disabled Condition
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		// Click on Round Trip Radio Button to Make Enable
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		// Get the Attribute in Enable Condition
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		// validation it is Enabled
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("It is Enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
}
