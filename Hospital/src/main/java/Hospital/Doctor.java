package Hospital;

import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement(name ="Doctor")
public class Doctor extends Staff {
	
	/**
	 * Constructor for Doctor. Calls Staff constructor.
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 * @param department
	 */
	public Doctor(String email, String name, String surname, Date birthday, String gender) {
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
		return "Doctor";
	}

}