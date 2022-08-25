Feature: feature to test login functionality 
@SmokeTest
Scenario: Check login is successful with valid credentials 
	Given user is on login page 
	When user enters login 
	And clicks on the login button 
	Then user is navigated to the home page