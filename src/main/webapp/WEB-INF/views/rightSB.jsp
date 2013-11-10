<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

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