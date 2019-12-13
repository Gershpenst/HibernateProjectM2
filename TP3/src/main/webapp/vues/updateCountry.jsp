<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="country.page.titreModif"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>

        <form:form method="post" modelAttribute="updateCountriesJSP" action="updateListCountries">
            <table border="1">
                <thead>
                    <tr>
                	<th><spring:message code="colonne.country.id"/></th>
                    <th><spring:message code="colonne.country.idCountry"/></th>
                    <th><spring:message code="colonne.country.code_iso"/></th>	
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${updateCountriesJSP.listCountries}" var="country" varStatus="status">
                        <tr>
                            <td>
                                <c:out value="${country.id}"/>
                                <input type="hidden" name="listCountries[${status.index}].id" value="${country.id}"/>
                            </td>
                            <td>
                            <input type="text" name="listCountries[${status.index}].id_country" value="${country.id_country}"/><br/>
                                <b><i><form:errors path="listCountries[${status.index}].id_country" /></i></b>
                            </td>
                            <td>
                                <input type="text" name="listCountries[${status.index}].code_iso" value="${country.code_iso}"/><br/>
                                <b><i><form:errors path="listCountries[${status.index}].code_iso" /></i></b>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit"/>
        </form:form>
    </body>
</html>