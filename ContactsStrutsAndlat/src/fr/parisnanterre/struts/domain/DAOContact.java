package fr.parisnanterre.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import fr.parisnanterre.struts.domain.Address;
import fr.parisnanterre.struts.domain.Contact;
import model.Group;
import model.PhoneNumber;
import util.HibernateUtil;



public class DAOContact {
	
	public void addContact(String firstName, String lastName, String emailC) {
		Session session = null;
		System.out.println("salut");

		// creation d'un contact et son insertion dans la BD
		Contact contact = new Contact();
		// dans le cas d'une startegie de generation de cle "increment" par exp,
		// cette ligne peut etre omise
		// car l'id sera affecte automatiquement comme max des id + 1 (de la
		// table contact)
		// contact.setId(1);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setEmail(emailC);
		
		
		Address address = new Address(1, "etoile", "Paris", "test", "France");
		contact.setAddress(address);
		 

		try {

			// utilisation de la classe utilitaire HibernateUtil
			// qui applique le pattern singleton et
			// qui assure que SessionFactory ne sera instanciee qu'une seule
			// fois

			session = HibernateUtil.getSessionFactory().getCurrentSession();

			// mettre les actions entre une transaction
			org.hibernate.Transaction tx = session.beginTransaction();

			session.save(contact);

			// pour montrer qu'hibernate met a jour systematiquement la base de
			// donnees
			// et sans faire un save a nouveau
			contact.setFirstName("Robin");

			
			System.out.println("before Commit instruction");
			// Commiter la transaction sinon rien ne se passe
			tx.commit();

			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		System.out.println("gggggggggggggggggggggggggggggggg");
	}
		/////READ///////
		
		
		public Contact lireContact(long id) {
			Contact contact = null;
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				contact = new Contact((Contact)session.createCriteria(Contact.class).add(Restrictions.like("ID",id )).uniqueResult());
				
				//session.flush();
				session.evict(contact);
				session.clear();
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return contact;
		}
		
		
	
		
		
		@SuppressWarnings({ "unchecked" })
		public Set<Contact> getAllContacts() {
			List<Contact> contacts = new LinkedList<Contact>();
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				//List<Contact> listContacts = session.createQuery("from Contact").list();
				List<Contact> listContacts = session.createCriteria(Contact.class).setFetchMode("groups", FetchMode.SELECT).list();
				for(Contact contact : listContacts) {
					Contact c = new Contact(contact);
					c.setId(contact.getId());
					contacts.add(c);
				}
				
				session.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return new HashSet<Contact>(contacts);
		}
		
		
		
		public Group getGroup(long groupId) {
			Group group = null;
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				group = (Group) session.createCriteria(Group.class).add(Restrictions.like("group_ID", groupId)).uniqueResult();
				session.close();
				return group;
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return group;
		}
		
		
		/////////// MISE A JOUR DUN CONTACT ////////////////
		
		public boolean updateContact(long id, String firstName, String lastName, String emailC, Address address){
			try{
				
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				Transaction tx = session.getTransaction();
				if(!tx.isActive()) tx = session.beginTransaction();
				
				Contact contact = (Contact) session.load(Contact.class, id);
				if(firstName!= null && !firstName.isEmpty()) contact.setFirstName(firstName);
				if(lastName!= null && !lastName.isEmpty()) contact.setLastName(lastName);
				if(emailC!= null && !emailC.isEmpty()) contact.setEmail(emailC);
				if(address!= null) contact.setAddress(address);
				
				tx.commit();
				return true;
			} catch(Exception e){
				return false;
			}
		}
		
		
		///Maj du groupe
		public boolean update(Group group) {
			boolean result = false;
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.update(group);
				session.getTransaction().commit();
				session.close();
				
				result = true;
			} catch (HibernateException e) {
				e.printStackTrace();
				e.getMessage();
			}
			return result;
		}
		
		
	
		
		
		/////Suppression d'un contact/////
		
		public boolean deleteContact(long contactId) {
			boolean result = false;
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Contact contact = (Contact)session.get(Contact.class, contactId);
				contact.setGroup(null);
				session.delete(contact);
				session.getTransaction().commit();
				result = true;
				session.close();
			} catch (HibernateException e) {
				e.getMessage();
				e.printStackTrace();
				result = false;
			} catch(Exception e) {
				e.getMessage();
				result = false;
			}
			
			System.out.println("Result = " + result);
			return result;
		}
		
	//////Suppression d'un groupe /////////
		
		public boolean deleteGroup(long group_ID) {
			boolean result = false;
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				Group group = (Group) session.get(Group.class, group_ID);
				for (Contact contact : group.getContacts()) {
					contact.getGroup().remove(group);
					session.update(contact);
				}
				session.delete(group);
				session.getTransaction().commit();
				session.close();
				result = true;
			} catch (HibernateException e) {
				e.getMessage();
				e.printStackTrace();
				result = false;
			} catch(Exception e) {
				e.getMessage();
				result = false;
			}
			
			System.out.println("Result = " + result);
			return result;
		}

		


	
