package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.ProductCatalogue;
import testComponents.BaseTest;

public class SearchAndAddToCart extends BaseTest{

	@Test(dataProvider="getData")
	public void searchAndAddToCart(HashMap<String,String> input) throws InterruptedException
	{
		LandingPage lp = new LandingPage(driver);
		lp.loginApplication(input.get("email"), input.get("password"));
		ProductCatalogue pc= new ProductCatalogue(driver);
		pc.addProductToCart(input.get("product"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//Order.json");
		return new Object[][] {{data.get(0)}};

	}
}
