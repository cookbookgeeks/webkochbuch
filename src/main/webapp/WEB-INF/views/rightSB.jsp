<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<c:url value="/logout" var="logoutUrl" />

<sec:authorize var="loggedIn" access="isAuthenticated()" />

    	<sec:authorize access="isAuthenticated()">			
    			<!-- 
				TODO:
				* User Object empfangen und anschließend auf diesem Objekt Bild, Namen, usw abfragen und anzeigen
				 -->
            <div class="panel-body">
              <div class="media">
                <a href="#">                <img class="media-object dp img-circle" src="<c:url value="/resources/images/test_keks.jpg" />" style="width: 80px;height:80px;">            </a>
                <div class="media-body">
                  <h4 class="media-heading"><%= request.getUserPrincipal().getName() %> <br> <small> Karlsruhe</small></h4>
                  <hr style="margin:8px auto">
                  <span class="label label-default">zum Profil von <c:out value="${request.getUserPrincipal().getName()}"/></span><span class="label label-default">Freunde</span>
                  <span class="label label-info"><a href="${logoutUrl}">Log Out</a></span></form>
                </div>
              </div>
            </div>
            <div class="panel-footer">
              <p class="smalltext"><a href="<c:url value="${logoutUrl}" />" ><i class="fa fa-unlock-o"></i>&nbsp; log out</a></p>
            </div>
          </div>
        </div>
    			
    </sec:authorize>
	
    <sec:authorize access="isAnonymous()">
   		 <div class="panel-body">
            	<c:if test="${not empty error}">
					<div class="error">${error} 
					</div>
				</c:if>
				
            	<c:if test="${not empty logout}">
        			<div>Erfolgreich ausgeloggt.</div>
        		</c:if>
        		        		
              <form name='loginForm'
				  action="<c:url value='j_spring_security_check' />" accept-charset="UTF-8" method="POST">
                <fieldset>
                  <div class="form-group">
                    <input class="form-control" path="email" placeholder="E-mail / Username" value="${SPRING_SECURITY_LAST_USERNAME}" name="username" type="text" autofocus>
                  </div>
                  <div class="form-group">
                    <input class="form-control" path="password" placeholder="Password" name="password" type="password">
                  </div>
                  <div class="checkbox">
                    <label>
                      <input id="_spring_security_remember_me" name="_spring_security_remember_me"  type="checkbox">eingeloggt bleiben</label>	
                  </div>
                  <input class="btn btn-lg btn-success btn-block" value="Login" type="submit">
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </fieldset>
              </form>
              <p class="smalltext"><br>not registered? <a href="#">sing up!</a></p>
            </div>
    </sec:authorize>