//	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
//	List<Contact> contacts;
//	
//	
//	public Long countContact() throws SQLException{
//		Long size = (long) 0;
//		Context lContext;
//		try {
//			lContext = new InitialContext();
//			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
//			final Connection lConnection  = lDataSource.getConnection();
//			
//			final PreparedStatement lPreparedStatementCreation = 
//			lConnection.prepareStatement("SELECT MAX(ID_CONTACT) AS SIZE FROM CONTACT");
//			
//			
//			ResultSet result = lPreparedStatementCreation.executeQuery();
//			while(result.next()){
//				
//				try {
//					size = Long.parseLong(result.getString("SIZE"));
//					size++;
//					return size;
//			    } catch (NumberFormatException e) {
//			       return size;
//			    }
//			}
//			
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return size;
//		
//		
//	}
	
//	public String addContact(final long id, final String firstName, final String lastName, final String email) {
//		
//		try {
//			countContact();
//			final Context lContext = new InitialContext();
//			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
//			final Connection lConnection  = lDataSource.getConnection();
//			
//			// adding a new contact
//			final PreparedStatement lPreparedStatementCreation = 
//					
//			lConnection.prepareStatement("INSERT INTO CONTACT(ID_CONTACT, FIRSTNAME, LASTNAME, EMAIL) VALUES(?, ?, ?, ?)");
//			
//			lPreparedStatementCreation.setLong(1, countContact());
//			lPreparedStatementCreation.setString(2, firstName);
//			lPreparedStatementCreation.setString(3, lastName);
//			lPreparedStatementCreation.setString(4, email);
//			lPreparedStatementCreation.executeUpdate();
//			
//			return null;
//		} catch (NamingException e) {
//		
//			return "NamingException : " + e.getMessage();
//		
//		} catch (SQLException e) {
//
//			return "SQLException : " + e.getMessage();
//			
//		}
//	}
//	
//	
//	public String alterContact(final long id, final String firstName, final String lastName, final String email) {
//		try {
//			final Context lContext = new InitialContext();
//			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
//			final Connection lConnection  = lDataSource.getConnection();
//			
//			// adding a new contact
//			final PreparedStatement lPreparedStatementCreation = 
//					lConnection.prepareStatement("UPDATE CONTACT SET FIRSTNAME='"+firstName+"', LASTNAME='"+lastName+"', EMAIL='"+email+"' WHERE ID_CONTACT="+id+"");
//			
//			lPreparedStatementCreation.executeUpdate();
//			
//			return null;
//		} catch (NamingException e) {
//		
//			return "NamingException : " + e.getMessage();
//		
//		} catch (SQLException e) {
//
//			return "SQLException : " + e.getMessage();
//			
//		}
//	}
//	public String removeContact(final long id, final String email){
//		try {
//			final Context lContext = new InitialContext();
//			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
//			final Connection lConnection  = lDataSource.getConnection();
//			System.out.println("je suis dans remove conatct dao");
//			// removing a new contact
//			String rq = "DELETE FROM CONTACT WHERE ID_CONTACT="+id+" AND EMAIL='"+email+"'";
//			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement(rq);
//
//			lPreparedStatementCreation.executeUpdate();
//			
//			return null;
//		} catch (NamingException e) {
//		
//			return "NamingException : " + e.getMessage();
//		
//		} catch (SQLException e) {
//
//			return "SQLException : " + e.getMessage();
//			
//		}
//	}
//	
//	public List<Contact> searchContact(String element){
//		System.out.println("step 1 : DAOContact entree dans search");
//		try {
//			final Context lContext = new InitialContext();
//			System.out.println("step 2 : DAOContact init context");
//			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
//			System.out.println("step 3 : DAOContact init sourcce");
//			final Connection lConnection  = lDataSource.getConnection();
//			System.out.println("step 4 : DAOContact init connection");
//			
//			String rqFN = "SELECT * FROM CONTACT WHERE FIRSTNAME='"+element+"'";
//			String rqLN = "SELECT * FROM CONTACT WHERE LASTNAME='"+element+"'";
//			String rqEmail = "SELECT * FROM CONTACT WHERE EMAIL='"+element+"'";
//			
//			contacts = new ArrayList<Contact>();
//			
//			System.out.println("step 5 : DAOContact init rq ok");
//
//			
//			
//			PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement(rqFN);
//			System.out.println("step 6 : DAOContact prepare statement");
//			ResultSet result = lPreparedStatementCreation.executeQuery();
//			System.out.println("step 7 : DAOContact execute query");
//			
//			System.out.println("step 8 : DAOContact list contact : ");
//			
//			
//			while(result.next()){
//				System.out.print("- "+result.getString("id_contact")+", ");
//				System.out.print(result.getString("firstname")+", ");
//				System.out.print(result.getString("lastname")+", ");
//				System.out.println(result.getString("email"));
//				Contact c = new Contact(Long.parseLong(
//								result.getString("id_contact")),
//								result.getString("firstname"),
//								result.getString("lastname"),
//								result.getString("email"));
//				System.out.println(c.toString());
//				
//				if(!isNotInList(contacts,c)){
//					contacts.add(c);
//				}
//				
//			
//			}
//			lPreparedStatementCreation = lConnection.prepareStatement(rqLN);
//			System.out.println("step 6 : DAOContact prepare statement");
//			result = lPreparedStatementCreation.executeQuery();
//			System.out.println("step 7 : DAOContact execute query");
//			
//			System.out.println("step 8 : DAOContact list contact : ");
//			
//			
//			while(result.next()){
//				System.out.print("- "+result.getString("id_contact")+", ");
//				System.out.print(result.getString("firstname")+", ");
//				System.out.print(result.getString("lastname")+", ");
//				System.out.println(result.getString("email"));
//				Contact c = new Contact(Long.parseLong(
//								result.getString("id_contact")),
//								result.getString("firstname"),
//								result.getString("lastname"),
//								result.getString("email"));
//				System.out.println(c.toString());
//				
//				if(!isNotInList(contacts,c)){
//					contacts.add(c);
//				}
//				
//			
//			}
//			lPreparedStatementCreation = lConnection.prepareStatement(rqEmail);
//			System.out.println("step 6 : DAOContact prepare statement");
//			result = lPreparedStatementCreation.executeQuery();
//			System.out.println("step 7 : DAOContact execute query");
//			
//			System.out.println("step 8 : DAOContact list contact : ");
//			
//			
//			while(result.next()){
//				System.out.print("- "+result.getString("id_contact")+", ");
//				System.out.print(result.getString("firstname")+", ");
//				System.out.print(result.getString("lastname")+", ");
//				System.out.println(result.getString("email"));
//				Contact c = new Contact(Long.parseLong(
//								result.getString("id_contact")),
//								result.getString("firstname"),
//								result.getString("lastname"),
//								result.getString("email"));
//				System.out.println(c.toString());
//				
//				if(!isNotInList(contacts,c)){
//					contacts.add(c);
//				}
//				
//			
//			}
//			return contacts;
//		} catch (NamingException e) {
//			System.out.println("NamingException : " + e.getMessage());
//			return null;
//
//		} catch (SQLException e) {
//
//			System.out.println("SQLException : " + e.getMessage());
//			return null;
//		}
//	}
//	public List<Contact> getListContact()  {
//		System.out.println("step 1 : DAOContact entree dans getListcontact");
//		try {
//			final Context lContext = new InitialContext();
//			System.out.println("step 2 : DAOContact init context");
//			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
//			System.out.println("step 3 : DAOContact init sourcce");
//			final Connection lConnection  = lDataSource.getConnection();
//			System.out.println("step 4 : DAOContact init connection");
//			
//			String requete ="SELECT * FROM CONTACT";
//			contacts = new ArrayList<Contact>();
//			
//			System.out.println("step 5 : DAOContact init rq ok");
//
//			final PreparedStatement lPreparedStatementCreation = lConnection.prepareStatement(requete);
//			System.out.println("step 6 : DAOContact prepare statement");
//			ResultSet result = lPreparedStatementCreation.executeQuery();
//			System.out.println("step 7 : DAOContact execute query");
//			
//			System.out.println("step 8 : DAOContact list contact : ");
//			
//			
//			while(result.next()){
//				System.out.print("- "+result.getString("id_contact")+", ");
//				System.out.print(result.getString("firstname")+", ");
//				System.out.print(result.getString("lastname")+", ");
//				System.out.println(result.getString("email"));
//				Contact c = new Contact(Long.parseLong(
//								result.getString("id_contact")),
//								result.getString("firstname"),
//								result.getString("lastname"),
//								result.getString("email"));
//				System.out.println(c.toString());
//				
//				contacts.add(c);
//				
//			
//			}
//
//			return contacts;
//		} catch (NamingException e) {
//			System.out.println("NamingException : " + e.getMessage());
//			return null;
//
//		} catch (SQLException e) {
//
//			System.out.println("SQLException : " + e.getMessage());
//			return null;
//		}
//	}
//	
//	public boolean isNotInList(List<Contact> l, Contact c){
//		for(int i=0;i<l.size();i++){
//			if(c.getId() == l.get(i).getId()){
//				return true;
//			}
//		}
//		return false;
//	}
	
}
