Feature: Customers
@sanity
Scenario: Add new Customer
	Given User launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters email as "admin@yourstore.com" and password as "admin"
	And clicks on Login
	Then User can view Dashboard
	When User clicks on customer menu
	And Clicks on customer Menu Item
	And Click on Add new Button
	Then User can view Add new customer page
	When User enter customer info
	And click on Save button
	Then User can view confirmation message "The new customer has been added successfully"
	And close browser
	
@regression	
Scenario: Search Customer by EmailId
Given User launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters email as "admin@yourstore.com" and password as "admin"
	And clicks on Login
	Then User can view Dashboard
	When User clicks on customer menu
	And Clicks on customer Menu Item
	And Enters Customer Email
	When click on search button
	Then user should found Email in the search table
	And close browser
	
	
