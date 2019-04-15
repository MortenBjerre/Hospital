package Hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PatientRegister extends Register<Patient> {
	
	HashMap<String, Department> dr = new HashMap<String, Department>();
	
	public PatientRegister() {
		Patient.resetSerialnumCounter();
	}
	
	/**
	 * Adds a patient to the patient register
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 * @param address
	 * @param phoneNumber
	 * @param alive
	 * @param department
	 * @param inpatient
	 * @param healthData
	 * @return Returns the serial number of the patient added
	 */
	public int add(String email, String name, String surname, Date birthday,
			String gender, String address, int phoneNumber, boolean alive, 
			boolean inpatient, String healthData) {
		Patient p = new Patient(email, name, surname, birthday, gender, address, 
								phoneNumber, alive, "Null", inpatient, healthData);
		users.put(p.getSerialnum(), p);
		
		return p.getSerialnum();
	}
	
	
	/**
	 * Searches for patients with matching address
	 * @param address
	 * @return String array of patients
	 */
	public String[] searchAddress(String address) {
		ArrayList<Patient> matches = findAddress(address);
		String[] m = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			m[i] = matches.get(i).toString();
		}
		return m;
	}
	/**
	 * Searches for patients with matching address
	 * @param address
	 * @return ArrayList of matching patients
	 */
	protected ArrayList<Patient> findAddress(String address) {
		ArrayList<Patient> matches = new ArrayList<Patient>();
		for (Integer key : users.keySet()) {
			if (users.get(key).getAddress() == address) {
				matches.add(users.get(key));
			}
		}
		return matches;
	}
	
	/**
	 * Searches for patients with matching phone numbers
	 * @param phoneNumber
	 * @return String array of matching patients
	 */
	public String[] searchNumber(int phoneNumber) {
		ArrayList<Patient> matches = findNumber(phoneNumber);
		String[] m = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			m[i] = matches.get(i).toString();
		}
		return m;
	}
	
	/**
	 * Searches for patients with matching phone numbers
	 * @param phoneNumber
	 * @return ArrayList of matching patients
	 */
	protected ArrayList<Patient> findNumber(int phoneNumber) {
		ArrayList<Patient> matches = new ArrayList<Patient>();
		for (Integer key : users.keySet()) {
			if (users.get(key).getPhoneNumber() == phoneNumber) {
				matches.add(users.get(key));
			}
		}
		return matches;
	}
	
	/**
	 * Searches for patients with matching alive status
	 * @param alive
	 * @return String array of matching patients
	 */
	public String[] searchAlive(boolean alive) {
		ArrayList<Patient> matches = findAlive(alive);
		String[] m = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			m[i] = matches.get(i).toString();
		}
		return m;
	}
	
	/**
	 * Searches for patients with matching alive status
	 * @param alive
	 * @return ArrayList of matching patients
	 */
	private ArrayList<Patient> findAlive(boolean alive) {
		ArrayList<Patient> matches = new ArrayList<Patient>();
		for (Integer key : users.keySet()) {
			if (users.get(key).getAlive() == alive) {
				matches.add(users.get(key));
			}
		}
		return matches;
	}
	
	/**
	 * Changes the birthday of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param birthday
	 */
	public void editBirthday(int serialnum, Date birthday) {
		Patient p = this.findSerialnum(serialnum);
		p.setBirthday(birthday);		
	}
	
	/**
	 * Changes the phone number of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param phoneNumber
	 */
	public void editPhoneNumber(int serialnum, int phoneNumber) {
		Patient p = this.findSerialnum(serialnum);
		p.setPhoneNumber(phoneNumber);	
	}
	
	/**
	 * Changes the address of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param address
	 */
	public void editAddress(int serialnum, String address) {
		Patient p = this.findSerialnum(serialnum);
		p.setAddress(address);		
	}
	
	/**
	 * Changes the alive status of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param alive
	 */
	public void editAlive(int serialnum, boolean alive) {
		Patient p = this.findSerialnum(serialnum);
		p.setAlive(alive);
	}
	
	/**
	 * Changes the inpatient status of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param inpatient
	 */
	public void editInpatient(int serialnum, boolean inpatient) {
		Patient p = this.findSerialnum(serialnum);
		p.setAlive(inpatient);	
	}
	
	/**
	 * Changes the health data of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param healthData
	 */
	public void editHealthData(int serialnum, String healthData) {
		Patient p = findSerialnum(serialnum);
		p.setHealthData(healthData);
	}
	
	/**
	 * View the health data
	 * @param serialnum
	 * @return health data
	 */
	public String viewHealthData(int serialnum) {
		return findSerialnum(serialnum).getHealthData();	
	}

	public void admit(int serialnum, String deptName) {
		if (dr.containsKey(deptName)) {
			Patient p = findSerialnum(serialnum);
			p.setDepartment(deptName);
			dr.get(deptName).addPatient(p);
		} else {
			throw new IllegalArgumentException("Invalid department name");
		}
	}

	public String getDeptOf(int serialnum) {
		return this.findSerialnum(serialnum).getDepartment();
	}

	public void addDept(String deptName, int beds) {
		if (dr.containsKey(deptName)) {
			throw new IllegalArgumentException("Department already exists");
		} else {
			dr.put(deptName, new Department(deptName, beds));
		}
	}
}
