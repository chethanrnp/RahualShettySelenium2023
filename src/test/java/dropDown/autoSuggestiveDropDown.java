package dropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class autoSuggestiveDropDown {

	@Test
	public void autoSuggestive() throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// enters data in auto suggestive drop down
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		// gets all the options in autosuggestive drop down
		List<WebElement> options = driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
		System.out.println(options.getClass());
		// To click on auto suggestive drop down
		for (WebElement lv : options) {
			if (lv.getText().equalsIgnoreCase("India")) {
				lv.click();
				break;
			}
		}

	}

}
