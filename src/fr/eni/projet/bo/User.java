package fr.eni.projet.bo;

/**
 * 
 * @author Yohann BERTIN
 *
 */
public class User {
	
	private Long userId;
	private String pseudo;
	private String lastName;
	private String firstName;
	private String email;
	private String phone;
	private String street;
	private String zip;
	private String city;
	private String password;
	private int credit;
	private int administrator;
	
	
	/**
	 * A FAIRE : récupérer le numero attribué par la BDD SQL
	 * sur le setter !
	 * @return
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setUserID(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	/**
	 * @return the administrator
	 */
	public int getAdministrator() {
		return administrator;
	}
	/**
	 * @param administrator the administrator to set
	 */
	public void setAdministrator(int administrator) {
		this.administrator = administrator;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", pseudo=" + pseudo + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", email=" + email + ", phone=" + phone + ", street=" + street + ", zip=" + zip + ", city=" + city
				+ ", password=" + password + ", credit=" + credit + ", administrator=" + administrator + "]";
	}
	
	
	
	
}
