<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un Contact Form</title>
</head>
<body>
    <h1>Ajouter un Contact</h1>
    <form action="${pageContext.request.contextPath}/ajouterGroupe" method="post">
        <table cellpadding="3pt">
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="groupName" size="30" /></td>
            </tr>
            
        </table>
        <p />
        <input type="submit" value="Ajouter" />
    </form>
</body>
</html>