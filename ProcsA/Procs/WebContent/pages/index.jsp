<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import = "entities.Contact"
    import = "domain.ContactDAO"
    import = "entities.PhoneNumber"
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%


Contact c = new Contact("fat","kar","k.F@gmail/com");
ContactDAO cd = new ContactDAO();
cd.addContact(c);

%>


</body>
</html>