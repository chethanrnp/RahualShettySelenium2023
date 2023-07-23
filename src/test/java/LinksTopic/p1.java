package LinksTopic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class p1 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// Fetches all the links in the webpage
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		// check the fetched links
		for (WebElement lv : links) {
			String li = lv.getAttribute("href");
			verifyLink(li);
		}

	}

	public static void verifyLink(String url) throws Throwable {
		// creating the object of urlconnection class and calling open connection method
		// and casting to Http
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		// creating the object of soft assert for validation
		SoftAssert a = new SoftAssert();
		// validation using soft assert
		a.assertTrue(conn.getResponseCode() >= 400, url + "=" + conn.getResponseCode() + " is a broken link");
		a.assertTrue(conn.getResponseCode() <= 200, url + conn.getResponseCode());
		// validation using the if else conditon
//				if (conn.getResponseCode() >= 400) {
//					System.out.println(li + "=" + conn.getResponseMessage() + "is a broken link");
//				} else {
//					System.out.println(li + conn.getResponseMessage());
//				}
	}
}
