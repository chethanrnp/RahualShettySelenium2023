package pop_Up;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class javaScriptPopUp {

	@Test
	public void javaScriptPopUp() {
		String name = "chethan";
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// enters name to the text box
		driver.findElement(By.xpath("//fieldset[@class='pull-right']//input[@id='name']")).sendKeys(name);
		// click on Alert button
		driver.findElement(By.xpath("//fieldset[@class='pull-right']//input[@id='alertbtn']")).click();
		// switches to Alert
		Alert a = driver.switchTo().alert();
		// print the Text in the alert
		System.out.println(a.getText());
		// Validate the alert
		if (a.getText().contains(name)) {
			// accept the alert
			a.accept();
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		// click on confirm button
		driver.findElement(By.xpath("//fieldset[@class='pull-right']//input[@id='confirmbtn']")).click();
		// dismiss the alert
		a.dismiss();
	}
}
