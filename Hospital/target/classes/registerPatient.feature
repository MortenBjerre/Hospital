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
Feature: Clerk using software

  @tag1
  Scenario: As a clerk, I want to register a patient so that we can have a record of all the patients in the hospital.
    Given That I am a clerk
    And I have a patient register
    When a patient needs to be admitted
    Then I should be able to add the patient to the patient register
    And assign him a unique serialnumber
  
  Scenario: As a clerk, I want to be able to search for patients so that I can access their registration/admission data.
  	Given That I am a clerk
  	And I have a patient register
  	And the patient register contains several patients
  	Then I should be able to search for a patient
 
  
  Scenario: Searching for a staff member
  	Given That I am a clerk
  	And I have a a staff register
  	Then I should not be able to add staff to the staff register
    
  Scenario: As a clerk, I want to be able to edit a patinent's personal information so that it is accurate.
  	Given That I am a clerk
  	And I have a patient register
  	And the patient register contains several patients
  	Then I should be able to search for a patient
  	And edit their information

