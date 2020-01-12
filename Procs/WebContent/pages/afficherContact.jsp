<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="servlet.ListContactControllerServlet"%>
<%@page import="entities.Contact"%>
<%@page import="entities.PhoneNumber"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher le contact</title>
<%
	Contact c = (Contact) request.getAttribute("Contact");
%>
</head>
<body>
    <h1> Contact </h1>
        <table cellpadding="3pt">
            <tr>
                <td>Id   :  </td>
                <td><%=c.getId()%></td>
            </tr>
            <tr>
                <td>First Name :   </td>
                <td><%=c.getFirstName()%></td>
            </tr>
            <tr>
                <td>Last Name :   </td>
                <td><%=c.getLastName()%></td>
            </tr>
            <tr>
                <td>Email :   </td>
                <td><%=c.getEmail()%></td>
            </tr>
            <%
            int i=1;
			for (PhoneNumber tel : c.getTels()) {
			%>
			<tr>
                <td>Phone kind <%System.out.print(i);%>:   </td>
                <td><%=tel.getPhoneKind()%></td>
                <td>Phone Number <%System.out.print(i);%>:   </td>
                <td><%=tel.getPhoneNumber()%></td>
            </tr>
			<%
			i++;
			}
			%>
            <tr>
                <td>street :</td>
                <td><%=c.getAdresse().getStreet()%></td>
            </tr>
            <tr>
                <td>City :</td>
            	<td><%=c.getAdresse().getCity()%></td>
            </tr>
            <tr>
                <td>ZipCode :</td>
                <td><%=c.getAdresse().getZip()%></td>
            </tr>
            <tr>
                <td>Country :</td>
                <td><%=c.getAdresse().getCountry()%></td>
            </tr>
        </table>
</body>
</html>