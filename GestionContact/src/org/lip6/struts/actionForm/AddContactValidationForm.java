package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddContactValidationForm extends ActionForm {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	private long id=0;
	private String firstName=null;
	private String lastName=null;
	private String email=null;
	private String mobile=null;
	private String fix=null;
	private String group=null;
	private String rue=null;
	private String ville=null;
	private String cp=null;
	private String pays=null;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	/**
	* @return Email
	*/
	public String getEmail() { return email; }
	/**
	* @return First Name
	*/
	public String getFirstName() { return firstName;}
	/**
	* @return Last name
	*/
	public String getLastName() { return lastName;
	}
	/**
	* @param string Sets the Email
	*/
	public void setEmail(String string) { email=string; }
	/**
	* @param string Sets the First Name
	*/
	public void setFirstName(String string) { firstName = string; }
	/**
	* @param string sets the Last Name
	*/
	public void setLastName(String string) { lastName = string; }
	/**
	* @return ID Returns ID
	*/
	public long getId() { return id; }
	/**
	* @param l Sets the ID
	*/
	public void setId(long l) {	id = l;	}
	
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFix() {
		return fix;
	}
	public void setFix(String fix) {
		this.fix = fix;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		this.firstName=null;
		this.lastName=null;
		this.email=null;
		this.cp=null;
		this.fix=null;
		this.mobile=null;
		this.ville=null;
		this.pays=null;
		this.rue=null;
		this.group=null;
		}
	
	
	
		public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
		ActionErrors errors = new ActionErrors();
		System.out.println(getLastName()+" "+getFirstName()+" "+getEmail()+" "+getMobile()
		+" "+getFix()+" "+getRue()+" "+getCp()+" "+getPays()+" "+getGroup());
		if( getFirstName()== null || getFirstName().length() < 1 ) {
		errors.add("first name",new
		ActionMessage("creation.fn.error.required"));
		}
		if( getLastName()== null || getLastName().length() < 1 ) {
		errors.add("last name",new
		ActionMessage("creation.ln.error.required"));
		}
		if( getEmail() == null || getEmail().length() < 1 ) {
		errors.add("email", new
		ActionMessage("creation.email.error.required"));
		}
		if( getMobile() == null || getMobile().length() < 1 ) {
			errors.add("mobile", new
			ActionMessage("creation.mobile.error.required"));
		}
		if( getFix() == null || getFix().length() < 1 ) {
			errors.add("fixe", new
			ActionMessage("creation.fixe.error.required"));
		}
		if( getRue() == null || getRue().length() < 1 ) {
			errors.add("rue", new
			ActionMessage("creation.rue.error.required"));
		}
		if( getVille() == null || getVille().length() < 1 ) {
			errors.add("ville", new
			ActionMessage("creation.ville.error.required"));
		}
		if( getCp() == null || getCp().length() < 1 ) {
			errors.add("cp", new
			ActionMessage("creation.cp.error.required"));
		}
		if( getPays() == null || getPays().length() < 1 ) {
			errors.add("pays", new
			ActionMessage("creation.pays.error.required"));
		}
		if( getGroup() == null || getGroup().length() < 1 ) {
			errors.add("group", new
			ActionMessage("creation.group.error.required"));
		}
		return errors;
		}
}
