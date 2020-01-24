package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ContactDAO;
import domain.IContactDAO;
import entities.Contact;
import entities.ContactGroup;

public class ListGroupControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		try {
			IContactDAO userDAO = new ContactDAO();
			// Recuperer la liste des contacts
			
		
				List<ContactGroup> categoryList = userDAO.listGroupe();
				request.setAttribute("listGroup", categoryList);  
				getServletConfig().getServletContext().getRequestDispatcher("/pages/listGroup.jsp").forward(request,response);
				System.out.println("******************request:" + String.valueOf(request));

		} catch (Exception e) {

			e.printStackTrace();
		}
		
//		ContactDAO userDAO = new ContactDAO();
//
//		List<ContactGroup> gList = new ArrayList();
//
//		System.out.println("********************************afficher la liste******************************");
//		String groupId = request.getParameter("groupId");
//		String groupName = request.getParameter("groupName");
//		
//		gList = userDAO.listGroupe();
//		request.setAttribute("gList", gList);
//		getServletConfig().getServletContext().getRequestDispatcher("/pages/listGroup.jsp").forward(request,response);

//		RequestDispatcher rd = request.getRequestDispatcher("pages/listGroup.jsp");
//		rd.forward(request, response);

	}

}
