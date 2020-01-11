package fr.parisnanterre.struts.domain;

import java.util.HashSet;
import java.util.Set;

public class Contact {
	private long id; 
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
	private Set<ContactGroup> groups = new HashSet<ContactGroup>();


	
	public Contact() {
	}
	
	public Contact(String lastName, String firstName, String email) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}
	
	
	public Contact(Contact uniqueResult) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address adress) {
		this.address = adress;
	}

	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = (phones);
	}

	public Set<ContactGroup> getGroup() {
		return groups;
	}

	public void setGroup(Set<ContactGroup> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + ", phones=" + phones + ", groups=" + groups + "]";
	}
	
	
	
}
