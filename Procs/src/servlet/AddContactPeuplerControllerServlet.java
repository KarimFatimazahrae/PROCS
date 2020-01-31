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

import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import domain.ContactDAO;
import domain.IContactDAO;
import entities.Contact;
import entities.IContact;
import entities.PhoneNumber;
import entities.Address;

public class AddContactPeuplerControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		try {
			
			
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			IContactDAO iContactDao = (IContactDAO)context.getBean("idContactDAO");
			IContact contact = (IContact)context.getBean("idContactPeupler");
			IContact contact2 = (IContact)context.getBean("idContactPeupler2");
			//IContact entreprise = (IContact)context.getBean("idEntreprise");


			iContactDao.addContactPeupler(contact);
			iContactDao.addContactPeupler(contact2);
			//iContactDao.addContactPeupler(entreprise);



			response.sendRedirect("Success");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
