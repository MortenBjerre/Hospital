package Hospital;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DepartmentRegister {
	
	//departments is a map mapping string department names to objects of department
	private Map<String, Department> departments;
	
	/**
	 * Prints departmentRegister by first listing the admitted patients in the department
	 * and then the staff members working in the department
	 */
	public String toString() {
		String a = "Patients in department: \n";
		for (String dep : departments.keySet()) {
			for (String patientInDept: departments.get(dep).getPatients()) {
				a += patientInDept;
			};
		}
		a += "\nStaff members in department \n";
		for (String dep : departments.keySet()) {
			for(String staffInDept: departments.get(dep).getStaff()) {
				a += staffInDept;
			}
		}
		return a;
		
	}
	
	public DepartmentRegister() {
		this.departments = new HashMap<String, Department>();
	}
	
	/**
	 * creates a new department and adds it to a map of departments (map: department name -> object of department with that name)
	 * @param deptName name you want to give to department 
	 * @param beds number of beds you want to add to newly created department
	 */
	public void createDepartment(String deptName, int beds) {
		departments.put(deptName, new Department(deptName, beds));
	}
	/**
	 * creates a new department and adds it to a map of departments (map: department name -> object of department with that name)
	 * @param deptName name you want to give to department - beds is set to 0
	 */
	public void createDepartment(String deptName) {
		departments.put(deptName, new Department(deptName));
	}
	
	/**
	 * returns an object of type Department whose name matches the input
	 * @param deptName name of department you want to find
	 * @return
	 */
	protected Department findDepartment(String deptName) {
		return departments.get(deptName);
	}
	
	/**
	 * Removes a department from the map of departments, by department name
	 * @param deptName name of department you want to remove
	 */
	public void deleteDepartment(String deptName) {
		departments.remove(deptName);
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
			if (departments.get(dep).containsPatient(p)) {
				departments.get(dep).deletePatient(p);
				departments.get(deptName).addPatient(p);
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
			if (departments.get(dep).containsStaff(s)) {
				departments.get(dep).deleteStaff(s);
				departments.get(deptName).addStaff(s);
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
			if (departments.get(dep).containsPatient(p)) {
				departments.get(dep).deletePatient(p);
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
	
	private boolean dischargeStaff(Staff s) {
		for (String dep : departments.keySet()) {
			if (departments.get(dep).containsStaff(s)) {
				departments.get(dep).deleteStaff(s);
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
	
	
	public String[] searchPatientDepartment(String deptName) {
		for (String dept : departments.keySet()) {
			if (dept == deptName) {
				return departments.get(dept).getPatients();
			}
		}
		return new String[0];
	}
	
	public String[] searchStaffDepartment(String deptName) {
		for (String dept : departments.keySet()) {
			if (dept == deptName) {
				return departments.get(dept).getStaff();
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
		Patient p = pr.findSerialnum(serialnum);
		if (this.findDepartment(deptName) == null) {
			throw new IllegalArgumentException("No such department");
		} else {
			if (this.findDepartment(deptName).getFreeBeds() > 0) {
				this.findDepartment(deptName).addPatient(p);
			} else {
				throw new IllegalArgumentException("Department is full");
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
			if (departments.get(deptName).containsPatient(serialnum)) {
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
		Staff s = sr.findSerialnum(serialnum);
		if (this.findDepartment(deptName) == null) {
			throw new IllegalArgumentException("No such department");
		} else {
			this.findDepartment(deptName).addStaff(s);
		}
	}

	public String searchSerialNum(int serialnum, PatientRegister pr) {
		Patient p = null;
		for (String deptName : departments.keySet()) {
			if (departments.get(deptName).containsPatient(serialnum)) {
				p = departments.get(deptName).getPatient(serialnum);
			}
		}
		if (p == null) {
			throw new IllegalArgumentException("No such patient admitted");
		} else {
			return p.toString();
		}
		
	}
	
	/**
	 * Gets the number of unoccupied beds from the department given
	 * @param deptName
	 * @return int number of unoccupied beds
	 */
	public int getAvailableBeds(String deptName) {
		if (departments.containsKey(deptName)) {
			return departments.get(deptName).getFreeBeds();
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
			return departments.get(deptName).getBedsTotal();
		} else {
			throw new IllegalArgumentException("No such department");
		}
	}


}