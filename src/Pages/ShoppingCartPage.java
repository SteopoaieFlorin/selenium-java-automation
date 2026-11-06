package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
	WebDriver driver;
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}
	//locators
	private By pageTitle = By.xpath("//span[@class=\"title\"]");
	private By itemInTheCart = By.xpath("//div[@class=\"inventory_item_name\"]");
	private By backToShoppingButton = By.xpath("//button[@class=\"btn btn_secondary back btn_medium\"]");
	private By checkOutButton = By.xpath("//button[@class=\"btn btn_action btn_medium checkout_button \"]");
	
	//actions
	
	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
	}
	public String getItemInTheCartName() {
		return driver.findElement(itemInTheCart).getText();
	}
	public void goBackToShopping() {
		driver.findElement(backToShoppingButton).click();
	}
	public void goToCheckOut() {
		driver.findElement(checkOutButton).click();
	}


}
