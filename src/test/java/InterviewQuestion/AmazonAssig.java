package InterviewQuestion;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonAssig {

	@Test
	public void amazonAssig() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Product Required to Add to Chart
		String[] pro = { "Cucumber", "Carrot" };
		int l = pro.length;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
