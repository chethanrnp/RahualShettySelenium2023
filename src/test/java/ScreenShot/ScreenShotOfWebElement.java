package ScreenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScreenShotOfWebElement {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement name = driver.findElement(By.xpath("//input[contains(@class,'form-control ng-u')]"));
		// enters data into name
		name.sendKeys("chethan");
		// gets title of the webpage
		String title = driver.getTitle();
		// taking ScreenShot of the Webelemet
		File src = name.getScreenshotAs(OutputType.FILE);
		// coping data from soure to file
		FileUtils.copyFile(src, new File(".\\ScreenShoot\\" + title + ".png"));
	}

}
