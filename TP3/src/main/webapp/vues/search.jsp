<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<title><spring:message code="search.page.titre"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />	
    </head>
    <body>
    	<br>
    	<h1>Rechercher</h1>
    	<br>
		 <form:form id="myForm" method="post" modelAttribute="creation" action="createSearch">

			<script>
			function refreshAndSubmit() {
				document.getElementById("myForm").submit();
			}
			</script>
	
		 	<p>
				<strong>Country: </strong>
				<form:select path="country_code_iso" onchange="refreshAndSubmit()"> 
					<form:option value="" label="--- Rechercher ---"/>
					<form:options items="${listCountryCodeIso}"/>
				</form:select>
			</p>
			
			
			<c:choose>
			    <c:when test="${areaBool}">
					<p>
						<strong>Area: </strong>
						<form:select path="area_label" onchange="refreshAndSubmit()"> 
							<form:option value="" label="--- Rechercher ---"/>
							<form:options items="${listAreaLabel}"/>
						</form:select>
					</p>
			    </c:when>    
			    <c:otherwise>
					<p>
						<strong>Area: </strong>
						<form:select path="area_label"> 
							<form:option value="" label="--- Rechercher ---"/>
						</form:select>
					</p>
			    </c:otherwise>
			</c:choose>
			
			
			<c:choose>
			    <c:when test="${cityBool}">
					<p>
						<strong>City: </strong>
						<form:select path="city_name" onchange="refreshAndSubmit()"> 
							<form:option value="" label="--- Rechercher ---"/>
							<form:options items="${listCityName}"/>
						</form:select>
					</p>
			    </c:when>    
			    <c:otherwise>
					<p>
						<strong>City: </strong>
						<form:select path="city_name" onchange="refreshAndSubmit()"> 
							<form:option value="" label="--- Rechercher ---"/>
						</form:select>
					</p>
			    </c:otherwise>
			</c:choose>
	
			
			<c:choose>
			    <c:when test="${streetBool}">
				 	<p>
				 		<strong>Street: </strong>
				        <form:select path="street_label_name" onchange="refreshAndSubmit()"> 
							<form:option value="" label="--- Rechercher ---"/>
							<form:options items="${listStreetLabel}"/>
						</form:select>
					</p>
			    </c:when>    
			    <c:otherwise>
				 	<p>
				 		<strong>Street: </strong>
				        <form:select path="street_label_name" onchange="refreshAndSubmit()"> 
							<form:option value="" label="--- Rechercher ---"/>
						</form:select>
					</p>
			    </c:otherwise>
			</c:choose>
			
			<input type="submit"/>
		</form:form>
    
    	<br>
    	<p>
    		<h2><strong>Output</strong></h2>
    		<p>
    			<strong>Pays: </strong>
    			<c:out value="${pays}"/>
    		</p>
    		
    		<p>
    			<strong>Région: </strong>
    			<c:out value="${region}"/>
    		</p>
    		
    		<p>
    			<strong>Langage: </strong>
    			<c:out value="${language}"/>
    		</p>
    		
    		<p>
    			<strong>Ville: </strong>
    			<c:out value="${ville}"/>
    		</p>
    		
    		<p>
    			<strong>Rue: </strong>
    			<c:out value="${rue}"/>
    		</p>
    	</p>
		<%--
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.street.id"/></th>
                    <th><spring:message code="colonne.street.idStreetName"/></th>
                    <th><spring:message code="colonne.street.idStreet"/></th>
                    <th><spring:message code="colonne.street.streetNameLabel"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listStreet}" var="street">
                    <tr>
                        <td><c:out value="${street.id}"/></td>
                        <td><c:out value="${street.id_street_name}"/></td>
                        <td><c:out value="${street.id_city}"/></td>
                        <td><c:out value="${street.street_label_name}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        --%>
        
    </body>
</html>

