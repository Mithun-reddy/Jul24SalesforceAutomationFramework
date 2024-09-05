package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//input[@id='username']")
	public WebElement userName;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "forgot_password_link")
	public WebElement forgotPassowrd;

	@FindBy(name = "rememberUn")
	public WebElement rememberMe;

	@FindBy(id = "hint_back_chooser")
	public WebElement savedUserName;
	
	@FindBy(how = How.ID, using = "error")
	public WebElement errorMessage;
	
	
	public void enterUsername(String username) {
		this.userName.sendKeys(username);
	}
	
	public void enterPassword(String passWord) {
		this.password.sendKeys(passWord);
	}
	
	public String getErrorMessage() {
		return this.errorMessage.getText();
	}
	
	public void clickLogin() {
		this.loginButton.click();
	}
	
	public String getValueAttribute(WebElement element) {
		return element.getAttribute("value");
	}
	
	public HomePage loginToApp(WebDriver driver, String username, String passWord) {
		this.enterUsername(username);
		this.enterPassword(passWord);
		this.clickLogin();
		return new HomePage(driver);
	}

}
