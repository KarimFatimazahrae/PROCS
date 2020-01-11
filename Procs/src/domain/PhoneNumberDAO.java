package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.PhoneNumber;
import util.HibernateUtil;

public class PhoneNumberDAO {

	static Session session=null;
	static Transaction tx= null;
	
	public static void addPhoneNumber() {
		session= HibernateUtil.getSessionFactory().getCurrentSession();
		tx=session.beginTransaction();
		PhoneNumber phone= new PhoneNumber();
		phone.setPhoneKind("00000000");
		phone.setPhoneNumber("0768943526");		
		session.save(phone);	
		tx.commit();	
	}
	
//	public void addPhoneNumber(PhoneNumber tel){
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
//		session.beginTransaction();            
//		session.save(tel);               
//		session.getTransaction().commit();
//		
//	}
	public static void main(String[]args) {
		System.out.println("début");
		addPhoneNumber();
		System.out.println("Fin");
	}

}
