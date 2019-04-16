package Hospital;

import java.util.HashMap;
import java.util.Map;

public class DepartmentRegister{
	
	//departments is a map mapping string department names to objects of department
	private Map<String, Department> departments;
	/**
	 * creates a new department and adds it to a map of departments (map: department name -> object of department with that name)
	 * @param deptName name you want to give to department 
	 * @param beds number of beds you want to add to newly created department
	 */
	
	public DepartmentRegister() {
		this.departments = new HashMap<String, Department>();
	}
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
	
	public void movePatient(Patient p, String deptName) {
		for (String dep : departments.keySet()) {
			if (departments.get(dep).containsPatient(p)) {
				departments.get(dep).deletePatient(p);
				departments.get(deptName).addPatient(p);
			}
		}
	}
	
	public void moveStaff(Staff s, String deptName) {
		for (String dep : departments.keySet()) {
			if (departments.get(dep).containsStaff(s)) {
				departments.get(dep).deleteStaff(s);
				departments.get(deptName).addStaff(s);
			}
		}
	}
	
	public void deletePatient(Patient p) {
		for (String dep : departments.keySet()) {
			if (departments.get(dep).containsPatient(p)) {
				departments.get(dep).deletePatient(p);
			}
		}
	}
	
	public void deleteStaff(Staff s) {
		for (String dep : departments.keySet()) {
			if (departments.get(dep).containsStaff(s)) {
				departments.get(dep).deleteStaff(s);
			}
		}
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
	public String getDeptOf(int serialnum) {
		for (String deptName : departments.keySet()) {
			if (departments.get(deptName).containsPatient(serialnum)) {
				return deptName;
			}
		}
		return "";
	}
	
	public boolean containsDept(String deptName) {
		return departments.containsKey(deptName);
	}
	public void addStaffTo(int serialnum, String deptName, StaffRegister sr) {
		Staff s = sr.findSerialnum(serialnum);
		if (this.findDepartment(deptName) == null) {
			throw new IllegalArgumentException("No such department");
		} else {
			this.findDepartment(deptName).addStaff(s);
		}
	}
}