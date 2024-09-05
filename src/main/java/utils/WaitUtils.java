package utils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void explicitlyWaitForVisibility(WebDriver driver, WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(elementToWait));
	}
	
	public static void explicitlyWaitForInVisibility(WebDriver driver, WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(elementToWait));
	}
	
	public static void explicitlyWaitForClickableElement(WebDriver driver, WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
	}
	
	
	public static void fluentlyWait(WebDriver driver, WebElement elementToWait) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(2000));
		WebElement ele = fWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return elementToWait;
			}
		});
	}
	
	
	
	
	
	
	

}
