package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	//locators
	private By pageTitle = By.xpath("//span[@class=\"title\"]");
	private By firstNameInput = By.id("first-name");
	private By lastNameInput = By.id("last-name");
	private By postalCodeInput = By.id("postal-code");
	private By cancelButton = By.xpath("//button[@class=\"btn btn_secondary back btn_medium cart_cancel_link\"]");
	private By continueButton = By.xpath("//input[@class=\"submit-button btn btn_primary cart_button btn_action\"]");

	//actions
	public String getTitle() {
		return driver.findElement(pageTitle).getText();
	}
	public void inputFirstName(String firstName) {
		driver.findElement(firstNameInput).sendKeys(firstName);
	}
	public void inputLasttName(String lastName) {
		driver.findElement(lastNameInput).sendKeys(lastName);
	}
	public void inputPostalCode(String postalCode) {
		driver.findElement(postalCodeInput).sendKeys(postalCode);
	}
	public void clickCancel() {
		driver.findElement(cancelButton).click();
	}
	public void clickContinue() {
		driver.findElement(continueButton).click();
	}
	



}
