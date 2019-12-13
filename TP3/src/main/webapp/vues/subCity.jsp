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
		<title><spring:message code="city.page.titreSuppr"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>

        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.city.id"/></th>
                    <th><spring:message code="colonne.city.idArea"/></th>
                    <th><spring:message code="colonne.city.idCity"/></th>
                    <th><spring:message code="colonne.city.idZip"/></th>                    
                    <th><spring:message code="colonne.city.cityName"/></th>
                    <th><spring:message code="colonne.city.zipLabel"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listCity}" var="city">
                    <tr>
                        <td><c:out value="${city.id}"/></td>
                        <td><c:out value="${city.id_area}"/></td>
                        <td><c:out value="${city.id_city}"/></td>
                        <td><c:out value="${city.id_zip}"/></td>
                        <td><c:out value="${city.city_name}"/></td>
                        <td><c:out value="${city.zip_label}"/></td>
                        
                        <td>
                            <c:url value="/city/subCityInList" var="url">
                                <c:param name="idCity" value="${city.id}"/>
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