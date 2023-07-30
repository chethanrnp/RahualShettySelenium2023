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
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_2.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).keyDown(Keys.SHIFT)
				.sendKeys("sony").keyUp(Keys.SHIFT).doubleClick().build().perform();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='s-suggestion-container']")));
		List<WebElement> autoSugg = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
		System.out.println(autoSugg.getClass());
		for (WebElement lv : autoSugg) {
			if (lv.getText().equalsIgnoreCase("sony headphones")) {
				lv.click();
				break;
			}
		}
	}

}
