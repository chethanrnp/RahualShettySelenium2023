package LinksTopic;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class openLinksInSeperateTabs {

	@Test
	public void openLinksInSeperateTabs() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// switch the driver control to particular column
		WebElement coloumDriver = driver.findElement(By.xpath("//a[text()='REST API']/../.."));
		// find number of links in particular column
		List<WebElement> links = coloumDriver.findElements(By.tagName("a"));
		System.out.println(links.size());
		// to click on every link and open in new tab
		for (WebElement lv : links) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			lv.sendKeys(clickOnLinkTab);
		}
		// To get all Tabs title
		new openLinksInSeperateTabs().getTitel(driver);
	}

	public void getTitel(WebDriver driver) {
		// gets id of all window
		Set<String> allWindow = driver.getWindowHandles();
		for (String lv : allWindow) {
			// Switches to window
			driver.switchTo().window(lv);
			// prints the tilte of the window
			System.out.println(driver.getTitle());
		}
	}
}
