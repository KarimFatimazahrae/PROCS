<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/w3.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/w3-theme-black.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-amesome.min.css" />
    
</head>
<body>
<!-- Sidebar on click -->
<nav class="w3-sidebar w3-bar-block w3-white w3-card w3-animate-left w3-xxlarge" style="display:none;z-index:2" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-display-topright w3-text-teal">Close
    <i class="fa fa-remove"></i>
  </a>
  <a href="#" class="w3-bar-item w3-button">Accueil</a>
  <a href="ContactCreation.do" class="w3-bar-item w3-button">Link1</a>
  <a href="#" class="w3-bar-item w3-button">Link 3</a>
  <a href="#" class="w3-bar-item w3-button">Link 4</a>
  <a href="#" class="w3-bar-item w3-button">Link 5</a>
</nav>

<!-- Navbar : https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_templates_website&stacked=h -->
<div class="w3-top">

 <div class="w3-bar w3-theme-d2 w3-left-align">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="http://localhost:8080/GestionContact/" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="http://localhost:8080/GestionContact/" class="w3-bar-item w3-button w3-teal"><i class="fa fa-home w3-margin-right"></i>Accueil</a>
      <a href="http://localhost:8080/GestionContact/ContactCreation.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><bean:message
key="main.addcontact.link"/></a>
      <!-- <a href="ContactModification.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><bean:message
key="main.updatecontact.link"/></a>
      <a href="ContactSuppression.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><bean:message
key="main.deletecontact.link"/></a>-->
<a href="http://localhost:8080/GestionContact/ListeContacts.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><bean:message
key="main.listeContacts.link"/></a>
<a href="http://localhost:8080/GestionContact/SearchContact.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><bean:message
key="main.searchContact.link"/></a>
      <a href="http://localhost:8080/GestionContact/GroupeCreation.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><bean:message
key="main.addgroup.link"/></a>
      <a href="http://localhost:8080/GestionContact/GroupeModification.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><bean:message
key="main.updategroup.link"/></a>
      <a href="http://localhost:8080/GestionContact/GroupeSuppression.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><bean:message
key="main.deletegroup.link"/></a>

 <!-- <a href="ListeContacts.do" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><bean:message
key="main.listeContacts.link"/></a>-->
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-right w3-hover-teal" title="Search"><i class="fa fa-search"></i></a>
 </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium">
    <a href="#team" class="w3-bar-item w3-button">Team</a>
    <a href="#work" class="w3-bar-item w3-button">Work</a>
    <a href="#pricing" class="w3-bar-item w3-button">Price</a>
    <a href="#contact" class="w3-bar-item w3-button">Contact</a>
    <a href="#" class="w3-bar-item w3-button">Search</a>
  </div>
</div>
