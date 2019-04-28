package Hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InpatientDepartment extends Department {

	private int beds;
	protected HashMap<Integer, Patient> patients = new HashMap<Integer, Patient>();
	

	public InpatientDepartment(String deptName, int beds) {
		super(deptName);
		this.beds = beds;
	}
	
	public InpatientDepartment(String deptName) {
		super(deptName);
		this.beds = 0;
	}

	/**
	 *  returns the number of beds in a department
	 * @return an int representing the number of beds in a department
	 */
	public int getBedsTotal() {
		return beds;
	}
	
	/**
	 * returns the number of free beds in a department
	 * It's calculated by subtracting the amount of patients from the number of beds
	 * @return returns an int representing the number of free beds in a department
	 */
	//needs to be updated with the ingoing, outgoing patients
	public int getFreeBeds(){
		return (beds-patients.size());
	}
	
	/**
	 * returns the number of occupied beds in a department
	 * @return returns an int representing the number of occupied beds in a department
	 */
	public int getOccupiedBeds() {
		return patients.size();
	}
	
	/**
	 * Adds beds to a department
	 * @param beds the amount of beds to be added
	 */
	public void addNewBeds(int beds) {
		this.beds += beds;
	}
	
	/**
	 * Removes beds from a department
	 * if the amount of beds in a department is less than the amount of beds to be subtracted, the amount of beds will be unchanged
	 * and an error message will be displayed
	 * @param beds the amount of beds to be removed
	 */
	public void removeBeds(int beds) {
		if (this.beds - beds < 0) {
			throw new IllegalArgumentException("There aren't that enough beds to subtract that many");
		} 
		else {
			this.beds -= beds;
		}
	}
}