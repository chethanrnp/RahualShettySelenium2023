package Miscelleanous;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindow_Type {
	/*
	 * opening two url @ a time
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// opening new url in another window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.rahulshettyacademy.com/");
		// control to new window
		new NewWindow_Type().switchRightWindow(driver, "Rahul Shetty Academy");
		// fetches the username
		String usn = driver.findElement(By.xpath("//a[contains(text(),'All-Access Membership')]")).getText();
		driver.close();
		// control to main window
		new NewWindow_Type().switchRightWindow(driver, "ProtoCommerce");
		// enters the user name
		driver.findElement(By.xpath("//input[contains(@class,'form-control ng-u')]")).sendKeys(usn);
	}

	public void switchRightWindow(WebDriver driver, String title) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String lv : allWindow) {
			String tite = driver.switchTo().window(lv).getTitle();
			if (tite.contains(title)) {
				driver.switchTo().window(lv);
				break;
			}
		}
	}
}
