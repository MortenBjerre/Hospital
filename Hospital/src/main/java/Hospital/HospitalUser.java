package Hospital;

import java.util.Date;

public abstract class HospitalUser {
	private String email;
	private String name;
	private String surname;
	private Date birthday;
	private String gender;
	private String department;
	
	public boolean equals(Object obj) {
		if (obj instanceof HospitalUser) {
			HospitalUser obj2 = (HospitalUser) obj;
			return (obj2.email == this.email 		&&
					obj2.name == this.name 			&&
					obj2.surname == this.surname 	&&
					obj2.birthday == this.birthday 	&&
					obj2.gender == this.gender 		&&
					obj2.department == this.department); 
		}
		return false;
	}
	
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + email.hashCode(); 
		hash = 31 * hash + name.hashCode();
		hash = 31 * hash + surname.hashCode();
		hash = 31 * hash + birthday.hashCode();
		hash = 31 * hash + gender.hashCode();
		hash = 31 * hash + department.hashCode();
		return hash;
	}
	
	public void set(String email, String name, String surname, Date birthday, String gender, String department) {

		setEmail(email);
		setName(name);
		setSurname(surname);
		setBirthday(birthday);
		setGender(gender);
		setDepartment(department);
	}
	
	public String getEmail() { 
		return email; 
	}
	
	public void setEmail(String email) { 
		this.email = email; 
	}

	public String getName() { 
		return name; 
	}
	
	public void setName(String name) { 
		this.name = name; 
	}

	public Date getBirthday() { 
		return birthday; 
	}

	public void setBirthday(Date birthday) { 
		this.birthday = birthday; 
	}
	
	public String getGender() { 
		return gender; 
	}

	public void setGender(String gender) { 
		this.gender = gender; 
	}

	public String getSurname() { 
		return surname; 
	}
	
	public void setSurname(String surname) { 
		this.surname = surname; 
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * Checks if this hospital user has editing permission to Register r
	 * @param r A Register
	 * @return true if hospital user has editing permission
	 */
	public abstract boolean hasWriteAccessTo(Register r);
	
	/**
	 * Checks if this hospital user has viewing permission to Register r
	 * @param r A Register
	 * @return true if hospital user has viewing permission
	 */
	public abstract boolean hasViewAccessTo(Register r);
	
	/**
	 * Checks if this hospital user has permission to view health data
	 * @return true if hospital user has health data access
	 */
	public abstract boolean hasHealthDataAccess();
	
}

