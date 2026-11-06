package Test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import TestData.Pages.SwagLabsApp;

public class LoginTests extends BaseTest {
	@Test
	public void loginSuccesfull() throws InterruptedException {
		homePage.login(standardUser);
		Thread.sleep(1000);
		Assert.assertEquals(productsPage.getTitle(),SwagLabsApp.PRODUCTS_TITLE);
	}
	@Test 
	public void loginInvalid() throws InterruptedException {
		homePage.login(wrongUser);
		Thread.sleep(5000);
		Assert.assertEquals(homePage.getError(), SwagLabsApp.WRONG_PASSWORD_ERROR);
	}
	@Test
	public void loginLockedUser() throws InterruptedException {
		homePage.login(lockedOutUser);
		Thread.sleep(1000);
		Assert.assertEquals(homePage.getError(), SwagLabsApp.LOCKED_OUT_USER_ERROR);
	}
}
