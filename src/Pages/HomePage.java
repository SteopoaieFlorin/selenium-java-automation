package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestData.clases.Users;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	//locators 
	private By header = By.xpath("//div[@class=\"login_logo\"]");
	private By usernameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");
	private By error = By.xpath("//h3");
	
	//actions
	public Boolean isDisplayed() {
		return driver.findElement(loginButton).isDisplayed();
	}
	public String getHeader() {
		return driver.findElement(header).getText();
	}
	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	public void loginClick() {
		driver.findElement(loginButton).click();
	}
	public String getError() {
		return driver.findElement(error).getText();
	}
	public void login(Users user) {
		enterUsername(user.getUsername());
		enterPassword(user.getPassword());
		loginClick();
	}
}
