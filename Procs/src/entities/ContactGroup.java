package entities;

import java.util.HashSet;
import java.util.Set;

public class ContactGroup {
	private long groupId;
	private String groupName;
	private Set<Contact> contacts = new HashSet<Contact>(0);



	public ContactGroup() {
		// TODO Auto-generated constructor stub
	}

	public ContactGroup(String groupName) {
		super();
		this.groupName = groupName;
	}

	public ContactGroup(long groupId) {
		super();
		this.groupId = groupId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactGroup other = (ContactGroup) obj;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}

	

}
