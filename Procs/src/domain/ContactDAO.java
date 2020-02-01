package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.Entreprise;
import entities.IContact;
import entities.PhoneNumber;
import util.HibernateUtil;

public class ContactDAO implements IContactDAO {

	private SessionFactory sessionFactory;

	public ContactDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ContactDAO() {

		// TODO Auto-generated constructor stub
	}

	static Session session = null;
	static Transaction tx = null;

	/*
	 * *********************************** CRUD Groupe
	 * ********************************************
	 */
	@Override
	public ContactGroup getGroupe(long idGroupe) {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();

		ContactGroup g = (ContactGroup) session.get(ContactGroup.class, idGroupe);
		tx.commit();
		session.close();
		return g;
	}

	@Override
	public void addGroup(ContactGroup group) {

		try {
			System.out.println("********************je suis dans addGroup********************************************");

			sessionFactory.getCurrentSession().save(group);

//			session = HibernateUtil.getSessionFactory().openSession();
//			tx = session.beginTransaction();
//			session.save(group);
//			tx.commit();
//
//			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ContactGroup getGroupFromName(String groupname) {

		try {

			System.out.println(
					"**************************   je suis dans getGroupFromName  ************************************************");

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.getTransaction().begin();

			System.out.println("voici le nom du groupe: " + groupname);
			Query query = session.createQuery("select groupId from ContactGroup where groupName =:groupname");
			query.setParameter("groupname", groupname);

			/* Créer des pages pour la gestion des différents erreurs */
			if (query.list() == null) {
				System.out.println("Le groupe n'existe pas, entrez un groupe existant");
				tx.commit();
				// session.close();
				return null;
			}
			Long id = Long.parseLong(String.valueOf(query.list().get(0)));
			System.out.println("voici le id du groupe: " + id);

			ContactGroup g = (ContactGroup) session.get(ContactGroup.class, id);
			session.getTransaction().commit();
			session.close();

			return g;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteGroupe(String groupname) {
		try {
			System.out.println(
					"**************************   je suis dans Delete Groupe  ************************************************");

			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();

			ContactGroup g = getGroupFromName(groupname);
			System.out.println("voici le nom du groupe dans la methode delete: " + g.getGroupName());

			session.delete(g);
			session.getTransaction().commit();
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

//	Affiche la Liste de tous les groupes
	@Override
	public List<ContactGroup> listGroupe() {
		try {
			System.out.println(
					"*************************  je suis dans Liste des groupes    *********************************");

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from ContactGroup");

			System.out.println("\n");
			System.out.println("******************list de groupes:" + String.valueOf(query.list()));

			List<ContactGroup> lg = (List<ContactGroup>) query.list();
			tx.commit();
			session.close();

			return lg;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Supprimer groupe dans la liste
	@Override
	public void deleteGroupList(Long id) {
		try {
			System.out.println(
					"********************   je suis dans DeleteGroup from group's list   **********************************************");

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			ContactGroup g = (ContactGroup) session.get(ContactGroup.class, id);
			session.delete(g);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ContactGroup ReadGroup(long id) {

		System.out.println("******************  je suis dans read group  **********************");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from ContactGroup where id =:id");
			query.setParameter("id", id);

			ContactGroup g = (ContactGroup) query.uniqueResult();
			tx.commit();
			session.close();

			return g;

		} catch (Exception e) {
			System.out.println("Erreur lors de la lecture du groupe");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateGroup(ContactGroup groupe) {

		try {
			System.out.println(
					"********************  je suis dans updateGroup ********************************************");

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			session.saveOrUpdate(groupe);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addContactToGroup(Long idGroupe, Long idContact) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Contact c = (Contact) session.get(Contact.class, idContact);
			ContactGroup g = (ContactGroup) session.get(ContactGroup.class, idGroupe);
			

			g.getContacts().add(c);
			c.getGroups().add(g);

			session.saveOrUpdate(g);
			tx.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * *********************************** CRUD
	 * Contact*********************************
	 */
	@Override
	public Contact getContact(long idContact) {
//		session = HibernateUtil.getSessionFactory().openSession();
//		tx = session.beginTransaction();
//
//		Contact c = (Contact) session.get(Contact.class, idContact);
//		tx.commit();
//		session.close();
		Contact c = (Contact) sessionFactory.getCurrentSession().get(Contact.class, idContact);
		return c;
	}

	@Override
	public IContact getContactFromName(String firstname, String lastname) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			System.out.println("voici les prenoms et noms: " + firstname + "   " + lastname);
			Query query = session
					.createQuery("select id from Contact where firstname =:firstname and lastname =:lastname");
			query.setParameter("firstname", firstname);
			query.setParameter("lastname", lastname);

			/* Créer des pages pour la gestion des différents erreurs */
			if (query.list() == null) {
				System.out.println("Le contact n'existe pas, entrrez un contact existant");
				tx.commit();
				session.close();
				return null;
			}
			Long id = Long.parseLong(String.valueOf(query.list().get(0)));

			IContact c = (IContact) session.get(Contact.class, id);
			tx.commit();
			session.close();

			return c;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addContact(IContact contact) {

		try {
			System.out
					.println("********************je suis dans addContact********************************************");

			sessionFactory.getCurrentSession().save(contact);

//			session = HibernateUtil.getSessionFactory().openSession();
//			tx = session.beginTransaction();
//
//			session.save(contact);
//			tx.commit();
//
//			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

//Add Contact avec spring
	public void addContactPeupler(IContact contact) {

		try {
			System.out.println(
					"*******************je suis dans addContact peupler *******************************************");
			sessionFactory.getCurrentSession().save(contact);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateContact(IContact contact) {

		try {
			System.out.println(
					"********************  je suis dans updateContact  ********************************************");

			sessionFactory.getCurrentSession().saveOrUpdate(contact);

//			session = HibernateUtil.getSessionFactory().openSession();
//			tx = session.beginTransaction();
//
//			session.saveOrUpdate(contact);
//			tx.commit();
//			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTelephone(PhoneNumber phone1) {

		try {
			System.out.println(
					"********************  je suis dans updatePhone  ********************************************");
			sessionFactory.getCurrentSession().save(phone1);

//			session = HibernateUtil.getSessionFactory().openSession();
//			tx = session.beginTransaction();
//
//			session.saveOrUpdate(phone1);
//			tx.commit();
//			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteContact(String firstname, String lastname) {
		try {
			System.out.println(
					"**************************   je suis dans DeleteContact   ************************************************");

//			session = HibernateUtil.getSessionFactory().openSession();
//			tx = session.beginTransaction();

			IContact c = getContactFromName(firstname, lastname);
//			session.delete(c);
//			tx.commit();
//			session.close();
			sessionFactory.getCurrentSession().delete(c);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteContactList(Long id) {
		try {
			System.out.println(
					"********************   je suis dans DeleteContact from contact's list   **********************************************");
			IContact c = (IContact) sessionFactory.getCurrentSession().get(Contact.class, id);
			sessionFactory.getCurrentSession().delete(c);
//			session = HibernateUtil.getSessionFactory().openSession();
//			tx = session.beginTransaction();
//			IContact c = (IContact) session.get(Contact.class, id);
//			session.delete(c);
//			tx.commit();
//			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

//	Affiche la Liste de tous les contacts
	@Override
	public List<Contact> listContact() {
		try {
			System.out.println(
					"*************************  je suis dans Liste des contacts    *********************************");
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from Contact");

			System.out.println("\n");
			System.out.println("liste des contacts: " + String.valueOf(query.list()));

			List<Contact> lc = (List<Contact>) query.list();
			tx.commit();
			session.close();

			return lc;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}


//	Affiche la Liste de tous les contacts
	@Override
	public List<Contact> listContactForGroup(Set<Contact> contactsinGroup) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			ArrayList<Long> listIds = new ArrayList<Long>();
			System.out.println(
					"*************************  " + listIds.toString());
			List<Contact> lc = null;
			for (Contact c : contactsinGroup) {
				listIds.add(c.getId());
			}
				
			if (listIds.isEmpty()) {
				Query query = session.createQuery("from Contact");
				System.out.println("\n");
				System.out.println("liste des contacts: " + String.valueOf(query.list()));
				lc = (List<Contact>) query.list();
			} else {
				Query query = session.createQuery("from Contact where id not in (:ids)");
				query.setParameterList("ids", listIds);
				System.out.println("\n");
				System.out.println("liste des contacts: " + String.valueOf(query.list()));
				lc = (List<Contact>) query.list();
			}
			tx.commit();
			session.close();

			return lc;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public IContact ReadContact(long id) {

		System.out.println("******************  je suis dans read   **********************");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from Contact where id =:id");
			query.setParameter("id", id);

			IContact c = (IContact) query.uniqueResult();
			tx.commit();
			session.close();

			return c;

		} catch (Exception e) {
			System.out.println("Erreur lors de la lecture du contact");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addPhoneNumber(PhoneNumber tel) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(tel);
		session.getTransaction().commit();

	}

	@Override
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
	@Override
	public List<Contact> searchContact(String search) {
		// Recherche avec tous les paramètres renseignés
		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.getTransaction();
		if(!tx.isActive()) tx = session.beginTransaction();
		System.out.println(search);
		
		List<Contact> listContact = session.createCriteria(Contact.class).add(Restrictions.like("firstName", "%"+search+"%")).list();
		listContact.addAll(session.createCriteria(Contact.class).add(Restrictions.like("lastName", "%"+search+"%")).list());
		listContact.addAll(session.createCriteria(Contact.class).add(Restrictions.like("email", "%"+search+"%")).list());
		Set<Contact> setContact = new HashSet<>();
		setContact.addAll(listContact);
		listContact.clear();
		listContact.addAll(setContact);
		List<Contact> newListContact = new ArrayList<Contact>();
		session.getTransaction().commit();
		return newListContact;
	}

}
