<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ page import="org.lip6.struts.domain.Contact" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<% int id = Integer.parseInt(request.getParameter("id"));System.out.println(request.getAttribute("listeGroupes")); %>

<html:html>
<head>
<title><bean:message key="update.contact" /></title>
<html:base />
</head>
<body bgcolor="white">
<html:form action="/UpdateContact" >
<html:errors />
<table>
<tr>
<td align="center" colspan="2"><font size="4"><bean:message key="modificationContactForm.titre" /></font>
</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.id" /></td>
<td align="left"> <html:text readonly="true" property="id" size="30"
maxlength="30" value="<%=Integer.toString(id)%>" /> </td>
</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.firstname" /></td>
<td align="left"><html:text  property="firstName" size="30"
maxlength="30"  ></html:text></td>
</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.lastname" /></td>
<td align="left"><html:text  property="lastName" size="30"
maxlength="30" /></td>
</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.email" /></td>
<td align="left"><html:text  property="email" size="30"
maxlength="30" /></td>
</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.mobile" /></td>
<td align="left"><html:text property="mobile" size="30"
maxlength="30" /></td>
</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.fixe" /></td>
<td align="left"><html:text  property="fixe" size="30"
maxlength="30" /></td>
</tr>
<tr>
<td align="right"><bean:message key="creationcontactform.group" /></td>
	<td align="left"><html:select property="group" >
				
	<c:forEach var="groupe" items="${listeGroupes}">
	<html:option value="${groupe.groupId}">${groupe.groupName}</html:option>
	</c:forEach>
     </html:select></td>
	</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.rue" /></td>
<td align="left"><html:text property="rue" size="30"
maxlength="30" /></td>
</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.ville" /></td>
<td align="left"><html:text  property="ville" size="30"
maxlength="30" /></td>
</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.cp" /></td>
<td align="left"><html:text  property="cp" size="30"
maxlength="30"  /></td>
</tr>
<tr>
<td align="right"><bean:message key="modificationContactForm.pays" /></td>
<td align="left"><html:text  property="pays" size="30"
maxlength="30"  /></td>
</tr>
<tr>
<td align="right"><html:submit><bean:message key="modificationContactForm.submit" /></html:submit></td>
</tr>
</table>
</html:form>
</body>
</html:html>