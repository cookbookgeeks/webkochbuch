<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>



<!-- 
Dieser View erwartet zwei Parameter:
* eine ArryList �ber die dann iteriert wird
* die aktuelle Seite anhand der dann die anzuzeigenenden Suchergebnisse ausgegeben werden



TODO:

* Pagination: Links auf sich selbst mit Weitergabe des Objectes und h�herer Seitenzahl 
* foreach Schleife
pr�fung ob seite �bergeben oder nicht (nein-> sitenumber=1) 
for (int i=sitenumber*10; i<=Arraylist.length;  i++)
* Tabellen-Item mit Beschreibung und Startbild
* Abfrage ob User eingeloggt f�r rechte Sidebar
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
 
            <div class="panel-heading">Suchterm oder Kategorie
            </div>
            <div class="panel-body">
              
              <!-- insert for each here -->
              
              <div class="row">
                <div class="col-md-4">
                  <img src="https://app.divshot.com/img/placeholder-100x100.gif">
                </div>
                <div class="col-md-8">
                  
                  <h5><a href="rezep.html"><b>Kartoffelgratin</b></a></h5>
                  <a href="rezep.html">
                  Leckeres Rezept mit Kartoffeln und Sahne                    
                  <br>                    
                  <i>Dauer: 30 min / 45 min Backofen</i>                    
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
              
              <!-- NEUES REZEPT -->
              
              <div class="row">
                <div class="col-md-4">
                  <img src="https://app.divshot.com/img/placeholder-100x100.gif">
                </div>
                <div class="col-md-8">
                  <p><a href="rezep.html">                    </a></p>
                  <h5><a href="rezep.html"><b>Erbseneintopf</b></a></h5>
                  <a href="#">
                  Einfach, schnell, s�ttigend
                  <br>                    
                  <i>Dauer: 20 min </i>                    
                  </a><br>
                  Wertung: 
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star-o"></i>
                  <i class="fa fa-star-o"></i>
                  <i class="fa fa-star-o"></i>
                  <p></p>
                </div>
              </div>
              <!-- NEUES REZEPT -->
              
              <div class="row">
                <div class="col-md-4">
                  <img src="https://app.divshot.com/img/placeholder-100x100.gif">
                </div>
                <div class="col-md-8">
                  <p><a href="rezep.html">                    </a></p>
                  <h5><a href="rezep.html"><b>Makkaroni-Auflauf</b></a></h5>
                  <a href="#">
                  Bella Italia! Hackfleisch, Makkaroni,..
                  <br>                    
                  <i>Dauer: 45 min / 30 min Backofen</i>                    
                  </a><br>
                  Wertung: 
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star-o"></i>
                  <i class="fa fa-star-o"></i>
                  <p></p>
                </div>
              </div>
              <!-- NEUES REZEPT -->
              
              <div class="row">
                <div class="col-md-4">
                  <img src="https://app.divshot.com/img/placeholder-100x100.gif">
                </div>
                <div class="col-md-8">
                  <p><a href="rezep.html">                    </a></p>
                  <h5><a href="rezep.html"><b>Butterbrot</b></a></h5>
                  <a href="#">
                  simpel, wie bei Gro�mutter
                  <br>                    
                  <i>Dauer: 5 min</i>                    
                  </a><br>
                  Wertung: 
                  <i class="fa fa-star"></i>
                  <i class="fa fa-star-o"></i>
                  <i class="fa fa-star-o"></i>
                  <i class="fa fa-star-o"></i>
                  <i class="fa fa-star-o"></i>
                  <p></p>
                </div>
                
            </div>
            <div class="panel-footer">
              <ul class="pagination ">
                <li>
                  <a>Prev</a>
                </li>
                <li>
                  <a href="#">1</a>
                </li>
                <li>
                  <a href="#">2</a>
                </li>
                <li>
                  <a href="#">3</a>
                </li>
                <li>
                  <a href="#">4</a>
                </li>
                <li>
                  <a href="#">Next</a>
                </li>
              </ul>
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
           