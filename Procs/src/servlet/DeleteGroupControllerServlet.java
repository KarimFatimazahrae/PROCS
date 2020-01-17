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

public class DeleteGroupControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("################################## I am in the delete Group #############################");
		String groupname = request.getParameter("groupname");
		
		HttpSession session = request.getSession(true);
		try {
			IContactDAO userDAO = new ContactDAO();
			userDAO.deleteGroupe(groupname);
			response.sendRedirect("Success");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
