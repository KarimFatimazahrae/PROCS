package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ContactDAO;
import entities.Contact;

public class DeleteContactControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("################################## I am in the delete part #############################");
		String prenom = request.getParameter("firstName");
		String nom = request.getParameter("lastName");
		
		HttpSession session = request.getSession(true);
		try {
			ContactDAO userDAO = new ContactDAO();
			userDAO.deleteContact(prenom,nom);
			response.sendRedirect("Success");

			//            ContactDAO.addUserDetails(nom, prenom, email, phone, city);
			//            ContactDAO.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
