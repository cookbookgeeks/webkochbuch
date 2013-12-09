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
					<div class="panel-heading">Herzlich Wilkommen
            </div>
            <div class="panel-body">
              <p>Wilkommen im Kochbuch der Cookbookgeeks. Hier finden sich viele tolle, 
              leckere und interessante Rezepte, und in Zukunft auch eine Menge Scoialfeatures.</p>
              <br>
              <p>Neueste Rezepte:</p>
              	<table>
              		<tr>
              			<td>Bild</td>
              			<td>Nachrichten aus der Essenswelt</td>
              		</tr>
              	</table>
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
