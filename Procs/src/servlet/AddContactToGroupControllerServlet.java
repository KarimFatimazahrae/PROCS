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

public class AddContactToGroupControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		try {
			IContactDAO userDAO = new ContactDAO();

			long group_id = Long.parseLong(request.getParameter("id"));
			ContactGroup cg = new ContactGroup(group_id); 
			Set<Contact> contactsinGroup =  cg.getContacts();
			List<Contact> categoryList = userDAO.listContactForGroup(contactsinGroup);
			request.setAttribute("listContactForGroup", categoryList);
			request.setAttribute("groupId", group_id);
			getServletConfig().getServletContext().getRequestDispatcher("/pages/ajouterContactauGroup.jsp")
					.forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
