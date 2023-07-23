package dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class upDatedDropDown {

	@Test
	public void upDatedDropDown() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on Adult drop down
		driver.findElement(By.id("divpaxinfo")).click();
		// To select 5 Adult
		int i = 5;
		for (int j = 1; j < 5; j++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		// click on Done options
		driver.findElement(By.id("btnclosepaxoption")).click();
		// get text of selected Adult
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}
}
