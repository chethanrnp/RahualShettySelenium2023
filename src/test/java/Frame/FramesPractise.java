package Frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FramesPractise {

	@Test
	public void framesPractise() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// to find number of frame
		System.out.println(driver.findElement(By.xpath("//iframe")));
		// switch the control to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		// create a Actions class]
		Actions a = new Actions(driver);
		// drag and drop the element
		a.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")),
				driver.findElement(By.xpath("//div[@id='droppable']"))).build().perform();
		// Bring control outside the frame
		driver.switchTo().defaultContent();
	}
}
