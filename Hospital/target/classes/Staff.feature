#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Checking permission of a staff member

  @tag1
  Scenario: Staff permissions
  	Given That I am a staff member
  	Then I should not have write access to the patient register
  	And I should not have write access to the staff register
  	And I should not have view access to the health data
  	And I should not have permission to move patients
  	And I should not have permission to move staff
  	
  Scenario: Hash code check 
  	Given That I am a clerk
  	And I have a staff register
  	And I have multiple staff members
  	Then I want to see that two staff members has different hash code
  	And That a staff member has the same hash code as them selves
  	
  	
