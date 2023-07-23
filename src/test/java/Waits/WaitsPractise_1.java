package Waits;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsPractise_1 {

	@Test
	public void waitsPractise() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Product Required to Add to Chart
		String[] pro = { "Cucumber", "Carrot" };
		String expected = "Code applied ..!";
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		new WaitsPractise_1().addToCart(driver, pro);
		// click on Cart DropDown
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		// click on proceed to check out button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='PROCEED TO CHECKOUT']"))).click();
		// enters data to the text box
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")))
				.sendKeys("rahulshettyacademy");
		// driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		// click on apply button
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		// validate whether promocode is applied
		Assert.assertEquals(wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']"))).getText(),
				expected);
		// click on place order
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();
	}

	public void addToCart(WebDriver driver, String[] pro) {
		int l = pro.length;
		// gets all the products name from the webpage
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j = 0;
		// To click on required Product
		for (int i = 0; i < products.size(); i++) {
			// Converting Array to Arraylist
			List<String> itemNeeded = Arrays.asList(pro);
			String product = products.get(i).getText().split(" ")[0].trim();
			// click on Add To Cart Button
			if (itemNeeded.contains(product)) {
				// click on Add To Cart Button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == l) {
					break;
				}
			}
		}
	}
}
