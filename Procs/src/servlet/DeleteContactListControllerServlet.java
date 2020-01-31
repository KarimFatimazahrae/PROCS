package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import domain.ContactDAO;
import domain.IContactDAO;
import entities.Contact;

public class DeleteContactListControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("################################## I am in the delete contact from list #############################");
		Long id = Long.parseLong(request.getParameter("id").toString());	
		
		HttpSession session = request.getSession(true);
		try {
			//IContactDAO userDAO = new ContactDAO();
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			IContactDAO iContactDao = (IContactDAO)context.getBean("idContactDAO");
			iContactDao.deleteContactList(id);
			response.sendRedirect("Success");

			//            ContactDAO.addUserDetails(nom, prenom, email, phone, city);
			//            ContactDAO.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
