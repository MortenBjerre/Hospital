package Hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Department {

	private int beds;
	private ArrayList<Patient> patients;
	private ArrayList<Staff> staff;

	private String deptName;
	
	public Department(String deptName, int beds) {
		this.deptName = deptName;
		this.beds = beds;
		patients = new ArrayList<Patient>();
		staff = new ArrayList<Staff>();
	}
	
	public Department(String deptName) {
		this.deptName = deptName;
		this.beds = 0;
		patients = new ArrayList<Patient>();
		staff = new ArrayList<Staff>();
	}

	/**
	 *  returns the number of beds in a department
	 * @return an int representing the number of beds in a department
	 */
	public int getBedsTotal() {
		return beds;
	}
	
	/**
	 * returns the number of free beds in a department
	 * It's calculated by subtracting the amount of patients from the number of beds
	 * @return returns an int representing the number of free beds in a department
	 */
	//needs to be updated with the ingoing, outgoing patients
	public int getFreeBeds(){
		return (beds-patients.size());
	}
	
	/**
	 * returns the number of occupied beds in a department
	 * @return returns an int representing the number of occupied beds in a department
	 */
	public int getOccupiedBeds() {
		return patients.size();
	}
	
	/**
	 * Adds beds to a department
	 * @param beds the amount of beds to be added
	 */
	public void addNewBeds(int beds) {
		this.beds += beds;
	}
	
	/**
	 * Removes beds from a department
	 * if the amount of beds in a department is less than the amount of beds to be subtracted, the amount of beds will be unchanged
	 * and an error message will be displayed
	 * @param beds the amount of beds to be removed
	 */
	public void removeBeds(int beds) {
		if (this.beds - beds < 0) {
			System.out.println("There aren't that enough beds to subtract that many");
		} 
		else {
			this.beds -= beds;
		}
	
	}
	
	/**
	 * gets the name of a department
	 * @return the name of the department
	 */
	public String getDeptName() {
		return deptName;
	}
	
	/**
	 * sets the name of a department
	 * @param deptName the name of the department to be set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	/**
	 * Adds a staff member to the hashmap of staffmembers in a department
	 * @param s The staff member to be added
	 */
	public void addStaff(Staff s) {
		staff.add(s);
	}
	/**
	 * Adds a patient to the hashmap of patients in a department
	 * @param patient the patient to be added
	 */
	public void addPatient(Patient patient) {
		patients.add(patient);
	}
	/**
	 * remove a patient from the arraylist of patientes in a department
	 * @param patient patient to be removed
	 */
	public void deletePatient(Patient patient) {
		patients.remove(patient);
	}
	
	/**
	 * remove a staff member from the arraylist of staff in a department
	 * @param staff staff to be removed
	 */
	public void deleteStaff(Staff staff) {
		this.staff.remove(staff);
	}
	
	public String[] getPatients() {
		ArrayList<String> patientslist = new ArrayList<String>();
		for (Patient p : patients) {
			patientslist.add(p.toString());
		}
		String[] m = new String[patientslist.size()];
		m = patientslist.toArray(m);
		return m;
	}
	
	public String[] getStaff() {
		ArrayList<String> stafflist = new ArrayList<String>();
		for (Staff s : staff) {
			stafflist.add(s.toString());
		}
		String[] m = new String[stafflist.size()];
		m = stafflist.toArray(m);
		return m;
	}
	
	/**
	 * Checks whether this department has a specified patient
	 * @param p A patient of type Patient
	 * @return true if department has patient
	 */
	public boolean containsPatient(Patient p) {
		return patients.contains(p);
	}
	
	/**
	 * Checks whether this department has a patient with a matching serialnum
	 * @param serialnum The patient's serialnum of type int
	 * @return true if department has patient
	 */
	public boolean containsPatient(int serialnum) {
		for (Patient p : patients) {
			if (p.getSerialnum() == serialnum) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks whether this department has a specified staff member
	 * @param s A staff of type Staff
	 * @return true if department has staff
	 */
	public boolean containsStaff(Staff s) {
		return staff.contains(s);
	}
	
	/**
	 * Checks whether this department has a staff with a matching serialnum
	 * @param serialnum The staff's serialnum of type int
	 * @return true if department has staff
	 */
	public boolean containsStaff(int serialnum) {
		for (Staff s : staff) {
			if (s.getSerialnum() == serialnum) {
				return true;
			}
		}
		return false;
	}
}