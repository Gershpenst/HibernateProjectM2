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
		<title><spring:message code="city.page.titreAjout"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>
    
		 <form:form method="post" modelAttribute="creation" action="createCity">
			<form:input path="id" id="id" type="hidden" value="42"/><br>
			
			<spring:message code="colonne.city.idArea"/>
			<form:input path="id_area" id="id_area" />
			<b><i><form:errors path="id_area" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.city.idCity"/>
			<form:input path="id_city" id="id_city" />
			<b><i><form:errors path="id_city" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.city.idZip"/>
			<form:input path="id_zip" id="id_zip" />
			<b><i><form:errors path="id_zip" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.city.cityName"/>
			<form:input path="city_name" id="city_name" />
			<b><i><form:errors path="city_name" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.city.zipLabel"/>
			<form:input path="zip_label" id="zip_label" />
			<b><i><form:errors path="zip_label" cssclass="error"/></i></b><br>
			
			<input type="submit"/>
		</form:form>
    

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
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

