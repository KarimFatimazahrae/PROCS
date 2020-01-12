<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="servlet.ListContactControllerServlet"%>
<%@page import="entities.Contact"%>
<%@page import="entities.PhoneNumber"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier un Contact Form</title>
<%
	Contact c = (Contact) request.getAttribute("Contact");
%>
</head>
<body>
    <h1>Modifier un Contact</h1>
    <form action="${pageContext.request.contextPath}/modifierContact2" method="post">
        <table cellpadding="3pt">
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="firstName" value=<%=c.getFirstName()%> size="30" /></td>
            </tr>
            <tr>
                <td>Last Name :</td>
                <td><input type="text" name="lastName" value=<%=c.getLastName()%> size="30" /></td>
            </tr>
 
            <tr>
                <td>email :</td>
                <td><input type="text" name="email" value=<%=c.getEmail()%> size="30" /></td>
            </tr>
             <%
			for (PhoneNumber tel : c.getTels()) {
			%>
			<tr>
                <td>Phone Kind :</td>
                <td><input type="text" name="email" value=<%=tel.getPhoneKind()%> size="30" /></td>
            </tr>
            <tr>
                <td>Phone Number :</td>
                <td><input type="text" name="email" value=<%=tel.getPhoneNumber()%> size="30" /></td>
            </tr>
            <%
			}
			%><tr>
                <td>street :</td>
                <td><input type="text" name="street" value=<%=c.getAdresse().getStreet()%> size="30" /></td>
            </tr>
            <tr>
                <td>City :</td>
                <td><input type="text" name="city" value=<%=c.getAdresse().getCity()%> size="30" /></td>
            </tr>
            <tr>
                <td>ZipCode :</td>
                <td><input type="text" name="zip" value=<%=c.getAdresse().getZip()%> size="30" /></td>
            </tr>
            <tr>
                <td>Country :</td>
                <td><input type="text" name="country" value=<%=c.getAdresse().getCountry()%> size="30" /></td>
            </tr>
        </table>
        <p />
        <input type="submit" value="modifier" />
    </form>
</body>
</html>