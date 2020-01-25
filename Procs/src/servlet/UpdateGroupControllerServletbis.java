package servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ContactDAO;
import domain.IContactDAO;
import entities.Contact;
import entities.ContactGroup;
import entities.PhoneNumber;
import entities.Address;

public class UpdateGroupControllerServletbis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long groupId = Long.parseLong(request.getParameter("groupId"));
		String groupName = request.getParameter("groupName");
		
		HttpSession session = request.getSession(true);
		try {
			IContactDAO userDAO = new ContactDAO();
			
			/* Updating the Contact */		
			ContactGroup ctt = userDAO.getGroupe(groupId);
			ctt.setGroupName(groupName);
				
			
			userDAO.updateGroup(ctt);;
			response.sendRedirect("Success");				

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


