package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pages.LoginPage;

public class BaseTest {
	LoginPage lp = null;
	WebDriver driver = null;
	
//	@BeforeSuite(alwaysRun =  true)
//	public void beforesuite() {
//		System.out.println("before suite");
//	}
//	
//	@AfterSuite(alwaysRun =  true)
//	public void aftersuite() {
//		System.out.println("After suite");
//	}
//	
//	@BeforeGroups(alwaysRun = true)
//	public void groups() {
//		System.out.println("Before groups");
//	}
//	
//	@BeforeTest
//	public void dummy() {
//		System.out.println("Before test");
//	}
//	
//	@BeforeClass
//	public void testBClass() {
//		System.out.println("Before class");
//	}
//	
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}
//	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
