package org.lip6.struts.actionForm;



import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class UpdateGroupValidationForm extends ActionForm {

	
	private static final long serialVersionUID = 1L;

	private String groupName=null;

	
	private int  groupId=0;
	
	public String getGroupName() { return groupName; }
	public int getGroupId() { return groupId; }
	
	public void setGroupName(String string) { groupName=string; }
	
	public void setGroupId(int i){ groupId=i; }
	
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