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
Feature: ICT Officer using software

  @tag1
  Scenario: As an ICT Officer, I want to register staff members so that we know where the staff members are working
  	Given That I am an ICT Officer
  	And I have a staff register
  	Then I should be able to register a staff member
  	
  Scenario: As an ICT Officer, I want to be able to see all hospital users' data to have tabs on the system
  	Given That I am an ICT Officer
  	And I have a staff register
  	And I have a patient register
  	And the patient register contains several patients
  	Then I want to be able to view the patient register
  	And I want to be able to view the staff register
  	And I want to be able to view the patients' health data
  	

