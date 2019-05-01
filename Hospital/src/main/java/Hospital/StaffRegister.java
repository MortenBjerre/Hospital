package Hospital;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "staffRegister")

public class StaffRegister extends Register<Staff> implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
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
		Staff s = new Staff(email, name, surname, birthday, gender);
		users.put(s.getSerialnum(), s);
		return s.getSerialnum();
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
		ICTOfficer s = new ICTOfficer(email, name, surname, birthday, gender);
		users.put(s.getSerialnum(), s);
		return s.getSerialnum();
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
		Nurse s = new Nurse(email, name, surname, birthday, gender);
		users.put(s.getSerialnum(), s);
		return s.getSerialnum();
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
		Doctor s = new Doctor(email, name, surname, birthday, gender);
		users.put(s.getSerialnum(), s);
		return s.getSerialnum();
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
		Clerk s = new Clerk(email, name, surname, birthday, gender);
		users.put(s.getSerialnum(), s);
		return s.getSerialnum();
	}

	
//	/**
//	 * Searches for a Staff with a matching Role
//	 * @param role
//	 * @return
//	 */
//	public String[] searchRole(String role) {
//		ArrayList<Staff> matches = findRole(role);
//		String[] m = new String[matches.size()];
//		for (int i = 0; i < matches.size(); i++) {
//			m[i] = matches.get(i).toString();
//		}
//		return m;
//	}
//	
//	/**
//	 * Searches for a Staff with a matching Role
//	 * @param role
//	 * @return
//	 */
//	protected ArrayList<Staff> findRole(String role) {
//		ArrayList<Staff> matches = new ArrayList<Staff>();
//		for (Integer key : users.keySet()) {
//			if (users.get(key).getRole() == role) {
//				matches.add(users.get(key));
//			}
//		}
//		return matches;
//	}
}
