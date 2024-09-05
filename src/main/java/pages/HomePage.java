package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='Community']")
	public WebElement communityPanel;
	
	public boolean isHomePage() {
		return this.communityPanel.isDisplayed();
	}

}
