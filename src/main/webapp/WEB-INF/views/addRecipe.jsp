<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Recipe</title>
</head>
<body>

<!-- TODO: Add input form and give the recipe via POST to the addRecipe controller method. -->
<c:url var="saveUrl" value="/recipe/adddata" />
<form:form modelAttribute="recipe" method="POST" action="${saveUrl}">
 <table>
  <tr>
   <td><form:label path="title">Titel:</form:label></td>
   <td><form:input path="title"/></td>
  </tr>
 
  <tr>
   <td><form:label path="description">Beschreibung</form:label></td>
   <td><form:input path="description"/></td>
  </tr>
   
  <tr>
   <td><form:label path="content">Inhalt:</form:label></td>
   <td><form:input path="content"/></td>
  </tr>
  
  <tr>
   <td><form:label path="preparationEndurance">Vorbereitungszeit:</form:label></td>
   <td><form:input path="preparationEndurance"/></td>
  </tr>
  
  <tr>
   <td><form:label path="totalEndurance">Komplett benötigte Zeit:</form:label></td>
   <td><form:input path="totalEndurance"/></td>
  </tr>
 </table>
 <input type="submit" value="Save" />
</form:form>

</body>
</html>