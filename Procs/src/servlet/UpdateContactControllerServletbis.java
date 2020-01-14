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
import entities.Contact;
import entities.PhoneNumber;
import entities.Address;

public class UpdateContactControllerServletbis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone1 = request.getParameter("phone");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");

		HttpSession session = request.getSession(true);
		try {
			ContactDAO userDAO = new ContactDAO();
			// Creation du contact
			//Contact c = new Contact(lastName, firstName, email);
			// creation de l'adresse
			//Address ad = new Address(street, city, zip, country);
			//c.setAdresse(ad);

			// Creation du numero telephone
			//PhoneNumber ph = new PhoneNumber("portable", phone1, c);
			//Set<PhoneNumber> tels = new HashSet<PhoneNumber>();
			//tels.add(ph);
			//c.setTels(tels);
			// Sauvegarde du contact
			//userDAO.updateContact(c);
			//response.sendRedirect("Success");
			
			Contact ctt = userDAO.getContact(id);
			ctt.setFirstName(firstName);
			ctt.setLastName(lastName);
			ctt.setEmail(email);
			userDAO.updateContact(ctt);
			response.sendRedirect("Success");				

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


