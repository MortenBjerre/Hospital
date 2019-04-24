import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import Hospital.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// Classes created goes in main/java NOT test/java


public class StepDefinitionClerk {
	
	PatientRegister pr;
	Staff s;
	int serialnum1;
	int serialnum2;
	StaffRegister sr;
	DepartmentRegister dr;
	
	@Given("^That I am a clerk$")
	public void that_I_am_a_clerk() {
		s = new Clerk("Smead@b.com","Turk","Turkelton",new Date(), "male");	
	}

	@Given("^I have a patient register$")
	public void i_have_a_patient_register() {
		pr = new PatientRegister();
	
	}

	@When("^a patient needs to be admitted$")
	public void a_patient_needs_to_be_admitted() {
		// needed for scenario to make sense.
	}

	@Then("^I should be able to add the patient to the patient register$")
	public void i_should_be_able_to_add_the_patient_to_the_patient_register() {
		if (s.hasWriteAccessTo(pr)) {
			serialnum1 = pr.add("patient@0.com", "Bob", "Kelso", new Date(), "male", "Hollywood", 90239103, true,"");
		}
	}

	@Then("^assign him a unique serialnumber$")
	public void assign_him_a_unique_serialnumber() {
		if (s.hasWriteAccessTo(pr)) {
			serialnum2 = pr.add("p@gmail.com", "Carlton", "Banks", new Date(), "male", "Bel Air", 12355590, true,"");
		}
		assertFalse(serialnum1 == serialnum2);
	}
	
	@SuppressWarnings("deprecation")
	@Given("^the patient register contains several patients$")
	public void the_patient_register_contains_several_patients() {
		if (s.hasWriteAccessTo(pr)) {
			pr.add("g@gmail.com", "Phil", "Banks", new Date(2000,12,1), "male", "Bel Air", 44329082, true,"");
			pr.add("p@ofir.dk", "Emilia", "Clarke", new Date(2000,12,1), "female", "USA", 12355590, true,"");
			pr.add("p@hotmail.com", "Phil", "Taylor", new Date(2000,12,2), "male", "California", 12355590, true,"");
			pr.add("pp@hotmail.com", "Philtwo", "Taylor", new Date(2002,1,1), "male", "California", 12355591, false,"");
		}
	}

	@Then("^I should be able to search for a patient$")
	public void i_should_be_able_to_search_for_a_patient() {
		if (s.hasWriteAccessTo(pr)) {
			String[] result = pr.searchGender("female");
			assertTrue(result[0].equals(("Serialnum: 1; Patient name: Emilia Clarke ; Gender: female ; Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: p@ofir.dk")));
			// The result of the search gave us the female in the register.
		}
		
	}

	@Then("^edit their information$")
	public void edit_their_information() {
		String name = "Josefine";
		int serialnum = 1;
		pr.editName(serialnum, name);
		assertTrue(pr.searchSerialnum(1)[0].equals("Serialnum: 1; Patient name: Josefine Clarke ; Gender: female ; Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: p@ofir.dk"));
	
		String surname = "Bjerre";
		pr.editSurname(serialnum,surname);
		assertTrue(pr.searchSerialnum(1)[0].equals("Serialnum: 1; Patient name: Josefine Bjerre ; Gender: female ; Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: p@ofir.dk"));
	
		String email = "JosefineB@gmail.com";
		pr.editEmail(serialnum, email);
		assertTrue(pr.searchSerialnum(1)[0].equals("Serialnum: 1; Patient name: Josefine Bjerre ; Gender: female ; Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: JosefineB@gmail.com"));
	
		String gender = "male";
		pr.editGender(serialnum, gender);
		
		@SuppressWarnings("deprecation")
		Date birthday = new Date(1996-1900,10,10);
		// Using Date the year is the year minus 1900.
		pr.editBirthday(serialnum, birthday);
		assertTrue(pr.searchSerialnum(1)[0].equals("Serialnum: 1; Patient name: Josefine Bjerre ; Gender: male ; Birthday: Sun Nov 10 00:00:00 CET 1996 ; Email: JosefineB@gmail.com"));
		
		int phonenumber = 696969;
		pr.editPhoneNumber(serialnum, phonenumber);
		assertTrue(pr.searchSerialnum(1)[0].equals("Serialnum: 1; Patient name: Josefine Bjerre ; Gender: male ; Birthday: Sun Nov 10 00:00:00 CET 1996 ; Email: JosefineB@gmail.com"));
		assertTrue(pr.findSerialnum(serialnum).getPhoneNumber() == 696969);
		
		String address = "sunset boulevard";
		pr.editAddress(serialnum, address);
		assertTrue(pr.findSerialnum(serialnum).getAddress() == address);
		
		boolean alive = false;
		pr.editAlive(serialnum, alive);
		assertTrue(pr.findSerialnum(serialnum).getAlive() == false);
		// Edit address, phoneNumber, alive and inpatient don't need testing since the implementation
		// is exactly the same as above, only the second argument is different. 
	}

