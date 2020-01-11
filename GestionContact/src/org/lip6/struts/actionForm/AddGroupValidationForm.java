package org.lip6.struts.actionForm;



import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class AddGroupValidationForm extends ActionForm {

	
	private static final long serialVersionUID = 1L;
	private int groupId=0;
	private String groupName=null;

	
	public int getGroupId() { return groupId; }
	public String getGroupName() { return groupName; }

	public void setGroupId(int i) { groupId=i; }
	public void setGroupName(String string) { groupName=string; }
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		//this.groupId=0;
		this.groupName=null;
		
		}
	
		public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
		ActionErrors errors = new ActionErrors();
		System.out.println(getGroupName()+" ");
		
		//if( getGroupId()==0) {
		//errors.add("groupId",new
		//ActionMessage("creationgroup.id.error.required"));
		//}
		if( getGroupName()== null || getGroupName().length() < 1 ) {
		errors.add("groupName",new
		ActionMessage("creationgroup.name.error.required"));
		}
		
		return errors;
		}
}