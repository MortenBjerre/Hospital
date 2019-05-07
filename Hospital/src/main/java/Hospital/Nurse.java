package Hospital;

import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement(name ="Nurse")
public class Nurse extends Staff {
	public Nurse() {}
	/**
	 * Constructor for nurse object. Calls Staff constructor.
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 * @param department
	 */
	public Nurse(String email, String name, String surname, Date birthday, String gender) {
		super(email, name, surname, birthday, gender);
	}
	
	public boolean hasWriteAccessTo(Register r) {
		if (r instanceof PatientRegister) {
			return true;
		}
		return false;
	}
	public boolean hasHealthDataAccess() {
		return true;
	}
	
	public String getRole() {
		return "Nurse";
	}
	
	public boolean canMovePatients() {
		return true;
	}
	
	public boolean canViewDepartmentRegister() {
		return true;
	}
}