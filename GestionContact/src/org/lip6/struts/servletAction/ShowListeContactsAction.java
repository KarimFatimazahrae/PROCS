package org.lip6.struts.servletAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.domain.Contact;
import org.lip6.struts.domain.DAOContact;

public class ShowListeContactsAction extends Action {
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws Exception {
			// create a new Contact
			final DAOContact lDAOContact = new DAOContact();
			List<Contact> listeContacts = lDAOContact.findAllContacts();
			pRequest.setAttribute("listeContacts", listeContacts);
			return pMapping.findForward("success");
			
			
			
			
}
}
