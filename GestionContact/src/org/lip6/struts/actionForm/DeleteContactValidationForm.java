package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DeleteContactValidationForm extends ActionForm {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	
	private long id=0;
	

	//private String lastName=null;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id=0;

				}
	
		

		public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
		ActionErrors errors = new ActionErrors();
		System.out.println(getId());
		
		
		return errors;
		}
}
