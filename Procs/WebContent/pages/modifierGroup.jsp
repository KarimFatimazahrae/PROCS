<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="servlet.ListContactControllerServlet"%>
<%@page import="entities.ContactGroup"%>
<%@page import="entities.PhoneNumber"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier un groupe</title>
<%
	ContactGroup g = (ContactGroup) request.getAttribute("ContactGroup");
%>
</head>
<body>
    <h1>Modifier un Groupe</h1>
    <form action="${pageContext.request.contextPath}/modifierGroup2" method="post">
        <table cellpadding="3pt">
            <tr>
                <td><input type="hidden" name="groupId" value=<%=g.getGroupId()%> size="30" /></td>
            </tr>
            <tr>
                <td>GroupName:</td>
                <td><input type="text" name="groupName" value=<%=g.getGroupName()%> size="30" /></td>
            </tr>
         
        </table>
        <p />
        <input type="submit" value="modifier" />
    </form>
</body>
</html>