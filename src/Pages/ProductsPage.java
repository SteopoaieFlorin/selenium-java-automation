package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestData.clases.Products;



public class ProductsPage {
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}
	//locators
	private By logOutButton = By.id("logout_sidebar_link");
	private By productNames = By.xpath("//div[@class=\"inventory_item_name \"]");
	private By productPrices = By.xpath("//div[@class=\"inventory_item_price\"]");
	private By shoppingCartLink = By.xpath("//a[@class=\"shopping_cart_link\"]");
	private By menuButton = By.id("react-burger-menu-btn");
	private By organizer = By.xpath("//select[@class=\"product_sort_container\"]");
	private By organizeAToZ = By.xpath("//option[@value=\"az\"]");
	private By organaziZToA = By.xpath("//option[@value=\"za\"]");
	private By organizeLowToHigh = By.xpath("//option[@value=\"lohi\"]");
	private By organizeHighToLow = By.xpath("//option[@value=\"hilo\"]");
	private By title = By.xpath("//span[@class=\"title\"]");
	private By productsInTheCart = By.xpath("//span[@class=\"shopping_cart_badge\"]");
	private By itemName(String itemName) {
		return By.xpath("//div[contains(text(),\""+itemName+"\")]");
	}
	private By specificItem(Products produs) {
		return By.xpath("//div[contains(text(),\""+produs.getProductName().toString()+"\")]");
	}
	private By specificItemAddToCart(String itemName) {
		return By.xpath("//div[contains(text(),\""+itemName+"\")]/ancestor::div[@class=\"inventory_item_label\"]/following-sibling::div/button");
	}
	private By specificItemToCart(Products produs) {
		return By.xpath("//div[contains(text(),\""+produs.getProductName().toString()+"\")]/ancestor::div[@class=\"inventory_item_label\"]//following-sibling::div/button");
	}
	public List<String> productsNameList(){
		List<WebElement> nameElements = driver.findElements(productNames);
		List<String> productNames = new ArrayList<String>();
		for(WebElement element:nameElements) {
			productNames.add(element.getText());
		}
		return productNames;
	}
	public List<Double>	productsPriceList(){
		List<WebElement> priceElements = driver.findElements(productPrices);
		List<Double> productsPrices = new ArrayList<Double>();
		for(WebElement element:priceElements) {
			productsPrices.add(Double.parseDouble((element.getText()).replace("$","")));
		}
		return productsPrices;
	}

	public void orgAToZ() {
		organizerClick();
		driver.findElement(organizeAToZ).click();
	}
	public void orgZToA() {
		organizerClick();
		driver.findElement(organaziZToA).click();
	}
	public void orgHiLo() {
		organizerClick();
		driver.findElement(organizeHighToLow).click();;
	}
	public void orgLoHi() {
		organizerClick();
		driver.findElement(organizeLowToHigh).click();
	}
	
	public String cartButtonTextForSpecific(Products produs) {
		return driver.findElement(specificItemToCart(produs)).getText();
	}
	public void checkForProductsInTheCart() {
		driver.findElement(productsInTheCart).isDisplayed();
	}
	public String howManyProductsInTheCart() {
		return driver.findElement(productsInTheCart).getText();
	}
	public void addToCartSpecific(Products produs) {
		driver.findElement(specificItemToCart(produs)).click();
	}
	public void addToCartSpecificItem(String itemName) {
		driver.findElement(specificItemAddToCart(itemName)).click();
	}
	public void shoppingCartClick() {
		driver.findElement(shoppingCartLink).click();
	}
	public void menuButtonClick() {
		driver.findElement(menuButton).click();
	}
	public void organizerClick() {
		driver.findElement(organizer).click();
	}
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public void clickOnSpecificItem(Products produs) {
		driver.findElement(specificItem(produs)).click();
}
	public void logOut() {
		menuButtonClick();
		driver.findElement(logOutButton).click();
	}
}
