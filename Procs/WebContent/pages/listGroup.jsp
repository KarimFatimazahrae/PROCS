<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="servlet.ListGroupControllerServlet"%>
<%@page import="entities.ContactGroup"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.* ,domain.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Groupes</title>
<%
	List<ContactGroup> list = (List<ContactGroup>) request.getAttribute("listGroup");
	System.out.println("\n");
	System.out.println(String.valueOf(list));
%>
<table class="table table-striped table-hover table-bordered">
	<tbody>
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Afficher</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>
		<%
			for (ContactGroup g : list) {
		%>
		<tr>
			<td><%=g.getGroupId()%></td>
			<td><%=g.getGroupName()%></td>
			<td><form
					action="${pageContext.request.contextPath}/listGroup"
					method="post">
					<p />
					<input type="hidden" name="id" value="<%=g.getGroupId()%>" />
					<input type="submit" value="Afficher Groupe" />
				</form></td>
			<td><form
					action="${pageContext.request.contextPath}/supprimerGroupFromList" method="post">
					<p />
					<input type="hidden" name="id" value="<%=g.getGroupId()%>" />
					<input type="submit" value="Supprimer Groupe" />
				</form></td>
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