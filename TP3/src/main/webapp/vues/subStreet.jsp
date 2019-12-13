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
		<title><spring:message code="street.page.titreSuppr"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>

        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.street.id"/></th>
                    <th><spring:message code="colonne.street.idZip"/></th>
                    <th><spring:message code="colonne.street.idStreetName"/></th>
                    <th><spring:message code="colonne.street.idStreet"/></th>
                    <th><spring:message code="colonne.street.streetNameLabel"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listStreet}" var="street">
                    <tr>
                        <td><c:out value="${street.id}"/></td>
                        <td><c:out value="${street.id_zip}"/></td>
                        <td><c:out value="${street.id_street_name}"/></td>
                        <td><c:out value="${street.id_city}"/></td>
                        <td><c:out value="${street.street_label_name}"/></td>
                        
                        <td>
                            <c:url value="/street/subStreetInList" var="url">
                                <c:param name="idStreet" value="${street.id}"/>
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