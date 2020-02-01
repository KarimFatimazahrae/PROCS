package entities;

import java.util.Set;

public class Entreprise extends Contact {
	
	private long numeroSiret ;

	
	public Entreprise() {
	}

	public Entreprise(long numeroSiret) {
		super();
		this.numeroSiret = numeroSiret;
	}

	
	public Entreprise( String firstName, String lastName, String email,long numeroSiret){
		super(firstName, lastName, email);
		this.numeroSiret=numeroSiret;
	}
	
	public Entreprise(String firstName, String lastName, String email, Set<PhoneNumber> tels, Set<ContactGroup> groups, Address adresse) {
		super(firstName,lastName,email,tels, groups, adresse);
		
	}


	public Entreprise(String lastName, String firstName, String email) {
		super(lastName, firstName, email);
		// TODO Auto-generated constructor stub
	}

	public long getNumeroSiret() {
		return numeroSiret;
	}

	public void setNumeroSiret(long numeroSiret) {
		this.numeroSiret = numeroSiret;
	}

}
