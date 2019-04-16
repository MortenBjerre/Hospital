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
Feature: Testing departments

  @tag1
  Scenario: As a nurse, I want to know where a patient is, so I can find and treat him
   Given That I am a nurse
   And I have a patient register
   And the patient register contains several patients
   And there exists an ER department
   And I have a patient admitted to the ER
   Then I should be able to find that patient's department
   And I should know patient two is not admitted
   
  @tag2
  Scenario: Admitting a patient to a non-existent department
   Given That I am a nurse
   And I have a patient register
   And the patient register contains several patients
   Then admitting a patient to a nonexistent department should give an error
   
  @tag3
  Scenario: As an ICT Officer, I should be able to move staff from one department to another
   Given That I am an ICT Officer
   And I have a staff register
   And I have a patient register
   And there are multiple departments
   And I have multiple staff members
   Then I should be able to move a staff member from ER to surgery