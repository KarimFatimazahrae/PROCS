package entities;

import java.util.HashSet;
import java.util.Set;

public class Contact {

	private String firstName;
	private String lastName;
	private String email;
	private long id;
	private Set<PhoneNumber> tels = new HashSet<PhoneNumber>();
	private Set<ContactGroup> groups = new HashSet<ContactGroup>();
	
		

	public Contact() {
		super();
	}


	public Contact(String lastName, String firstName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	
	public Contact(String lastName, String firstName, String email,Set<PhoneNumber> tels) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tels = tels;
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
}
