package Hospital;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "StaffRegister")
public class StaffRegister extends Register<Staff> {
	
	public StaffRegister() {
		Staff.resetSerialnumCounter();
	}
	
	/**
	 * Adds a staff member to the register
	 * @param serialnum
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 */
	public int addStaff(String email, String name, String surname, Date birthday, String gender) {
		Staff staff = new Staff(email, name, surname, birthday, gender);
		users.put(staff.getSerialnum(), staff);
		return staff.getSerialnum();
	}
	
	/**
	 * Adds an ICT Officer to the register
	 * @param serialnum
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 */
	public int addICTOfficer(String email, String name, String surname, Date birthday, String gender) {
		ICTOfficer ict = new ICTOfficer(email, name, surname, birthday, gender);
		users.put(ict.getSerialnum(), ict);
		return ict.getSerialnum();
	}
	
	/**
	 * Adds a nurse to the register
	 * @param serialnum
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 */
	public int addNurse(String email, String name, String surname, Date birthday, String gender) {
		Nurse nurse = new Nurse(email, name, surname, birthday, gender);
		users.put(nurse.getSerialnum(), nurse);
		return nurse.getSerialnum();
	}
	
	/**
	 * Adds a doctor to the register
	 * @param serialnum
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 */
	public int addDoctor(String email, String name, String surname, Date birthday, String gender) {
		Doctor doctor = new Doctor(email, name, surname, birthday, gender);
		users.put(doctor.getSerialnum(), doctor);
		return doctor.getSerialnum();
	}
	
	/**
	 * Adds a clerk to the register
	 * @param serialnum
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 */
	public int addClerk(String email, String name, String surname, Date birthday, String gender) {
		Clerk clerk = new Clerk(email, name, surname, birthday, gender);
		users.put(clerk.getSerialnum(), clerk);
		return clerk.getSerialnum();
	}

	public void deleteStaff(Staff s) {
		int serialnum = s.getSerialnum();
		users.remove(serialnum);
		
	}
}