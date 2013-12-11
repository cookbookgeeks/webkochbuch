<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Webkochbuch</title>
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/webkochbuch-main.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/summernote.css" />" />

    <script src="<c:url value="/resources/js/jquery.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>

</head>
<body><div class="container">
				
				<%@ include file="navbar.jsp" %>  

      </div>
      <header>
      
      	<%@ include file="header.jsp" %>
      </header>
      <div class="row">
        <div class="col-md-3">
          <div class="panel panel-default">
          		<%@ include file="leftSB.jsp" %>
			           
          </div>
        </div>
        <div class="col-md-6">
          <div class="panel panel-default">
					<div class="panel-heading">Rezept bearbeiten
            </div>
            <div class="panel-body">
              <!-- TODO: Add input form and give the recipe via POST to the editRecipe controller method. -->
              <div class="form-group">
<c:url var="saveUrl" value="/recipe/editdata" />
<form:form modelAttribute="recipe" method="POST" action="${saveUrl}">
 <form:hidden path="id" />
 <table>
  <tr>
   <td><form:label path="title">Titel:</form:label></td>
   <td><form:input path="title" class="form-control"/></td>
  </tr>
 
  <tr>
   <td><form:label path="description">Beschreibung</form:label></td>
   <td><form:input path="description" class="form-control"/></td>
  </tr>
   
  <tr>
   <td><form:label path="preparationEndurance">Vorbereitungszeit:</form:label></td>
   <td><form:input path="preparationEndurance" class="form-control"/></td>
  </tr>	
  
  <tr>
   <td><form:label path="totalEndurance">Gesamtzeit:</form:label></td>
   <td><form:input path="totalEndurance" class="form-control"/></td>
  </tr>
   
  <tr>
   <td><form:label path="content">Inhalt:</form:label></td>
   <td>
   <form:textarea path="content" cols="50" rows="10"  class="form-control"/></td>
  </tr>
 
 </table>
 <input type="submit" value="Save" class="btn btn-success"/>
 </div>
</form:form>
            </div>
            <div class="panel-footer">
              
            </div>
			
          </div>
        </div>
        <div class="col-md-3">
        		
          <div class="panel panel-default">
          
				<%@ include file="rightSB.jsp" %>
			
          </div>
        </div>
      </div>
    <div class="container" align="center">
      <footer>
    		<%@ include file="footer.jsp" %>
      </footer>
    </div>

</body>
</html>


