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
import entities.Contact;
import entities.PhoneNumber;
import entities.Address;

public class UpdateContactControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		try {
				ContactDAO userDAO = new ContactDAO();
			// Recuperer le contact à modifier
			
				Long id = Long.parseLong(request.getParameter("id").toString());
				Contact cd = userDAO.ReadContact(id);
				
				request.setAttribute("Contact", cd);  
				getServletConfig().getServletContext().getRequestDispatcher("/pages/modifierContact.jsp").forward(request,response);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
