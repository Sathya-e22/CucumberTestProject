package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

public WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(id = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(id = "search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(xpath = "//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void setEmail(String Email) throws InterruptedException
	{
		txtEmail.clear();
		txtEmail.sendKeys("victoria_victoria@nopCommerce.com");
		Thread.sleep(4000);
	}
	public void setFirstName(String fname) throws InterruptedException
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
		Thread.sleep(4000);
	}
	public void setLastName(String lname) throws InterruptedException
	{
		txtLastName.clear();
		txtLastName.sendKeys(lname);
		Thread.sleep(4000);
	}
	public void clickSearch() {
		btnSearch.click();
	}
	public int getNoOfRows()
	{
		return(tableRows.size());
	}
	public int getNoOfColumns()
	{
		return(tableColumns.size());
	}
	public boolean searchCustomerByEmail(String Email) {
		boolean flag= false;
		for(int i=1; i<getNoOfRows();i++)
		{
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			
			System.out.println(emailid);
			
			if(emailid.equals(Email))
			{
				flag=true;
		}
		}
		return flag;
	}
	
}
