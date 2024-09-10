package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pages.HomePage;
import pages.LoginPage;

public class BaseTest {
//	LoginPage lp = null;
//	WebDriver driver = null;
	HomePage hp = null;
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	public void setDriver(String browserName, boolean headless) {
		WebDriver driver = getDriver(browserName, false);
		threadLocalDriver.set(driver);
	}

	public WebDriver getBrowser() {
		return threadLocalDriver.get();
	}

	public WebDriver getDriver(String browserName, boolean headless) {
		WebDriver driver = null;
		String browser = browserName.toLowerCase();
		switch (browser) {
		case "chrome":
			if (headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
			break;
		}
		return driver;
	}

	@Parameters({"bName","headless"})
	@BeforeMethod(alwaysRun = true)
	public void setup(String browserName, boolean headLess) {
		setDriver(browserName, headLess);
		WebDriver driver = getBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

//	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		getBrowser().close();
	}

}
