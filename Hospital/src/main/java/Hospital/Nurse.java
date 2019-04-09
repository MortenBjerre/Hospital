package Hospital;

import java.util.Date;

public class Nurse extends Staff {

	public Nurse(String email, String name, String surname, Date birthday, String gender, String department) {
		super(email, name, surname, birthday, gender, department);
	}
	
	public boolean hasWriteAccessTo(Register r) {
		if (r instanceof PatientRegister) {
			return true;
		}
		return false;
	}
}
