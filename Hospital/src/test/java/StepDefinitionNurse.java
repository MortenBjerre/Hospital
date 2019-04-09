import java.util.Date;

import Hospital.Nurse;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinitionNurse {
	@Given("^That I am a nurse$")
	public void that_I_am_a_nurse() {
		Nurse nurse = new Nurse("nurse@mail.dk","John","Hancock", new Date(), "male", "ER");
	}

	@Then("^edit the patients heatlh data$")
	public void edit_the_patients_heatlh_data() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
