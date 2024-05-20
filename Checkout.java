package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyAbstarctComponents.AbstractComponents;

public class Checkout extends AbstractComponents{
	WebDriver driver;
	public Checkout(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy (xpath="//a[contains(text(),'Place Order ')]")
    WebElement submit;
 
 @FindBy (css="[placeholder='Select Country']")
 WebElement country;
 
 @FindBy (xpath = "//button[contains(@class,'ta-item')][2]")
 WebElement selectCountry;
 
 By results = By.cssSelector(".ta-results");
 
 public void selectCountry(String countryName) {
	 Actions a = new Actions (driver);
	 a.sendKeys(country, countryName).build().perform();
	 waitforElementToAppear(results);
	 selectCountry.click();
	 
 }
 public ConfirmationPage submitOrder() throws InterruptedException {
	 Thread.sleep(2000);
	 submit.click();
	 return new ConfirmationPage(driver);
 }
 }

