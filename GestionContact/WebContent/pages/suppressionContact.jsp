
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<% int id = Integer.parseInt(request.getParameter("id")); %>


<html:html>
<head>
<title><bean:message key="delete.contact" /></title>
<html:base/>
</head>
<body bgcolor="white">
	<html:form action="/DeleteContact"> 
		<html:errors />
		<table>
			<tr>
				<td align="center" colspan="2"><font size="4"><bean:message key="suppressioncontactform.titre" /></font>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="modificationContactForm.id" /></td>
				<td align="left"> <html:text readonly="true" property="id" size="30"
						maxlength="30" value="<%=Integer.toString(id)%>" /> </td>
			</tr>
			<tr>
				<td align="right"><html:submit><bean:message key="suppressioncontactform.submit" /></html:submit></td>
			</tr>
		</table>
	</html:form>
</body>
</html:html>