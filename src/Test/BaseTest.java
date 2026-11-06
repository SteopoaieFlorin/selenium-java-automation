package Test;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.CheckoutCompletePage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.OverviewPage;
import Pages.ProductsInfo;
import Pages.ProductsPage;
import Pages.ShoppingCartPage;
import TestData.Pages.SwagLabsApp;
import TestData.Pages.URL;
import TestData.clases.Products;
import TestData.clases.Users;


public class BaseTest {
	static WebDriver driver;
	static HomePage homePage;
	static ProductsPage productsPage;
	static ProductsInfo productsInfo;
	static ShoppingCartPage shoppingCartPage;
	static CheckoutPage checkoutPage;
	static OverviewPage overviewPage;
	static CheckoutCompletePage checkoutCompletePage;
	public Users standardUser = new Users("StandardUser");
	public Users wrongUser = new Users("WrongUser");
	public Users lockedOutUser = new Users("LockedOutUser");
	public Products backpack = new Products("Backpack");
	public Products bikelight = new Products("Bikelight");
	public Products girltshirt = new Products("Girltshirt");
	public Products jacket= new Products("Jacket");
	public Products onesie = new Products("Onesie");
	public Products tshirt = new Products("Tshirt");
	@BeforeClass
	public static void setUp() {
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		chromeOption.addArguments("disable-infobars"); // Disable infobars
		chromeOption.addArguments("disable-popup-blocking"); // Disable popup blocking
		chromeOption.addArguments("disable-default-apps"); // Disable default apps
		chromeOption.addArguments("no-first-run"); // Skip first run wizards
		chromeOption.addArguments("no-default-browser-check"); // Skip default browser check
		chromeOption.addArguments("--disable-search-engine-choice-screen");
		chromeOption.addArguments("start-maximized"); // Open browser in maximized mode
		chromeOption.addArguments("disable-notifications"); // Disable notifications
		chromeOption.addArguments("disable-extensions"); // Disable extensions
		chromeOption.addArguments("guest"); // Disable change password popup
	
		//System.setProperty("webdriver.chrome.driver","src/resource/chromedriver.exe");
		
		driver = new ChromeDriver(chromeOption);
		//wait implicit
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		productsPage = new ProductsPage(driver);
		productsInfo = new ProductsInfo(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		overviewPage = new OverviewPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
		
	}
	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	@Before
	public void before() {
		driver.get(URL.MAIN);
		Assert.assertEquals(SwagLabsApp.HEADER_TITLE, homePage.getHeader());	}
}

