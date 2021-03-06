<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<html>
<head>
	<title>Webkochbuch</title>
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/webkochbuch-main.css" />">
        

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
					<div class="panel-heading"><h4>Kontakt</h4>
            </div>
            <div class="panel-body">
            <div class="form-group">
              <div class="row">
              
                <div class="col-md-6">
                  <label>Vorname</label><br>
                  <label>Nachname</label><br>
                  <label>Email Addresse</label>
                  <br><br>
                  <label>Betreff</label>
                </div>
                <div class="col-md-6">
                  <input class="span3 form-control" placeholder="Your First Name" type="text">
                  <input class="span3 form-control" placeholder="Your Last Name" type="text">
                  <input class="span3 form-control" placeholder="Your email address" type="text">
                  <br><br>
                  <select class="span3 form-control" id="subject" name="subject">
                    <option selected value="na">Bitte w&auml;hlen:</option>
                    <option value="service">Service</option>
                    <option value="suggestions">Vorschl&auml;ge</option>
                    <option value="Rezept">Rezept</option>
                    <option value="sonstiges">Sonstiges</option>
                  </select>
                </div>
              </div>
              <form>
                <div >
                  <br>
                  <label>Nachricht</label><br>
                  <textarea class="input-xlarge span5 form-control" id="message" name="message" rows="10" cols="60"></textarea>
                </div>
                <br>
                <button class="btn  btn-success " type="submit">Send</button>
              </form>
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
    <div class="container">
      <footer>
    		<%@ include file="footer.jsp" %>
      </footer>
    </div>

</body>
</html>
