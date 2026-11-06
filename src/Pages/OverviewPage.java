package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestData.clases.Products;

public class OverviewPage {
	WebDriver driver;
	public OverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	//locators
	private By title = By.xpath("//span[@class=\"title\"]");
	private By itemTotal = By.xpath("//div[@class=\"summary_subtotal_label\"]");
	private By itemTax = By.xpath("//div[@class=\"summary_tax_label\"]");
	private By total = By.xpath("//div[@class=\"summary_total_label\"]");
	private By	itemName = By.xpath("//div[@class=\"inventory_item_name\"]");
	private By itemDescription = By.xpath("//div[@class=\"inventory_item_desc\"]");
	private By itemPrice = By.xpath("//div[@class=\"inventory_item_price\"]");
	private By finishButton = By.id("finish");
	
	//actions
	
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	public String getItemTotal() {
		return driver.findElement(itemTotal).getText();
	}
	public String getItemTax() {
		return driver.findElement(itemTax).getText();
	}
	public String getTotal() {
		return driver.findElement(total).getText();
	}
	public String getItemName() {
		return driver.findElement(itemName).getText();
	}
	public String getItemDesc() {
		return driver.findElement(itemDescription).getText();
	}
	public String getItemPrice() {
		return driver.findElement(itemPrice).getText();
	}
	public void finishShopping() {
		driver.findElement(finishButton).click();
	}
	public String calcItemTax(Products produs) {
		Double price = Double.parseDouble(produs.getProductPrice());
		double tax = Math.round((price*0.08)*100.0)/100.0;
		return String.valueOf(tax);
	}
	public String calcTaxAndPrice(Products produs) {
		return String.valueOf((Math.round(((Double.parseDouble(produs.getProductPrice()))*100.0))/100.0)+Double.parseDouble(calcItemTax(produs)));
	}
}
