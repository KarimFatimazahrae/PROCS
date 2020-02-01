package domain;

import java.util.List;
import java.util.Set;

import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.IContact;
import entities.PhoneNumber;

public interface IContactDAO {

	/* ****************** CRUD Groupe ****************** */
	ContactGroup getGroupe(long idGroupe);

	void addGroup(ContactGroup group);

	ContactGroup getGroupFromName(String groupName);

	void deleteGroupe(String groupName);

	/* ****************** CRUD Contact ****************** */
	Contact getContact(long idContact);

	IContact getContactFromName(String firstname, String lastname);

	void addContact(IContact contact);

	void updateContact(IContact contact);

	void updateTelephone(PhoneNumber phone1);

	void deleteContact(String firstname, String lastname);

	void deleteContactList(Long id);

	//	Affiche la Liste de tous les contacts
	List<Contact> listContact();

	IContact ReadContact(long id);

	void addPhoneNumber(PhoneNumber tel);

	void updateAdress(Long idAdress, Address adresse);

	List<ContactGroup> listGroupe();

	void deleteGroupList(Long id);

	ContactGroup ReadGroup(long id);

	void updateGroup(ContactGroup groupe);

	void addContactPeupler(IContact contact);

	List<Contact> searchContact(String search);

	List<Contact> listContactForGroup(Set<Contact> contactsinGroup);

	boolean addContactToGroup(Long idGroupe, Long idContact);

	//void addContact(Contact contact);

}