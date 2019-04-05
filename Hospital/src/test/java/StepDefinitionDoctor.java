import java.util.Date;

import Hospital.Doctor;
import cucumber.api.java.en.Given;

public class StepDefinitionDoctor {
	@Given("^That I am a doctor$")
	public void that_I_am_a_doctor() {
		Doctor doctor = new Doctor("doctor@gmail.com", "Dr", "Cox", new Date(), "male", "ER");
	}
}
