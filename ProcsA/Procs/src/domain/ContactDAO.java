package domain;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;


import entities.Contact;
import entities.PhoneNumber;
import entities.ContactGroup;
import util.HibernateUtil;


public class ContactDAO {
	
	
	
	public ContactDAO() {
		
		// TODO Auto-generated constructor stub
	}

	static Session session = null;
	static Transaction tx = null;

	
	public void addContact(Contact contact) 
	{
		System.out.println("je suis dans addContact");

		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();
		
		Set<PhoneNumber> tels = new HashSet<PhoneNumber>();
		PhoneNumber ph1 = new PhoneNumber("FR","00000000");
		PhoneNumber ph2 = new PhoneNumber("FR","22222222"); 

		tels.add(ph1);
		tels.add(ph2);
		
		contact.getTels().add(ph1);
		contact.getTels().add(ph2);
		
		ph1.setContact(contact);
		ph2.setContact(contact);
		
		ContactGroup group = new ContactGroup();
		group.setGroupName("MIAGE");
		group.getContacts().add(contact);
		
		contact.getGroups().add(group);
		System.out.println("hhhhhh");

		System.out.println(tels.toString());
				
		session.save(ph1);
		session.save(ph2);
		session.save(group);
		session.save(contact);
		
		
		tx.commit();	
	}
	
	
	public void addPhoneNumber(PhoneNumber tel){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
		session.beginTransaction();            
	    session.save(tel);               
		session.getTransaction().commit();
		
	}
	

}
