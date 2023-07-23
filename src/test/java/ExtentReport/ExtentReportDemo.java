package ExtentReport;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		// path where the report has to be stored
		String path = System.getProperty("user.dir") + "/reports/index.html";
		// creating object and passing the path responsible for creating html file
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		// set report name
		reporter.config().setReportName("Web Automation Results");
		// sets document name
		reporter.config().setDocumentTitle("Test Result");
		// creating object responsible for generating report
		extent = new ExtentReports();
		// attaching the config
		extent.attachReporter(reporter);
		// giving the name of the tester
		extent.setSystemInfo("Tester", "chethan");
	}

	@Test
	public void demo() {
		// resposible for watching the exicution of the test
		ExtentTest test = extent.createTest("demo");
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver_2.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getTitle());
		// to fail test or take screenshot
		test.fail("does not match");
		// responsible for generating report and stops monitoring
		extent.flush();
		driver.close();
	}
}
