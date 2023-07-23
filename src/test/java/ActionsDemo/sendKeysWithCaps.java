package ActionsDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class sendKeysWithCaps {

	@Test
	public void sendKeysWithCaps() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// creates the Actions Class
		Actions a = new Actions(driver);
		// enters the text in text box using capital letter and select the entered text
		a.contextClick(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).keyDown(Keys.SHIFT)
				.sendKeys("sony").keyUp(Keys.SHIFT).doubleClick().build().perform();
		// other method to send keys
//		a.sendKeys(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")), "sony").build().perform();
	}
}
