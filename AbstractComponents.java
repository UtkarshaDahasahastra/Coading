package rahulshettyAbstarctComponents;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.CartPage;
import PageObject.OrderPage;

public class AbstractComponents {
	WebDriver driver;
	
	public AbstractComponents (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy (xpath= "//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy (css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void waitforElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public CartPage goToCartPage() throws InterruptedException 
	{
		cartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	public OrderPage goToOrdersPage() throws InterruptedException 
	{
		orderHeader.click();
		OrderPage ordersPage = new OrderPage(driver);
		return ordersPage;
	}
	public void waitForElementToDisappear (WebElement ele) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	//Thread.sleep (1000);
	// Or use Thread.sleep (1000) to speed up the execution process

	}
	
	}
