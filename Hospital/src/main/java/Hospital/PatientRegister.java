package Hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "patientRegister")

public class PatientRegister extends Register<Patient> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	 * @param healthData
	 * @return Returns the serial number of the patient added
	 */
	public int add(String email, String name, String surname, Date birthday,
			String gender, String address, int phoneNumber, boolean alive, 
			String healthData) {
		Patient p = new Patient(email, name, surname, birthday, gender, address, 
								phoneNumber, alive, healthData);
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
}
