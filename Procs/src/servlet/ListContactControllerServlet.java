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
			// Recuperer la liste des contacts
			
			if((request.getParameter("id"))==null) {
				List<Contact> categoryList = userDAO.listContact();
				request.setAttribute("listContact", categoryList);  
				getServletConfig().getServletContext().getRequestDispatcher("/pages/listContact.jsp").forward(request,response);
				
			} else {
				System.out.println("############ looking for contact ########");
				Long id = Long.parseLong(request.getParameter("id").toString());
				System.out.println("\n"+"############ id ######## " + id);
				Contact cd = userDAO.ReadContact(id);
				System.out.println("\n"+"############ Contact ######## " + cd.toString());
				
				request.setAttribute("Contact", cd);  
				getServletConfig().getServletContext().getRequestDispatcher("/pages/afficherContact.jsp").forward(request,response);
			}
			//response.sendRedirect("/pageslistContanct.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
