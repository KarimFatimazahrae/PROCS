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
	/////////////////////////////////////////// CRUD Groupe

	public ContactGroup getGroupe(long idGroupe) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();

		ContactGroup g = (ContactGroup) session.get(ContactGroup.class, idGroupe);
		return g;
	}

	/////////////////////////////////////////// CRUD Contact
	public void addContact(Contact contact) {
		System.out.println("********************je suis dans addContact********************************************");

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();
		/*
		 * Set<PhoneNumber> tels = new HashSet<PhoneNumber>(); PhoneNumber ph1 = new
		 * PhoneNumber("FR","06757575"); PhoneNumber ph2 = new
		 * PhoneNumber("FR","07585858");
		 * 
		 * tels.add(ph1); tels.add(ph2);
		 * 
		 * contact.getTels().add(ph1); contact.getTels().add(ph2);
		 * 
		 * ph1.setContact(contact); ph2.setContact(contact);
		 * 
		 * ContactGroup group = new ContactGroup(); group.setGroupName("MIAGE");
		 * group.getContacts().add(contact); contact.getGroups().add(group);
		 * //System.out.println(tels.toString());
		 * 
		 * Address ad = new Address("kk","jj","ll","fr"); contact.setAdresse(ad);
		 * session.save(ph1); session.save(ph2); session.save(ad); session.save(group);
		 */
		session.save(contact);

		tx.commit();
	}

	public void deleteContact(String firstname, String lastname) {
		try {
			System.out.println(
					"**************************je suis dans DeleteContact **********************************************************");

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();

			Query query = session
					.createQuery("select id from Contact where firstname =:firstname and lastname =:lastname");
			query.setParameter("firstname", firstname);
			query.setParameter("lastname", lastname);
			Long id = Long.parseLong(String.valueOf(query.list().get(0)));

			Contact c = (Contact) session.get(Contact.class, id);
			session.delete(c);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

//	Affiche la Liste de tous les contacts
	public List<Contact> listContact() {
		try {
			System.out.println("********************************je suis dans Liste des contacts *********************************");

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from Contact");

			System.out.println("\n");
			System.out.println(String.valueOf(query.list()));
			return query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Contact ReadContact(long id) {

		System.out.println("je suis dans read*****************************************************************");
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();

			Query query = session
					.createQuery("from Contact where id =:id");
			query.setParameter("id", id);
			
//			Query query2 = session
//					.createQuery("from Telephone where id_contact =:id");
//			query2.setParameter("id", id);
//			
//			Query query3 = session
//					.createQuery("from Address where id_contact =:id");
//			query3.setParameter("id", ((Contact)query.uniqueResult()).getAdresse());
//			
			return (Contact) query.uniqueResult();

		} catch (Exception e) {
			System.out.println("Catch2");
			
			e.printStackTrace();
			return null;
		}
	}

	public Contact getContact(long idContact) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Contact c = (Contact) session.get(Contact.class, idContact);
		return c;
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
