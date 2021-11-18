#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
Feature: Login and Logout functionality
Description This feature verifyies the Login and Logout functioanlities

Scenario: Login with Valid Credentails
Given I launch the Chrome Browser
And I navigate the url of the Application
When I enter the username in username text field
And I enter the password in password text field
And I click on Login button in login page
Then I find the Home Page

Scenario: Logout from the Application
Given I minimized the flyout window
When I click on Logout link
Then I find the login page
And I close the browser