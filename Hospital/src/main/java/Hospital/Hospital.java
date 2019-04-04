package Hospital;

import java.util.Date;

public class Hospital {
	StaffRegister staffRegister = new StaffRegister();
	PatientRegister patientRegister = new PatientRegister();
	DepartmentRegister departmentRegister = new DepartmentRegister();
	
	public void registerPatient(String email, String name, String surname, Date birthday,
			String gender, String address, int number, boolean alive,String department, boolean inpatient) {
		int serialnum = patientRegister.add(email, name, surname, birthday, gender, address, number, alive, department, inpatient);
		departmentRegister.findDepartment(department).addPatient(patientRegister.findSerialnum(serialnum));
	}
	
	public void registerStaff(String email, String name, String surname, Date birthday, String gender, String department) {
		int serialnum = staffRegister.add(email, name, surname, birthday, gender, department);
		departmentRegister.findDepartment(department).addStaff(staffRegister.findSerialnum(serialnum));
	}
	
	public void movePatient(int serialnum, String departmentName) {
		Patient p = patientRegister.findSerialnum(serialnum);
		departmentRegister.movePatient(p, departmentName);
		patientRegister.findSerialnum(serialnum).setDepartment(departmentName);
	}
	
	public void moveStaffMember(int serialnum, String departmentName) {
		Staff s = staffRegister.findSerialnum(serialnum);
		departmentRegister.moveStaff(s, departmentName);
		staffRegister.findSerialnum(serialnum).setDepartment(departmentName);
	}
	
	public void dischargePatient(int serialnum) {
		departmentRegister.deletePatient(patientRegister.findSerialnum(serialnum));
		//remove from patientRegister
	}
	
	public void dischargeStaff(int serialnum) {
		departmentRegister.deleteStaff(staffRegister.findSerialnum(serialnum)); // should be findBySerialnum
		//remove from staffRegister
	}
	
	public void createDepartment(String departmentName) {
		departmentRegister.createDepartment(departmentName);
	}
	
	public void createDepartment(String departmentName, int numberofbeds) {
		departmentRegister.createDepartment(departmentName, numberofbeds);
	}
}
//patientmember 