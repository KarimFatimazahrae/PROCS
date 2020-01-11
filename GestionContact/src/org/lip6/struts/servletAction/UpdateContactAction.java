package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.UpdateContactValidationForm;
import org.lip6.struts.domain.DAOContact;

public class UpdateContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
			final UpdateContactValidationForm
			lForm=(UpdateContactValidationForm)pForm;
			final long id = lForm.getId();
			final String firstName = lForm.getFirstName();
			final String lastName = lForm.getLastName();
			final String email = lForm.getEmail();
			final String mobile = lForm.getMobile();
			final String fixe=lForm.getFixe();
			final String rue=lForm.getRue();
			final String ville=lForm.getVille();
			final String cp=lForm.getCp();
			final String pays=lForm.getPays();
			final int group = Integer.parseInt(lForm.getGroup());
			// create a new Contact
			final DAOContact lDAOContact = new DAOContact();
			String lError;
			 if(firstName!=null && firstName.trim()!=""){
              lError = lDAOContact.editFirstNameContact(firstName, id);}
                 if(lastName!=null  && lastName.trim()!=""){
                 lError = lDAOContact.editLastNameContact(lastName, id);}
                 if(email!=null  && email.trim()!=""){
                 lError = lDAOContact.editEmailContact(email, id);}
                 if(mobile!=null  && mobile.trim()!=""){
                 lError = lDAOContact.editPhoneMobileContact(mobile, id);}
                 if(fixe!=null  && fixe.trim()!=""){
                 lError = lDAOContact.editPhoneFixContact(fixe, id);}
                 if(rue!=null  && rue.trim()!="") {
                	 lError = lDAOContact.editRueAdresseContact(rue, id);
                 }
                 if(ville!=null  && ville.trim()!="") {
                	 lError = lDAOContact.editVilleAdresseContact(ville, id);
                 }
                 if(cp!=null  && cp.trim()!="") {
                	 lError = lDAOContact.editCPAdresseContact(cp, id);
                 }
                 if(pays!=null  && pays.trim()!="") {
                	 lError = lDAOContact.editPaysAdresseContact(pays, id);
                 }
                 if(group!=0) {
                	 lError = lDAOContact.editGroupeContact(group, id);
                 }
                 //if(rue!=null && ville!=null && cp!=null && pays!=null){
                 //lError = lDAOContact.editAdresseContact(rue,ville,cp,pays, id);}
                 else {lError="remplir";}
			//final String lError = lDAOContact.editContact(firstName, lastName, email,group,mobile, fixe, rue, ville, cp, pays,  id);
			System.out.print(lError);
			if(lError == null) {
			// if no exception is raised, forward "success"
			return pMapping.findForward("success");
			}
			else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}
	}
}
