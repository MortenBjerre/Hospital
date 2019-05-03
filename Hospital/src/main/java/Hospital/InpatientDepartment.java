package Hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="InpatientDepartment")
public class InpatientDepartment extends OutpatientDepartment {
	@XmlElement(name = "beds")
	private int beds;
	@XmlElementWrapper(name="patients")
	protected HashMap<Integer, Patient> patients = new HashMap<Integer, Patient>();
	
	protected InpatientDepartment() {}
	protected InpatientDepartment(String deptName, int beds) {
		super(deptName);
		this.beds = beds;
	}
	

	/**
	 * Assigns a patient to the first available bed in the department.
	 * Throws IllegalArgumentException "No available beds" if there are no available beds.
	 * @param patient the patient to be added
	 */
	protected void addPatient(Patient patient) {
		boolean availableBeds = false;
		for (int bedNumber = 0; bedNumber < beds; bedNumber++) {
			if (!patients.containsKey(bedNumber)) {
				patients.put(bedNumber, patient);
				availableBeds = true;
				break;
			}
		}
		if (!availableBeds) {
			throw new IllegalArgumentException("No available beds");
		}
	}
	/**
	 * Remove the patient from the department.
	 * Throws IllegalArgumentException "No such patient" if the patient is not in the department
	 * @param patient patient to be removed
	 */
	protected void deletePatient(Patient patient) {
		boolean patientFound = false;
		for (Integer bedNumber : patients.keySet()) {
			if (patients.get(bedNumber).equals(patient)) {
				patients.remove(bedNumber);
				patientFound = true;
				break;
			}
		}
		if (!patientFound) {
			throw new IllegalArgumentException("No such patient");
		}
	}
	
	
	/**
	 * Gives the patients in department 
	 * @return string array of patients in department
	 */
	protected String[] getPatients() {
		ArrayList<String> patientslist = new ArrayList<String>();
		for (Integer bedNumber : patients.keySet()) {
			String patientString = patients.get(bedNumber).toString();
			patientslist.add(patientString);
		}
		String[] patientListString = new String[patientslist.size()];
		patientListString = patientslist.toArray(patientListString);
		return patientListString;
	}
	
	
	/**
	 * Checks whether this department has a specified patient
	 * @param patient A patient of type Patient
	 * @return true if department has patient
	 */
	protected boolean containsPatient(Patient patient) {
		for (Integer bedNumber : patients.keySet()) {
			if (patients.get(bedNumber).equals(patient)) {
				return true;
			}
		} 
		return false;
	}
	
	/**
	 * Checks whether this department has a patient with a matching serialnum
	 * @param serialnum The patient's serialnum of type int
	 * @return true if department has patient
	 */
	protected boolean containsPatient(int serialnum) {
		for (Integer bedNumber : patients.keySet()) {
			if (patients.get(bedNumber).getSerialnum() == serialnum) {
				return true;
			}
		} 
		return false;
	}
	
	
	/**
	 * Gets the patient with a matching serialnum. Throws an IllegalArgumentException
	 * returns null if there is no matching patient
	 * @param serialnum
	 * @return matching Patient p
	 */
	protected Patient getPatient(int serialnum) {
		for (Integer bedNumber : patients.keySet()) {
			Patient patient = patients.get(bedNumber);
			if (patient.getSerialnum() == serialnum) {
				return patient;
			}
		}
		return null;
	}
	/**
	 *  returns the number of beds in a department
	 * @return an int representing the number of beds in a department
	 */
	protected int getTotalBeds() {
		return beds;
	}
	
	/**
	 * returns the number of free beds in a department
	 * It's calculated by subtracting the amount of patients from the number of beds
	 * @return returns an int representing the number of free beds in a department
	 */
	protected int getFreeBeds(){
		return (beds - patients.size());
	}
	
	/**
	 * returns the number of occupied beds in a department
	 * @return returns an int representing the number of occupied beds in a department
	 */
	protected int getOccupiedBeds() {
		return patients.size();
	}
	
	/**
	 * Adds beds to a department
	 * @param beds the amount of beds to be added
	 */
	protected void addNewBeds(int beds) {
		this.beds += beds;
	}
	
	/**
	 * Removes beds from a department
	 * if the amount of beds in a department is less than the amount of beds to be subtracted, the amount of beds will be unchanged
	 * and an IllegalArgumentException message "There aren't that enough beds to subtract that many" will be displayed
	 * @param beds the amount of beds to be removed
	 */
	protected void removeBeds(int beds) {
		if (this.beds - beds < 0) {
			throw new IllegalArgumentException("There aren't that enough beds to subtract that many");
		} 
		else {
			this.beds -= beds;
		}
	}

	/**
	 * Returns bed number of patient with corresponding serialnumber. 
	 * Throws IllegalArgumentException "No such patient" if the patient is not in department.
	 * @param serialnum
	 * @return bed number
	 */
	protected int getBedOf(int serialnum) {
		for (Integer bedNumber : patients.keySet()) {
			if (patients.get(bedNumber).getSerialnum() == serialnum) {
				return bedNumber;
			}
		}
		throw new IllegalArgumentException("No such patient");
	}
	
	/**
	 * Returns patient in specified bed
	 * @param bedNumber
	 * @return Patient
	 */
	protected Patient getPatientIn(int bedNumber) {
		return patients.get(bedNumber);
	}
}