package PageObject;

import java.time.Duration;

import PageObject.ProductListingPage;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPOM2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPOM loginpage = new LoginPOM(driver);
		loginpage.goToSite();
		ProductListingPage plp = loginpage.loginApplication("utkarsha1@gmail.com", "Utkarsha@1234");
		
		List <WebElement> products =plp.getProductList(); //
		plp.addproductToCart(productName);
		
		
		CartPage cartpage = plp.goToCartPage();
		Boolean match = cartpage.VerifyProductDisplay(productName);
		
		Assert.assertTrue(match);
		
		
		Checkout checkoutPage = cartpage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
		
		
		OrderPage orderpage = confirmationPage.goToOrdersPage();
		Boolean match1 = orderpage.VerifyOrderDisplay(productName);
		Assert.assertTrue(match1);
		
	}
		

	}


