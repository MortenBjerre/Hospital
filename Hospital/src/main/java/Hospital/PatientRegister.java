package Hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PatientRegister extends Register<Patient> {
	
	/**
	 * When creating a patient register the serialnum counter is reset
	 */
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
		Patient patient = new Patient(email, name, surname, birthday, gender, address, 
								phoneNumber, alive, healthData);
		users.put(patient.getSerialnum(), patient);
		
		return patient.getSerialnum();
	}
	
	
	/**
	 * Searches for patients with matching address
	 * @param address
	 * @return String array of patients
	 */
	public String[] searchAddress(String address) {
		ArrayList<Patient> matches = findAddress(address);
		String[] matchesToStringArray = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			matchesToStringArray[i] = matches.get(i).toString();
		}
		return matchesToStringArray;
	}
	/**
	 * Searches for patients with matching address
	 * @param address
	 * @return ArrayList of matching patients
	 */
	protected ArrayList<Patient> findAddress(String address) {
		ArrayList<Patient> matches = new ArrayList<Patient>();
		for (Integer serialnum : users.keySet()) {
			Patient patient = users.get(serialnum);
			if (patient.getAddress() == address) {
				matches.add(patient);
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
		String[] matchesToStringArray = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			matchesToStringArray[i] = matches.get(i).toString();
		}
		return matchesToStringArray;
	}
	
	/**
	 * Searches for patients with matching phone numbers
	 * @param phoneNumber
	 * @return ArrayList of matching patients
	 */
	protected ArrayList<Patient> findNumber(int phoneNumber) {
		ArrayList<Patient> matches = new ArrayList<Patient>();
		for (Integer serialnum : users.keySet()) {
			Patient patient = users.get(serialnum);
			if (patient.getPhoneNumber() == phoneNumber) {
				matches.add(patient);
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
		String[] matchesToStringArray = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			matchesToStringArray[i] = matches.get(i).toString();
		}
		return matchesToStringArray;
	}
	
	/**
	 * Searches for patients with matching alive status
	 * @param alive
	 * @return ArrayList of matching patients
	 */
	private ArrayList<Patient> findAlive(boolean alive) {
		ArrayList<Patient> matches = new ArrayList<Patient>();
		for (Integer serialnum : users.keySet()) {
			Patient patient = users.get(serialnum);
			if (patient.getAlive() == alive) {
				matches.add(patient);
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
		Patient patient = this.findSerialnum(serialnum);
		patient.setBirthday(birthday);		
	}
	
	/**
	 * Changes the phone number of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param phoneNumber
	 */
	public void editPhoneNumber(int serialnum, int phoneNumber) {
		Patient patient = this.findSerialnum(serialnum);
		patient.setPhoneNumber(phoneNumber);	
	}
	
	/**
	 * Changes the address of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param address
	 */
	public void editAddress(int serialnum, String address) {
		Patient patient = this.findSerialnum(serialnum);
		patient.setAddress(address);		
	}
	
	/**
	 * Changes the alive status of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param alive
	 */
	public void editAlive(int serialnum, boolean alive) {
		Patient patient = this.findSerialnum(serialnum);
		patient.setAlive(alive);
	}
	
	/**
	 * Changes the health data of a given patient, identified by their serialnum
	 * @param serialnum
	 * @param healthData
	 */
	public void editHealthData(int serialnum, String healthData) {
		Patient patient = findSerialnum(serialnum);
		patient.setHealthData(healthData);
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
