<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="language.page.titreModif"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>
    
        <form:form method="post" modelAttribute="updateLanguageJSP" action="updateListLanguage">
            <table border="1">
                <thead>
                    <tr>
                	<th><spring:message code="colonne.language.id"/></th>
                    <th><spring:message code="colonne.language.idLanguage"/></th>
                    <th><spring:message code="colonne.language.languageCode"/></th>
                    <th><spring:message code="colonne.language.languageName"/></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${updateLanguageJSP.listLanguage}" var="language" varStatus="status">

                      	<tr>
                      		<td><input name="listLanguage[${status.index}].id" value="${language.id}" readonly/></td>
							<td><input name="listLanguage[${status.index}].language_id" value="${language.language_id}"/></td>
							<td><input name="listLanguage[${status.index}].language_code" value="${language.language_code}"/></td>
							<td><input name="listLanguage[${status.index}].language_name" value="${language.language_name}"/></td>
						</tr>
						
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit"/>
        </form:form>
    </body>
</html>