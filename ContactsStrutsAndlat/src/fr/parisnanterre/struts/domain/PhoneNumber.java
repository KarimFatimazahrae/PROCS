package fr.parisnanterre.struts.domain;

import java.util.List;

public class PhoneNumber {
	private long id;
	String phoneKind;
	String phoneNumber;
	Contact contact;
	
	
	public PhoneNumber() {

	}
	public PhoneNumber(long id) {
		
		this.id = id;
	}
	public PhoneNumber(long id, String phoneKind) {
		
		this.id = id;
		this.phoneKind = phoneKind;
	}
	public PhoneNumber(String phoneKind, String phoneNumber) {
		
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	public PhoneNumber(long id, String phoneKind, String phoneNumber) {
		
		this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	public PhoneNumber(long id, String phoneKind, String phoneNumber, Contact contact) {
		
		this.id = id;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhoneKind() {
		return phoneKind;
	}
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
