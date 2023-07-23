package dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class dynamicDropDown {

	@Test
	public void dynamicDropDown() throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
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
	}
}
