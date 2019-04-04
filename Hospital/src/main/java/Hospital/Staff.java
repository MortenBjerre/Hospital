package Hospital;

import java.util.Date;

public class Staff extends HospitalUser {

	
	public Staff(String email, String name, String surname, Date birthday, String gender, String department) {
		set(email, name, surname, birthday, gender, department);

		//need to add department
	}
	
	public String toString() {
		return ("Staff name: " + getName() + " " + getSurname() + " ; Gender: " + getGender() + " ; Birthday: " + getBirthday() + " ; Email: " + getEmail() + " ; Role: Staff"); 
	}

	@Override
	public boolean hasWriteAccessTo(Register r) {
		return false;
	}

}
