Feature: Login

@sanity
Scenario: Successful login with valid credentials
Given User launch Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters email as "admin@yourstore.com" and password as "admin"
And clicks on Login
Then page title should be "Dashboard / nopCommerce administration"
When user click on Log out link
Then page title should be "Your store. Login"
And close browser

@regression
Scenario Outline: Login Data Driven
Given User launch Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters email as "<email>" and password as "<password>"
And clicks on Login
Then page title should be "Dashboard / nopCommerce administration"  
When user click on Log out link
Then page title should be "Your store. Login"
And close browser

Examples:
	| email | password |
	| admin@yourstore.com | admin |
	| admin1@yourstore.com | admin123 |