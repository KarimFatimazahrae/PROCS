package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import domain.IContactDAO;
import entities.Contact;
import entities.IContact;

/**
 * Servlet implementation class NewContact
 */
public class SearchContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchContactServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SearchContact doGet");
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		IContactDAO iContactDao = (IContactDAO)context.getBean("idContactDAO");
		
		String search = request.getParameter("search");
		HttpSession session = request.getSession();
		System.out.println(session.getAttributeNames().toString());
		boolean okSearch = search!=null && !search.isEmpty();
		
		if(!okSearch){
			request.setAttribute("message", "Please enter at least one word");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);
			
			} else {
				List<Contact> contacts =iContactDao.searchContact(search);
				if(contacts==null || contacts.isEmpty()){
					request.setAttribute("message", "No contacts found...");
				} else {
					request.setAttribute("contacts", contacts);
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("searchContact.jsp");
				dispatcher.forward(request, response);
			}
		}
			
	}


