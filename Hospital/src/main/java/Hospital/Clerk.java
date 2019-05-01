package Hospital;

import java.util.Date;
import java.io.Serializable;

public class Clerk extends Staff implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for clerk. Sets staff information
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 * @param department
	 */
	
	public Clerk() {}
	
	public Clerk(String email, String name, String surname, Date birthday, String gender) {
		super(email, name, surname, birthday, gender);	
	}
	
	public boolean hasWriteAccessTo(Register r) {
		if (r instanceof PatientRegister) {
			return true;
		}
		return false; 
	}
	
	public boolean hasHealthDataAccess() {
		return false;
	}
	
	public String getRole() {
		return "Clerk";
	}
}

