<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
    <script src="<c:url value="resources/js/summernote.min.js" />" type="text/javascript"></script>
    
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
					<%@ include file="contentStart.jsp" %>
			
          </div>
        </div>
        <div class="col-md-3">
        		
          <div class="panel panel-default">
				<%@ include file="rightSB.jsp" %>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <footer>
    	<center>
    		<%@ include file="footer.jsp" %>
		
	    </center>
      </footer>
    </div>

</body>
</html>
