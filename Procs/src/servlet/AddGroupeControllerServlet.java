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

public class AddGroupeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String groupName = request.getParameter("groupName");

		HttpSession session = request.getSession(true);
		try {
			IContactDAO userDAO = new ContactDAO();
			// Creation du groupe
			ContactGroup g = new ContactGroup(groupName);

			// Sauvegarde du contact
			userDAO.addGroup(g);

			response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
