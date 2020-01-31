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

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import domain.ContactDAO;
import domain.IContactDAO;
import entities.Contact;
import entities.ContactGroup;
import entities.PhoneNumber;
import entities.Address;

public class AddGroupeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String groupName = request.getParameter("groupName");

		HttpSession session = request.getSession(true);
		try {
			
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			IContactDAO iContactDao = (IContactDAO)context.getBean("idContactDAO");
			//IContactDAO userDAO = new ContactDAO();
			// Creation du groupe
			ContactGroup g = new ContactGroup(groupName);

			// Sauvegarde du contact
			iContactDao.addGroup(g);

			response.sendRedirect("Success");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
