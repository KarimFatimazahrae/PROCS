package domain;

import java.util.List;

import entities.Address;
import entities.Contact;
import entities.ContactGroup;
import entities.PhoneNumber;

public interface IContactDAO {

	/* ****************** CRUD Groupe ****************** */
	ContactGroup getGroupe(long idGroupe);

	void addGroup(ContactGroup group);

	ContactGroup getGroupFromName(String groupName);

	void deleteGroupe(String groupName);

	/* ****************** CRUD Contact ****************** */
	Contact getContact(long idContact);

	Contact getContactFromName(String firstname, String lastname);

	void addContact(Contact contact);

	void updateContact(Contact contact);

	void updateTelephone(PhoneNumber phone1);

	void deleteContact(String firstname, String lastname);

	void deleteContactList(Long id);

	//	Affiche la Liste de tous les contacts
	List<Contact> listContact();

	Contact ReadContact(long id);

	void addPhoneNumber(PhoneNumber tel);

	void updateAdress(Long idAdress, Address adresse);

	List<ContactGroup> listGroups();

	List<ContactGroup> listGroupe();

	void deleteGroupList(Long id);

}