<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Webkochbuch</title>
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="<c:url value="resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="resources/css/font-awesome.css" />">
    <link rel="stylesheet" href="<c:url value="resources/css/webkochbuch-main.css" />">

    <script src="<c:url value="resources/js/jquery.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="resources/js/bootstrap.min.js" />" type="text/javascript"></script>
</head>
<body><div class="container">
      <div class="navbar navbar-default">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">Webkochbuch</a>
          </div>
          <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav pull-right">
              <li class="active">
                <a href="index.html"><i class="fa fa-home"></i> Home</a>
              </li>
              <li>
                <a href="#"><i class="fa fa-book"></i> Kategorien</a>
              </li>
              <li>
                <a href="#"><i class="fa fa-user"></i> Profil</a>
              </li>
              <li>
                <a href="kontakt.html"><i class="fa fa-envelope-o"></i> Kontakt</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <header>
        <div class="jumbotron header">
          <h1>Webkochbuch</h1>
          <p>welcome to the social cooking-experience!<br></p>
          <p></p>
        </div>
      </header>
      <div class="row">
        <div class="col-md-3">
          <div class="panel panel-default">
            <div class="panel-heading">
              <i>Navigation</i>
            </div>
            <ul class="list-group">
              <li class="list-group-item"><a href="rezep.html">Rezept des Tages</a></li>
              <li class="list-group-item"><a href="liste.html">Kochen</a></li>
              <li class="list-group-item"><a href="liste.html">Backen</a></li>
              <li class="list-group-item"><a href="liste.html">Desert</a></li>
            </ul>
            <div class="panel-footer">
              <div class="row">
                  <form id="custom-search-form" class="form-search form-horizontal pull-right">
                    <input class="search-query" placeholder="Search" type="text">
                    <button type="submit" class="btn">
                      <i class="fa fa-search"></i>
                    </button>
                  </form>
                
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="panel panel-default">
            <div class="panel-heading">This is a header
            </div>
            <div class="panel-body">
              <p>Hier stehen Neuigkeiten<br>
                und Rezepte<br><br>
                und neues usw usw<br>
                blabla<br><br>
                test</p>
              <p>Voluptatum cumque autem hic quo amet ducimus temporibus et tempor elit irure architecto accusantium necessitatibus laborum id debitis. Aspernatur explicabo recusandae voluptatibus dignissimos dolore aliqua commodi odit cupidatat dignissimos sequi occaecat beatae harum debitis dicta sequi quae, ea saepe commodi quaerat sunt. Accusantium odit cupidatat fugit quas maxime, nisi ea earum laboriosam laboris, labore elit voluptate perferendis veritatis eius cupidatat sint duis do sint aspernatur, adipisicing culpa aliqua corrupti itaque. Quos delectus magna illo cupidatat sunt rem excepteur do magnam quam aliquip eveniet ipsa ex pariatur eveniet, ipsa perspiciatis mollit, vero eum natus impedit itaque.</p>
              <p>Voluptatum cumque autem hic quo amet ducimus temporibus et tempor elit irure architecto accusantium necessitatibus laborum id debitis. Aspernatur explicabo recusandae voluptatibus dignissimos dolore aliqua commodi odit cupidatat dignissimos sequi occaecat beatae harum debitis dicta sequi quae, ea saepe commodi quaerat sunt. Accusantium odit cupidatat fugit quas maxime, nisi ea earum laboriosam laboris, labore elit voluptate perferendis veritatis eius cupidatat sint duis do sint aspernatur, adipisicing culpa aliqua corrupti itaque. Quos delectus magna illo cupidatat sunt rem excepteur do magnam quam aliquip eveniet ipsa ex pariatur eveniet, ipsa perspiciatis mollit, vero eum natus impedit itaque.</p>
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
            <div class="panel-body">
              <form accept-charset="UTF-8" role="form" method="link" action="loggedin.html">
                <fieldset>
                  <div class="form-group">
                    <input class="form-control" placeholder="E-mail" name="email" type="text">
                  </div>
                  <div class="form-group">
                    <input class="form-control" placeholder="Password" name="password" value type="password">
                  </div>
                  <div class="checkbox">
                    <label>
                      <input name="remember" value="Remember Me" type="checkbox">Remember Me</label>
                  </div>
                  <input class="btn btn-lg btn-success btn-block" value="Login" type="submit">
                </fieldset>
              </form>
              <p class="smalltext"><br>not registered? <a href="#">sing up!</a></p>
            </div>
            <div class="panel-footer">
              <p class="smalltext">log out</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <footer>webkochbuch &copy; by <b>cookbookgeeks</b>. The website was created during our project in lecture 'software-engineering'</footer>
    </div>

</body>
</html>
