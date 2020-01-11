package servlet;

import java.io.IOException;

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
	 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	System.out.print("#########################################################I am here");
        String nom = request.getParameter("firstName");
        String prenom= request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone1 = request.getParameter("phone_portable");
        String phone2 = null;
        if (!request.getParameter("phone_fixe").isEmpty())
        	 phone2 = request.getParameter("phone_fixe");
        String street = request.getParameter("street");
    	String city = request.getParameter("city");
    	String zip = request.getParameter("zip");
    	String country = request.getParameter("country");
        
 
        HttpSession session = request.getSession(true);
        try {
            ContactDAO userDAO = new ContactDAO();
            Contact c= new Contact(nom,prenom,email);
            userDAO.addContact(c);
            Address ad = new Address(street,city,zip,country);
            
            PhoneNumber ph = new PhoneNumber("portable",phone1,c);
            PhoneNumber ph2;
            if(!phone2.isEmpty())
            	ph2 = new  PhoneNumber("Fixe",phone1,c);
            
            response.sendRedirect("Success");
               
         
//            ContactDAO.addUserDetails(nom, prenom, email, phone, city);
//            ContactDAO.sendRedirect("Success");
        } catch (Exception e) {
 
            e.printStackTrace();
        }
 
    }

}
