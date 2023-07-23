package LinksTopic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class numberOfLinksInfooterSection {

	@Test
	public void numberOfLinksInFooterSection() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// reduce the scope of the drier to footer section //div[@id='gf-BIG']
		WebElement footSec = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		// to find number of link in footer section
		System.out.println(footSec.findElements(By.tagName("a")).size());

	}
}
