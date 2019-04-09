import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import Hospital.Clerk;
import Hospital.Doctor;
import Hospital.Nurse;
import Hospital.PatientRegister;
import Hospital.Staff;
import Hospital.StaffRegister;
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
	
	@Given("^That I am a clerk$")
	public void that_I_am_a_clerk() {
		s = new Clerk("Smead@b.com","Turk","Turkelton",new Date(), "male","ER");	
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
			serialnum1 = pr.add("patient@0.com", "Bob", "Kelso", new Date(), "male", "Hollywood", 90239103, true, "ER", true,"");
		}
	}

	@Then("^assign him a unique serialnumber$")
	public void assign_him_a_unique_serialnumber() {
		if (s.hasWriteAccessTo(pr)) {
			serialnum2 = pr.add("p@gmail.com", "Carlton", "Banks", new Date(), "male", "Bel Air", 12355590, true, "ER", true,"");
		}
		assertFalse(serialnum1 == serialnum2);
	}
	
	@Given("^the patient register contains several patients$")
	public void the_patient_register_contains_several_patients() {
		if (s.hasWriteAccessTo(pr)) {
			pr.add("g@gmail.com", "Phil", "Banks", new Date(), "male", "Bel Air", 44329082, true, "ER", true,"");
			pr.add("p@ofir.dk", "Emilia", "Clarke", new Date(2000,12,1), "female", "USA", 12355590, true, "ER", true,"");
			pr.add("p@hotmail.com", "Phil", "Taylor", new Date(), "male", "California", 12355590, true, "ER", true,"");
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
		
		Date birthday = new Date(1996-1900,10,10);
		// Using Date the year is the year minus 1900.
		pr.editBirthday(serialnum, birthday);
		assertTrue(pr.searchSerialnum(1)[0].equals("Serialnum: 1; Patient name: Josefine Bjerre ; Gender: male ; Birthday: Sun Nov 10 00:00:00 CET 1996 ; Email: JosefineB@gmail.com"));
	
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
		s = new Nurse("nurse@mail.dk","John","Hancock", new Date(), "male", "ER");
	}
	
	@Given("^That I am a doctor$")
	public void that_I_am_a_doctor() {
		s = new Doctor("doctor@gmail.com", "Dr", "Cox", new Date(), "male", "ER");
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
			System.out.println(pr.viewHealthData(1));
		}
	}
}
