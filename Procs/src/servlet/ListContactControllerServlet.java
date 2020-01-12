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

public class ListContactControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		try {
			ContactDAO userDAO = new ContactDAO();
			// Creation du contact
		
			List<Contact> categoryList = userDAO.listContact();

			request.setAttribute("listContact", categoryList);  
			getServletConfig().getServletContext().getRequestDispatcher("/pages/listContact.jsp").forward(request,response);
			
			//response.sendRedirect("/pageslistContanct.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
