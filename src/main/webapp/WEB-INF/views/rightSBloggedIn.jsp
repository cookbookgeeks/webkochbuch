<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!-- 
TODO:
* User Object empfangen und anschließend auf diesem Objekt Bild, Namen, usw abfragen und anzeigen
"spring security" verwenden und mit :
<sec:authorize var="loggedIn" access="isAuthenticated()" />
testen und variable setzen 
 -->

            <div class="panel-body">
              <div class="media">
                <a href="#">                <img class="media-object dp img-circle" src="http://www.huffmancode.com/img/hardik.jpg" style="width: 80px;height:80px;">            </a>
                <div class="media-body">
                  <h4 class="media-heading">Lukas Langenbacher <small> Karlsruhe</small></h4>
                  <hr style="margin:8px auto">
                  <span class="label label-default">zum Profil</span><span class="label label-default">Freunde</span>
                  <a href="index.html"><span class="label label-info">log out</span></a>
                </div>
              </div>
            </div>
            <div class="panel-footer">
              <p class="smalltext"><a href="index.html"><i class="fa fa-unlock-o"></i>&nbsp; log out</a></p>
            </div>
          </div>
        </div>
