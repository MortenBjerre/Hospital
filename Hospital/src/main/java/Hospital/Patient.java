package Hospital;

import java.util.Date;




//methods: 
//- make a new Patient
//- an edit method to each value (that are not a part of HospitalUser)


public class Patient extends HospitalUser {
	private String address;
	private int phoneNumber;
	private boolean alive;
	private boolean inpatient;
	private static int serialnumCounter = 0;
	private int serialnum;

	
	//This is protected so that there can't be free floating patients. Can only make one in a register
	/**
	 * creates a patient
	 * @param serialnum
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 * @param address
	 * @param number
	 * @param alive
	 */
	protected Patient(String email, String name, String surname, Date birthday,
			String gender, String address, int phoneNumber, boolean alive, String department, boolean inpatient) {
		set(email, name, surname, birthday, gender, department);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setAlive(alive);
		setInpatient(inpatient);
		serialnum = serialnumCounter;
		serialnumCounter++;
		
	}
	
	public void setPatient(String email, String name, String surname, Date birthday,
			String gender, String address, int phoneNumber, boolean alive, String department) {
		set( email, name, surname, birthday, gender, department);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setAlive(alive);
		
		//need to add department
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public boolean getAlive() {
		return alive;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public String toString() {
		return ("Serialnum: " + serialnum + "; Patient name: " + getName() + " " + getSurname() + " ; Gender: " + getGender() 
				+ " ; Birthday: " + getBirthday() + " ; Email: " + getEmail()); 
	}

	public boolean getInpatient() {
		return inpatient;
	}

	public void setInpatient(boolean inpatient) {
		this.inpatient = inpatient;
	}

	@Override
	public boolean hasWriteAccessTo(Register r) {
		return false;
	}

	public int getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(int serialnum) {
		this.serialnum = serialnum;
	}
	
	public static void resetSerialnumCounter() {
		serialnumCounter = 0;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Patient) {
			Patient obj2 = (Patient) obj;
			return (super.equals(obj) && obj2.serialnum == this.serialnum); 
		}
		return false;
	}
	
	public int hashCode() {
		int hash = super.hashCode();
		hash += 13 * this.serialnum;
		return hash;
	}
}



