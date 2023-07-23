package SSLCertification;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ExpiredWebsite {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		// sets the behavior of the browser
		ChromeOptions options = new ChromeOptions();
		//In firefox browser and rest is same
		FirefoxOptions options1 = new FirefoxOptions();
		options.addArguments("--remote-allow-origins=*");
		// accepts the certificates
		options.setAcceptInsecureCerts(true);
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}

}
