<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<title><spring:message code="country.page.titreAjout"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>

		 <form:form method="post" modelAttribute="creation" action="createCountry">
		 	
			<form:input path="id" id="id" type="hidden" value="42"/><br>
		 
			<spring:message code="colonne.country.idCountry" />
			<form:input path="id_country" id="id_country"/>
			<b><i><form:errors path="id_country" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.country.code_iso"/>
			<form:input path="code_iso" id="code_iso" />
			<b><i><form:errors path="code_iso" cssclass="error"/></i></b><br>
			
			<input type="submit"/>
		</form:form>
    
    
    		<%-- 
    	   <a href="index.jsp"><spring:message code="lien.retour.accueil"/></a>
    	   <h3><spring:message code="pays.liste.identifiant"/></h3>
    	   --%>
    	   
        <table border="1">
            <thead>
                <tr>
                	<th><spring:message code="colonne.country.id"/></th>
                    <th><spring:message code="colonne.country.idCountry"/></th>
                    <th><spring:message code="colonne.country.code_iso"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listCountry}" var="country">
                    <tr>
                        <td><c:out value="${country.id}"/></td>
                        <td><c:out value="${country.id_country}"/></td>
                        <td><c:out value="${country.code_iso}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>


<%--
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.listecourses"/></title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.id"/></th>
                    <th><spring:message code="colonne.code_iso"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listCountries}" var="pays">
                    <tr>
                        <td><c:out value="${pays.id}"/></td>
                        <td><c:out value="${pays.code_iso}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
--%>