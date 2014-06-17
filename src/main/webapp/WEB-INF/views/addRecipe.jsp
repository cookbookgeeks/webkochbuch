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
	
    <script src="<c:url value="/resources/js/jquery.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery.form.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/bootstrap.file-input.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/tinymce/tinymce.min.js" />" type="text/javascript"></script>

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
					<div class="panel-heading"> <b>Rezept erstellen</b>
            </div>
            <div class="panel-body">
<div class="form-group">
<form id="fileUploadForm" method="post" enctype="multipart/form-data" action="/upload">
<table>
	<tr>
		<td><label>Bilddatei:</label></td>
		<td><input type="file" title="Durchsuchen" name="file" class="btn-success" /></td>
	</tr>
	<tr>
		<td></td>
		<td>
			<div class="progress">
		 		<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
		  		</div>
			</div>
		</td>
	</tr>
	<tr>
		<td><label>Bildunterschrift:</label></td>
		<td><input type="text" name="description" maxlength="255" />
	</tr>
	<tr>
		<td></td>
		<td><button value="Submit" class="btn btn-success">Bild hochladen</button></td>
	</tr>
	<tr>
		<td></td>
		<td><div id="result"></div></td>
	</tr>
</table>
</form>
</div>            

<div class="form-group">
<c:url var="saveUrl" value="/recipe/adddata" />
<form:form id="recipeForm" modelAttribute="recipe" method="POST" action="${saveUrl}">
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
   <td><form:label path="preparationEndurance">Vorbereitungszeit(min):</form:label></td>
   <td><form:input path="preparationEndurance" class="form-control"/></td>
  </tr>	
  
  <tr>
   <td><form:label path="totalEndurance">Gesamtzeit(min):</form:label></td>
   <td><form:input path="totalEndurance" class="form-control"/></td>
  </tr>
  
  <tr>
  <td><label for="categoryInput">Kategorie</label></td>
  <td>
  	<select name="categoryInput" class="form-control">
  		<c:forEach items="${categories}" var="category">
  			<option value="${category.id}">${category.name}</option>
  		</c:forEach>
  	</select>
  </td>
  </tr>
  
  <tr>
   <td>
   		<b>Zutaten:</b>
   </td>
   <td>
	   		<input name="amount" class="form-control" type="number" length="4" placeholder="Anzahl" />
	   		<select name="measure" class="form-control">
	   			<c:forEach items="${measures}" var="measure">
	   				<option value="${measure.id}">${measure.name}</option>
	   			</c:forEach>
	    	</select>
	    	<input name="ingredientName" class="form-control" length="100" placeholder="Zutat" />
	    <div id="dynamisch"></div>
  		<input type="button" value="-" onClick="minus();" class="btn btn-success btn-xs">
	  	<input type="button" value="+" onClick="plus();"class="btn btn-success btn-xs">
  	</td>
  </tr>
   
  <tr>
   <td><form:label path="content">Zubereitung:</form:label></td>
   <td>
   <form:textarea path="content"  class="form-control"/> 
   </td>
  </tr>
 
 </table>
 <input type="submit" value="Save" class="btn btn-success"/>
</form:form>
 </div>


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
    
    <script type="text/javascript">
    var options = {
  			url: '/upload',
  			type: 'POST',
  			resetForm: true,
  			clearForm: true,
  			// update progress bar
  			uploadProgress: function(event, position, total, percentComplete) {
	            $('.progress-bar').width(percentComplete + '%');
	     	},
	     	// set progress bar back, clear result box
	     	beforeSubmit: function(arr, $form, options) {
	     		$('.progress-bar').width(0 + '%');
	     		$('#result').innerHTML = "";
	     	},
	     	// check if upload successfull
	     	success: function(data) {
	     		if(data != "null") {
	     			// append id of uploaded image to recipe form
	     			$('#recipeForm').append('<input type="hidden" name="ids" value="' + data + '" />');
	     		} else {
	     			// show error message
	     			$('#result').innerHTML = "Upload fehlgeschlagen!";
	     		}
	     	}
  	};
    
    $('#fileUploadForm').ajaxForm(options);
    </script>
    <script>$(document).ready(function(){    
	$('input[type=file]').bootstrapFileInput();
	$('.file-inputs').bootstrapFileInput();
	tinymce.init({
	    selector: "textarea",
	    	theme: "modern",
	        //width: 300,
	        height: 300,
	        menubar:false,
	        statusbar: false,
	        language : 'de',
	        fontsize_formats: "8pt 10pt 12pt 14pt 18pt 24pt 36pt",
	        plugins: [
						"advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
						"searchreplace  visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
						"save table contextmenu directionality emoticons template paste textcolor"

	       ],
	       toolbar: " fontsizeselect | undo redo  | bold italic  | bullist numlist outdent indent | preview fullpage | forecolor emoticons", 
	       style_formats: [
	            {title: 'Bold text', inline: 'b'},
	            {title: 'Big header', block: 'h1', styles: {color: '#000000'}},
	            {title: 'Example 1', inline: 'span', classes: 'example1'},
	            {title: 'Example 2', inline: 'span', classes: 'example2'},
	            
	        ]

	 });

	});</script>
	
	<script>
	// Formularfelder dynamisch hinzuf�gen
	
	var feld = 1;
	
	function plus() {
	 if (feld <= 10) {
	  document.getElementById("dynamisch").innerHTML +=
		"<input name='amount' class='form-control' type='number' length='4' placeholder='Anzahl' />\
 		<select name='measure' class='form-control'>\
 			<c:forEach items='${measures}' var='measure'>\
 				<option value='${measure.id}'>${measure.name}</option>\
 			</c:forEach>\
  		</select>\
  		<input name='ingredientName' class='form-control' length='100' placeholder='Zutat' />";
	  feld++;
	 }
	}
	
	function minus() {
	 if (feld > 1) {
	  feld--;
	  document.getElementById("dynamisch").innerHTML = "";
	  for (var zaehler = 1; zaehler < feld; zaehler++) {
	    document.getElementById("dynamisch").innerHTML +=
			"<input name='amount' class='form-control' type='number' length='4' placeholder='Anzahl' />\
	 		<select name='measure' class='form-control'>\
	 			<c:forEach items='${measures}' var='measure'>\
	 				<option value='${measure.id}'>${measure.name}</option>\
	 			</c:forEach>\
	  		</select>\
	  		<input name='ingredientName' class='form-control' length='100' placeholder='Zutat' />";
	  }
	 }
	}
	</script>
	      
</body>
</html>


