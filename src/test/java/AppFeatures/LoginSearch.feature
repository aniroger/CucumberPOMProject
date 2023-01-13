
Feature: Login Search Page Feature

   	Background:
		Given User has already logged into application
		|username|password|
		|anirudhsharma303@gmail.com|Roger1234@|

   Scenario Outline: Login Search Data
    Given User is on login page
    When user enters the data "<Searchdata>"
    And user clicks on search button
    Then its shows the desired page  
    Examples:
    |Searchdata|
    |shirt|
    |Pants|
    