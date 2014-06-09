<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <script type="text/javascript">
	    function loeschen() {
    		if(confirm("Rezept wirklich l�schen?")){
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
                  <form id="ratingform"><div id="star"></div></form>
                  <br><br>
                  <a href="/recipe/edit/${recipe.id}"><span id="editdelete" class="label label-success"><i class="fa fa-pencil"></i>&nbsp; Rezept bearbeiten</span></a>
                  <a href="javascript:loeschen()"><span id="editdelete" class="label label-success"><i class="fa fa-pencil"></i>&nbsp; Rezept l�schen</span></a>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <p>

				<br>
                  <!-- <b>Zutaten:</b><br> -->
					
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
				click: function(score, evt) {
				   // alert('ID: ' + $(this).attr('id') + "\nscore: " + score + "\nevent: " + evt);
				    document.getElementById('ratingform').submit();
				}
			});
		});
		
	</script>
</body>
</html>
