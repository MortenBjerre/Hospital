package Hospital;

import java.util.Date;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "HospitalUser")
public abstract class HospitalUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name ="email")
	private String email;
	@XmlElement(name ="name")
	private String name;
	@XmlElement(name ="surname")
	private String surname;
	@XmlElement(name ="birthday")
	private Date birthday;
	@XmlElement(name ="gender")
	private String gender;
	@XmlElement(name ="serialnum")
	protected int serialnum;
	protected static int serialnumCounter;
	
	public boolean equals(Object obj) {
		if (obj instanceof HospitalUser) {
			HospitalUser obj2 = (HospitalUser) obj;
			return (obj2.email == this.email 		&&
					obj2.name == this.name 			&&
					obj2.surname == this.surname 	&&
					obj2.birthday == this.birthday 	&&
					obj2.gender == this.gender); 
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
		return hash;
	}
	
	public static void setSerialnumCounter(int newSerialnumCounter) {
		serialnumCounter = newSerialnumCounter;
	}
	
	public void set(String email, String name, String surname, Date birthday, String gender) {

		setEmail(email);
		setName(name);
		setSurname(surname);
		setBirthday(birthday);
		setGender(gender);
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
