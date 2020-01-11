package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.AddContactValidationForm;
import org.lip6.struts.domain.DAOContact;

public class AddContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
			final AddContactValidationForm
			lForm=(AddContactValidationForm)pForm;
			//final long id = lForm.getId();
			final String firstName = lForm.getFirstName();
			final String lastName = lForm.getLastName();
			final String email = lForm.getEmail();
			final String mobile = lForm.getMobile();
			final String fixe = lForm.getFix();
			final String rue = lForm.getRue();
			final String ville = lForm.getVille();
			final String cp = lForm.getCp();
			final String pays = lForm.getPays();
			final int group = Integer.parseInt(lForm.getGroup());
			// create a new Contact
			final DAOContact lDAOContact = new DAOContact();
			final String lError = lDAOContact.addContact( firstName,
			lastName, email, mobile, fixe, rue, ville, cp, pays, group);
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
