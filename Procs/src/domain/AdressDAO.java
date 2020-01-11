package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Address;
import util.HibernateUtil;

public class AdressDAO {
	
	static Session session=null;
	static Transaction tx= null;
	
	public static void addAddress() {
		session= HibernateUtil.getSessionFactory().getCurrentSession();
		tx=session.beginTransaction();
		Address adr= new Address();
		adr.setStreet("Rue de la Garenne");
		adr.setCity("Paris");
		adr.setZip("75001");
		adr.setCountry("France");

		session.save(adr);
		
		tx.commit();
		
	}
	
	public static void main(String[]args) {
		System.out.println("début");
		addAddress();
		System.out.println("Fin");
	}

}
