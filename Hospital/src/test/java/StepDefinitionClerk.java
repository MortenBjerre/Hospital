import static org.junit.Assert.assertFalse;

import java.util.Date;

import Hospital.Clerk;
import Hospital.PatientRegister;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// Classes created goes in main/java NOT test/java


public class StepDefinitionClerk {
	
	PatientRegister pr;
	Clerk clerk;
	int serialnum1;
	int serialnum2;
	
	@Given("^That I am a clerk$")
	public void that_I_am_a_clerk() {
		clerk = new Clerk("Smead@b.com","Turk","Turkelton",new Date(), "male","ER");	
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
		if (clerk.hasWriteAccessTo(pr)) {
			serialnum1 = pr.add("patient@0.com", "Bob", "Kelso", new Date(), "male", "Hollywood", 90239103, true, "ER", true);
		}
	}

	@Then("^assign him a unique serialnumber$")
	public void assign_him_a_unique_serialnumber() {
		serialnum2 = pr.add("p@gmail.com", "Carlton", "Banks", new Date(), "male", "Bel Air", 12355590, true, "ER", true);
		assertFalse(serialnum1 == serialnum2);
	}
	
	@Given("^the patient register contains several patients$")
	public void the_patient_register_contains_several_patients() {
		pr.add("g@gmail.com", "Phil", "Banks", new Date(), "male", "Bel Air", 44329082, true, "ER", true);
		pr.add("p@ofir.dk", "Emilia", "Clarke", new Date(), "female", "USA", 12355590, true, "ER", true);
		pr.add("p@hotmail.com", "Phil", "Taylor", new Date(), "male", "California", 12355590, true, "ER", true);
		
	}

	@Then("^I should be able to search for a patient$")
	public void i_should_be_able_to_search_for_a_patient() {
		if (clerk.hasWriteAccessTo(pr)) {
			System.out.println(pr);
			String[] result = pr.searchGender("female");
			// The user looks at the output containing serialnumbers and
			// picks the patient needed
			for (String r : result) {
				System.out.println(r);
			}
			
		}
	}

	@Then("^edit their information$")
	public void edit_their_information() {
		
	}

	@Given("^I have a a staff register$")
	public void i_have_a_a_staff_register() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I should not be able to add staff to the staff register$")
	public void i_should_not_be_able_to_add_staff_to_the_staff_register() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
