package PageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {

	
	WebDriver driver;
	
	public LoginPOM (WebDriver driver)
	{
		//Intialization
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page Factory
	@FindBy(id= "userEmail")
	WebElement userEmail;
	
	@FindBy(id= "userPassword")
	WebElement userPassword;
	
	@FindBy (id = "login")
	WebElement submit;
	
	public ProductListingPage loginApplication (String email, String password) throws InterruptedException {
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		Thread.sleep(3000);
        submit.click();
        ProductListingPage plp = new ProductListingPage(driver);
        return plp;
	}
	
	public void goToSite() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}

}


