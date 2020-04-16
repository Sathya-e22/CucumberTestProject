package StepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	
	public AddCustomerPage addCust;
		
	//created for generating random string for unique email
	public static String randomString() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
}
