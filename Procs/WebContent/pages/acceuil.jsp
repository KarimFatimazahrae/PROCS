<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form des ajouts de contacts</title>
</head>
<body>
    <h1>Ajouter un Contact</h1>
    <button onclick="window.location.href = 'pages/ajouterContact.jsp';">Ajouter Contact</button>
    
    <h1>Supprimer un Contact</h1>
    <button onclick="window.location.href = 'pages/supprimerContact.jsp';">Supprimer Contact</button>
    
    <h1>Liste de tous les Contacts</h1>
    <form action="${pageContext.request.contextPath}/listContact" method="post">
    <p />
        <input type="submit" value="Afficher" />
    </form>
</body>
</html>