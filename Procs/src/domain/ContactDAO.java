package domain;

import java.util.ArrayList;
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

public class ContactDAO implements IContactDAO {

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

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			session.save(group);
			tx.commit();

			session.close();

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
			System.out.println("*************************apres delete****************************** ");
			session.getTransaction().commit();
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ContactGroup> listGroups() {
		System.out.println("**********afficher group 1***************************");
		List<ContactGroup> gList = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("From ContactGroup");
		System.out.println("\n");
		System.out.println(String.valueOf(query.list()));

		gList = query.list();
		return gList;
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

	/*
	 * *********************************** CRUD Contact*********************************
	 */
	@Override
	public Contact getContact(long idContact) {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();

		Contact c = (Contact) session.get(Contact.class, idContact);
		tx.commit();
		session.close();

		return c;
	}

	@Override
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
			if (query.list() == null) {
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

	@Override
	public void addContact(Contact contact) {

		try {
			System.out
					.println("********************je suis dans addContact********************************************");

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			session.save(contact);
			tx.commit();

			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateContact(Contact contact) {

		try {
			System.out.println(
					"********************  je suis dans updateContact  ********************************************");

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			session.saveOrUpdate(contact);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTelephone(PhoneNumber phone1) {

		try {
			System.out.println(
					"********************  je suis dans updatePhone  ********************************************");

			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			session.saveOrUpdate(phone1);
			tx.commit();
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteContact(String firstname, String lastname) {
		try {
			System.out.println(
					"**************************   je suis dans DeleteContact   ************************************************");

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

	@Override
	public void deleteContactList(Long id) {
		try {
			System.out.println(
					"********************   je suis dans DeleteContact from contact's list   **********************************************");

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

	@Override
	public Contact ReadContact(long id) {

		System.out.println("******************  je suis dans read   **********************");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from Contact where id =:id");
			query.setParameter("id", id);

			Contact c = (Contact) query.uniqueResult();
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

}
