<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<html:html>
<head>
<title><bean:message key="add.group" /></title>
<html:base />
</head>
<body bgcolor="white">
 <jsp:include page="header.jsp"/>
	<html:form action="/AddGroup">
		<html:errors />
		<table>
			<tr>
				<td align="center" colspan="2"><font size="4"><bean:message key="creationgroupform.titre" /></font>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="creationgroupform.name" /></td>
				<td align="left"><html:text property="groupName" size="30"
						maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit><bean:message key="creationcontactform.submit" /></html:submit></td>
			</tr>
		</table>
	</html:form>
 <jsp:include page="footer.jsp"/>
</body>
</html:html>