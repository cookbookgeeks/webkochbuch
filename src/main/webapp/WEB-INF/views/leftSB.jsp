<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
 <div class="panel-heading">
              <i>Navigation</i>
            </div>
            <ul class="list-group">
              <li class="list-group-item"><a href="/list">Alle Rezepte</a></li>
              <li class="list-group-item"><a href="/recipe/100001">Rezept des Tages</a></li>
              <li class="list-group-item"><a href="/category/0">Kochen</a></li>
              <li class="list-group-item"><a href="/category/1">Backen</a></li>
              <li class="list-group-item"><a href="/category/2">Desert</a></li>
              <li class="list-group-item"><a href="/recipe/add">Rezept erstellen</a></li>
            </ul>
            <div class="panel-footer">
              <div class=" input-group">
                  <form id="custom-search-form" class="form-search form-horizontal pull-right" method="GET" action="/search">
                    <input class="search-query" placeholder="Search" type="text" name="s">
                    <button type="submit" class="btn">
                      <i class="fa fa-search"></i>
                    </button>
                  </form>
                
              </div>
            </div>