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

    <link rel="stylesheet" href="<c:url value="resources/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/css/font-awesome.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/css/webkochbuch-main.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/css/summernote.css" />" />

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
			<div class="panel-heading">
				${recipe.title}
            </div>
            <div class="panel-body">
              	<table style="border: 0px;">
              		<tr><td>Beschreibung:</td><td>${recipe.description}</td></tr>
              		<tr><td>Inhalt:</td><td>${recipe.content}</td></tr>
              		<tr><td>Vorbereitungszeit in Minuten:</td><td>${recipe.preparationEndurance}</td></tr>
              		<tr><td>Gesamtzeit in Minuten:</td><td>${recipe.totalEndurance}</td></tr>
              		<tr><td>Erstellt:</td><td>${recipe.creation}</td></tr>
              	</table>
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
