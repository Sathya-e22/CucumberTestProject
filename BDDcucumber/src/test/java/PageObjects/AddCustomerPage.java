package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver =rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	By lnkCustomers_menu = By.xpath("(//span[text()='Customers'])[1]");
	By lnkCustomers_menuitem = By.xpath("(//a[@href='/Admin/Customer/List'])[1]");
	
	By btnAddnew = By.xpath("//a[@class='btn bg-blue']");
	
	By txtEmail = By.xpath("//input[@type='email']");
	By txtPassword = By.xpath("//input[@type='password']");
	
	By txtCustomerRoles = By.xpath("(//input[@class='k-input'])[2]");
	
	By lstitemAdministrators = By.xpath("//li[text()='Administrators']");
	By lstitemRegistered = By.xpath("//li[text()='Registered']");
	By lstitemGuests = By.xpath("//li[text()='Guests']");
	By lstitemVendors = By.xpath("//li[text()='Vendors']");
	
	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");
	
	By txtFirstName = By.xpath("(//div[@class='col-md-9']//input)[3]");
	By txtLastName = By.xpath("(//div[@class='col-md-9']//input)[4]");
	
	By txtDob = By.xpath("//input[@data-role='datepicker']");
	
	By txtCompanyName = By.xpath("(//input[contains(@class,'form-control text-box')])[5]");
	
	By txtAdminContent = By.xpath("//textarea[@class='form-control']");
	
	By btnSave =By.xpath("//button[text()[normalize-space()='Save']]");
	
	//Action Methods
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void clickOnCustomersMenu() {
	ldriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
		}
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	public void setEmail(String Email) {
		ldriver.findElement(txtEmail).sendKeys(Email);
	}
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	public void setCustomerRoles(String Role) throws InterruptedException
	{
		if(!Role.equals("Vendors")) //If role is vendors should not delete register 
		{
			ldriver.findElement(By.xpath("//span[@class='k-icon k-delete']"));	
		}
		ldriver.findElement(txtCustomerRoles).click();
		WebElement listitem;
		Thread.sleep(3000);
		
		if(Role.equals("Administrators"))
		{
			listitem = ldriver.findElement(lstitemAdministrators);
		}
		else if(Role.equals("Guests"))
		{
			listitem = ldriver.findElement(lstitemGuests);
		}
		else if (Role.equals("Registered"))
		{
			listitem = ldriver.findElement(lstitemRegistered);
		}
		else if (Role.equals("Vendors"))
		{
			listitem = ldriver.findElement(lstitemVendors);
		}
		else
		{
			listitem = ldriver.findElement(lstitemVendors);
		}
		
		//listitem.click();
		//Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
		
	}
	
	public void setManagerOfVendor(String value)
	{
		Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFemaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click();  //Default
		}
	}
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setCompanyName(String compName)
	{
		ldriver.findElement(txtCompanyName).sendKeys(compName);
	}
	public void setAdminContent(String adminContent)
	{
		ldriver.findElement(txtAdminContent).sendKeys(adminContent);;
	}
	public void clickSubmit()
	{
		ldriver.findElement(btnSave).click();
	}
}
