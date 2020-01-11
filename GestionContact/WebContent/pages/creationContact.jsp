<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html:html>
<head>
<title><bean:message key="add.contact" /></title>
<html:base />
</head>
<body bgcolor="white">
<jsp:include page="header.jsp"/>
	<html:form action="/AddContact">
		<html:errors />
		<table>
			<tr>
				<td align="center" colspan="2"><font size="4"><bean:message key="creationcontactform.titre" /></font>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="creationcontactform.firstname" /></td>
				<td align="left"><html:text property="firstName" size="30"
						maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="creationcontactform.lastname" /></td>
				<td align="left"><html:text property="lastName" size="30"
						maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="creationcontactform.email" /></td>
				<td align="left"><html:text property="email" size="30"
						maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="creationcontactform.mobile" /></td>
				<td align="left"><html:text property="mobile" size="30"
						maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="creationcontactform.fix" /></td>
				<td align="left"><html:text property="fix" size="30"
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
				<td align="right"><bean:message key="creationcontactform.rue" /></td>
				<td align="left"><html:text property="rue" size="30"
						maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="creationcontactform.ville" /></td>
				<td align="left"><html:text property="ville" size="30"
						maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="creationcontactform.cp" /></td>
				<td align="left"><html:text property="cp" size="30"
						maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="creationcontactform.pays" /></td>
				<td align="left"><html:text property="pays" size="30"
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