	@Given("^I have a a staff register$")
	public void i_have_a_a_staff_register() {
		sr = new StaffRegister();
	}

	@Then("^I should not be able to add staff to the staff register$")
	public void i_should_not_be_able_to_add_staff_to_the_staff_register() {
		assertFalse(s.hasWriteAccessTo(sr));
		 
	}
	
	@Given("^That I am a nurse$")
	public void that_I_am_a_nurse() {
		s = new Nurse("nurse@mail.dk","John","Hancock", new Date(), "male");
	}
	
	@Given("^That I am a doctor$")
	public void that_I_am_a_doctor() {
		s = new Doctor("doctor@gmail.com", "Dr", "Cox", new Date(), "male");
	}
	
	@Then("^I should not be able search for staff$")
	public void i_should_not_be_able_search_for_staff() {
		assertFalse(s.hasViewAccessTo(sr));
	}
	
	@Then("^edit or view the patients health data$")
	// There is no differentiating between viewing and editing health data.
	public void edit_or_view_the_patients_health_data() {

		assertTrue(s.hasHealthDataAccess());
	
		
		if (s.hasHealthDataAccess()) {
			String healthData = "Patient needs a colonoscopy";
			pr.editHealthData(1,healthData);
			assertTrue(pr.viewHealthData(1).equals(healthData));
		}
	}
	
	// ICT Officer scenarios
	
	@Given("^That I am an ICT Officer$")
	public void that_I_am_an_ICT_Officer() {
		s = new ICTOfficer("ICTemail@dtu.dk", "Dermot", "Mulroney", new Date(), "male");
	}

	@Given("^I have a staff register$")
	public void i_have_a_staff_register() {
		sr = new StaffRegister();
	}

	@Then("^I should be able to register a staff member$")
	public void i_should_be_able_to_register_a_staff_member() {
		if (s.hasWriteAccessTo(sr)) {
			sr.addStaff("Dylan@90210.com", "Dylan", "McKay", new Date(), "male");
		}
		assertTrue(sr.toString().length() != 0);
		// The staff register is no longer empty
	}
	
	@Then("^I want to be able to view the patient register$")
	public void i_want_to_be_able_to_view_the_patient_register() {
		assertTrue(s.hasViewAccessTo(pr));
	}

	@Then("^I want to be able to view the staff register$")
	public void i_want_to_be_able_to_view_the_staff_register() {
		assertTrue(s.hasViewAccessTo(sr));
	}

	@Then("^I want to be able to view the patients' health data$")
	public void i_want_to_be_able_to_view_the_patients_health_data() {
		assertTrue(s.hasHealthDataAccess());
	}
	
	@Given("^I have a department register$")
	public void i_have_a_department_register() {
		dr = new DepartmentRegister();
	}
	
	@Given("^there exists an ER department$")
	public void there_exists_an_ER_department() {
	    dr.createDepartment("ER", 5);
	}
	
	@Given("^I have a patient admitted to the ER$")
	public void i_have_a_patient_admitted_to_the_ER() {
		dr.admit(1, "ER", pr);
	}

