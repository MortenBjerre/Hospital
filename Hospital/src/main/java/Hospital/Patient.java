package Hospital;

import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name="Patient")
public class Patient extends HospitalUser {
	@XmlElement(name="address")
	private String address;
	@XmlElement(name="phoneNumber")
	private int phoneNumber;
	@XmlElement(name="alive")
	private boolean alive;
	@XmlElement(name="serialnumCounter")
	private static int serialnumCounter = 0;
	@XmlElement(name="healthData")
	private String healthData = "";

	protected Patient() {}
	//This is protected so that there can't be free floating patients. Can only make one in a register
	/**
	 * Creates a patient
	 * @param email
	 * @param name
	 * @param surname
	 * @param birthday
	 * @param gender
	 * @param address
	 * @param phoneNumber
	 * @param alive
	 * @param healthData
	 */
	protected Patient(String email, String name, String surname, Date birthday,
			String gender, String address, int phoneNumber, boolean alive, String healthData) {
		set(email, name, surname, birthday, gender);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setAlive(alive);
		setHealthData(healthData);
		serialnum = serialnumCounter;
		serialnumCounter++;
	}
	
	/**
	 * Set alive status
	 * @param alive
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		if (Integer.toString(phoneNumber).length() < 6) {
			throw new IllegalArgumentException("Phone number too short");
		}
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

	public int getSerialnum() {
		return serialnum;
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

	/**
	 * Returns the health data of a patient
	 * @return string of health data
	 */
	public String getHealthData() {
		return healthData;
	}

	/**
	 * Adds health data to the patients existing health data.
	 * @param healthData String of health data
	 */
	public void setHealthData(String healthData) {
		Date d = new Date();
		this.healthData += "Health data updated on the " + d.toString() + ".\n" + healthData +"\n\n";
		// healthData is added but never deleted
	}
	
	/**
	 * Checks if patient has write access to a register
	 */
	public boolean hasWriteAccessTo(Register r) {
		return false;
	}
	
	@Override
	public boolean hasViewAccessTo(Register r) {
		return false;
	}

	@Override
	public boolean hasHealthDataAccess() {
		return false;
	}
}