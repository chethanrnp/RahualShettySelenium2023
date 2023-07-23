package locatorsInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginPractiseWithFirefox {

	@Test
	public void loginPractise() {
		System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Enter the user name
		driver.findElement(By.id("inputUsername")).sendKeys("chethan");
		// Enter the password
		driver.findElement(By.name("inputPassword")).sendKeys("Chethan@17");
		// click on sign in
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());
		// Click on forget password to get correct password
		driver.findElement(By.xpath("//a[contains(text(),'Forgot ')]")).click();
		// enter the name
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("chethan");
		// enter the E-mail
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("chethan@17");
		// enter the phone number
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9620711667");
		// click on re-set password
		driver.findElement(By.className("reset-pwd-btn")).click();
		// Get the password
		String[] pass = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText().split(" ");
		String[] pas = pass[4].split("'");
		System.out.println(pas[1]);
		// Click on go-to Sign-in
		driver.findElement(By.xpath("//button[contains(text(),'Go')]")).click();
		// Enter the user name
		driver.findElement(By.id("inputUsername")).sendKeys("chethan");
		// Enter the password
		driver.findElement(By.name("inputPassword")).sendKeys(pas[1]);
		// click on sign-in
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
}
