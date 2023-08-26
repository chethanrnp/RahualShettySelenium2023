package calender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Calender {

	@Test
	public void calender() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on Calendar button
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		// Expected date and month
		String date = "20";
		String month = "September";
		// to select the desired month
		while (!(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().contains(month))) {
			// clicks on next button
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}

		// fetches all the date in the month
		List<WebElement> dat = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		for (WebElement lv : dat) {
			if (lv.getText().equalsIgnoreCase(date)) {
				// clicks on expected date
				lv.click();
				break;
			}
		}
	}
}
