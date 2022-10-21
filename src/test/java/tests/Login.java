package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.ProductCatalogue;
import testComponents.BaseTest;

public class Login extends BaseTest{
	
	@Test(dataProvider="getData")
	public void login(HashMap<String,String> input) throws IOException, InterruptedException
	{
		LandingPage lp = new LandingPage(driver);
		lp.loginApplication(input.get("email"), input.get("password"));
	}
	

	@DataProvider
	public Object[][] getData() throws IOException
	{

		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//Order.json");
		return new Object[][] {{data.get(0)}};

	}
}
