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
		<title><spring:message code="country.page.titreSuppr"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>
    
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
                        
                        <td>
                            <c:url value="/country/subCountryInList" var="url">
                                <c:param name="idCountry" value="${country.id}"/>
                            </c:url>
                            <a href="${url}">
                                <spring:message code="suppression.supprimer.libelle" />
                            </a>
                        </td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>