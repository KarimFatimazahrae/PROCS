package org.lip6.struts.domain;

import org.lip6.struts.domain.Contact;

public class PhoneNumber {
	private int phoneId;
	private String phoneKind;
	private String phoneNumber;
	private Contact contact;
	
	public Contact getContact() { return this.contact; }
	public void setContact(Contact contact) { this.contact = contact; }
	public int getPhoneId() { return this.phoneId; }
	public void setPhoneId(int phoneId) { this.phoneId = phoneId; }
	public String getPhoneKind() { return this.phoneKind; }
	public void setPhoneKind(String phoneKind) { this.phoneKind = phoneKind; }
	public String getPhoneNumber() { return this.phoneNumber; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
