package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import utils.FileUtils;

public class LoginTest extends BaseTest {
	
	
	@Test()
	public void loginErrorMessageTC01() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		lp = new LoginPage(driver);
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		String expectedUsername = FileUtils.readLoginPropertiesFile("valid.username");
		lp.enterUsername(expectedUsername);
		String actualUsername = lp.getValueAttribute(lp.userName);
		Assert.assertEquals(expectedUsername, actualUsername, "The actual and expected usernames should be same");
		lp.password.clear();
		String actualPassword = lp.getValueAttribute(lp.password);
		Assert.assertEquals("", actualPassword, "The actual and expected passwords should be same");
		lp.clickLogin();
		Assert.assertEquals(lp.getErrorMessage(), FileUtils.readLoginPropertiesFile("error.text"), "Error message should be same");
	}
	
	@Test()
	public void loginToSalesforceTC02() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		lp = new LoginPage(driver);
		LoginPage lp = new LoginPage(driver);
		SoftAssert sa = new SoftAssert();
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		String expectedUsername = FileUtils.readLoginPropertiesFile("valid.username");
		lp.enterUsername(expectedUsername);
		String actualUsername = lp.getValueAttribute(lp.userName);
		sa.assertEquals(expectedUsername, actualUsername, "The actual and expected usernames should be same");
		lp.enterPassword(FileUtils.readLoginPropertiesFile("valid.password"));
		lp.clickLogin();
		sa.assertEquals(driver.getTitle(), FileUtils.readLoginPropertiesFile("homepage.title"));
		System.out.println("Reached last line");
		sa.assertAll();
	}
	
	@Test()
	public void loginToSalesforce() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(FileUtils.readLoginPropertiesFile("prod.url"));
		String expectedUsername = FileUtils.readLoginPropertiesFile("valid.username");
		HomePage hPage = lp.loginToApp(driver, expectedUsername, FileUtils.readLoginPropertiesFile("valid.password"));
		Assert.assertEquals(driver.getTitle(), FileUtils.readLoginPropertiesFile("homepage.title"));
		Assert.assertTrue(hPage.isHomePage(), "User should be in home page");
	}
}
