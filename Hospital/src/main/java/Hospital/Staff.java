package Hospital;

import java.util.Date;

public class Staff extends HospitalUser {

	private static int serialnumCounter = 0;
	private int serialnum;
	
	/**
	 * Staff constructor. Takes all fields and sets them. Increments serialnumCounter every time it's called
	 * so every serialnum is unique between staff members
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 * @param department
	 */
	public Staff(String email, String name, String surname, Date birthday, String gender, String department) {
		set(email, name, surname, birthday, gender, department);
		serialnum = serialnumCounter;
		serialnumCounter++;

		//need to add department
	}
	
	public String toString() {
		return ("Serialnum: " + serialnum + "; Staff name: " + getName() + " " + getSurname() + " ; Gender: " 
				+ getGender() + " ; Birthday: " + getBirthday() + " ; Email: " + getEmail() + " ; Role: Staff"); 
	}
	
	/**
	 * Checks if this staff member has editing permission to a register
	 */
	public boolean hasWriteAccessTo(Register r) {
		return false;
	}
	
	/**
	 * Resets the serialnumcounter of Staff to 0
	 */
	protected static void resetSerialnumCounter() {
		serialnumCounter = 0;
	}
	
	/**
	 * Gets the serialnum of the staff member
	 * @return serialnum
	 */
	public int getSerialnum() {
		return serialnum;
	}
	
	/**
	 * Sets the serial number of the staff member
	 * @param serialnum
	 */
	protected void setSerialnum(int serialnum) {
		this.serialnum = serialnum;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Staff) {
			Staff obj2 = (Staff) obj;
			return (super.equals(obj) && obj2.serialnum == this.serialnum); 
		}
		return false;
	}
	
	public int hashCode() {
		int hash = super.hashCode();
		hash += 13 * this.serialnum;
		return hash;
	}
	/**
	 * Checks if staff member has view access to a register.
	 * @param r Register 
	 * @return true if staff member has view access
	 */
	public boolean hasViewAccessTo(Register r) {
		return false;
	}
	
	/**
	 * Checks if staff member has view access to patients' health data
	 * @return true if staff member has access
	 */
	public boolean hasHealthDataAccess() {
		return false;
	}

}
