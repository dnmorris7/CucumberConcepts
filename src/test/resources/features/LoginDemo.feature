Feature: Test login functionality

Scenario Outline: Check login is successful with valid credentials
	Given demo test browser is open
	And login demo user is on login page
	When user enters <username> and <password>
	And user clicks on login
	Then user is navigated to the homepage
	
	Examples:
	| username | password |
	| Raghav | 12345 |
	| Ele | 12345 |