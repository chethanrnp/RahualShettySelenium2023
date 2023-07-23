package locatorsInSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class windowActivity {

	@Test
	public void windowActivity() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// opens the new webpage
		driver.navigate().to("https://www.facebook.com/login/");
		// navigates back to google home page
		driver.navigate().back();
		// navigates to facebok home page
		driver.navigate().forward();
	}
}
