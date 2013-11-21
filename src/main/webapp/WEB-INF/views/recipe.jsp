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

    <link rel="stylesheet" href="<c:url value="resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="resources/css/font-awesome.css" />">
    <link rel="stylesheet" href="<c:url value="resources/css/webkochbuch-main.css" />">
        <link rel="stylesheet" href="<c:url value="resources/css/summernote.css" />">

    <script src="<c:url value="resources/js/jquery.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="resources/js/bootstrap.min.js" />" type="text/javascript"></script>
    
    <script src="resources/js/summernote.min.js" type="text/javascript"></script>
    
    <script>
$(document).ready(function() {
  $('#summernote').summernote();
});

  $('.summernote').summernote({
  toolbar: [
    //['style', ['style']], // no style button
    ['style', ['bold', 'italic', 'underline', 'clear']],
    ['fontsize', ['fontsize']],
    ['color', ['color']],
    ['para', ['ul', 'ol', 'paragraph']],
    ['height', ['height']],
    //['insert', ['picture', 'link']], // no insert buttons
    //['table', ['table']], // no table button
    //['help', ['help']] //no help button
  ]
});
var edit = function() {
  $('.click2edit').summernote({focus: true});
};
var save = function() {
  var aHTML = $('.click2edit').code(); //save HTML If you need(aHTML: array).
  $('.click2edit').destroy();
};
  
</script>
    

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
					<div class="panel-heading">Name des Rezeptes
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-6">
                  <img src="https://app.divshot.com/img/placeholder-100x100.gif" height="200" width="200">
                  <br><br></div>
                <div class="col-md-6">
                  <h5><b>Kartoffelgratin</b></h5>Leckeres Rezept mit Kartoffeln und Sahne<br>
                  <i>Dauer: 30 min / 45 min Backofen</i><br>
                  Wertung:<i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star-o"></i><br><br>
                  <a href="edit.html"><span class="label label-success"><i class="fa fa-pencil"></i>&nbsp; Rezept bearbeiten</span></a>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <p><b>Zutaten:</b><br>
                    800 gr Kartoffeln<br>
                    1/4 L Milch<br>
                    1 Prise Salz<br><br>
                    <b>Zubereitung:</b><br><br>
                    Die Kartoffeln sch&auml;en und in d&uuml;nne Scheiben schneiden, anschlie&szlig;end in einer Auflaufform schichten und jede Schicht mit Salz und Sahne versehen.<br>
                    Das Ganze bei 200&deg;C Umluft 45 min lang im Backofen lassen.</p>
                </div>
              </div>
            </div>
            <div class="panel-footer">
              <a href="window.history.back()"><i class="fa fa-arrow-left"></i>&nbsp; Zur&uuml;ck zur vorherigen Seite</a>
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
