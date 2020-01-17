<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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


Contact c = new Contact("kk","k","k.k@gmail/com");
ContactDAO cd = new ContactDAO();
cd.addContact(c);

cd.ReadContact(1);
Contact cc = cd.ReadContact(1);
System.out.println(cc.toString());
long id =1;
//cd.deleteContact(id);

%>


</body>
</html> --%>