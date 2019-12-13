<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="street.page.titreModif"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>

        <form:form method="post" modelAttribute="updateStreetJSP" action="updateListStreet">
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
                    <c:forEach items="${updateStreetJSP.listStreet}" var="street" varStatus="status">

                      	<tr>
							<td><input name="listStreet[${status.index}].id" value="${street.id}"/></td>
							<td><input name="listStreet[${status.index}].id_zip" value="${street.id_zip}"/></td>
							<td><input name="listStreet[${status.index}].id_street_name" value="${street.id_street_name}"/></td>
							<td><input name="listStreet[${status.index}].id_city" value="${street.id_city}"/></td>
							<td><input name="listStreet[${status.index}].street_label_name" value="${street.street_label_name}"/></td>
						</tr>
						
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit"/>
        </form:form>
    </body>
</html>