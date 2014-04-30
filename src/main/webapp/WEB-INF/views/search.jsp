<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!--
 
TODO:

for each schleife über neugikeiten iterieren und die letzten X neuigkeiten anzeigen

 -->

<html>
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
<body>
	<div class="container">
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
					<div class="panel-heading">Suche</div>
            <div class="panel-body">
             	<c:forEach items="${recipes}" var="recipe">
             		<div class="row">
                		<div class="col-md-4">
                			<c:if test="${!recipe.images.isEmpty()}">
                  				<img src="${recipe.images.get(0).getResourcesPath()}" width="100" height="100">
                 			</c:if>
                  			<c:if test="${recipe.images.isEmpty()}">
                  				<img src="<c:url value="/resources/images/notfound.jpg" />" width="100" height="100">
                  			</c:if>
                		</div>
                		<div class="col-md-8">
	                  		<h5><a href="/recipe/${recipe.id}"><b>${recipe.title}</b></a></h5>
	                  		<a href="/recipe/${recipe.id}">
		                  		${recipe.description}                    
		                  		<br>                    
		                  		<i>Dauer: ${recipe.preparationEndurance} min / ${recipe.totalEndurance} min Backofen</i>                    
	                  		</a><br>
	                  		Wertung: 
		                  <i class="fa fa-star"></i>
		                  <i class="fa fa-star"></i>
		                  <i class="fa fa-star"></i>
		                  <i class="fa fa-star"></i>
		                  <i class="fa fa-star-o"></i>
		                  <p></p>
	               		</div>
              		</div>
             	</c:forEach>
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
