<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="area.page.titreModif"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>

        <form:form method="post" modelAttribute="updateAreaJSP" action="updateListArea">
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
                    <c:forEach items="${updateAreaJSP.listArea}" var="area" varStatus="status">

                      	<tr>
							<td><input name="listArea[${status.index}].id" value="${area.id}" readonly/></td>
							<td><input name="listArea[${status.index}].id_area" value="${area.id_area}"/></td>
							<td><input name="listArea[${status.index}].id_country" value="${area.id_country}"/></td>
							<td><input name="listArea[${status.index}].language_id" value="${area.language_id}"/></td>
							<td><input name="listArea[${status.index}].area_label" value="${area.area_label}"/></td>
						</tr>
						
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit"/>
        </form:form>
    </body>
</html>