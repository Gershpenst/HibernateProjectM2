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
		<title><spring:message code="language.page.titreAjout"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>
    
		 <form:form method="post" modelAttribute="creation" action="createLanguage">
		 
		 	<form:input path="id" id="id" type="hidden" value="42"/><br>
		 
			<spring:message code="colonne.language.idLanguage" />
			<form:input path="language_id" id="language_id"/>
			<b><i><form:errors path="language_id" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.language.languageCode"/>
			<form:input path="language_code" id="language_code" />
			<b><i><form:errors path="language_code" cssclass="error"/></i></b><br>
			
			<spring:message code="colonne.language.languageName"/>
			<form:input path="language_name" id="language_name" />
			<b><i><form:errors path="language_name" cssclass="error"/></i></b><br>
			
			<input type="submit"/>
		</form:form>
    

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
                <c:forEach items="${listLanguage}" var="language">
                    <tr>
                    	<td><c:out value="${language.id}"/></td>
                        <td><c:out value="${language.language_id}"/></td>
                        <td><c:out value="${language.language_code}"/></td>
                        <td><c:out value="${language.language_name}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

