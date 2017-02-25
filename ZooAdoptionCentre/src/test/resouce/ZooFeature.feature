#Author: OCS-Consulting.com: Borehamwood
@tag
Feature: Title "Zoo Adoption Center"

@tag1
Scenario: Title : Sumbission of contact page information
Given I am on the Zoo site
	
When I click on "contact"
	And i enter "Name for Test" into the name field
	And i enter "Address for Test" into the Address field    
	And i enter "Postcode for Test" into the Postcode field 
	And i enter "Email for Test" into the Email field
	And i submit the contact form
	
Then I check i am on the confirmation page
	And i close the browser 


@tag2
Scenario: Title : Adopting an animal
Given I am on the Zoo site
	
When I click on "adoption"
  And i click on "today" form the dropdown menu 
  And i click on "check" for turtle 
  And i enter "veera pulapakura" into the name field
	And i enter "Borehamwood" into the Address field    
	And i enter "wd6 1qq" into the Postcode field 
	And i enter "ocs@borehamwood.com" into the Email field
	And i click on the check button
	
Then I check i am on the adoption setup page
	And i close the browser 
	
@tag3
Scenario: Title : Validating of About page 
Given I am on the Zoo site
	
When I click on "about"
  	
Then I check i am on the about page
	And i close the browser 
	