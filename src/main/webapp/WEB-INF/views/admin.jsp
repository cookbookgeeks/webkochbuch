<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
	<title>Webkochbuch</title>
    <meta name="viewport" content="width=device-width">
    
    <link rel="shortcut icon" href="<c:url value="/resources/icons/favicon.ico" />" type="image/x-icon">
	<link rel="icon" href="<c:url value="/resources/icons/favicon.ico" />" type="image/x-icon">
	
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/webkochbuch-main.css" />" />
    

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
					<div class="panel-heading">Admin-Seite
            </div>
            <div class="panel-body">
              <p>Dies ist die Test-Seite fuer das Admin-Backend</p>
              <br /><br /><br /><br />
              <p><u>Funktion mit abgefragtem Usernamen:</u></p>
              	<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h3>Username : ${pageContext.request.userPrincipal.name} 
                 | <a href="<c:url value="/logout" />" > Logout</a></h3>  
				</c:if>
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
