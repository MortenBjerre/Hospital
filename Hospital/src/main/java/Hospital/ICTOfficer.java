package Hospital;

import java.util.Date;

public class ICTOfficer extends Staff {

	public ICTOfficer(String email, String name, String surname, Date birthday, String gender, String department) {
		super(email, name, surname, birthday, gender, department);
		
	}
	
	public boolean hasWriteAccessTo(Register r) {
		return true;
	}
	
	public boolean hasViewAccessTo(Register r) {
		return true;
	}
	
	public boolean hasHealthDataAccess() {
		return true;
	}
}
