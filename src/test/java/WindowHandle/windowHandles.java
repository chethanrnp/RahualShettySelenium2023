package WindowHandle;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class windowHandles {

	@Test
	public void windowHandle() throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		// click on new tab link
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		// switch control to child window
		switchChildWindow(driver);
		// waits until the element to be visible
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='im-para red']")));
		// to get the user name
		String text = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		String usrName = text.split(" ")[4];
		// switch back to parent window
		switchBackMainWindow(driver);
		// enters user name
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(usrName);

	}

	public void switchParentWindow(WebDriver driver) {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String lv : allWindow) {
			driver.switchTo().window(lv);
			if (!lv.equals(mainWindow)) {
				break;
			}
		}
		driver.switchTo().window(mainWindow);
	}

	public void switchChildWindow(WebDriver driver) {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String lv : allWindow) {
			driver.switchTo().window(lv);
			if (!(lv.equals(mainWindow))) {
				driver.switchTo().window(lv);
				break;
			}
		}

	}

	public void switchBackMainWindow(WebDriver driver) {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String lv : allWindow) {
			driver.switchTo().window(lv);
			if (!(lv.equals(mainWindow))) {
				driver.switchTo().window(lv);
				break;
			}
		}

	}

	public void switchRightWindow(WebDriver driver, String windowTitle) {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String lv : allWindow) {
			String title = driver.switchTo().window(lv).getTitle();
			if (title.contains(windowTitle)) {
				driver.switchTo().window(lv);
				break;
			}

		}
	}
}
