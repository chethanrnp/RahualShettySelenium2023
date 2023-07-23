package calender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practise {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver_2.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.globalsqa.com/demo-site/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		// click on Calendar button
		Actions a = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//p[text()='Date: ']//input[@id='datepicker']"));
		element.click();
		String month = "September";
		String date = "20";
		while (!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().contains(month)) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
		List<WebElement> dat = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		for (WebElement lv : dat) {
			if (lv.getText().contains(date)) {
				lv.click();
			}
		}

	}

}
