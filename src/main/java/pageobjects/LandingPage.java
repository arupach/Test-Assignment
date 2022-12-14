package pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComponent;


public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public static Logger log =LogManager.getLogger(AbstractComponent.class.getName());
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
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement SignOn;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement AccountDetails;
	
	
	
	public  void loginApplication(String email,String password)
	{
		SignOn.click();
		userEmail.sendKeys(email);
		continueButton.click();
		passwordele.sendKeys(password);
		submit.click();
		
		String accDetails = AccountDetails.getText();
		Assert.assertTrue(accDetails.equalsIgnoreCase("Hello, Arup"));
		log.info("Successfully logged in to Amazon site");
	}
	
	public void goTo() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);
		
		String url = prop.getProperty("url");
		
		driver.get(url);
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
