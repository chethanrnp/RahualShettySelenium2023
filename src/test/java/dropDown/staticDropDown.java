package dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class staticDropDown {

	@Test
	public void staticDropDown() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// when tag name is select use select object
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		// create object of select class
		Select s = new Select(staticDropDown);
		// select using index
		s.selectByIndex(3);
		// get text of the selected value
		System.out.println(s.getFirstSelectedOption().getText());
		// select using visible text
		s.selectByVisibleText("AED");
		// get text of the selected value
		System.out.println(s.getFirstSelectedOption().getText());
		// select using value
		s.selectByValue("INR");
		// get text of the selected value
		System.out.println(s.getFirstSelectedOption().getText());
	}
}
