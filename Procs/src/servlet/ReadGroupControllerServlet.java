package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ContactDAO;
import domain.IContactDAO;
import entities.Contact;
import entities.ContactGroup;

public class ReadGroupControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	System.out.print("#########################################################I am in read group");
        String nom = request.getParameter("groupName");
      
 
        HttpSession session = request.getSession(true);
        try {
            IContactDAO userDAO = new ContactDAO();
            ContactGroup group= new ContactGroup(nom);
            userDAO.addGroup(group);
            response.sendRedirect("Success");
          
        } catch (Exception e) {
 
            e.printStackTrace();
        }
 
    }

}
