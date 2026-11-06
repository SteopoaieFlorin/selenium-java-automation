package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
	WebDriver driver;
	public CheckoutCompletePage(WebDriver driver) {
		this.driver=driver;
	}
	//locators
	private By title = By.xpath("//span[@class=\"title\"]");
	private By message = By.xpath("//h2[@class=\"complete-header\"]");
	private By backButton = By.xpath("//button[@class=\"btn btn_primary btn_small\"]");
	//actions
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public String getMessage() {
		return driver.findElement(message).getText();
	}
	public void clickBack() {
		driver.findElement(backButton).click();
	}
}
