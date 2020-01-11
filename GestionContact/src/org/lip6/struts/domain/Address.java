package org.lip6.struts.domain;

public class Address {
	private int idAddress;
	private String street;
	private String city;
	private String zip;
	private String country;
	
	public Address() { }
	public Address(String st, String cit, String zip, String count) {
		this.street = st;
		this.city = cit;
		this.zip = zip;
		this.country = count;
	}
	public int getIdAddress() { return this.idAddress; }
	public void setIdAddress(int newId) { this.idAddress = newId; }
	public String getStreet() { return this.street; }
	public void setStreet(String newSt) { this.street = newSt; }
	public String getCity() { return this.city; }
	public void setCity(String newCit) { this.city = newCit; }
	public String getZip() { return this.zip; }
	public void setZip(String newZip) { this.zip = newZip; }
	public String getCountry() { return this.country; }
	public void setCountry(String newCount) { this.country = newCount; }
}
