<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="city.page.titreModif"/></title>
		<link href="<c:url value="/vues/css/styles.css" />" rel="stylesheet">
		<jsp:include page="/vues/tag/main.jsp" />
    </head>
    <body>
    
    <h4>Choix: </h4>
	<form:form id="myForm1" method="post" action="hello">
		<button type="submit" name="button" value="button1"> << </button>  
		<button type="submit" name="button" value="button2"> < </button>  
		<button type="submit" name="button" value="button3"> > </button>  
		<button type="submit" name="button" value="button4"> >> </button>  
	</form:form>
	

        <form:form method="post" modelAttribute="updateCityJSP" action="updateListCity">
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
                    <c:forEach items="${updateCityJSP.listCity}" var="city" varStatus="status">

                      	<tr>
							<td><input name="listCity[${status.index}].id" value="${city.id}" readonly/></td>
							<td><input name="listCity[${status.index}].id_city" value="${city.id_city}"/></td>
							<td><input name="listCity[${status.index}].id_area" value="${city.id_area}"/></td>
							<td><input name="listCity[${status.index}].id_zip" value="${city.id_zip}"/></td>
							<td><input name="listCity[${status.index}].city_name" value="${city.city_name}"/></td>
							<td><input name="listCity[${status.index}].zip_label" value="${city.zip_label}"/></td>
						</tr>
						
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit"/>
        </form:form>
    </body>
</html>