package StepDefinitions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.junit.Assert;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;


public class Steps extends BaseClass{

	@Before
	public void setup() throws IOException
	{
		//Reading Properties
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("Config.properties");
		configProp.load(configPropfile);
				
	}
	
	@Given("User launch Chrome Browser")
	public void user_launch_Chrome_Browser() {
		
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		
		else if(br.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));  
		driver = new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));  
			driver = new InternetExplorerDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);   
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
//		driver.findElement(By.id("Email")).sendKeys(email);
		lp.UserName(email);
		lp.Password(password);
    }

	@When("clicks on Login")
	public void clicks_on_Login() {
	    lp.clickLogin();
	}

	
	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful")) {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }
	    else {
	    	Assert.assertEquals(title, driver.getTitle());
	    } 
		}

	@When("user click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}
	
	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
	//Customer Feature Step Defintition--------------------------------------

	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User clicks on customer menu")
	public void user_clicks_on_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
		}

	@When("Clicks on customer Menu Item")
	public void clicks_on_customer_Menu_Item() throws InterruptedException {
		Thread.sleep(3000);
	    addCust.clickOnCustomersMenuItem();
	}

	@When("Click on Add new Button")
	public void click_on_Add_new_Button() throws InterruptedException {
	    addCust.clickOnAddnew();
	    Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
	   Assert.assertEquals("Add a new customer / nopCommerce administration",  addCust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	    String email = randomString()+"@gmail.com";
	    addCust.setEmail(email);
	    addCust.setPassword("test123");
	    
	    //Registered - default
	    //The customer cannot be in both "Guests" and "Registered" customer roles
	    //Add the customer to "Guests" or "Registered" customer role
	    
	    addCust.setCustomerRoles("Guest");
	    Thread.sleep(3000);
	    	    
	    addCust.setManagerOfVendor("Vendor 2");
	    	addCust.setGender("Female");
	    	addCust.setFirstName("Sathya");
	    	addCust.setLastName("Elangovan");
	    	addCust.setCompanyName("IBM");
	    	addCust.setAdminContent("This is for testing------");
	    	
	}
	
	    	
	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
			addCust.clickSubmit();
			Thread.sleep(3000);
			
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String ConfirmationMessage) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
		
	    
	}
	
	// Steps for searching a customer using EmailId------------------------------
	
	@When("Enters Customer Email")
	public void enters_Customer_Email() throws InterruptedException {
	   searchCustomer = new SearchCustomerPage(driver); 
	   searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCustomer.clickSearch();
		Thread.sleep(3000);
	}
	
	@Then("user should found Email in the search table")
	public void user_should_found_Email_in_the_search_table() {
	    boolean status = searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	    Assert.assertEquals(true,status);
	    
	}


}
