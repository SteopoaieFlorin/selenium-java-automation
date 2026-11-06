package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsInfo {
	WebDriver driver;
	public ProductsInfo(WebDriver driver) {
		this.driver = driver;
	}
		//locators
		private By backButton = By.id("back-to-products");
		private By productName = By.xpath("//div[@class=\"inventory_details_name large_size\"]");
		private By productDescription = By.xpath("//div[@class=\"inventory_details_desc large_size\"]");
		private By productPrice = By.xpath("//div[@class=\"inventory_details_price\"]");
		private By addToCartButton = By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory\"]");
		private By cartInfo = By.xpath("//span[@class=\"shopping_cart_badge\"]");
		private By cart = By.xpath("//a[@class=\"shopping_cart_link\"]");
		//actions
		
		public void goBackToProductsPage() {
			driver.findElement(backButton).click();
		}
		public String getProductName() {
			return driver.findElement(productName).getText();
		}
		public String getProductDescription() {
			return driver.findElement(productDescription).getText();
		}
		public String getProductPrice() {
			return driver.findElement(productPrice).getText();
		}
		public void addToCart() {
			driver.findElement(addToCartButton).click();
		}
		public Boolean buttonIsDisplayed() {
			return driver.findElement(backButton).isDisplayed();
		}
		public Boolean itemsInTheCart() {
			return driver.findElement(cartInfo).isDisplayed();
		}
		public void clickCart() {
			driver.findElement(cart).click();
		}
		
	}

