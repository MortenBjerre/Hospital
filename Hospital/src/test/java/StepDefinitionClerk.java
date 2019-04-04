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
		serialnum2 = pr.add("p@gmail.com", "Carlton", "Banks", new Date(), "male", "Roskilde", 12355590, true, "ER", true);
		assertFalse(serialnum1 == serialnum2);
	}
}
