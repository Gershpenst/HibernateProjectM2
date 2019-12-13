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
		<title><spring:message code="street.page.titreAjout"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>

		 <form:form method="post" modelAttribute="creation" action="createStreet">
		 
			<form:input path="id" id="id" type="hidden" value="42"/><br>
			
			<spring:message code="colonne.street.idZip" />
			<form:input path="id_zip" id="id_zip"/>
			<b><i><form:errors path="id_zip" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.street.idStreet"/>
			<form:input path="id_street_name" id="id_street_name" />
			<b><i><form:errors path="id_street_name" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.street.idStreetName"/>
			<form:input path="id_city" id="id_city" />
			<b><i><form:errors path="id_city" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.street.streetNameLabel"/>
			<form:input path="street_label_name" id="street_label_name" />
			<b><i><form:errors path="street_label_name" cssclass="error"/></i></b><br>
			
			<input type="submit"/>
		</form:form>
    

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
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>