package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;


public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".s-main-slot")
	List<WebElement> products;

	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;

	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;

	@FindBy(linkText ="Apple iPhone 12 (64GB) - Purple")
	WebElement LinkButton;

	@FindBy(id ="add-to-cart-button")
	WebElement addToCart;

	By Link = By.linkText("Apple iPhone 12 (64GB) - Purple");
	By productsBy = By.cssSelector(".s-main-slot");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		System.out.println(products);
		return products;

	}

	public WebElement getProductByName(String productName)
	{	
		searchBar.sendKeys(productName);
		searchButton.click();
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(Link).getText().equals("Apple iPhone 12 (64GB) - Purple")).findFirst().orElse(null);
		System.out.println(prod.getText());
		return prod;

	}

	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.click();
		waitForWebElementToAppear(addToCart);
		addToCart.click();

	}
}