	@Then("^I should be able to find that patient's department$")
	public void i_should_be_able_to_find_that_patient_s_department() {
		assertTrue(dr.getDeptOfPatient(1).equals("ER")); 
	}
	
	@Then("^I should know patient two is not admitted$")
	public void i_should_know_patient_two_is_not_admitted() {
		assertTrue(dr.getDeptOfPatient(2).equals(""));
		
	}

	@Then("^admitting a patient to a nonexistent department should give an error$")
	public void admitting_a_patient_to_a_nonexistent_department_should_give_an_error() {
	    try {
	    	dr.admit(1, "blabla", pr);
	    } catch (IllegalArgumentException e) {
	    	assertTrue(e.getMessage() == "No such department");
	    	
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Given("^I have multiple staff members$")
	public void i_have_multiple_staff_members() {
	    sr.addStaff("email", "Eric", "Jensen", new Date(1998-1900,1,1), "male");
	    sr.addStaff("m@hotmail.com", "Morten", "Bjerre", new Date(), "male");
	    sr.addStaff("msldkf", "Bo", "Burnham", new Date(), "female");
	    assertTrue(sr.toString().length() != 0);
	}
	
	@Given("^Staff zero is in ER$")
	public void staff_zero_is_in_ER() {
		dr.addStaffTo(0, "ER", sr);
		assertTrue(dr.searchStaffDepartment("ER")[0].equals("Serialnum: 0 ; Name: Eric Jensen ; Gender: male ; Birthday: Sun Feb 01 00:00:00 CET 1998 ; Email: email ; Role: Staff"));
	}

	@Given("^there are multiple departments$")
	public void there_are_multiple_departments() {
		dr.createDepartment("ER", 5);
		dr.createDepartment("surgery", 10);
		assertTrue(dr.containsDept("ER"));
		assertTrue(dr.containsDept("surgery"));
	}

	@Then("^I should be able to move a staff member from ER to surgery$")
	public void i_should_be_able_to_move_a_staff_member_from_ER_to_surgery() {
		dr.moveStaff(0, "surgery", sr);
		assertTrue(dr.searchStaffDepartment("surgery")[0].equals("Serialnum: 0 ; Name: Eric Jensen ; Gender: male ; Birthday: Sun Feb 01 00:00:00 CET 1998 ; Email: email ; Role: Staff"));
		
	}
	
	@Then("^I should be able to discharge that patient$")
	public void i_should_be_able_to_discharge_that_patient() {
		dr.dischargePatient(1, pr);
		try {
			dr.searchSerialNum(1, pr);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage() == "No such patient admitted");
		}
	}
	
	@Then("^I should be able to add a clerk$")
	public void i_should_be_able_to_add_a_clerk() {
		@SuppressWarnings("deprecation")
		int serialclerk = sr.addClerk("clerk", "Clark", "Clerkson", new Date(1998-1900,1,1), "Superman");
		assertEquals(sr.searchSerialnum(serialclerk)[0], "Serialnum: 0 ; Name: Clark Clerkson ; "
				+ "Gender: Superman ; Birthday: Sun Feb 01 00:00:00 CET 1998 ; Email: clerk ; Role: Clerk");
	}

	@Then("^I should be able to add an ICT Officer$")
	public void i_should_be_able_to_add_an_ICT_Officer() {
		@SuppressWarnings("deprecation")
		int serialict = sr.addICTOfficer("officer@sir.com", "Mr.", "Sir", new Date(1998-1900,1,1), "manly");
		assertEquals(sr.searchSerialnum(serialict)[0], ("Serialnum: 1 ; Name: Mr. Sir ; "
				+ "Gender: manly ; Birthday: Sun Feb 01 00:00:00 CET 1998 ; Email: officer@sir.com ; Role: ICT Officer"));
	}

	@Then("^I should be able to add a nurse$")
	public void i_should_be_able_to_add_a_nurse() {
		@SuppressWarnings("deprecation")
		int serialnurse = sr.addNurse("f@night.com", "Florence", "Nightingale", new Date(1998-1900,1,1), "female");
		assertEquals(sr.searchSerialnum(serialnurse)[0],("Serialnum: 2 ; Name: Florence Nightingale ; "
				+ "Gender: female ; Birthday: Sun Feb 01 00:00:00 CET 1998 ; Email: f@night.com ; Role: Nurse"));
	}

	@Then("^I should be able to add a doctor$")
	public void i_should_be_able_to_add_a_doctor() {
		@SuppressWarnings("deprecation")
		int serialdoc = sr.addDoctor("~~~@~~~.com", "Neil", "Degrasse Thyson", new Date(1998-1900,1,1), "black science man");
		assertEquals(sr.searchSerialnum(serialdoc)[0], ("Serialnum: 3 ; Name: Neil Degrasse Thyson ; "
				+ "Gender: black science man ; Birthday: Sun Feb 01 00:00:00 CET 1998 ; Email: ~~~@~~~.com ; Role: Doctor"));
	}
	
	@SuppressWarnings("deprecation")
	@Given("^That I am a staff member$")
	public void that_I_am_a_staff_member() {
		s = new Staff("staff@staff.staff", "Staff", "Stafferson", new Date(1998-1900,1,1), "female");
	}

	@Then("^I should be able to see how many beds are available in the ER$")
	public void i_should_be_able_to_see_how_many_beds_are_available_in_the_ER() {
		if (s.canViewDepartmentRegister()) {
			assertTrue(dr.getAvailableBeds("ER") == 5);
		}
	}
	
	@Then("^I should be able to see how many beds there are total in the ER$")
	public void i_should_be_able_to_see_how_many_beds_there_are_total_in_the_ER() {
		if (s.canViewDepartmentRegister()) {
			assertTrue(dr.getTotalBeds("ER") == 5);
		}
	}
	
	@Given("^patient zero is in the ER$")
	public void patient_zero_is_in_the_ER() {
		dr.admit(0, "ER", pr);
		assertEquals(dr.getDeptOfPatient(0), "ER");
	}

	@Then("^I should be able to move patient zero from the ER to surgery$")
	public void i_should_be_able_to_move_patient_zero_from_the_ER_to_surgery() {
		dr.movePatient(0, "surgery", pr);
		assertEquals(dr.getDeptOfPatient(0), "surgery");
	}
	
	@Then("^I should have permission to move staff$")
	public void i_should_have_permission_to_move_staff() {
	    assertTrue(s.canMoveStaff());
	}

	@Then("^I should have permission to move patients$")
	public void i_should_have_permission_to_move_patients() {
	    assertTrue(s.canMovePatients());
	}
	
	@Then("^I should not have write access to the patient register$")
	public void i_should_not_have_write_access_to_the_patient_register() {
		assertFalse(s.hasWriteAccessTo(pr));
	}

	@Then("^I should not have write access to the staff register$")
	public void i_should_not_have_write_access_to_the_staff_register() {
		assertFalse(s.hasWriteAccessTo(sr));
	}

	@Then("^I should not have view access to the health data$")
	public void i_should_not_have_view_access_to_the_health_data() {
		assertFalse(s.hasHealthDataAccess());
	}

	@Then("^I should not have permission to move staff$")
	public void i_should_not_have_permission_to_move_staff() {
		assertFalse(s.canMoveStaff());
	}
	
	@Then("^Adding staff zero to surgery should discharge them from the ER$")
	public void adding_staff_zero_to_surgery_should_discharge_them_from_the_ER() {
		dr.addStaffTo(0, "surgery", sr);
		assertTrue(dr.searchStaffDepartment("ER").length == 0);
	}
	
	@Then("^I should be able to search for a patient by address$")
	public void i_should_be_able_to_search_for_a_patient_by_address() {
	    assertEquals("Serialnum: 1; Patient name: Emilia Clarke ; Gender: female ;"
	    		+ " Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: p@ofir.dk"
	    		,(pr.searchAddress("USA")[0]));
	}
	
	@Then("^I should be able to search for a patient by phone number$")
	public void i_should_be_able_to_search_for_a_patient_by_phone_number() {
	    assertEquals("Serialnum: 1; Patient name: Emilia Clarke ; Gender: female ;"
	    		+ " Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: p@ofir.dk"
	    		,pr.searchNumber(12355590)[0]);
	}
	
	@Then("^I should be able to search for a patient that is still alive$")
	public void i_should_be_able_to_search_for_a_patient_that_is_still_alive() {
		assertEquals(pr.searchAlive(true).length, 3);
		
	    assertEquals("Serialnum: 0; Patient name: Phil Banks ; Gender: male ;"
	    		+ " Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: g@gmail.com"
	    		,pr.searchAlive(true)[0]);
	    assertEquals("Serialnum: 1; Patient name: Emilia Clarke ; Gender: female ; "
	    		+ "Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: p@ofir.dk"
	    		,pr.searchAlive(true)[1]);
	    assertEquals("Serialnum: 2; Patient name: Phil Taylor ; Gender: male ; "
	    		+ "Birthday: Wed Jan 02 00:00:00 CET 3901 ; Email: p@hotmail.com"
	    		,pr.searchAlive(true)[2]);

	}
	
	@Then("^I should be able to search for a patient by email$")
	public void i_should_be_able_to_search_for_a_patient_by_email() {
	    assertEquals("Serialnum: 1; Patient name: Emilia Clarke ; Gender: female ;"
	    		+ " Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: p@ofir.dk"
	    		,(pr.searchEmail("p@ofir.dk")[0]));		
	}

	@Then("^I should be able to search for a patient by name$")
	public void i_should_be_able_to_search_for_a_patient_by_name() {
	    assertEquals("Serialnum: 1; Patient name: Emilia Clarke ; Gender: female ;"
	    		+ " Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: p@ofir.dk"
	    		,(pr.searchName("Emilia")[0]));	
	}

	@Then("^I should be able to search for a patient by surname$")
	public void i_should_be_able_to_search_for_a_patient_by_surname() {
	    assertEquals("Serialnum: 1; Patient name: Emilia Clarke ; Gender: female ;"
	    		+ " Birthday: Tue Jan 01 00:00:00 CET 3901 ; Email: p@ofir.dk"
	    		,(pr.searchSurname("Clarke")[0]));
	}

	@Then("^I should be able to search for a patient by birthday$")
	public void i_should_be_able_to_search_for_a_patient_by_birthday() {
		Date a = new Date(2002,1,1);
//		System.out.println(pr.searchBirthday(a)[0]);
	    assertEquals("Serialnum: 3; Patient name: Philtwo Taylor ; Gender: male ; "
	    		+ "Birthday: Sat Feb 01 00:00:00 CET 3902 ; Email: pp@hotmail.com"
				,(pr.searchBirthday(new Date(2002,1,1))[0]));
	}
	
	@Then("^I want to see that two staff members has different hash code$")
	public void i_want_to_see_that_two_staff_members_has_different_hash_code() {
		Staff s1 = sr.findSerialnum(0);
		Staff s2 = sr.findSerialnum(1);
		assertTrue(s1.hashCode() != s2.hashCode());
		
	}

	@Then("^That a staff member has the same hash code as them selves$")
	public void that_a_staff_member_has_the_same_hash_code_as_them_selves() {
		Staff s1 = sr.findSerialnum(0);
		Staff s2 = sr.findSerialnum(0);
		assertTrue(s1.hashCode() == s2.hashCode());
		
	}
	
	@Then("^I should be able to add some beds$")
	public void i_should_be_able_to_add_some_beds() {
		dr.addBeds("ER", 10);
		// Originally there were 5 beds so now there are 15
	}
	
	@Then("^I should be able to remove beds$")
	public void i_should_be_able_to_remove_beds() {
		dr.removeBeds("ER",3);
		// Now there is 12 beds in ER
	}

	@Then("^The number of beds should be updated$")
	public void the_number_of_beds_should_be_updated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
