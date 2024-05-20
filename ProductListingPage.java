package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyAbstarctComponents.AbstractComponents;

public class ProductListingPage extends AbstractComponents {
	WebDriver driver;
	public ProductListingPage (WebDriver driver)
	{
		//Initialization
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css = ".mb-3")
	List <WebElement> products;
	@FindBy (css = ".ng-animating")
	WebElement spinner;
	@FindBy (css = "#toast-container")
	WebElement toastMessage;
	@FindBy (xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");
	public List<WebElement> getProductList()
	{
		waitforElementToAppear (productsBy);
		return products;
	}
	public WebElement getProductByName (String productName) {
		WebElement prod= getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		return prod;
	}
	public void addproductToCart (String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		Thread.sleep(2000);
		prod.findElement(addToCart).click();
		waitforElementToAppear(toastMsg);
		waitForElementToDisappear(spinner);
		waitForElementToDisappear(toastMessage);
	}

}


