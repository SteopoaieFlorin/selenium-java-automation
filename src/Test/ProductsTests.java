package Test;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import TestData.Pages.SwagLabsApp;
import Utils.RandomGenerator;

public class ProductsTests extends BaseTest {
	@Before
	public void Before() {
		super.before();
		homePage.login(standardUser);
		Assert.assertEquals(productsPage.getTitle(), SwagLabsApp.PRODUCTS_TITLE);
	}

	@Test
	public void addAndRemoveProduct() throws InterruptedException {
		productsPage.addToCartSpecific(tshirt);
		Thread.sleep(1000);
		Assert.assertEquals(productsPage.cartButtonTextForSpecific(tshirt), SwagLabsApp.CART_BUTTON_STATUS_REMOVE);
		productsPage.addToCartSpecific(tshirt);
		Thread.sleep(1000);
		Assert.assertEquals(productsPage.cartButtonTextForSpecific(tshirt), SwagLabsApp.CART_BUTTON_STATUS_ADD);
	}

	@Test
	public void booking() throws InterruptedException {
		productsPage.clickOnSpecificItem(backpack);
		Thread.sleep(500);
		Assert.assertTrue(productsInfo.buttonIsDisplayed());
		Assert.assertEquals(backpack.getProductName(), productsInfo.getProductName());
		Assert.assertEquals(backpack.getProductDescription(), productsInfo.getProductDescription());
		Assert.assertTrue(productsInfo.getProductPrice().contains(backpack.getProductPrice()));
		productsInfo.addToCart();
		Thread.sleep(500);
		Assert.assertTrue(productsInfo.itemsInTheCart());
		productsInfo.clickCart();
		Thread.sleep(500);
		shoppingCartPage.goToCheckOut();
		Assert.assertEquals(checkoutPage.getTitle(), SwagLabsApp.CHECKOUT_PAGE_TITLE);
		Thread.sleep(500);
		checkoutPage.inputFirstName(RandomGenerator.stringValue(10));
		checkoutPage.inputLasttName(RandomGenerator.stringValue(10));
		String code = RandomGenerator.rndBetween(10000, 999999).toString();
		checkoutPage.inputPostalCode(code);
		checkoutPage.clickContinue();
		Thread.sleep(500);
		Assert.assertEquals(overviewPage.getTitle(), SwagLabsApp.OVERVIEW_PAGE_TITLE);
		Assert.assertEquals(overviewPage.getItemName(), backpack.getProductName());
		Assert.assertTrue(overviewPage.getItemPrice().contains(backpack.getProductPrice()));
		Assert.assertTrue(overviewPage.getItemTotal().contains(backpack.getProductPrice()));
		Assert.assertTrue(overviewPage.getItemTax().contains(overviewPage.calcItemTax(backpack)));
		Assert.assertTrue(overviewPage.getTotal().contains(overviewPage.calcTaxAndPrice(backpack)));
		overviewPage.finishShopping();
		Thread.sleep(500);
		Assert.assertEquals(checkoutCompletePage.getTitle(), SwagLabsApp.COMPLETE_PAGE_TITLE);
		Assert.assertEquals(checkoutCompletePage.getMessage(), SwagLabsApp.COMPLETE_PAGE_MESSAGE);

	}

	@Test
	public void organize() throws InterruptedException {
		List<String> productsNames = productsPage.productsNameList();
		List<Double> productsPrices = productsPage.productsPriceList();
		productsPage.orgAToZ();
		Thread.sleep(500);
		Collections.sort(productsNames);
		Assert.assertEquals(productsNames, productsPage.productsNameList());
		productsPage.orgZToA();
		Thread.sleep(500);
		Collections.sort(productsNames, Collections.reverseOrder());
		Assert.assertEquals(productsNames, productsPage.productsNameList());
		productsPage.orgLoHi();
		Thread.sleep(500);
		Collections.sort(productsPrices);
		Assert.assertEquals(productsPrices, productsPage.productsPriceList());
		productsPage.orgHiLo();
		Thread.sleep(500);
		Collections.sort(productsPrices, Collections.reverseOrder());
		Assert.assertEquals(productsPrices, productsPage.productsPriceList());

	}

	@Test
	public void logOut() throws InterruptedException {
		Thread.sleep(1000);
		productsPage.logOut();
		Thread.sleep(500);
		Assert.assertTrue(homePage.isDisplayed());
	}
}
