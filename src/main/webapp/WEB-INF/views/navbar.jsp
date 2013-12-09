<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<div class="navbar navbar-default">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand"> Webkochbuch </a>
          </div>
          <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav pull-right">
              <li class="active">
                <a href="/"><i class="fa fa-home"></i> Home</a>
              </li>
              <li>
                <a href="/categories"><i class="fa fa-book"></i> Kategorien</a>
              </li>
              <li>
                <a href="/profile"><i class="fa fa-user"></i> Profil</a>
              </li>
              <li>
                <a href='<c:url value="contact.jsp"/>'><i class="fa fa-envelope-o"></i> Kontakt</a>
              </li>
            </ul>
          </div>
        </div>
        </div>