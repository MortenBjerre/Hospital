package Hospital;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name="OutpatientDepartment")
public class OutpatientDepartment implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElementWrapper(name="patients")
	protected ArrayList<Patient> patients;
	@XmlElementWrapper(name="staff")
	protected ArrayList<Staff> staff;
	@XmlElement(name ="deptName")
	protected String deptName;
	
	protected OutpatientDepartment() {}
	
	protected OutpatientDepartment(String deptName) {
		this.deptName = deptName;
		patients = new ArrayList<Patient>();
		staff = new ArrayList<Staff>();
	}
	
	/**
	 * gets the name of a department
	 * @return the name of the department
	 */
	protected String getDeptName() {
		return deptName;
	}
	
	/**
	 * sets the name of a department
	 * @param deptName the name of the department to be set
	 */
	protected void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	/**
	 * Adds a staff member to the arraylist of staffmembers in a department
	 * @param s The staff member to be added
	 */
	protected void addStaff(Staff s) {
		staff.add(s);
	}
	/**
	 * Adds a patient to the arraylist of patients in a department
	 * @param patient the patient to be added
	 */
	protected void addPatient(Patient patient) {
		patients.add(patient);
	}
	/**
	 * remove a patient from the arraylist of patientes in a department
	 * @param patient patient to be removed
	 */
	protected void deletePatient(Patient patient) {
		patients.remove(patient);
	}
	
	/**
	 * remove a staff member from the arraylist of staff in a department
	 * @param staff staff to be removed
	 */
	protected void deleteStaff(Staff staff) {
		this.staff.remove(staff);
	}
	
	/**
	 * Gives the patients in department 
	 * @return string array of patients in department
	 */
	protected String[] getPatients() {
		ArrayList<String> patientslist = new ArrayList<String>();
		for (Patient patient : patients) {
			patientslist.add(patient.toString());
		}
		String[] patientListString = new String[patientslist.size()];
		patientListString = patientslist.toArray(patientListString);
		return patientListString;
	}
	
	/**
	 * Gives the staff members in department 
	 * @return string array of staff members in department
	 */
	protected String[] getStaffMembers() {
		ArrayList<String> stafflist = new ArrayList<String>();
		for (Staff s : staff) {
			stafflist.add(s.toString());
		}
		String[] patientListString = new String[stafflist.size()];
		patientListString = stafflist.toArray(patientListString);
		return patientListString;
	}
	
	/**
	 * Gives the staff members working in department
	 * @return string array of staff members in department
	 */
	protected String[] getAllStaff() {
		ArrayList<String> stafflist = new ArrayList<String>();
		for (Staff s : staff) {
			stafflist.add(s.toString());
		}
		String[] staffListString = new String[stafflist.size()];
		staffListString = stafflist.toArray(staffListString);
		return staffListString;
	}
	
	/**
	 * Checks whether this department has a specified patient
	 * @param patient A patient of type Patient
	 * @return true if department has patient
	 */
	protected boolean containsPatient(Patient patient) {
		return patients.contains(patient);
	}
	
	/**
	 * Checks whether this department has a patient with a matching serialnum
	 * @param serialnum The patient's serialnum of type int
	 * @return true if department has patient
	 */
	protected boolean containsPatient(int serialnum) {
		for (Patient patient : patients) {
			if (patient.getSerialnum() == serialnum) {
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
	protected boolean containsStaff(Staff s) {
		return staff.contains(s);
	}
	
	/**
	 * Checks whether this department has a staff with a matching serialnum
	 * @param serialnum The staff's serialnum of type int
	 * @return true if department has staff
	 */
	protected boolean containsStaff(int serialnum) {
		for (Staff s : staff) {
			if (s.getSerialnum() == serialnum) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the patient with a matching serialnum. 
	 * returns null if there is no matching patient
	 * @param serialnum
	 * @return matching Patient p
	 */
	protected Patient getPatient(int serialnum) {
		for (Patient patient : patients) {
			if (patient.getSerialnum() == serialnum) {
				return patient;
			}
		}
		return null;
	}

	/**
	 * Gets the staff member with a matching serialnumb.
	 * returns null if there is no matching patietnt
	 * @param serialnum 
	 * @return matching Staff
	 */
	protected Staff getStaff(int serialnum) {
		for (Staff staff : staff) {
			if (staff.getSerialnum() == serialnum) {
				return staff;
			}
		}
		throw new IllegalArgumentException("No such staff");
	}
}