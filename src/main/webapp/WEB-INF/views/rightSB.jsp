<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<c:set var="authenticated" value="${true}"/>
          
    <c:if test="${ not authenticated}">
			
            <div class="panel-body">
              <form:form commandName="login" accept-charset="UTF-8" name="login" method="POST">
                <fieldset>
                  <div class="form-group">
                    <input class="form-control" path="email" placeholder="E-mail" name="email" type="text">
                  </div>
                  <div class="form-group">
                    <input class="form-control" path="password" placeholder="Password" name="password" value type="password">
                  </div>
                  <div class="checkbox">
                    <label>
                      <input name="remember" value="Remember Me" type="checkbox">Remember Me</label>
                  </div>
                  <input class="btn btn-lg btn-success btn-block" value="Login" type="submit">
                </fieldset>
              </form:form>
              <p class="smalltext"><br>not registered? <a href="#">sing up!</a></p>
            </div>
            <div class="panel-footer">
              <p class="smalltext">log out</p>
            </div>
            
    </c:if>
    
    <c:if test="${authenticated}">
				<!-- 
TODO:
* User Object empfangen und anschließend auf diesem Objekt Bild, Namen, usw abfragen und anzeigen
 -->

            <div class="panel-body">
              <div class="media">
                <a href="#">                <img class="media-object dp img-circle" src="http://www.huffmancode.com/img/hardik.jpg" style="width: 80px;height:80px;">            </a>
                <div class="media-body">
                  <h4 class="media-heading">Lukas Langenbacher <small> Karlsruhe</small></h4>
                  <hr style="margin:8px auto">
                  <span class="label label-default">zum Profil</span><span class="label label-default">Freunde</span>
                  <a href="/"><span class="label label-info">log out</span></a>
                </div>
              </div>
            </div>
            <div class="panel-footer">
              <p class="smalltext"><a href="/"><i class="fa fa-unlock-o"></i>&nbsp; log out</a></p>
            </div>
          </div>
        </div>
	</c:if>