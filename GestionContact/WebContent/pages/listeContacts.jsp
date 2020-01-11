<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<html:html>
<head>
<link rel="stylesheet" type="text/css" href="/DataTables/datatables.css">
 
<script type="text/javascript" charset="utf8" src="/DataTables/datatables.js"></script>
</head>
<body>
 <jsp:include page="header.jsp"/>
 <div id="myTable" style="margin-top:100px;">
 <table >
   <thead>
       <tr>
           <th>ID</th><th>Nom</th><th>Prénom</th><th>Email</th><th>Adresse</th><th>Téléphones</th><th>Modification</th><th>Suppression</th>
       </tr>
   </thead>
   <tbody> 
   <logic:iterate name="listeContacts" id="listUserId">
<tr>
	<td><bean:write name="listUserId" property="id"/></td> 
	<td><bean:write name="listUserId" property="firstName"/></td>
	<td><bean:write name="listUserId" property="lastName"/></td>
	<td><bean:write name="listUserId" property="email"/></td>
	<td><bean:write name="listUserId" property="rue"/><br/>
	<bean:write name="listUserId" property="cp"/> <bean:write name="listUserId" property="ville"/> (<bean:write name="listUserId" property="pays"/>)</td>
	<td><bean:write name="listUserId" property="fixe"/> / <bean:write name="listUserId" property="mobile"/></td>
	<td><a href="AfficheContact.do?id=<bean:write name="listUserId" property="id"/>">Modifier le profil</a></td><!-- &id=<bean:write name="listUserId" property="id"/> -->
	<td><a href="SupprimeContact.do?id=<bean:write name="listUserId" property="id"/>">Supprimer le contact</a></td>
</tr>
</logic:iterate>

   </tbody>
</table></div>
 <jsp:include page="footer.jsp"/>
 <script type="text/javascript">
 $(document).ready( function () {
	    $('#personTable').DataTable();
	} );
 </script>
 
</body>
</html:html>