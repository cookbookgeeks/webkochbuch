<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Webkochbuch</title>
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"  />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/webkochbuch-main.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery.fancybox.css"  />" />
    
    
    <script src="<c:url value="/resources/js/jquery.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery.fancybox.pack.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/jquery.raty.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/tinymce/tinymce.min.js" />" type="text/javascript"></script>

    <script type="text/javascript">
	    function loeschen() {
    		if(confirm("Rezept wirklich löschen?")){
    			location.href="/recipe/delete/${recipe.id}";
    		}
    		else {
	    		location.href="/recipe/${recipe.id}";
    		}
    	}
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
				<h3>${recipe.title}</h3>
            </div>
            <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                <c:if test="${!recipe.images.isEmpty()}">
                	<a class="fancybox" href="${recipe.images.get(0).getViewUrl()}" title="${recipe.title}">
                  		<img src="${recipe.images.get(0).getViewUrl()}" alt="${recipe.title}" class="img-responsive">
                  		</a>
                   </c:if>
                  <c:if test="${recipe.images.isEmpty()}">
                  <img src="<c:url value="/resources/images/notfound.jpg" />" width="200" height="200">
                  </c:if>
                  
                  <br><br></div>
                <div class="col-md-6">
                  <h5><b>${recipe.title}</b></h5><br>${recipe.description}<br>
                  Erstellt: <fmt:formatDate value="${recipe.creation}" pattern="dd.mm.yyyy" /> <br>
                  <i>Dauer: ${recipe.preparationEndurance} min / 
                  Gesamt: ${recipe.totalEndurance} min </i><br>
                  <b>Kategorie:</b> ${recipe.category.name}<br />
                  <c:if test="${recipe.ratings.size() > 0}">
                  	${recipe.ratings.size()} Bewertungen
                  </c:if>
                  <form id="ratingform" method="GET" action="/recipe/${recipe.id}/rating"><div id="star"></div></form>
                  <br><br>
                  <c:if test="${!ratingError.isEmpty()}">
                  	<c:if test="${param.ratingError == true}">
                  		Bewertung fehlgeschlagen!
                  	</c:if>
                  </c:if>
                  <!-- -->
                  <sec:authorize ifAnyGranted="ROLE_ADMIN, ROLE_USER">
                  <a href="/recipe/edit/${recipe.id}"><span id="editdelete" class="label label-success"><i class="fa fa-pencil"></i>&nbsp; Rezept bearbeiten</span></a>
                  <a href="javascript:loeschen()"><span id="editdelete" class="label label-success"><i class="fa fa-pencil"></i>&nbsp; Rezept löschen</span></a>
                  </sec:authorize>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <p>
                  <hr>
                  <br>
                  <b>Zutaten:</b><br>
                  <table>
	                  <c:forEach var="ingredient" items="${recipe.ingredients }">
	                  	<tr>
	                  		<td>${ingredient.amount }</td><td>${ingredient.measure }</td><td>${ingredient.name }</td>
	                  	</tr>
	                  </c:forEach>
                  </table>
                  <br>
					<hr>
					<br>
                    <b>Zubereitung:</b><br><br>
                    ${recipe.content}
					</p>
					<c:if test="${!recipe.images.isEmpty()}">
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					  <!-- Indicators -->
					  <ol class="carousel-indicators">
					  	<c:forEach var="image" items="${recipe.images}" varStatus="loop">
					    <li data-target="#carousel-example-generic" data-slide-to="${loop.index}" <c:if test="${loop.index == 0}">class="active"</c:if>></li>
					    </c:forEach>
					  </ol>
					
					  <!-- Wrapper for slides -->
					  <div class="carousel-inner">
					  <c:forEach var="image" items="${recipe.images}" varStatus="loop">
					    <div class="item <c:if test="${loop.index == 0}">active</c:if>">
					      <img src="<c:url value="${image.getViewUrl()}" />" alt="${image.description}" />
					      <div class="carousel-caption">
					      	${image.description}
					      </div>
					    </div>
					  </c:forEach>
					  </div>
					
					  <!-- Controls -->
					  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
					    <span class="glyphicon glyphicon-chevron-left"></span>
					  </a>
					  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
					    <span class="glyphicon glyphicon-chevron-right"></span>
					  </a>
					</div>
				</c:if>
				
				<!-- Comment Container -->
				<div class="container">
				    <div class="row">
				        <div class="panel panel-default widget">
				            <div class="panel-heading">
				                
				                <h3 class="panel-title"><span class="glyphicon glyphicon-comment"></span>
				                    Benutzer-Kommentare</h3>
				            </div>
				            <div class="panel-body">
				                <ul class="list-group">
				                   <c:forEach var="comment" items="${recipe.comments}">
						    			
						    			<li class="list-group-item">
				                        <div class="row">
				                            <div class="col-xs-2 col-md-1">
				                                <img src="http://placehold.it/80" class="img-circle img-responsive" alt="" /></div> 
				                                <!--  profile-pic if possible-->
				                            <div class="col-xs-10 col-md-11">
				                                <div>
				                                    <div class="mic-info">
				                                        By: <a href="#">${comment.user.userName}</a> on <fmt:formatDate value="${comment.creation}" pattern="dd.mm.yyyy" /> 
				                                    </div>
				                                </div>
				                                <div class="comment-text">${comment.comment}
				                                </div>
				                                <div class="action">
				                                <sec:authorize ifAnyGranted="ROLE_ADMIN">
				                                    <a class="btn btn-primary btn-xs" title="Edit" href="comment/edit/${comment.id}">
				                                        <span class="glyphicon glyphicon-pencil"></span>
				                                    </a>
				                                    <a class="btn btn-success btn-xs" title="Approved">
				                                        <span class="glyphicon glyphicon-ok"></span>
				                                    </a>
				                                    <a class="btn btn-danger btn-xs" title="Delete" href="comment/delete/${comment.id}">
				                                        <span class="glyphicon glyphicon-trash"></span>
				                                    </a>
				                                    </sec:authorize>
				                                </div>
				                            </div>
				                        </div>
				                    </li>				                
					    			</c:forEach>
					    		</ul>
				                <a href="javascript:location.reload()" class="btn btn-success btn-primary btn-sm btn-block" role="button"><span class="glyphicon glyphicon-refresh"></span>aktualisieren</a>
				            </div>
				        </div>
				    </div>
			</div>
				<!--  Comment Container End -->
				
				
							<div class="form-group"> <sec:authorize ifAnyGranted="ROLE_ADMIN, ROLE_USER">							
								<c:url var="saveComUrl" value="/recipe/${recipe.id}/comment" />
								<form:form id="commentForm" modelAttribute="recipe" method="POST" action="${saveComUrl}">
									 <textarea  rows="3"
													class="form-control" name="comment" path="comment"></textarea></td>
									<input type="submit" value="Save" class="btn btn-success btn-block" />
								</form:form>
								</sec:authorize>
							</div>

						</div>
              </div>
              
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
	<script type="text/javascript">
		$(document).ready(function() {
			$(".fancybox").fancybox(
					{
					        padding : 0
					});
			$('#star').raty({
				score: ${recipe.meanRating()},
				<sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER">
				readOnly   : true,
				</sec:authorize>
				click: function(score, evt) {
				   // alert('ID: ' + $(this).attr('id') + "\nscore: " + score + "\nevent: " + evt);
				    document.getElementById('ratingform').submit();
				}
			});
			tinymce.init({
			    selector: "textarea",
			    	theme: "modern",
			        //width: 300,
			        //height: 300,
			        menubar:false,
			        statusbar: false,
			        language : 'de',
			        fontsize_formats: "8pt 10pt 12pt 14pt 18pt 24pt 36pt",
			        plugins: [
								"advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
								"searchreplace  visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
								"save table contextmenu directionality emoticons template paste textcolor"

			       ],
			       toolbar: " undo redo  | bold italic  | bullist numlist outdent indent | forecolor emoticons", 
			       style_formats: [
			            {title: 'Bold text', inline: 'b'},
			            {title: 'Big header', block: 'h1', styles: {color: '#000000'}},
			            {title: 'Example 1', inline: 'span', classes: 'example1'},
			            {title: 'Example 2', inline: 'span', classes: 'example2'},
			            
			        ]

			 });
		});
	</script>
</body>
</html>
