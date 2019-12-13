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
		<title><spring:message code="area.page.titreAjout"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />		
    </head>
    <body>
    
		 <form:form method="post" modelAttribute="creation" action="createArea">
			
			<form:input path="id" id="id" type="hidden" value="42"/><br>
			
			<spring:message code="colonne.area.idArea"/>
			<form:input path="id_area" id="id_area" />
			<b><i><form:errors path="id_area" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.area.idCountry"/>
			<form:input path="id_country" id="id_country" />
			<b><i><form:errors path="id_country" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.area.idLanguage"/>
			<form:input path="language_id" id="language_id" />
			<b><i><form:errors path="language_id" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.area.idAreaLabel"/>
			<form:input path="area_label" id="area_label" />
			<b><i><form:errors path="area_label" cssclass="error"/></i></b><br>
			
			<input type="submit"/>
		</form:form>
    

        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.area.id"/></th>
                    <th><spring:message code="colonne.area.idArea"/></th>
                    <th><spring:message code="colonne.area.idCountry"/></th>
                    <th><spring:message code="colonne.area.idLanguage"/></th>
                    <th><spring:message code="colonne.area.idAreaLabel"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listArea}" var="area">
                    <tr>
                        <td><c:out value="${area.id}"/></td>
                        <td><c:out value="${area.id_area}"/></td>
                        <td><c:out value="${area.id_country}"/></td>
                        <td><c:out value="${area.language_id}"/></td>
                        <td><c:out value="${area.area_label}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

