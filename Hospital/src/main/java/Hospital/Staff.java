package Hospital;

import java.util.Date;

public class Staff extends HospitalUser {

	private static int serialnumCounter = 0;
	private int serialnum;
	
	public Staff(String email, String name, String surname, Date birthday, String gender, String department) {
		set(email, name, surname, birthday, gender, department);
		serialnum = serialnumCounter;
		serialnumCounter++;

		//need to add department
	}
	
	public String toString() {
		return ("Serialnum: " + serialnum + "; Staff name: " + getName() + " " + getSurname() + " ; Gender: " + getGender() + " ; Birthday: " + getBirthday() + " ; Email: " + getEmail() + " ; Role: Staff"); 
	}

	@Override
	public boolean hasWriteAccessTo(Register r) {
		return false;
	}
	
	public static void resetSerialnumCounter() {
		serialnumCounter = 0;
	}

	public int getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(int serialnum) {
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

	public boolean hasViewAccessTo(Register r) {
		return false;
	}

	public boolean hasHealthDataAccess() {
		return false;
	}

}
