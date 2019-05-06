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
Feature: Testing the patient class

  @tag1
  Scenario: Patient permissions
    #Acting as a nurse to create the hospital
  	Given That I am a nurse
  	And I have a patient register
  	And I have a staff register
  	And I have a department register
  	And the patient register contains several patients
  	
  	#Now acting as a patient
  	And A patient is using the system
  	Then The patient should not have write access to the staff register
  	And The patient should not have view access to the staff register
  	And The patient should not have write access to the patient register
  	And The patient should not have view access to the patient register
  	And The patient should not have view access to health data
  	
  Scenario: Checking hashcodes
  	Given That I am a nurse
  	And I have a patient register
  	And the patient register contains several patients
  	Then patient zero and one should have different hash codes
  	And patient zero should have the same hash code as themselves
  	