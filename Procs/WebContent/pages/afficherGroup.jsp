<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="servlet.ListContactControllerServlet"%>
<%@page import="entities.ContactGroup"%>
<%@page import="entities.Contact"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="entities.PhoneNumber"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher le groupe</title>
<%
	ContactGroup g = (ContactGroup) request.getAttribute("ContactGroup");
	Set<Contact> contacts = g.getContacts();
%>
</head>
<body>
    <h1> Groupe </h1>
        <table cellpadding="3pt">
            <tr>
                <td>Id   :  </td>
                <td><%=g.getGroupId()%></td>
            </tr>
            <tr>
                <td>GroupName :   </td>
                <td><%=g.getGroupName()%></td>
            </tr>
            <%
			for (Contact c : contacts) {
			%>
			<tr>
                <td>First Name :   </td>
                <td><%=c.getFirstName()%></td>
            </tr>
            <tr>
                <td>Last Name :   </td>
                <td><%=c.getLastName()%></td>
            </tr>
           <%
			}
			%>
        </table>
</body>
</html>