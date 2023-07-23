package locatorsInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginPractiseWithMethod {

	@Test
	public void loginPractiseWithMethod() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String pass = getPassword(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// Enter the user name
		driver.findElement(By.id("inputUsername")).sendKeys("chethan");
		// Enter the password
		driver.findElement(By.name("inputPassword")).sendKeys(pass);
		// click on sign in
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		// verification for sucessfully login
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'successfully')]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'successfully')]")).getText(),
				"You are successfully logged in.");
		// click on log out button
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		// close the window
		driver.close();
	}

	public String getPassword(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// Click on forget password to get correct password
		driver.findElement(By.xpath("//a[contains(text(),'Forgot ')]")).click();
		// click on re-set password
		driver.findElement(By.className("reset-pwd-btn")).click();
		// Get the password
		String pass = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText().replace("'", "").split(" ")[4];
		// return the password
		return pass;
	}
}
