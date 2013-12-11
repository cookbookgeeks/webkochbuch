<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!-- 
TODO:
Abfrage ob User eingeloggt für rechte Sidebar
 -->
<html>
<head>
	<title>Webkochbuch</title>
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"  />" />
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
			<div class="panel-heading">
				Kategorien
            </div>
            <div class="panel-body">
            <p>
            <h4>Ver&uuml;gbare Kategorien:</h4>
            </p>
            <ul>
            	<a href="/category/0"><li class="">Kochen</li></a>
            	<a href="/category/1"><li class="">Backen</li></a>
            	<a href="/category/2"><li class="">Desert</li></a>
            	
            </ul>
            </div>
            <div class="panel-footer">
              <a href="javascript:history.back()"><i class="fa fa-arrow-left"></i>&nbsp; Zur&uuml;ck zur vorherigen Seite</a>
            </div>
			
          </div>
        </div>
        <div class="col-md-3">
        		
          <div class="panel panel-default">
				<%@ include file="rightSB.jsp" %>
          </div>
        </div>
      </div>
    <div class="container">
      <footer>
    		<%@ include file="footer.jsp" %>
      </footer>
    </div>

</body>
</html>
