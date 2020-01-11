package org.lip6.struts.actionForm;



import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class DeleteGroupValidationForm extends ActionForm {

	
	private static final long serialVersionUID = 1L;

	private String groupName=null;

	
	
	public String getGroupName() { return groupName; }

	public void setGroupName(String string) { groupName=string; }
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.groupName=null;
		}
	
		public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
		ActionErrors errors = new ActionErrors();
		System.out.println(getGroupName()+" ");
		
		
		//ajouter erreur de "nexiste pas" 
		
		return errors;
		}
}