package Hospital;

import java.util.ArrayList;
import java.util.Date;

public class PatientRegister extends Register<Patient> {
	
	public PatientRegister() {
		Patient.resetSerialnumCounter();
	}
	
	/**
	 * Adds a patient to the register
	 * @param p Patient
	 */
	public int add(String email, String name, String surname, Date birthday,
			String gender, String address, int phoneNumber, boolean alive, String department, boolean inpatient) {
		Patient p = new Patient(email, name, surname, birthday, gender, address, phoneNumber, alive, department, inpatient);
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

	public void editBirthday(int serialnum, Date birthday) {
		Patient p = this.findSerialnum(serialnum);
		p.setBirthday(birthday);		
	}
	
	public void editPhoneNumber(int serialnum, int phoneNumber) {
		Patient p = this.findSerialnum(serialnum);
		p.setPhoneNumber(phoneNumber);	
	}
	
	public void editAddress(int serialnum, String address) {
		Patient p = this.findSerialnum(serialnum);
		p.setAddress(address);		
	}
	
	public void editAlive(int serialnum, boolean alive) {
		Patient p = this.findSerialnum(serialnum);
		p.setAlive(alive);	
	}
	
	public void editInpatient(int serialnum, boolean inpatient) {
		Patient p = this.findSerialnum(serialnum);
		p.setAlive(inpatient);	
	}
	
}
