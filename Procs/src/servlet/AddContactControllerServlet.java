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

public class AddContactControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("firstName");
		String prenom = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone1 = request.getParameter("phone");
//        String phone2 = null;
//        if (!request.getParameter("phone_fixe").isEmpty())
//        	 phone2 = request.getParameter("phone_fixe");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");

		HttpSession session = request.getSession(true);
		try {
			ContactDAO userDAO = new ContactDAO();
			// Creation du contact
			Contact c = new Contact(nom, prenom, email);
			// creation de l'adresse
			Address ad = new Address(street, city, zip, country);
			c.setAdresse(ad);

			// Creation du numero telephone
			PhoneNumber ph = new PhoneNumber("portable", phone1, c);
			Set<PhoneNumber> tels = new HashSet<PhoneNumber>();
			tels.add(ph);
			c.setTels(tels);
			// Sauvegarde du contact
			userDAO.addContact(c);

//            PhoneNumber ph2;
//            if(!phone2.isEmpty())
//            	ph2 = new  PhoneNumber("Fixe",phone1,c);

			response.sendRedirect("Success");

//            ContactDAO.addUserDetails(nom, prenom, email, phone, city);
//            ContactDAO.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
