package entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class Contact implements IContact {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String type;
	private int version; //pour pas avoir une lecture sale
	
	private Set<PhoneNumber> tels = new HashSet<PhoneNumber>();
	private Set<ContactGroup> groups = new HashSet<ContactGroup>();
	private Address adresse;
		

	public Contact() {
		super();
	}

	public Contact(long id) {
		super();
		this.id = id;
	}

	public Contact(IContact uniqueResult) {
		super();
	}


	public Contact(String lastName, String firstName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	
	
	public Contact(String firstName, String lastName, String email, Set<PhoneNumber> tels, Set<ContactGroup> groups, Address adresse) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tels = tels;
		this.groups = groups;
		this.adresse = adresse;
	}

	public Contact(String lastName, String firstName, String email,Set<PhoneNumber> tels) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tels = tels;
	}
	
	public String getType(IContact c){
		if(c instanceof Contact)
			return "Contact";
		else
			return "Entreprise";
	}
	
	public Address getAdresse() {
		return adresse;
	}


	public void setAdresse(Address adresse) {
		this.adresse = adresse;
	}


	public Set<PhoneNumber> getTels() {
		return tels;
	}


	public void setTels(Set<PhoneNumber> tels) {
		this.tels = tels;
	}


	public String getEmail() { 
		return this.email; 
		}
	
	public void setEmail(String email) { 
		this.email = email; 
		}
	public String getFirstName() { 
		return this.firstName; 
		}
	
	public void setFirstName(String firstName) { 
		this.firstName = firstName; 
		}
	
	public String getLastName() { 
		return this.lastName; 
		}
	public void setLastName(String lastName) { 
		this.lastName = lastName; 
		}
	
	public long getId() { 
		return this.id; 
		}
		
	public void setId(long id) { 
		this.id = id; 
		}
	
	public Set<ContactGroup> getGroups() {
		return groups;
	}


	public void setGroups(Set<ContactGroup> groups) {
		this.groups = groups;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", id=" + id
				+ ", type=" + type + ", tels=" + tels + ", groups=" + groups + ", adresse=" + adresse + "]";
	}

	
	
	
}
