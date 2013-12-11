<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
 <div class="panel-heading">
              <i>Navigation</i>
            </div>
            <ul class="list-group">
              <li class="list-group-item"><a href="/list">Alle Rezepte</a></li>
              <li class="list-group-item"><a href="/recipe/0">Rezept des Tages</a></li>
              <li class="list-group-item"><a href="/list">Kochen</a></li> <!-- Aufruf über list mit Übergabe einer Kategorienummer/-Name -->
              <li class="list-group-item"><a href="/list">Backen</a></li>
              <li class="list-group-item"><a href="/list">Desert</a></li>
              <li class="list-group-item"><a href="/recipe/add">Rezept erstellen</a></li>
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