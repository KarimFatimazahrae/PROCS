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
    
    <!--Groupe  -->
    <h1>Ajouter un Groupe</h1>
    <button onclick="window.location.href = 'pages/ajouterGroupe.jsp';">Ajouter Groupe</button>
    
    <h1>Supprimer un Groupe</h1>
    <button onclick="window.location.href = 'pages/supprimerGroupe.jsp';">Supprimer Groupe</button>
    
<%--     <h1>Liste de tous les groupes</h1>
    <form action="${pageContext.request.contextPath}/AfficherGroupe" method="post">
    <p />
        <input type="submit" value="Afficher" />
    </form>
 --%>    
    <h1>Liste de tous les Groupes</h1>
    <form action="${pageContext.request.contextPath}/listGroup" method="post">
    <p />
        <input type="submit" value="Afficher Groupes" />
    </form>
    
</body>
</html>