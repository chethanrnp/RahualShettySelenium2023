package ScreenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScreenShotOfEWebPage {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver_2.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title = driver.getTitle();
		System.out.println(title);
		// creating object of screenshot
		TakesScreenshot t = (TakesScreenshot) driver;
		// storing capturing screenshot in file
		File src = t.getScreenshotAs(OutputType.FILE);
		// creating folder to store the screenshot
		File dest = new File(".\\ScreenShoot\\" + title + ".png");
		// copying from source to destination
		FileUtils.copyFile(src, dest);
	}

}
