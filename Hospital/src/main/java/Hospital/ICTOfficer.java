package Hospital;

import java.util.Date;

public class ICTOfficer extends Staff {
	
	/**
	 * Constructor of ICTOfficer. Calls Staff constructor.
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 * @param department
	 */
	public ICTOfficer(String email, String name, String surname, Date birthday, String gender) {
		super(email, name, surname, birthday, gender);
		
	}
	
	public boolean hasWriteAccessTo(Register r) {
		return true;
	}
	
	public boolean hasViewAccessTo(Register r) {
		return true;
	}
	
	public boolean hasHealthDataAccess() {
		return true;
	}
	
	public boolean canMoveStaff() {
		return true;
	}
	
	public boolean canMovePatients() {
		return true;
	}
	
	public String getRole() {
		return "ICT Officer";
	}
	
	public boolean canEditDepartmentRegister(DepartmentRegister dr) {
		return true;
	}

}