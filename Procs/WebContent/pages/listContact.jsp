<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="servlet.ListContactControllerServlet"%>
<%@page import="entities.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.* ,domain.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des contact</title>
<%
	List<Contact> list = (List<Contact>) request.getAttribute("listContact");
%>
<table class="table table-striped table-hover table-bordered">
	<tbody>
		<tr>
			<th>Id</th>
			<th>Prenom</th>
			<th>Nom</th>
			<th>Email</th>
			<th>Afficher</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>
		<%
			for (Contact c : list) {
		%>
		<tr>
			<td><%=c.getId()%></td>
			<td><%=c.getFirstName()%></td>
			<td><%=c.getLastName()%></td>
			<td><%=c.getEmail()%></td>
			<td><form
					action="${pageContext.request.contextPath}/listContact"
					method="post">
					<p />
					<input type="hidden" name="id" value="<%=c.getId()%>" />
					<input type="submit" value="Afficher Contact" />
				</form></td>
			<td><button
					onclick="window.location.href = 'pages/supprimerContact.jsp';">Modifier
					Contact</button></td>
			<td><button
					onclick="window.location.href = 'pages/supprimerContact.jsp';">Supprimer
					Contact</button></td>
		</tr>
		<%
			}
		%>
	</tbody>


</table>
</head>
<body>

</body>
</html>