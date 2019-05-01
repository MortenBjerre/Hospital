package Hospital;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DepartmentRegister {
	
	//departments is a map mapping string department names to objects of department
	private Map<String, OutpatientDepartment> departments;
	
	public DepartmentRegister() {
		this.departments = new HashMap<String, OutpatientDepartment>();
	}
	
	/**
	 * creates a new department and adds it to a map of departments (map: department name -> object of department with that name)
	 * @param deptName name you want to give to department 
	 * @param beds number of beds you want to add to newly created department
	 */
	public void createDepartment(String deptName, int beds) {
		departments.put(deptName, new InpatientDepartment(deptName, beds));
	}
	
	/**
	 * creates a new department and adds it to a map of departments (map: department name -> object of department with that name)
	 * @param deptName name you want to give to department - beds is set to 0
	 */
	public void createDepartment(String deptName) {
		departments.put(deptName, new OutpatientDepartment(deptName));
	}
	
	/**
	 * returns an object of type Department whose name matches the input
	 * @param deptName name of department you want to find
	 * @return
	 */
	protected OutpatientDepartment findDepartment(String deptName) {
		return departments.get(deptName);
	}
	
	/**
	 * Removes a department from the department register by name if there are 
	 * no staff members or patients still in the department. If there is it throws 
	 * a new IllegalArgumentException "There are still staff and/or patients in the department"
	 * @param deptName name of department you want to remove
	 */
	public void deleteDepartment(String deptName) {
		String[] listOfPatients = departments.get(deptName).getPatients();
		String[] listOfStaffMembers = departments.get(deptName).getStaffMembers();
		if (listOfPatients.length == 0 && listOfStaffMembers.length == 0) {
				departments.remove(deptName);
		} else {
			throw new IllegalArgumentException("There are still staff and/or patients in the department");
		}
	}
	
	/**
	 * Moves patient from current department to specified department by serialnum.
	 * Throws IllegalArgumentException if specified department exists.
	 * @param serialnum
	 * @param deptName
	 * @param pr PatientRegister
	 */
	public void movePatient(int serialnum, String deptName, PatientRegister pr) {
		Patient p = pr.findSerialnum(serialnum);
		movePatient(p, deptName);
	}
	
	/**
	 * Moves patient from current department to specified department by serialnum.
	 * Throws IllegalArgumentException if specified department exists.
	 * @param p Patient object
	 * @param deptName
	 * @return true if successful 
	 */
	private boolean movePatient(Patient p, String deptName) {
		for (String dep : departments.keySet()) {
			OutpatientDepartment department = departments.get(dep);
			if (department.containsPatient(p)) {
				department.deletePatient(p);
				OutpatientDepartment newDepartment = departments.get(deptName);
				newDepartment.addPatient(p);
				return true;
			}
		} 
		throw new IllegalArgumentException("No such department");
	}
	
	/**
	 * Moves staff member from current department to specified department by serialnum.
	 * Throws IllegalArgumentException if specified department exists.
	 * @param serialnum
	 * @param deptName
	 * @param sr StaffRegister
	 */
	public void moveStaff(int serialnum, String deptName, StaffRegister sr) {
		Staff s = sr.findSerialnum(serialnum);
		moveStaff(s, deptName);
	}
	
	/**
	 * Moves staff member from current department to specified department by serialnum.
	 * Throws IllegalArgumentException if specified department exists.
	 * @param s Staff object
	 * @param deptName
	 * @return true if successful 
	 */
	private boolean moveStaff(Staff s, String deptName) {
		for (String dep : departments.keySet()) {
			OutpatientDepartment department = departments.get(dep);
			if (department.containsStaff(s)) {
				department.deleteStaff(s);
				OutpatientDepartment newDepartment = departments.get(deptName);
				newDepartment.addStaff(s);
				return true;
			}
		}
		throw new IllegalArgumentException("No such department");
	}
	
	/**
	 * Discharges a patient from their department and the hospital.
	 * @param p Patient object
	 * @return true if successful
	 */
	private boolean dischargePatient(Patient p) {
		for (String dep : departments.keySet()) {
			OutpatientDepartment department = departments.get(dep);
			if (department.containsPatient(p)) {
				department.deletePatient(p);
				return true;
			}
		}
		throw new IllegalArgumentException("No such patient admitted");
	}
	
	/**
	 * Discharges a patient from their department and the hospital.
	 * @param serialnum
	 * @param pr PatientRegister
	 */
	public void dischargePatient(int serialnum, PatientRegister pr) {
		Patient p = pr.findSerialnum(serialnum);
		dischargePatient(p);		
	}
	
	/**
	 * Removes staff member s from their department. Otherwise, throws IllegalArgumentException
	 * "No such staff member in a department"
	 * @param s Staff
	 * @return true if successful
	 */
	private boolean dischargeStaff(Staff s) {
		for (String dep : departments.keySet()) {
			OutpatientDepartment department = departments.get(dep);
			if (department.containsStaff(s)) {
				department.deleteStaff(s);
				return true;
			}
		}
		throw new IllegalArgumentException("No such staff member in a department");
	}
	
	/**
	 * Discharges a staff from a their department
	 * @param serialnum
	 * @param sr StaffRegister
	 */
	public void dischargeStaff(int serialnum, StaffRegister sr) {
		Staff s = sr.findSerialnum(serialnum);
		dischargeStaff(s);		
	}
	
	/**
	 * Gives the staff members in searched department
	 * @param deptName
	 * @return String array of staff members in department
	 */
	public String[] searchStaffDepartment(String deptName) {
		for (String dept : departments.keySet()) {
			if (dept == deptName) {
				return departments.get(dept).getAllStaff();
			}
		}
		return new String[0];
	}
	
	/**
	 * Admits a patient to a specific department. The patient should
	 * be registered in the PatientRegister already. Throws exceptions
	 * if the department does not exist or it is already fully occupied
	 * @param serialnum
	 * @param deptName
	 * @param pr PatientRegister
	 */
	public void admit(int serialnum, String deptName, PatientRegister pr) {
		Patient patient = pr.findSerialnum(serialnum);
		if (this.findDepartment(deptName) instanceof InpatientDepartment) {
			InpatientDepartment department = (InpatientDepartment) this.findDepartment(deptName);
			if (department == null) {
				throw new IllegalArgumentException("No such department");
			} else {
				if (department.getFreeBeds() > 0) {
					department.addPatient(patient);
				} else {
					throw new IllegalArgumentException("Department is full");
				}
			}
		} else {
			OutpatientDepartment department = departments.get(deptName);
			if (department == null) {
				throw new IllegalArgumentException("No such department");
			} else {
				department.addPatient(pr.findSerialnum(serialnum));
			}
		}
	}
	
	/**
	 * Returns the department of the patient specified by specific serialnum.
	 * @param serialnum
	 * @return department name or empty string if patient has not yet been admitted
	 */
	public String getDeptOfPatient(int serialnum) {
		for (String deptName : departments.keySet()) {
			boolean deptContainsPatient = departments.get(deptName).containsPatient(serialnum);
			if (deptContainsPatient) {
				return deptName;
			}
		}
		return "";
	}
	
	/**
	 * Returns true if the department register contains the department
	 * @param deptName
	 * @return true if department exists
	 */
	public boolean containsDept(String deptName) {
		return departments.containsKey(deptName);
	}
	
	/**
	 * Adds a staff member to a department. Throws an error if the department
	 * does not exist. 
	 * @param serialnum
	 * @param deptName
	 * @param sr StaffRegister
	 */
	public void addStaffTo(int serialnum, String deptName, StaffRegister sr) {
		Staff staff = sr.findSerialnum(serialnum);
		if (this.findDepartment(deptName) == null) {
			throw new IllegalArgumentException("No such department");
		} else {
			try {
				this.dischargeStaff(staff);
			} catch (IllegalArgumentException e) {
				; //pass
			}
			this.findDepartment(deptName).addStaff(staff);
		}
	}
	
	/**
	 * Searches department register for patient by serialnumber.
	 * Will throw error if the patient is not admitted.
	 * @param serialnum
	 * @param pr PatientRegister
	 * @return string of patient
	 */
	public String searchSerialNum(int serialnum, PatientRegister pr) {
		Patient patientInDept = null;
		for (String deptName : departments.keySet()) {
			boolean deptContainsPatient = departments.get(deptName).containsPatient(serialnum);
			if (deptContainsPatient) {
				patientInDept = departments.get(deptName).getPatient(serialnum);
			}
		}
		if (patientInDept == null) {
			throw new IllegalArgumentException("No such patient admitted");
		} else {
			return patientInDept.toString();
		}	
	}
	
	/**
	 * Gets the number of unoccupied beds from the department given
	 * @param deptName
	 * @return int number of unoccupied beds
	 */
	public int getAvailableBeds(String deptName) {
		if (departments.containsKey(deptName)) {
			if (departments.get(deptName) instanceof InpatientDepartment) {
				InpatientDepartment inpatientDepartment = (InpatientDepartment) departments.get(deptName);
				return inpatientDepartment.getFreeBeds();
			} else {
				return 0;
			}
		} else {
			throw new IllegalArgumentException("No such department");
		}
	}
	
	/**
	 * Gets the total number of beds in a department, including occupied beds
	 * @param deptName
	 * @return int total number of beds 
	 */
	public int getTotalBeds(String deptName) {
		if (departments.containsKey(deptName)) {
			if (departments.get(deptName) instanceof InpatientDepartment) {
				InpatientDepartment inpatientDepartment = (InpatientDepartment) departments.get(deptName);
				return inpatientDepartment.getTotalBeds();
			} else {
				return 0;
			}
		} else {
			throw new IllegalArgumentException("No such department");
		}
	}

	/**
	 * Adds a number of beds to a department, updating the existing number of beds
	 * @param deptName
	 * @param addedBeds Number of beds you want added to department
	 */
	public void addBeds(String deptName, int addedBeds) {
		if (departments.containsKey(deptName)) {
			if (departments.get(deptName) instanceof InpatientDepartment) {
				InpatientDepartment inpatientDepartment = (InpatientDepartment) departments.get(deptName);
				inpatientDepartment.addNewBeds(addedBeds);
			} else {
				throw new IllegalArgumentException("Can't add beds to outpatient department");
			}
		} else {
			throw new IllegalArgumentException("No such department");
		}
	}

	/**
	 * Removes a number of beds from a department, updating the existing number of beds
	 * @param deptName
	 * @param removedBeds Number of beds you want removed from department
	 */
	public void removeBeds(String deptName, int removedBeds) {
		if (departments.containsKey(deptName)) {
			if (departments.get(deptName) instanceof InpatientDepartment) {
				InpatientDepartment inpatientDepartment = (InpatientDepartment) departments.get(deptName);
				inpatientDepartment.removeBeds(removedBeds);;
			} else {
				throw new IllegalArgumentException("Can't remove beds from outpatient department");
			}
		} else {
			throw new IllegalArgumentException("No such department");
		}
	}

	public int getBedOf(int serialnum, String deptName) {
		if (departments.containsKey(deptName)) {
			if (departments.get(deptName) instanceof InpatientDepartment) {
				InpatientDepartment inpatientDepartment = (InpatientDepartment) departments.get(deptName);
				return inpatientDepartment.getBedOf(serialnum);
			} else {
				throw new IllegalArgumentException("No beds in this department");
			}
		} else {
			throw new IllegalArgumentException("No such department");
		}
	}

	public Patient getPatientInBed(int bedNumber, String deptName) {
		if (departments.containsKey(deptName)) {
			if (departments.get(deptName) instanceof InpatientDepartment) {
				InpatientDepartment inpatientDepartment = (InpatientDepartment) departments.get(deptName);
				Patient patient = inpatientDepartment.getPatientIn(bedNumber);
				return patient;
			} else {
				throw new IllegalArgumentException("No patient in this department");
			}
		} else {
			throw new IllegalArgumentException("No such department");
		}
	}

	/**
	 * Gives the staff member with specified serial number
	 * @param serialnum
	 * @return Staff member
	 */
	public Staff getStaff(int serialnum) {
		for (String deptName : departments.keySet()) {
			OutpatientDepartment department = departments.get(deptName);
			if (department.containsStaff(serialnum)) {
				return department.getStaff(serialnum);
			}
		}
		throw new IllegalArgumentException("No such staff");
	}

	/**
	 * Allows you to change the name of a department.
	 * Throws IllegalArgumentException "No such department" if the department
	 * is not in department register
	 * @param deptName old department name
	 * @param newDeptName new department name
	 */
	public void changeNameOf(String deptName, String newDeptName) {
		if (departments.containsKey(deptName)) {
			departments.get(deptName).setDeptName(newDeptName);
			OutpatientDepartment d = departments.remove(deptName);
			departments.put(newDeptName, d);
		} else {
			throw new IllegalArgumentException("No such department");
		}
	}
}