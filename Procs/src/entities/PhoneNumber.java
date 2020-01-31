package entities;

public class PhoneNumber {
	private long phoneId;
	private String phoneKind;
	private String phoneNumber;
	private IContact contact;

	public PhoneNumber() {
		// TODO Auto-generated constructor stub
	}
	

	public PhoneNumber(String phoneKind, String phoneNumber) {
		super();
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneNumber( String phoneKind, String phoneNumber,IContact contact) {
		super();
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}


	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
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
	public IContact getContact() {
		return contact;
	}
	public void setContact(IContact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "PhoneNumber [phoneKind=" + phoneKind + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	

}
