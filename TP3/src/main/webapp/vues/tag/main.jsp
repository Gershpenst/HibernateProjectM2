<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/main.css" />
	</head>
	<body>
	<nav>
	  <ul>
	  	<li class="deroulant"><a href="http://localhost:8080/TP3/index.jsp"><spring:message code="search.page.home"/></a>
	    </li>
	    <li class="deroulant"><a href="http://localhost:8080/TP3/country/printCountry"><spring:message code="search.page.country"/></a>
	      <ul class="sous">
	        <li><a href="http://localhost:8080/TP3/country/printCountry"><spring:message code="search.page.create"/></a></li>
	        <li><a href="http://localhost:8080/TP3/country/updCountry"><spring:message code="search.page.update"/></a></li>
	        <li><a href="http://localhost:8080/TP3/country/subCountry"><spring:message code="search.page.substract"/></a></li>
	      </ul>
	    </li>
	    <li class="deroulant"><a href="http://localhost:8080/TP3/street/printStreet"><spring:message code="search.page.street"/> </a>
	      <ul class="sous">
	        <li><a href="http://localhost:8080/TP3/street/printStreet"><spring:message code="search.page.create"/></a></li>
	        <li><a href="http://localhost:8080/TP3/street/updStreet"><spring:message code="search.page.update"/></a></li>
	        <li><a href="http://localhost:8080/TP3/street/subStreet"><spring:message code="search.page.substract"/></a></li>
	      </ul>
	    </li>
	    <li class="deroulant"><a href="http://localhost:8080/TP3/area/printArea"><spring:message code="search.page.area"/> </a>
	        <ul class="sous">
		        <li><a href="http://localhost:8080/TP3/area/printArea"><spring:message code="search.page.create"/></a></li>
		        <li><a href="http://localhost:8080/TP3/area/updArea"><spring:message code="search.page.update"/></a></li>
		        <li><a href="http://localhost:8080/TP3/area/subArea"><spring:message code="search.page.substract"/></a></li>
	      	</ul>
	    </li>
	    <li class="deroulant"><a href="http://localhost:8080/TP3/city/printCity"><spring:message code="search.page.city"/></a>
	       	<ul class="sous">
		        <li><a href="http://localhost:8080/TP3/city/printCity"><spring:message code="search.page.create"/></a></li>
		        <li><a href="http://localhost:8080/TP3/city/updCity"><spring:message code="search.page.update"/></a></li>
		        <li><a href="http://localhost:8080/TP3/city/subCity"><spring:message code="search.page.substract"/></a></li>
	     	</ul>
	    </li>
	    <li class="deroulant"><a href="http://localhost:8080/TP3/language/printLanguage"><spring:message code="search.page.language"/></a>
	        <ul class="sous">
		        <li><a href="http://localhost:8080/TP3/language/printLanguage"><spring:message code="search.page.create"/></a></li>
		        <li><a href="http://localhost:8080/TP3/language/updLanguage"><spring:message code="search.page.update"/></a></li>
		        <li><a href="http://localhost:8080/TP3/language/subLanguage"><spring:message code="search.page.substract"/></a></li>
	      	</ul>
	     </li>
	     
	     <li class="deroulant"><a href="http://localhost:8080/TP3/search/printSearch"><spring:message code="search.page.search"/></a></li>    
	     
	  </ul>
	</nav>
	</body>
</html>
	