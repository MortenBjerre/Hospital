package Hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Register<T extends HospitalUser> {
	public Map<Integer, T> users = new HashMap<Integer, T>();
	
	protected int serialnum = 0;
	
	public String toString() {
		String a = "";
		for (Integer u : users.keySet()) {
			a += users.get(u).toString() +"\n";
		}
		return a;
	}
	
	/**
	 * Searches for HospitalUsers with a matching serial number
	 * @param serialnum
	 * @return HashMap of matching HospitalUsers
	 */
	protected T findSerialnum(int serialnum) {
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
		String[] m = new String[matches.size()];
		return matches.toArray(m);
	}
	
	/**
	 * Finds all the users in the register with matching emails
	 * @param email
	 * @return ArrayList of users
	 */
	protected ArrayList<T> findEmail(String email) {
		ArrayList<T> matches = new ArrayList<T>();
		for (Integer key : users.keySet()) {
			if (users.get(key).getEmail() == email) {
				matches.add(users.get(key));
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
		String[] m = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			m[i] = matches.get(i).toString();
		}
		return m;
	}
	
	/**
	 * Searches for HospitalUsers with a matching name
	 * @param name
	 * @return ArrayList of matching HospitalUsers
	 */
	protected ArrayList<T> findName(String name) {
		ArrayList<T> matches = new ArrayList<T>();
		for (Integer key : users.keySet()) {
			if (users.get(key).getName() == name) {
				matches.add(users.get(key));
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
		String[] m = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			m[i] = matches.get(i).toString();
		}
		return m;
	}
	
	/**
	 * Searches for HospitalUsers with a matching birthday
	 * @param birthday
	 * @return ArrayList of matching HospitalUsers
	 */
	protected ArrayList<T> findBirthday(Date birthday) {
		ArrayList<T> matches = new ArrayList<T>();
		for (Integer key : users.keySet()) {
			if (users.get(key).getBirthday() == birthday) {
				matches.add(users.get(key));
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
		String[] m = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			m[i] = matches.get(i).toString();
		}
		return m;
	}
	
	/**
	 * Searches for HospitalUsers with a matching surname
	 * @param surname
	 * @return ArrayList of matching HospitalUsers
	 */
	protected ArrayList<T> findSurname(String surname) {
		ArrayList<T> matches = new ArrayList<T>();
		for (Integer key : users.keySet()) {
			if (users.get(key).getSurname() == surname) {
				matches.add(users.get(key));
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
		String[] m = new String[matches.size()];
		for (int i = 0; i < matches.size(); i++) {
			m[i] = matches.get(i).toString();
		}
		return m;
	}
	
	/**
	 * Searches for HospitalUsers with a matching Gender
	 * @param role
	 * @return ArrayList of matching HospitalUsers
	 */
	protected ArrayList<T> findGender(String Gender) {
		ArrayList<T> matches = new ArrayList<T>();
		for (Integer key : users.keySet()) {
			if (users.get(key).getGender() == Gender) {
				matches.add(users.get(key));
			}
		}
		return matches;
	}
}
