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
Feature: Testing department class

  @tag1
  Scenario: As a nurse, I want to know where a patient is, so I can find and treat him
   Given That I am a nurse
   And I have a department register
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
   And I have a department register
   And the patient register contains several patients
   Then admitting a patient to a nonexistent department should give an error
   
  @tag3
  Scenario: As an ICT Officer, I should be able to move staff from one department to another
   Given That I am an ICT Officer
   And I have a department register
   And I have a staff register
   And I have a patient register
   And there are multiple departments
   And I have multiple staff members
   And Staff zero is in ER
   Then I should be able to move a staff member from ER to surgery
   
  Scenario: As a nurse, I want to be able to discharge a patient so that the bed can be freed up for other patients
   Given That I am a nurse
   And I have a patient register
   And the patient register contains several patients
   And I have a department register
   And there exists an ER department
   And I have a patient admitted to the ER
   Then I should be able to discharge that patient
   
  @tag4
  Scenario: Adding various staff types to the staff register
   Given That I am an ICT Officer
   And I have a staff register
   Then I should be able to add a clerk
   And I should be able to add an ICT Officer
   And I should be able to add a nurse
   And I should be able to add a doctor
   
  @tag5
  Scenario: As a staff member, I want to be able to see how many beds are available in a department so I can see where to assign my patient.
   Given That I am a staff member
   And I have a department register
   And there are multiple departments
   Then I should be able to see how many beds are available in the ER
   And I should be able to see how many beds there are total in the ER
   
  @tag6
  Scenario: As a nurse/doctor, I want to be able to send a patient to a different department so that he can be treated properly.
   Given That I am a doctor
   And I have a department register
   And I have a patient register
   And there are multiple departments
   And the patient register contains several patients
   And patient zero is in the ER
   Then I should be able to move patient zero from the ER to surgery
   
  @tag7
  Scenario: As an ICT Officer, Adding a staff member to a department should remove them from their current department
  	Given That I am an ICT Officer
   	And I have a department register
   	And I have a staff register
	  And there are multiple departments
	  And I have multiple staff members
	  And Staff zero is in ER
	  Then Adding staff zero to surgery should discharge them from the ER
	  
  @tag9
  Scenario: As an ICT Officer, i should be able to able to see how many beds are free and add some more
  	Given That I am an ICT Officer
   	And I have a department register 
	  And there are multiple departments
	  Then I should be able to see how many beds are available in the ER
	  And I should be able to add some beds 
	  And I should be able to remove beds
	  And The number of beds should be updated

	@tag10
	Scenario: when a patient is added to a department, I should as a nurse/clerk/doctor have the system automatically assign the patient to a bed
		Given That I am a clerk
		And I have a department register 
		And I have a patient register
		And the patient register contains several patients
		And there are multiple departments
		When I admit a patient to the ER
		Then that patient should be assigned to the first available bed in ER
		
	@tag11
	Scenario: As an ICT Officer, I should be able to fire a staff member
		Given That I am an ICT Officer
		And I have a department register 
	  And there are multiple departments
	  And I have a staff register
		And I have multiple staff members
		And Staff one is in the ER
		Then I should be able to fire staff member one
		
	@tag12 
	Scenario: ICT Officer creating and deleting outpatient department
		Given That I am an ICT Officer
		And I have a department register 
		Then I can create an outpatient department called Waiting Room
		And I can create an inpatient department called Cardiology
		And I can delete both departments again

	@tag13
	Scenario: As an ICT Officer, I should be able to change the name of a department
		Given That I am an ICT Officer
		And I have a department register 
		Then I can create an outpatient department called Waiting Room
		And I can rename the department to Patient Waiting Rooms
 
 Scenario: As an ICT Officer, i should be able to add and then delete a patient from a outpatient department 
  	Given That I am an ICT Officer
   	And I have a department register 
   	And I have a patient register
   	And the patient register contains several patients
		Then I can create an outpatient department called Waiting Room
		And I should be able to add a patient to Waiting Room 
		And I should be able to discharge the patient
	  