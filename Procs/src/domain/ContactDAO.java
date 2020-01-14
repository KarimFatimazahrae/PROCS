package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.PhoneNumber;
import util.HibernateUtil;

public class ContactDAO {

	public ContactDAO() {

		// TODO Auto-generated constructor stub
	}

	static Session session = null;
	static Transaction tx = null;

	/* ******************    CRUD Groupe     ******************  */
	public ContactGroup getGroupe(long idGroupe) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();

		ContactGroup g = (ContactGroup) session.get(ContactGroup.class, idGroupe);
		return g;
	}

	
	/*  ******************    CRUD Contact      ******************   */   
	public Contact getContact(long idContact) {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();

		Contact c = (Contact) session.get(Contact.class, idContact);
		tx.commit();
		session.close();
		
		return c;	
	}


	public Contact getContactFromName(String firstname, String lastname) {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			
			System.out.println("voici les prenoms et noms: " + firstname + "   " + lastname);
			Query query = session
					.createQuery("select id from Contact where firstname =:firstname and lastname =:lastname");
			query.setParameter("firstname", firstname);
			query.setParameter("lastname", lastname);
			
			/* Créer des pages pour la gestion des différents erreurs */
			if (query.list()==null) {
				System.out.println("Le contact n'existe pas, entrrez un contact existant");
				tx.commit();
				session.close();
				return null;
			}
			Long id = Long.parseLong(String.valueOf(query.list().get(0)));
			
			Contact c = (Contact) session.get(Contact.class, id);
			tx.commit();
			session.close();
			return c;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}		
	}

	
	public void addContact(Contact contact) {
		
		try {
			System.out.println("********************je suis dans addContact********************************************");

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			session.save(contact);
			tx.commit();
			
			session.close();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	
	public void updateContact(Contact contact) {
		
		try {
			System.out.println("********************je suis dans updateContact********************************************");
					
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.saveOrUpdate(contact);
			tx.commit();
			session.close();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	
	public void deleteContact(String firstname, String lastname) {
		try {
			System.out.println(
					"**************************je suis dans DeleteContact **********************************************************");

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Contact c = getContactFromName(firstname, lastname);
			session.delete(c);
			tx.commit();
			session.close();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	

	public void deleteContactList(Long id) {
		try {
			System.out.println(
					"**************************je suis dans DeleteContact from contact's list **********************************************************");

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Contact c = (Contact) session.get(Contact.class, id);
			session.delete(c);
			tx.commit();
			session.close();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	
//	Affiche la Liste de tous les contacts
	public List<Contact> listContact() {
		try {
			System.out.println(
					"********************************je suis dans Liste des contacts *********************************");

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from Contact");

			System.out.println("\n");
			System.out.println(String.valueOf(query.list()));
			return (List<Contact>) query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public Contact ReadContact(long id) {

		System.out.println("je suis dans read*****************************************************************");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from Contact where id =:id");
			query.setParameter("id", id);
			session.close();
				
			return (Contact) query.uniqueResult();

		} catch (Exception e) {
			System.out.println("Catch2");
			e.printStackTrace();
			return null;
		}
	}

	
	public void addPhoneNumber(PhoneNumber tel) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(tel);
		session.getTransaction().commit();

	}

	
	public void updateAdress(Long idAdress, Address adresse) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.getTransaction().begin();
		Address ad = (Address) session.get(Address.class, idAdress);
		ad.setZip(adresse.getZip());
		ad.setStreet(adresse.getStreet());
		ad.setCity(adresse.getCity());
		ad.setCountry(adresse.getCountry());

		session.update(ad);
		session.getTransaction().commit();
	}

//    public void updateContact (Contact contactTmp, Contact contact,PhoneNumber telp,PhoneNumber telf, long numSiret){
//		
//		if (numSiret <= 0) {
//				contactTmp.setType("Contact");
//		} else {
//			if (contactTmp instanceof Entreprise) {
//				((Entreprise) contactTmp).setNumeroSiret(numSiret);
//			}
//		}
//		contactTmp.setLastName(contact.getLastName());
//		contactTmp.setFirstName(contact.getFirstName());
//		contactTmp.setEmail(contact.getEmail());
//		contactTmp.getAdresse().setZip((contact.getAdresse().getZip()));
//		contactTmp.getAdresse().setCity((contact.getAdresse().getCity()));
//		contactTmp.getAdresse().setStreet((contact.getAdresse().getStreet()));
//		contactTmp.getAdresse().setCountry((contact.getAdresse().getCountry()));
//		updateTelPort(contactTmp.getId(),telp);
//		updateTelFix(contactTmp.getId(), telf);
//		
//		getHibernateTemplate().merge(contactTmp);
//	}

}
