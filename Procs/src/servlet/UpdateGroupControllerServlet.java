package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ContactDAO;
import domain.IContactDAO;
import entities.ContactGroup;

public class UpdateGroupControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		try {
			IContactDAO userDAO = new ContactDAO();

			Long id = Long.parseLong(request.getParameter("id").toString());
			ContactGroup g = userDAO.ReadGroup(id);

			request.setAttribute("ContactGroup", g);
			getServletConfig().getServletContext().getRequestDispatcher("/pages/modifierGroup.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
