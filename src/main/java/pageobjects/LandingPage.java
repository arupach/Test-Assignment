package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="ap_email")
	WebElement userEmail;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="ap_password")
	WebElement passwordele;
	
	@FindBy(id="signInSubmit")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	
	public  void loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		continueButton.click();
		passwordele.sendKeys(password);
		submit.click();
		
//		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
//		return productCatalogue;
		
		
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
