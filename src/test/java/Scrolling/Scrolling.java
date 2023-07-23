package Scrolling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// javascriptExecutor for scrolling and takescreenshot
		JavascriptExecutor j = (JavascriptExecutor) driver;
		// scrolling to desired table
		WebElement table = driver.findElement(By.xpath("//div[@class='tableFixHead']"));
		// finding x and y location of table
		int x = table.getLocation().getX();
		int y = table.getLocation().getY();
		// scrolling to desired table
		j.executeScript("window.scrollBy(" + x + "," + y + ")");
		// scroll inside the table
		j.executeScript("document.querySelector('.tableFixHead').scrollTop=400");
	}

}
