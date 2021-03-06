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
Feature: Nurse/doctor using software

  @tag1
  Scenario: As a nurse, I want to be able to search for patients so that i can easily edit their health data.
    Given That I am a nurse
    And I have a patient register
    And the patient register contains several patients
    Then I should be able to search for a patient
  
    
  Scenario: As a doctor, I want to be able to search for patients so that i can easily edit their health data (part 1).
    Given That I am a doctor
    And I have a patient register
    And the patient register contains several patients
    Then I should be able to search for a patient
    
  Scenario: Nurse trying to edit staff register
    Given That I am a nurse
		And I have a a staff register
		Then I should not be able to add staff to the staff register

  Scenario: Nurse trying to search staff register
    Given That I am a nurse
		And I have a a staff register
		Then I should not be able search for staff
		
	Scenario: Doctor trying to edit staff register
    Given That I am a doctor
		And I have a a staff register
		Then I should not be able to add staff to the staff register
		
  Scenario: Doctor trying to search staff register
    Given That I am a doctor
		And I have a a staff register
		Then I should not be able search for staff

	Scenario: As a nurse, I want to be able to search for patients so that i can easily edit their health data (part 2).
		Given That I am a nurse
		And I have a patient register
    And the patient register contains several patients	
		Then I should be able to search for a patient
		And the patient register contains several patients
		And edit or view the patients health data
		
	Scenario: As a doctor, I want to be able to search for patients so that i can easily edit their health data (part 2).
		Given That I am a doctor
		And I have a patient register
		And the patient register contains several patients
		Then I should be able to search for a patient
		And edit or view the patients health data
    
