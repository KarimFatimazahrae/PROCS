package org.lip6.struts.domain;

public class Contact {
	
	private String firstName;
	private String lastName;
	private String email;
	private int id;
	private String mobile;
	private String fixe;
	private String rue;
	private String ville;
	private String cp;
	private String pays;
	//private List<ContactGroup> books;
	//private List<PhoneNumber> phones;
	//private Address add;
	
	public Contact(int id,String lastName, String firstName, String email, String mobile,
			String fixe, String rue, String ville, String cp, String pays) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
		this.mobile = mobile;
		this.fixe = fixe;
		this.rue= rue;
		this.cp = cp;
		this.pays = pays;
	}
	
	/*public List<ContactGroup> getBooks() { return books; }
	public void setBooks(List<ContactGroup> books) { this.books = books; }
	public List<PhoneNumber> getProfiles() { return phones; }
	public void setProfile(List<PhoneNumber> phones) { this.phones = phones; }
	public Address getAdd() { return this.add; }
	public void setAdd(Address add) { this.add = add; }*/
	public String getEmail() { return this.email; }
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName; }
	public void setEmail(String email) { this.email = email; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFixe() {
		return fixe;
	}

	public void setFixe(String fixe) {
		this.fixe = fixe;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
}

