@Login	
Feature: Login Page Feature

@Smoke
Scenario: Login Page Title
    Given User is on login page
		When user gets the title of page
		Then page title should be "Amazon Sign In"
    
@Smoke @Regression 
Scenario: Forgot Password Link
    Given User is on login page
    When User enters username "anirudhsharma303@gmail.com"
    When User clicks on Continue Button
    Then Forgot your password link should be displayed.

@Smoke  
Scenario: Login with Correct credentials
    Given User is on login page
    When User enters username "anirudhsharma303@gmail.com"
    When User clicks on Continue Button
    And User enters password "Roger1234@"
    And User clicks on Login Button
    When user gets the title of page
    Then page title should be "Amazon Sign In"


