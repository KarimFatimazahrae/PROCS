<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supprimer un Groupe</title>
</head>
<body>
    <h1>Supprimer un Contact</h1>
    <form action="${pageContext.request.contextPath}/supprimerGroupe" method="post">
        <table cellpadding="3pt">
            <tr>
                <td>Group Name:</td>
                <td><input type="text" name="groupname" size="30" /></td>
            </tr>
            
        </table>
        <p />
        <input type="submit" value="Supprimer" />
    </form>
</body>

</html>