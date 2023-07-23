package ActionsDemo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class practise {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement footer = driver.findElement(By.xpath("//a[text()='REST API']/../.."));
		List<WebElement> link = footer.findElements(By.tagName("a"));
//		ArrayList<String> al = new ArrayList<String>();
//		for (WebElement lv : link) {
//			al.add(lv.getAttribute("href"));
//		}
//		for (String lv : al) {
//			driver.switchTo().newWindow(WindowType.TAB);
//			driver.get(lv);
//		   
//		}
		for (WebElement lv : link) {
			String cli = Keys.chord(Keys.CONTROL, Keys.ENTER);
			lv.sendKeys(cli);

		}

		Set<String> allWindow = driver.getWindowHandles();
		for (String lv : allWindow) {
			driver.switchTo().window(lv);
			Thread.sleep(7000);
			System.out.println(driver.getTitle());
		}
	}

	public void switchRightWindow(WebDriver driver, String window) {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String lv : allWindow) {
			String title = driver.switchTo().window(lv).getTitle();
			if (title.contains(window)) {
				driver.switchTo().window(lv);
				break;
			}
		}
	}

}
