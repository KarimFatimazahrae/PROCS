package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SearchValidationForm extends ActionForm {

        private static final long serialVersionUID = 1L;

        private String motcle=null;



        public String getMotcle() {
                return motcle;
        }



        public void setMotcle(String motcle) {
                this.motcle = motcle;
        }



        public void reset(ActionMapping mapping, HttpServletRequest request) {

                this.motcle=null;


                }



                public ActionErrors validate( ActionMapping mapping, HttpServletRequest request ) {
                ActionErrors errors = new ActionErrors();
                System.out.println(getMotcle());
                if( getMotcle()== null || getMotcle().length() < 1 ) {
                        errors.add("motcle",new
                        ActionMessage("search.error.required"));
                        }


                return errors;
                }
}


