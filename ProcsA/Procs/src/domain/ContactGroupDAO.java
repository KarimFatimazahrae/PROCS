package domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Address;
import entities.ContactGroup;
import util.HibernateUtil;

public class ContactGroupDAO {

	static Session session=null;
	static Transaction tx= null;
	
	public static void addContactGroup() {
		session= HibernateUtil.getSessionFactory().getCurrentSession();
		tx=session.beginTransaction();
		ContactGroup cg=new ContactGroup();
		cg.setGroupName("fati");
		
		session.save(cg);
		
		tx.commit();
		
	}
	
	public static void main(String[]args) {
		System.out.println("début");
		addContactGroup();
		System.out.println("Fin");
	}

}
