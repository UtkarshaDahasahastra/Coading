package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyAbstarctComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
   WebDriver driver;
   
   public ConfirmationPage(WebDriver driver) {
	   super(driver);
	   this.driver= driver;
	   PageFactory.initElements(driver, this);
	   
   }
   @FindBy (css = ".hero-primary")
   WebElement confirmMessage;
   
   @FindBy (css= "tr td:nth-child(3)")
	WebElement orderlink;
   
   
   public String getConfirmationMessage()
   {
	   return confirmMessage.getText();
   }

   public OrderPage goToOrderPage() {

	// Click on the "Go to Order Page" button

	orderlink.click();

	return new OrderPage(driver);

			}
}
