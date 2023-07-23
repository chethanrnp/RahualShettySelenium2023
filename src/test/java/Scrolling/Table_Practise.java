package Scrolling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Table_Practise {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		int actual = 0;
		// fetches all the price in the row
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		for (WebElement lv : prices) {
			// convert string to integer
			int a = Integer.parseInt(lv.getText());
			actual = actual + a;
		}
		// fetch total value
		String total = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(" ")[3];
		int expected = Integer.parseInt(total);
		// Validation
		Assert.assertEquals(actual, expected);
	}

}
