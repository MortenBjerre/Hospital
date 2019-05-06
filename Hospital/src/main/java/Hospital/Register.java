package Hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.*;

public abstract class Register<T extends HospitalUser> {
	@XmlElementWrapper(name ="users")
	protected Map<Integer, T> users = new HashMap<Integer, T>();
		
	public String toString() {
		String a = "";
		for (Integer serialnum : users.keySet()) {
			a += users.get(serialnum).toString() +"\n";
		}
		return a;
	}
	
	/**
	 * Number of users in the register
	 * @return number of users
	 */
	public int NumberOfUsersInRegister() {
		return users.size();
	}
	
	/**
	 * Searches for HospitalUsers with a matching serial number
	 * @param serialnum
	 * @return matching HospitalUser, or null if none exists
	 */
	public T findSerialnum(int serialnum) {
		return users.get(serialnum);
	}
	
	/**
	 * Searches for HospitalUsers with a matching serial number
	 * @param serialnum
	 * @return ArrayList of matching HospitalUsers
	 */
	public String[] searchSerialnum(int serialnum) {
		String[] matches = new String[]{users.get(serialnum).toString()};
		return matches;
	}
	
	/**
	 * Finds all the users in the register with matching emails
	 * @param email
	 * @return String array of users, where each element is the .toString()
	 */
	public String[] searchEmail(String email) {
		ArrayList<T> matches = findEmail(email);
		String[] matchesToStringArray = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			matchesToStringArray[i] = matches.get(i).toString();
		}
		return matchesToStringArray;
	}
	
	/**
	 * Finds all the users in the register with matching emails
	 * @param email
	 * @return ArrayList of users
	 */
	protected ArrayList<T> findEmail(String email) {
		ArrayList<T> matches = new ArrayList<T>();
		for (Integer serialnum : users.keySet()) {
			T user = users.get(serialnum);
			if (user.getEmail() == email) {
				matches.add(user);
			}
		}
		return matches;
	}
	
	/**
	 * Searches for HospitalUsers with a matching name
	 * @param name
	 * @return String array of matching HospitalUsers
	 */
	public String[] searchName(String name) {
		ArrayList<T> matches = findName(name);
		String[] matchesToStringArray = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			matchesToStringArray[i] = matches.get(i).toString();
		}
		return matchesToStringArray;
	}
	
	/**
	 * Searches for HospitalUsers with a matching name
	 * @param name
	 * @return ArrayList of matching HospitalUsers
	 */
	protected ArrayList<T> findName(String name) {
		ArrayList<T> matches = new ArrayList<T>();
		for (Integer serialnum : users.keySet()) {
			T user = users.get(serialnum);
			if (user.getName() == name) {
				matches.add(user);
			}
		}
		return matches;
	}
	
	/**
	 * Searches for HospitalUsers with a matching birthday
	 * @param birthday
	 * @return String array of matching HospitalUsers
	 */
	public String[] searchBirthday(Date birthday) {
		ArrayList<T> matches = findBirthday(birthday);
		String[] matchesToStringArray = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			matchesToStringArray[i] = matches.get(i).toString();
		}
		return matchesToStringArray;
	}
	
	/**
	 * Searches for HospitalUsers with a matching birthday
	 * @param birthday
	 * @return ArrayList of matching HospitalUsers
	 */
	protected ArrayList<T> findBirthday(Date birthday) {
		ArrayList<T> matches = new ArrayList<T>();

		for (Integer serialnum : users.keySet()) {
			T user = users.get(serialnum);
			if (user.getBirthday().equals(birthday)) {
				matches.add(user);
			}
		}
		return matches;
	}
	
	/**
	 * Searches for HospitalUsers with a matching surname
	 * @param surname
	 * @return String array of matching HospitalUsers
	 */
	public String[] searchSurname(String surname) {
		ArrayList<T> matches = findSurname(surname);
		String[] matchesToStringArray = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			matchesToStringArray[i] = matches.get(i).toString();
		}
		return matchesToStringArray;
	}
	
	/**
	 * Searches for HospitalUsers with a matching surname
	 * @param surname
	 * @return ArrayList of matching HospitalUsers
	 */
	protected ArrayList<T> findSurname(String surname) {
		ArrayList<T> matches = new ArrayList<T>();
		for (Integer serialnum : users.keySet()) {
			T user = users.get(serialnum);
			if (user.getSurname() == surname) {
				matches.add(user);
			}
		}
		return matches;
	}
	
	/**
	 * Searches for HospitalUsers with a matching Gender
	 * @param role
	 * @return String array of matching HospitalUsers
	 */
	public String[] searchGender(String Gender) {
		ArrayList<T> matches = findGender(Gender);
		String[] matchesToStringArray = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			matchesToStringArray[i] = matches.get(i).toString();
		}
		return matchesToStringArray;
	}
	
	/**
	 * Searches for HospitalUsers with a matching Gender
	 * @param role
	 * @return ArrayList of matching HospitalUsers
	 */
	protected ArrayList<T> findGender(String Gender) {
		ArrayList<T> matches = new ArrayList<T>();
		for (Integer serialnum : users.keySet()) {
			T user = users.get(serialnum);
			if (user.getGender() == Gender) {
				matches.add(user);
			}
		}
		return matches;
	}
	
	// Edit:
	/**
	 * Changes the name of a given HospitalUser, identified by their serialnum
	 * @param serialnum
	 * @param name
	 */
	public void editName(int serialnum, String name) {
		T user = this.findSerialnum(serialnum);
		user.setName(name);
		users.put(serialnum, user);
	}	
	/**
	 * Changes the surname of a given HospitalUser, identified by their serialnum
	 * @param serialnum
	 * @param surname
	 */
	public void editSurname(int serialnum, String surname) {
		T user = this.findSerialnum(serialnum);
		user.setSurname(surname);
		users.put(serialnum, user);	
	}
	
	/**
	 * Changes the email of a given HospitalUser, identified by their serialnum
	 * @param serialnum
	 * @param email
	 */
	public void editEmail(int serialnum, String email) {
		T user = this.findSerialnum(serialnum);
		user.setEmail(email);
		users.put(serialnum, user);	
	}
	
	/**
	 * Changes the gender of a given HospitalUser, identified by their serialnum
	 * @param serialnum
	 * @param gender
	 */
	public void editGender(int serialnum, String gender) {
		T user = this.findSerialnum(serialnum);
		user.setGender(gender);
		users.put(serialnum, user);	
	}
}