package servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
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
import entities.IContact;
import entities.PhoneNumber;
import entities.Address;

public class AddContactToGroupControllerServletbis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		try {
			IContactDAO userDAO = new ContactDAO();
					
			boolean adding = userDAO.addContactToGroup(Long.parseLong(request.getParameter("groupId")),Long.parseLong(request.getParameter("id")));
			
			if (adding) {
				response.sendRedirect("Success");
			} else {
				response.sendRedirect("Fail");
			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
