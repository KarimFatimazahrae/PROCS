<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="servlet.ListContactControllerServlet"%>
<%@page import="entities.ContactGroup"%>
<%@page import="entities.PhoneNumber"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher le groupe</title>
<%
	ContactGroup g = (ContactGroup) request.getAttribute("ContactGroup");
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
            
        </table>
</body>
</html>