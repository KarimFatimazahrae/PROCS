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
		String phoneKind = request.getParameter("phoneKind");
		String phone1 = request.getParameter("phoneNumber");
		
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");

		HttpSession session = request.getSession(true);
		try {
			ContactDAO userDAO = new ContactDAO();
			
			/* Updating the Contact */		
			Contact ctt = userDAO.getContact(id);
			ctt.setFirstName(firstName);
			ctt.setLastName(lastName);
			ctt.setEmail(email);

			/* Updating the Address */
			Address ad = ctt.getAdresse();
			ad.setStreet(street);
			ad.setCity(city);
			ad.setZip(zip);
			ad.setCountry(country);
			ctt.setAdresse(ad);
			
			/* Updating Phone Number */
			Set<PhoneNumber> tels =ctt.getTels();
			for(PhoneNumber tel : tels) {
				tel.setPhoneKind(phoneKind);
				tel.setPhoneNumber(phone1);
				
				
				tel.setContact(ctt);
				userDAO.updateTelephone(tel);
			}
			ctt.setTels(tels);
			
			userDAO.updateContact(ctt);
			response.sendRedirect("Success");				

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


