package Hospital;

import java.util.Date;
import java.io.Serializable;
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "patient")



//methods: 
//- make a new Patient
//- an edit method to each value (that are not a part of HospitalUser)


public class Patient extends HospitalUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name ="address")
	private String address;
	@XmlElement(name ="phoneNumber")
	private int phoneNumber;
	@XmlElement(name ="alive")
	private boolean alive;
	@XmlElement(name ="serialnumCounter")
	private static int serialnumCounter = 0;
	@XmlElement(name ="serialnum")
	private int serialnum;
	@XmlElement(name ="healthData")
	private String healthData = "";

	
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
	 * Edit all the patient fields at once
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
	public void setPatient(String email, String name, String surname, Date birthday,
			String gender, String address, int phoneNumber, boolean alive, String healthData) {
		set(email, name, surname, birthday, gender);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setAlive(alive);
		setHealthData(healthData);
		//need to add department
	}
	
	/**
	 * Set alive status
	 * @param alive
	 */
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
	
	/**
	 * Checks if patient has write access to a register
	 */
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

	public String getHealthData() {
		return healthData;
	}

	public void setHealthData(String healthData) {
		this.healthData += healthData;
		// healthData is added but never deleted
	}

	@Override
	public boolean hasViewAccessTo(Register r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasHealthDataAccess() {
		// TODO Auto-generated method stub
		return false;
	}
}



