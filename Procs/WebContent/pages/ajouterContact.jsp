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
    <form action="${pageContext.request.contextPath}/ajouterContact" method="post">
        <table cellpadding="3pt">
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="firstName" size="30" /></td>
            </tr>
            <tr>
                <td>Last Name :</td>
                <td><input type="text" name="lastName" size="30" /></td>
            </tr>
 
            <tr>
                <td>email :</td>
                <td><input type="text" name="email" size="30" /></td>
            </tr>
            <tr>
                <td>Phone :</td>
                <td><input type="text" name="phone" size="30" /></td>
            </tr>
            <tr>
                <td>street :</td>
                <td><input type="text" name="street" size="30" /></td>
            </tr>
            <tr>
                <td>City :</td>
                <td><input type="text" name="city" size="30" /></td>
            </tr>
            <tr>
                <td>ZipCode :</td>
                <td><input type="text" name="zip" size="30" /></td>
            </tr>
            <tr>
                <td>Country :</td>
                <td><input type="text" name="country" size="30" /></td>
            </tr>
        </table>
        <p />
        <input type="submit" value="Ajouter" />
    </form>
</body>
</html>