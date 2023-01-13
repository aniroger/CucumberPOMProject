
Feature: Home Page feature

		Background:
		Given User has already logged into application
		|username|password|
		|anirudhsharma303@gmail.com|Roger1234@|

  Scenario: Title of your scenario
    Given User is on home improvement page
    When user gets the title of page
    Then page title should be "Amazon.in: Home Improvement"

  Scenario: Home Improvement Count
    Given User is on home improvement page
		Then User gets on Home section
		|Cleaning Supplies|
		|Electrical|
		|Hardware|
		|Heavy Equipment & Agricultural Supplies|
		|Kitchen & Bath Fixtures|
		|Power & Hand Tools|
		|Safety & Security|
		|Painting Supplies, Tools & Wall Treatments|
    Then page section should be 7
